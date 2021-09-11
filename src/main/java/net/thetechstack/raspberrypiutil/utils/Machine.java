package net.thetechstack.raspberrypiutil.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Machine {
    public static void shutdown() {
        try {
            Process p = Runtime.getRuntime().exec("sudo shutdown -h now");
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static String ipAddress() {
        InetAddress IP;
        try {
            IP = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "";
        }
        return IP.getHostAddress();
    }
}
