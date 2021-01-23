package com.liuy.dao.impl;

import com.liuy.bean.BookBean;
import com.liuy.dao.IBookDao;
import com.liuy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDaoImpl implements IBookDao {


    /**
     * 添加书籍
     * @param bookBean 添加的书籍内容
     * @return 添加是否成功
     */
    @Override
    public boolean addBook(BookBean bookBean) {

        String sql = "insert into book(bname,bprice) values(?,?)";

        //通过我们通用的dml操作插入书籍信息
        return DBUtil.executeDML(sql,bookBean.getBname(),bookBean.getBprice());
    }

    /**
     * 执行扣钱的动作
     * @param money
     * @param name
     * @return
     */
    @Override
    public boolean subMoney(float money,String name) {

        String sql = "UPDATE user_acount SET umoney = umoney-? WHERE uname = ?";
        return DBUtil.executeDML(sql,money,name);
    }

    /**
     * 执行价钱的动作
     * @param money
     * @param name
     * @return
     */
    @Override
    public boolean addMoney(float money,String name) {
        String sql = "UPDATE user_acount SET umoney = umoney+? WHERE uname = ?";
        return DBUtil.executeDML(sql,money,name);
    }


    public void test(float money,String subname,String addname) throws SQLException {

        String sql1 = "UPDATE user_acount SET umoney = umoney-? WHERE uname = ?";
        String sql2 = "UPDATE user_acount SET umoney = umoney+? WHERE uname = ?";

        Connection connection = DBUtil.getConnection();
        connection.setAutoCommit(false); //不自动提交事务

        //减钱
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setObject(1,money);
        preparedStatement.setObject(2,subname);
        System.out.println(preparedStatement.executeUpdate());

        //加钱
        PreparedStatement statement = connection.prepareStatement(sql2);
        statement.setObject(1,money);
        statement.setObject(2,addname);
        System.out.println(statement.executeUpdate());

        //需要我们手动提交事务
//        connection.commit();//提交事务
        connection.rollback();//回滚事务
    }
}
