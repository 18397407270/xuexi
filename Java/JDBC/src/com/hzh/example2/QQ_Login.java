package com.hzh.example2;

import com.hzh.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QQ_Login {
    public boolean Login(String username,String password){
        ResultSet resultSet =null;
        Statement statement =null;
        Connection conn =null;
        if(username==null||password==null){
            return false;
        }
        try {
             conn = JDBCUtils.ConnectionUtils();
            String sql = "select * from user where username='"+username+"' and PASSWORD='"+password+"'";
            System.out.println(sql);
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.Close(resultSet,statement,conn);
        }
        return false;
    }
}
