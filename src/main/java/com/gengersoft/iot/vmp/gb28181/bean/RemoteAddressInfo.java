package com.gengersoft.iot.vmp.gb28181.bean;

/**
 * @author hanzai
 * @date 2023/1/13
 */
public class RemoteAddressInfo {
    private String ip;
    private int port;

    public RemoteAddressInfo(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}