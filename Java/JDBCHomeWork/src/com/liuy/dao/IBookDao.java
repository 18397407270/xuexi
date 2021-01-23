package com.liuy.dao;

import com.liuy.bean.BookBean;

public interface IBookDao {

    /**
     * 添加书籍
     * @param bookBean 添加的书籍内容
     * @return 添加是否成功
     */
    public boolean addBook(BookBean bookBean);

    public boolean subMoney(float money,String name);

    public boolean addMoney(float money,String name);

}
