package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: sort
 * @Date: 2018/10/15 10:39
 * @Author: Mr.Li
 * @Description:
 */
public class InetAddressClass {
    public static void main(String[] args) throws UnknownHostException{
        function();
    }
    public static void function() throws UnknownHostException{
        //InetAddress ip=InetAddress.getLocalHost();
        InetAddress ip=InetAddress.getByName("www.baidu.com");
        String hostName=ip.getHostName();
        String address=ip.getHostAddress();
        System.out.println(hostName+"--->"+address);
    }
}
