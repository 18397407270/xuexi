package com.liuy.demo3.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest2 {
    public static void main(String[] args) {

        try {
            //获取连接 要使用自己包下面的去获取
            Connection connection = DBUtil.getConnection();

            //预处理sql语句
            String sql = "select uid,uname,upass from userinfo where uid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //设置参数
            preparedStatement.setInt(1,8);

            //执行修改
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                //获取结果集里面的用户名
                System.out.println(resultSet.getString("uname"));
            }

            //关闭连接
            DBUtil.close(resultSet,preparedStatement,connection);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
