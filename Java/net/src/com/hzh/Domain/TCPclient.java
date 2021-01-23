package com.hzh.Domain;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPclient {
    public static void main(String[] args) throws IOException {
        Socket s1 = new Socket("127.0.0.1",8888);
        OutputStream o1 = s1.getOutputStream();
        o1.write(("我是客户端").getBytes());
        InputStream inputStream = s1.getInputStream();
        byte [] bytes = new byte[1024];
        int len =inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        o1.close();
        s1.close();

    }
}
