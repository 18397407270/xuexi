package com.liuy.demo4.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    static String url = "jdbc:mysql://222.222.222.222:3306/mytest";
    static String username="mysql";
    static String password="66666";
    static String dirver="com.mysql.jdbc.Dirver";

    //加载我们配置文件里面的为准
    static{

        //1: 需要从配置文件里面去获取上面的信息
        Properties properties = new Properties();
        InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(is); //将这个配置文件加载到这个对象
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取配置文件里面的信息
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        dirver = properties.getProperty("dirver");

        try {
            Class.forName(dirver);
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
                connection = DriverManager.getConnection(url,username,password);
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
