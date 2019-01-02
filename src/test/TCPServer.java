package test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @program: sort
 * @Date: 2018/10/15 12:10
 * @Author: Mr.Li
 * @Description:
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket();
        SocketAddress socketAddress=new InetSocketAddress("127.0.0.1",9999);
        serverSocket.bind(socketAddress);
        Socket socket=serverSocket.accept();
        InputStream inputStream=socket.getInputStream();
        byte[] buf=new byte[1024];
        inputStream.read(buf);
        System.out.println(new String(buf));
        socket.close();
        serverSocket.close();

    }
}
