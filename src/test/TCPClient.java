package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @program: sort
 * @Date: 2018/10/15 11:59
 * @Author: Mr.Li
 * @Description:
 */
public class TCPClient {
    public static void main(String[] args) throws IOException{
        send();
    }
    private static void send() throws IOException {
        Socket socket=new Socket("127.0.0.1",9999);
        OutputStream outputStream=socket.getOutputStream();
        //byte[] buf=new byte[1024];
        String data="你好";
        byte[] buf=data.getBytes();
        outputStream.write(buf,0,buf.length);
        socket.close();
    }

}
