package com.gengersoft.iot.vmp.common.util;

import com.alibaba.fastjson.JSON;
import com.gengersoft.iot.vmp.zlm.ZLMResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.*;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author hanzai
 * @date 2022/12/22
 */
@Slf4j
public class HttpUtils {

    private static final RestTemplate restTemplate;

    static {
        OkHttp3ClientHttpRequestFactory requestFactory = new OkHttp3ClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);//连接超时
        requestFactory.setReadTimeout(5000);//请求读取超时
        requestFactory.setWriteTimeout(5000);//请求写入超时
        restTemplate = new RestTemplate(requestFactory);
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
    }

    public static ZLMResult zlmPostForm(String url, Map<String, Object> param) {
        MultiValueMap<String, Object> formReqParams = new LinkedMultiValueMap<>();
        formReqParams.setAll(param);
        return zlmPostForm(url, formReqParams);
    }

    public static ZLMResult zlmPostForm(String url, MultiValueMap<String, Object> param) {
        String responseStr = post(url, param, MediaType.APPLICATION_FORM_URLENCODED);
        return JSON.parseObject(responseStr, ZLMResult.class);
    }

    public static <I> String post(String url, I body, MediaType type) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(type);
        HttpEntity<I> requestEntity = new HttpEntity<>(body, headers);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
            if (response.getStatusCode() != HttpStatus.OK) {
                log.info("URL:{},http status code :{}", url, response.getStatusCode());
            } else {
                return response.getBody();
            }
        } catch (Exception e) {
            log.error("URL:{},http post error", url);
        }
        return StringUtils.EMPTY;
    }

}
