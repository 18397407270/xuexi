package com.hzh.PreparedStatement;

import com.hzh.util.JDBCUtils;

import java.sql.*;

public class QQ_Login1 {
    public boolean Login1(String username,String password){
        ResultSet resultSet =null;
        PreparedStatement preparedStatement =null;
        Connection conn =null;
        if(username==null||password==null){
            return false;
        }
        try {
            conn = JDBCUtils.ConnectionUtils();
            String sql = "select * from user where username= ? and PASSWORD= ? ";
            preparedStatement= conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.Close(resultSet,preparedStatement,conn);
        }
        return false;
    }
}
