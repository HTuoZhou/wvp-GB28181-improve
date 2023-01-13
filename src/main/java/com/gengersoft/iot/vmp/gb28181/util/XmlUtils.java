package com.gengersoft.iot.vmp.gb28181.util;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Element;

/**
 * @author hanzai
 * @date 2023/1/13
 */
@Slf4j
public class XmlUtils {

    /**
     * 获取element对象的text的值
     *
     * @param em  节点的对象
     * @param tag 节点的tag
     * @return 节点
     */
    public static String getText(Element em, String tag) {
        if (null == em) {
            return null;
        }
        Element e = em.element(tag);
        //
        return null == e ? null : e.getText().trim();
    }

}
