package com.gengersoft.iot.vmp.gb28181.transmit.event.request;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.sip.PeerUnavailableException;
import javax.sip.RequestEvent;
import javax.sip.SipFactory;
import javax.sip.header.HeaderFactory;
import javax.sip.message.MessageFactory;
import javax.sip.message.Request;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hanzai
 * @date 2023/1/12
 */
@Slf4j
public abstract class AbstractSIPRequestProcessor {

    public HeaderFactory getHeaderFactory() {
        try {
            return SipFactory.getInstance().createHeaderFactory();
        } catch (PeerUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MessageFactory getMessageFactory() {
        try {
            return SipFactory.getInstance().createMessageFactory();
        } catch (PeerUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Element getRootElement(RequestEvent requestEvent) throws DocumentException {
        return getRootElement(requestEvent, "gb2312");
    }

    public Element getRootElement(RequestEvent requestEvent, String charset) throws DocumentException {
        if (charset == null) {
            charset = "gb2312";
        }
        Request request = requestEvent.getRequest();
        SAXReader reader = new SAXReader();
        reader.setEncoding(charset);
        // 对海康出现的未转义字符做处理。
        String[] destStrArray = new String[]{"&lt;","&gt;","&amp;","&apos;","&quot;"};
        char despChar = '&'; // 或许可扩展兼容其他字符
        byte destBye = (byte) despChar;
        List<Byte> result = new ArrayList<>();
        byte[] rawContent = request.getRawContent();
        if (rawContent == null) {
            return null;
        }
        for (int i = 0; i < rawContent.length; i++) {
            if (rawContent[i] == destBye) {
                boolean resul = false;
                for (String destStr : destStrArray) {
                    if (i + destStr.length() <= rawContent.length) {
                        byte[] bytes = Arrays.copyOfRange(rawContent, i, i + destStr.length());
                        resul = resul || (Arrays.equals(bytes,destStr.getBytes()));
                    }
                }
                if (resul) {
                    result.add(rawContent[i]);
                }
            }else {
                result.add(rawContent[i]);
            }
        }
        Byte[] bytes = new Byte[0];
        byte[] bytesResult = ArrayUtils.toPrimitive(result.toArray(bytes));

        Document xml = reader.read(new ByteArrayInputStream(bytesResult));
        return xml.getRootElement();
    }

}
