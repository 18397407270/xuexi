package com.hzh.JDBC_Jruid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

public class JruidDemo {
    public static void main(String[] args) {

        try {
            //加载配置文件
            Properties properties = new Properties();
            ClassLoader classLoader = JruidDemo.class.getClassLoader();
            URL resource = classLoader.getResource("jruid.properties");
            String path = resource.getPath();
            properties.load(new FileReader(path));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

            Connection connection = dataSource.getConnection();
            System.out.println(connection);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
