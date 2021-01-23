package com.liuy.demo3;

import com.liuy.demo3.entity.UserEntity;
import com.liuy.demo3.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCORMTest2 {
    public static void main(String[] args) {

        //1需要去数据库查询我们的数据表
        //2将数据表里面的内容我们封装到一个集合里面
        //3一条数据表的记录;代表我们一个实体类信息


        try {
            Connection connection = DBUtil.getConnection(); //获取连接
            PreparedStatement ps = connection.prepareStatement("select uid,uname,upass from userinfo");//获取预处理对象
            ResultSet resultSet = ps.executeQuery();//获取结果集

            //需要将这个结果集里面的数据,全部放到一个List里面;
            //list里面一个实体类对象,代表我们一条记录
            List<UserEntity> list = new ArrayList<UserEntity>();

            UserEntity userEntity;

            //循环结果集里面的每一条记录
            while(resultSet.next()){

                //先用变量保存这个列的信息
                String upass = resultSet.getString("upass");

                //实例化的过程,一定要放到循环里面; 每一次实例化代表new一个新对象;放到list里面的每一次引用地址都是不一样
                userEntity = new UserEntity();
                userEntity.setUid(resultSet.getInt("uid")); //直接获取列的信息放到实体类里面
                userEntity.setUname(resultSet.getString("uname"));
                userEntity.setUpass(upass); //把这个变量放到这里面

                //把这个实体类对象,放到List里面
                list.add(userEntity);
            }

            System.out.println(list.size());

            //遍历一下list
            for (UserEntity ue : list){
                System.out.println(ue);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
