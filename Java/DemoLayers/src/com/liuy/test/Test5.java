package com.liuy.test;

import com.liuy.util.DBUtilPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test5 {
    public static void main(String[] args) {

        try {
            Connection connection = DBUtilPool.ConnectionUtils();

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
