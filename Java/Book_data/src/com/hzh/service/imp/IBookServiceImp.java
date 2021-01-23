package com.hzh.service.imp;

import com.hzh.bean.BookBean;
import com.hzh.code.SystemCode;
import com.hzh.dao.IBookDao;
import com.hzh.dao.imp.IBookDaoImp;
import com.hzh.service.IBookService;

import java.util.List;

public class IBookServiceImp implements IBookService {
    IBookDao Book = new IBookDaoImp();
    @Override
    public int AddBook(BookBean book) {
        boolean b = Book.AddBook(book);
        if (b){
            return SystemCode.ADD_SUCCESS;
        }else{
            return SystemCode.ADD_ERROR;
        }
    }

    @Override
    public int DeleteBook(BookBean book) {
        boolean b = Book.DeleteBook(book);
        if (b){
            return SystemCode.Delete_SUCCESS;
        }else{
            return SystemCode.Delete_ERROR;
        }
    }

    @Override
    public int UpdateBook(BookBean book) {
        boolean b = Book.UpdateBook(book);
        if (b){
            return SystemCode.Update_SUCCESS;
        }else{
            return SystemCode.Update_ERROR;
        }
    }

    @Override
    public List<BookBean> SelectBooks() {
        return  Book.SelectBooks();
    }
}
