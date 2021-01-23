package com.hzh.dao.imp;

import com.hzh.bean.BookBean;
import com.hzh.dao.IBookDao;
import com.hzh.util.JDBCUtils1;

import java.util.List;

public class IBookDaoImp implements IBookDao {
    @Override
    public boolean AddBook(BookBean book) {
        String sql = "insert into book (bname,bprice) values(?,?)";
        return JDBCUtils1.executeDML(sql,book.getBname(),book.getBprice());
    }

    @Override
    public boolean DeleteBook(BookBean book) {
        String sql = "delete from book where bname=?";
        return JDBCUtils1.executeDML(sql,book.getBname());
    }

    @Override
    public boolean UpdateBook(BookBean book) {
        String sql = "update book set bprice=? where bname=?";
        return JDBCUtils1.executeDML(sql,book.getBprice(),book.getBname());
    }

    @Override
    public List<BookBean> SelectBooks() {
        String sql = "select * from book";
        Class<BookBean> bookBeanClass = BookBean.class;
        return JDBCUtils1.executeDQL(sql,bookBeanClass);
    }
}
