package com.liuy.test;

import com.liuy.util.DBUtilPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test6 {

    public static void main(String[] args) {
        try {

            //通过HikariCP来获取连接对象
            Connection connection = DBUtilPool.getConnectionByHikariCP();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                System.out.println(resultSet.getObject(2));
            }


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
