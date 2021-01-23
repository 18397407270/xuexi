package com.liuy.demo2.util;

import java.sql.*;

public class DBUtil {

    static String url = "jdbc:mysql://127.0.0.1:3306/mytest";
    static String name = "root";
    static String pass = "123456";

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过这个方法可以到一个数据库的连接
     * @return 一个数据库连接
     */
    public static Connection getConnection(){

        Connection connection = null; //每次调用这个方式,不同的人,拿到的就是不同的连接

        if(null == connection){
            try {
                connection = DriverManager.getConnection(url,name,pass);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return connection;
    }


    /**
     * 关闭你传过来的相应的对象
     * @param resultSet 结果集
     * @param preparedStatement 预处理对象
     * @param connection 连接对象
     */
    public static void close(ResultSet resultSet , PreparedStatement preparedStatement , Connection connection){

        try{

            if(null != resultSet){
                resultSet.close();
            }

            if(null != preparedStatement){
                preparedStatement.close();
            }

            if(null != connection){
                connection.close();
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

}
