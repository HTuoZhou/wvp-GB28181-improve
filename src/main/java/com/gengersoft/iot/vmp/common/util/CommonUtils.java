package com.gengersoft.iot.vmp.common.util;

import com.gengersoft.iot.vmp.common.constant.CommonConstant;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author hanzai
 * @date 2022/12/22
 * 公共工具类
 */
public class CommonUtils {

    public static String localIP() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo") && !name.startsWith("veth") && !name.startsWith("cali")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipaddress = inetAddress.getHostAddress().toString();
                            if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
                                return ipaddress;
                            }
                        }
                    }
                }
            }
        } catch (SocketException e) {

        }
        return CommonConstant.DEFAULT_LOCAL_IP;
    }

}
