package com.hzh.JDBC;

import java.sql.*;

public class Jdbc_Demo2 {
    public static void main(String[] args) {

                Connection conn=null;
                Statement statement = null;
                ResultSet resultSet =null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
            //添加数据sql
            String sql = "insert into user values(60,'小叶','2011-11-10 00:00:00','女','上海')";
            //修改数据sql1
            String sql1 = "update user set sex='男' where id =60";
            //删除数据sql2
            String sql2 = "delete from user where id = 60";
            //查询数据sql
            String sql3 = "select * from user";
            //3.连接数据库
            conn= DriverManager.getConnection("jdbc:mysql:///test", "root", "260477");
            //4.创建对象
            statement = conn.createStatement();
            int l2 = statement.executeUpdate(sql2);
            int l = statement.executeUpdate(sql);
            int l1 = statement.executeUpdate(sql1);
             //查询语句的执行方式
             resultSet = statement.executeQuery(sql3);
             //遍历数据
             while(resultSet.next()){
                 int anInt = resultSet.getInt(1);
                 String username = resultSet.getString("username");
                 String birthday = resultSet.getString("birthday");
                 String sex = resultSet.getString("sex");
                 String address = resultSet.getString("address");
                 System.out.println("id:"+anInt+"username:"+username+"birthday:"+birthday+"sex:"+sex+"address:"+address);
             }
            if(l2>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
            if(l>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
            if(l1>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //避免空指针异常
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }
}
