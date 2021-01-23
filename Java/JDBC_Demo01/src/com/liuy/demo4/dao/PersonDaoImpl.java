package com.liuy.demo4.dao;

import com.liuy.demo4.info.PersonInfo;
import com.liuy.demo4.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements IPersonDao{

    /**
     * 传入一个person的信息,保存这个person的信息
     * @return 保存是否成功
     */
    public boolean insert(PersonInfo pi){

        String sql = "insert into person(pname,page) values(?,?)";

        try {
            //获取连接
            Connection connection = DBUtil.getConnection();

            //获取执行sql的对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //设置参数
            preparedStatement.setString(1, pi.getPname());
            preparedStatement.setInt(2,pi.getAge());

            //执行sql
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return false;
    }

    /**
     * 传入一个person的信息,修改这个person的信息
     * @return 修改是否成功
     */
    public boolean update(PersonInfo pi){

        String sql = "update person set pname=?,page=? where pid=?";

        try {
            //获取连接
            Connection connection = DBUtil.getConnection();

            //获取执行sql的对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //设置参数
            preparedStatement.setObject(1,pi.getPname());
            preparedStatement.setObject(2,pi.getAge());
            preparedStatement.setObject(3,pi.getPid());

            //执行sql
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return false;
    }

    /**
     * 根据id删除一条数据信息
     * @param pid 唯一编号
     * @return 删除是否成功
     */
    public boolean delete(int pid){

        String sql = "delete from person where pid=?";

        try {
            //获取连接
            Connection connection = DBUtil.getConnection();

            //获取执行sql的对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //设置参数
            preparedStatement.setObject(1,pid);

            //执行sql
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return false;
    }

    /**
     * 查询所有的person表的信息
     * @return person集合
     */
    public List<PersonInfo> query(){
        List<PersonInfo> list = null;

        String sql = "select pid,pname,page from person";

        try {
            //获取连接
            Connection connection = DBUtil.getConnection();

            //获取执行sql的对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //处理结果集
            ResultSet resultSet = preparedStatement.executeQuery();

            list = new ArrayList<>();
            PersonInfo pi;

            while(resultSet.next()){
                pi = new PersonInfo();

                pi.setPid(resultSet.getInt("pid"));
                pi.setPname(resultSet.getString("pname"));
                pi.setAge(resultSet.getInt("page"));

                list.add(pi);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return list;
    }

}
