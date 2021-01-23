package com.liuy.demo4.test;

import com.liuy.demo4.dao.IPersonDao;
import com.liuy.demo4.dao.PersonDaoImpl;
import com.liuy.demo4.info.PersonInfo;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {


        //面向接口编程;
        IPersonDao personDao = new PersonDaoImpl();

        List<PersonInfo> query = personDao.query();

    }
}
