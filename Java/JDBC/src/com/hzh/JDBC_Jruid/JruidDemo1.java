package com.hzh.JDBC_Jruid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.hzh.util.JDBCUtils1;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JruidDemo1 {
    public static void main(String[] args) {


            //加载配置文件
        Connection conn= null;
        PreparedStatement psmt =null;
        try {
            conn = JDBCUtils1.ConnectionUtils();
            //sql
            String sql ="insert into user values(?,?,?,?,?)";

            psmt = conn.prepareStatement(sql);

            psmt.setInt(1,65);
            psmt.setString(2,"小刘");
            psmt.setString(3,"2011-11-10 00:00:00");
            psmt.setString(4,"女");
            psmt.setString(5,"北京");

            psmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils1.Close(psmt,conn);
        }

    }
}
