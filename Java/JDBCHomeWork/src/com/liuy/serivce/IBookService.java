package com.liuy.serivce;

import com.liuy.bean.BookBean;

public interface IBookService {

    /**
     * 添加书籍
     * @param bookBean 添加的书籍内容
     * @return 添加是否成功
     */
    public int addBook(BookBean bookBean);//如果说需要检查书籍是否已经存在了

}
