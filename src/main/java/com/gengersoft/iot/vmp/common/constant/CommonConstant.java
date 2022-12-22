package com.gengersoft.iot.vmp.common.constant;

/**
 * @author hanzai
 * @date 2022/12/22
 * 公共常量类
 */
public class CommonConstant {

    /**
     * 项目访问端口号
     */
    public static final String SERVER_PORT = "server.port";

    /**
     * 项目访问路径
     */
    public static final String SERVER_SERVLET_CONTEXT_PATH = "server.servlet.context-path";


    /**
     * 默认本地地址
     */
    public static final String DEFAULT_LOCAL_IP = "127.0.0.1";

    /**
     * 当前服务器操作系统是否为linux
     */
    public static final boolean LINUX_OS = System.getProperty("os.name").toLowerCase().contains("linux");

}
