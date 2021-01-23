package com.hzh.Domain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPserver {
    public static void main(String[] args) throws IOException {
        //1.创建服务端
        ServerSocket socket = new ServerSocket(8888);
        //2.获取客户端
        Socket accept = socket.accept();
        InputStream inputStream = accept.getInputStream();
        //3.输出客户端发给服务端的信息
        byte [] bytes = new byte[1024];
        int len =inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        //4.给客户端回应信息
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("服务器已经收到信息".getBytes());
        //关闭服务器与客户端
        accept.close();
        socket.close();

    }
}
