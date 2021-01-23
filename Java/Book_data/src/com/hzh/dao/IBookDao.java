package com.hzh.dao;

import com.hzh.bean.BookBean;

import java.util.List;

public interface IBookDao {

    boolean AddBook(BookBean book);
    boolean DeleteBook(BookBean book);
    boolean UpdateBook(BookBean book);
    List<BookBean> SelectBooks();
}
