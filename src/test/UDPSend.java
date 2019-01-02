package test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @program: sort
 * @Date: 2018/10/15 11:03
 * @Author: Mr.Li
 * @Description:
 * 实现封装数据的类 java.net.DatagramPacket将你的数据包装
 * 实现数据传输的类 java.net.DatagramSocket将数据包发出去
 */
public class UDPSend {

    public static void main(String[] args) throws IOException {
        send();
    }

    private static void send() throws IOException {
        Scanner scanner=new Scanner(System.in);
        DatagramSocket datagramSocket=new DatagramSocket();
        InetAddress ip=InetAddress.getByName("127.0.0.1");
        while (true) {
            String data = scanner.nextLine();
            byte[] buf = data.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, ip, 9999);
            datagramSocket.send(datagramPacket);
        }
        //datagramSocket.close();
    }
}
