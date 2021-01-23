package com.liuy.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtilPool {
    public static DataSource ds;
    static{
        Properties pro = new Properties();
        try {
            //获取配置路径
            ClassLoader classLoader = DBUtilPool.class.getClassLoader();
            URL resource = classLoader.getResource("jruid.properties");
            String path = resource.getPath();
            //将配置文件加载到集合
            pro.load(new FileReader(path));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     * 获取连接*/
    public static Connection ConnectionUtils() throws SQLException {
        Connection conn = ds.getConnection();
        return conn;
    }

    /*
     * 释放资源方法
     * */
    public static void Close(Statement statement, Connection conn){
        Close(null,statement,conn);
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
    //获取数据库连接池
    public static DataSource getDs() {
        return ds;
    }
    //使用 Hikari 获取连接
    public static Connection getConnectionByHikariCP() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        config.setUsername("root1");
        config.setPassword("123456");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);

        return ds.getConnection();

    }

}
