package com.liuy.demo4.test;

import com.liuy.demo4.dao.PersonDaoImpl;
import com.liuy.demo4.info.PersonInfo;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {

        //对person去做查询的动作和删除的动作
        PersonDaoImpl personDao = new PersonDaoImpl();

        //删除
        if(personDao.delete(4)){
            System.out.println("删除成功");
        }

        //查询
        List<PersonInfo> list = personDao.query();

        for(PersonInfo p : list){
            System.out.println(p);
        }

    }
}
