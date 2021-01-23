package com.hzh.JDBC_c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo {
    public static void main(String[] args) throws SQLException {

        //1.创建数据库连接池
        DataSource ds = new ComboPooledDataSource();

        //2.获取数据库连接对象
        Connection conn= ds.getConnection();

        System.out.println(conn);

    }
}
