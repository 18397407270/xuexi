package com.hzh.service;

import com.hzh.bean.BookBean;

import java.util.List;

public interface IBookService {
    int AddBook(BookBean book);
    int DeleteBook(BookBean book);
    int UpdateBook(BookBean book);
    List<BookBean> SelectBooks();
}
