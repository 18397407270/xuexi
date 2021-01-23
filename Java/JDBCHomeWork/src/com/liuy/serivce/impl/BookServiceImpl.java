package com.liuy.serivce.impl;

import com.liuy.bean.BookBean;
import com.liuy.code.SystemCode;
import com.liuy.dao.IBookDao;
import com.liuy.dao.impl.BookDaoImpl;
import com.liuy.serivce.IBookService;

/**
 * 业务层
 * 不直接和数据库打交道
 */
public class BookServiceImpl implements IBookService {

    //数据库交互
    IBookDao bookDao = new BookDaoImpl();

    /**
     * 添加书籍
     * @param bookBean 添加的书籍内容
     * @return 添加是否成功
     */
    @Override
    public int addBook(BookBean bookBean) {

        //根据不同的情况,对整个业务进行把控
        boolean result = bookDao.addBook(bookBean);

        if(result){
            return SystemCode.ADD_SUCCESS;
        }

        return SystemCode.ADD_ERROR; //没有直接返回1009 ; 一般在项目里面,代码不允许出现 纯数字 纯字符串
    }
}
