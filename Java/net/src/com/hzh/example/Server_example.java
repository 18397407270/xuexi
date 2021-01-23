package com.hzh.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_example {
    public static void main(String[] args) throws IOException {
        //1.定义文件输出位置
        FileOutputStream out = new FileOutputStream("b.jpg");
        //2.定义服务器
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();
        InputStream in = accept.getInputStream();
        //3.读取客户端传来的数据并且写入指定位置
        int len;
        byte [] bytes = new byte[1024];
        while ((len=in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        //4.告知客户端文件已经上传完毕
        OutputStream out1 = accept.getOutputStream();
        out1.write("文件已经上传到服务器".getBytes());
        //5.关闭输出流 客户端 服务器
        out.close();
        accept.close();
        serverSocket.close();

    }
}
