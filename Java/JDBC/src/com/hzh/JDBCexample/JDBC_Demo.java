package com.hzh.JDBCexample;

import com.hzh.util.JDBCUtils;
import com.hzh.util.JDBCUtils1;

import java.sql.*;
import java.util.List;

public class JDBC_Demo {

    public List<Person> FindAll(){
        Connection conn = null;
        Statement statement =null;
        ResultSet resultSet =null;
        List<Person> list = null;
        try {


            String sql = "select * from user";

            conn = JDBCUtils.ConnectionUtils();

            statement = conn.createStatement();

            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                int anInt = resultSet.getInt(1);
                String username = resultSet.getString("username");
                String birthday = resultSet.getString("birthday");
                String sex = resultSet.getString("sex");
                String address = resultSet.getString("address");
                if(username != null && birthday != null&&sex != null && address != null){
                    list.add(new Person(anInt,username,birthday,sex,address));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.Close(resultSet,statement,conn);
        }
        return list;
    }

    public List<Person> FindAll1(){
        String sql = "select * from user";
        Class<Person> personClass = Person.class;
        List<Person> people = JDBCUtils1.executeDQL(sql, personClass);
        return people;
    }

}
