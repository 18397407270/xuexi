package com.liuy.test;

import com.liuy.util.DBUtilPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test7 {
    public static void main(String[] args) throws SQLException {


        //如果保存1w条记录

        String sql = "insert into userinfo(uname,upass) values(?,?)";

        Connection connection = DBUtilPool.ConnectionUtils();

        long start = System.currentTimeMillis();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for(int i = 0 ; i < 10000 ; i++){

            preparedStatement.setObject(1,"jack"+i);
            preparedStatement.setObject(2,"aaaa"+i);
            preparedStatement.addBatch(); //将当前的sql预编译好以后,加到批处理; 不会直接执行到数据库里面


            if(i % 500 == 0){
                preparedStatement.executeBatch(); //执行我们批处理
                preparedStatement.clearBatch(); //把上面的执行了,需要清空
            }
        }

        preparedStatement.executeBatch(); //最后一次进行批处理

        long end = System.currentTimeMillis();

        System.out.println("");
        System.out.println(end-start);

    }
}
