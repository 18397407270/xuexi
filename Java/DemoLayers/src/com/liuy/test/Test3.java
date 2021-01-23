package com.liuy.test;

import com.liuy.util.DBUtil;

import java.sql.*;

public class Test3 {

    public static void main(String[] args) throws SQLException {

        Connection connection = DBUtil.ConnectionUtils();

//        String sql = "select * from userinfo";
        String sql = "select pid,pname,page age from person";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //可以从这个结果集里面去获取每一列里面的数据内容;
        ResultSet resultSet = preparedStatement.executeQuery();

        //1: 第一个问题: 我们需要解决,不同表,查询过来的字段不一样的问题;
        //解决方案: 有一个方法,能够获取到当前查询结果的所有列;

        ResultSetMetaData metaData = resultSet.getMetaData(); //元数据信息; 包含了我们所有的列

        //获取当前的查询结果有多少列
        int columnCount = metaData.getColumnCount(); //获取我们当前这个查询结果有多少列

        while(resultSet.next()){ //每一行的信息

            //获取所有列的信息
            //这个循环获取了我们所有的列的信息
            for(int i = 1 ; i <= columnCount ; i++){

                String columnLabel = metaData.getColumnLabel(i);// 这个是别名

                Object object = resultSet.getObject(columnLabel);

                System.out.print(object+",");
            }

            System.out.println("");
        }

    }

}
