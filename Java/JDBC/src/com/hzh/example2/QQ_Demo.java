package com.hzh.example2;

import com.hzh.PreparedStatement.QQ_Login1;

public class QQ_Demo {
    public static void main(String[] args) {
        //boolean f= new QQ_Login().Login("张三", "123456");
        //sql注入
        boolean f= new QQ_Login1().Login1("张三", " a' or 'a'='a");
        if(f){
            System.out.println("登陆成功");
        }else{
            System.out.println("用户名或者密码错误");
        }
    }
}
