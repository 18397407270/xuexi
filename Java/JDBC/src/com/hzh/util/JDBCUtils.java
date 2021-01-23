package com.hzh.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/*
*
* 数据库连接工具类
* */
public class JDBCUtils {
    public static String url;
    public static String user;
    public static String password;
    public static String driver;

     static{
        Properties pro = new Properties();
        try {
            //获取配置路径
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL resource = classLoader.getResource("JDBC.properties");

            if(resource !=null){
                String path = resource.getPath();
                pro.load(new FileReader(path));
            }
            //将配置文件加载到集合
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
            //注册驱动
            Class.forName(driver);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static Connection ConnectionUtils() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }

    /*
    * 释放资源方法
    * */
    public static void Close(Statement statement, Connection conn){
        if(statement !=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void Close(ResultSet rs, Statement statement, Connection conn){

        if(rs !=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(statement !=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
