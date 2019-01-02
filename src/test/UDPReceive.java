package test;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @program: sort
 * @Date: 2018/10/15 11:20
 * @Author: Mr.Li
 * @Description:
 */
public class UDPReceive {
    public static void main(String[] args) throws IOException{
        receive();
    }
    private static void receive() throws IOException {
        byte[] buf=new byte[1024];
        DatagramSocket datagramSocket=new DatagramSocket(9999);
        DatagramPacket datagramPacket=new DatagramPacket(buf,buf.length);
        while (true) {
            datagramSocket.receive(datagramPacket);
            String ip=datagramPacket.getAddress().getHostAddress();
            System.out.println(new String(buf));
            System.out.println(ip);
        }
        //datagramSocket.close();
    }
}
