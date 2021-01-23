package com.liuy.test;

import com.liuy.util.DBUtil;

public class Test1 {

    public static void main(String[] args) {

        //测试DBUtil是否可用
        String sql = "insert into userinfo(uname,upass) values(?,?)";
        boolean flag = DBUtil.executeDML(sql,"haha","123213");

        if(flag){
            System.out.println("注册成功");
        }

    }

}
