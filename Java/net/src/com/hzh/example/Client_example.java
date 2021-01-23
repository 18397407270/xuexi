package com.hzh.example;

import java.io.*;
import java.net.Socket;

public class Client_example {
    public static void main(String[] args) throws IOException {
        //1.上传文件位置
        FileInputStream in = new FileInputStream("a.jpg");
        //2.定义客户端
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream out = socket.getOutputStream();
        //3.开始写入数据
        int len;
        byte [] bytes = new byte[1024];
        while((len=in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }

        //4.添加结束符,不然会阻塞
        socket.shutdownOutput();
        //5.接收服务器传来的信息
        InputStream in1 = socket.getInputStream();
        byte [] bytes1 = new byte[1024];
        int len1 =in1.read(bytes1);
        System.out.println(new String(bytes1,0,len1));
        //6.关闭输入流与客户端
        in.close();
        socket.close();
    }
}
