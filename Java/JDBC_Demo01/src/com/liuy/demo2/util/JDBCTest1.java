package com.liuy.demo2.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest1 {
    public static void main(String[] args) {

        try {
            //获取连接
            Connection connection = DBUtil.getConnection();

            //预处理sql语句
            String sql = "update userinfo set upass = ? where uid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //设置参数
            preparedStatement.setString(1,"888888");
            preparedStatement.setInt(2,8);

            //执行修改
            int i = preparedStatement.executeUpdate();

            if(i > 0){
                System.out.println("修改成功");
            }

            //关闭连接
            DBUtil.close(null,preparedStatement,connection);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
