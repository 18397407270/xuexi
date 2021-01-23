package com.hzh.JDBC_template;

import com.hzh.util.JDBCUtils1;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TemplateDemo1 {
    /*
    * jdbcTemplate,使用之后会被释放,不可以重复使用
    * */
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils1.getDs());

    @Test
    public void test1(){
        /*
        * 1.将ID为40的人的性别改为男
        * */
        jdbcTemplate = new JdbcTemplate(JDBCUtils1.getDs());
        String sql = "update user set sex= ? where id= ?";

        jdbcTemplate.update(sql, "男", 40);
    }
    @Test
    public void test2(){
        /*
        * 2.添加一个人的记录
        * */
        String sql ="insert into user values(?,?,?,?,?)";
        jdbcTemplate.update(sql,90,"张三","1999-11-10 00:00:00","男","天津");
    }
    @Test
    public void test3(){
        /*
         * 3.删除刚刚添加的数据
         * */
        String sql ="delete from user where id= ?";
        jdbcTemplate.update(sql,90);
    }

    @Test
    public void test4(){
        /*
         * 4.查询id为40的人的信息,将其封装为map集合
         * */
        String sql ="select * from user where id= ?";
        //queryForMap查询的结果只能是一行
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, 40);
        System.out.println(stringObjectMap);
    }
    @Test
    public void test5(){
        /*
         * 5.查询所有信息
         * */
        String sql ="select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> s:maps
             ) {
            System.out.println(s);
        }

    }

    @Test
    public void test6(){
        /*
         * 6.查询所有信息,并将其封装为person对象的List集合
         * */
        String sql ="select * from user";
        List<Person> list = jdbcTemplate.query(sql, new RowMapper<Person>() {

            @Override
            public Person mapRow(ResultSet resultSet, int i) throws SQLException {
                int anInt = resultSet.getInt(1);
                String username = resultSet.getString("username");
                String birthday = resultSet.getString("birthday");
                String sex = resultSet.getString("sex");
                String address = resultSet.getString("address");
                return (new Person(anInt,username,birthday,sex,address));
            }
        });

        for (Person p:list
             ) {
            System.out.println(p);
        }

    }
/*
* 简化版本
* */
    @Test
    public void test7(){
        /*
         * 6.查询所有信息,并将其封装为person对象的List集合
         * 一般使用BeanPropertyRowMapper<类型>(类型的字节码),,可以完成数据到javaBean的自动封装
         * */
        String sql ="select * from user";
        List<Person> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Person>(Person.class));
        for (Person p:list
             ) {
            System.out.println(p);
        }

    }

    @Test
    public void test8(){
        /*
         * 6.查询所有id的数量
         * */
        String sql ="select count(id) from user";
        Long aLong = jdbcTemplate.queryForObject(sql, long.class);
        System.out.println(aLong);
    }

    public static void main(String[] args) {


    }
}
