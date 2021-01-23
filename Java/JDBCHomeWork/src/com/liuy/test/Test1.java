package com.liuy.test;

import com.liuy.dao.IBookDao;
import com.liuy.dao.impl.BookDaoImpl;

import java.sql.SQLException;

//只是测试用
public class Test1 {

    public static void main(String[] args) {

        BookDaoImpl bookDao = new BookDaoImpl();

        try {
            bookDao.test(200,"jack","rose");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

}
