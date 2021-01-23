package com.hzh.JDBC_template;

import com.hzh.util.JDBCUtils1;
import org.springframework.jdbc.core.JdbcTemplate;
/*
* 用的是jruid的配置文件
* 用自定义的工具类生成的DataSource对象
* JdbcTemplate用的是Spring自带有一个连接池DriverManagerDataSource
*
* Spring中有一个类JdbcTemplate,它封装了JDBC的操作方法。我们只需要传入一个连接池就可以用它来操作数据库。
优点:
1,不用频繁的创建或关闭连接。
2,设置参数更方便。不用写大量的setXXX方法
3,能快速的返回需要的类型。
4,对比mybatis,JdbcTemplate操作一些简单的查询更加快速,比如查询某一行一列,即一个单元格的值。这时候用mybatis操作可能还更麻烦。
5,JdbcTemplate对一些复杂的查询语句操作更加灵活。因为sql语句和JAVA代码在同一个类上。拼接操作更加快速。
缺点:
1,复杂sql及其拼接过程还有结果集操作都写在java类上,耦合性强,这样会导致维护性下降。
由于这个缺点。JdbcTemplate使用的就不多了。但操作简单语句,查询少量列的时候它还是很给力的。
*
* */




public class TemplateDemo {

    public static void main(String[] args) {

        //1.获取jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils1.getDs());

        //2.定义sql
        /*String sql = "update user set sex= ? where id= ?";*/
        String sql1 = "select count(id) from user";
        //update可以增删改
        /*int a = jdbcTemplate.update(sql, "女", 40);*/
        long a=jdbcTemplate.queryForObject(sql1,long.class);
        System.out.println(a);



    }
}
