package com.liuy.test;

import com.liuy.dao.IPersonDao;
import com.liuy.dao.impl.PersonDaoImpl;
import com.liuy.info.PersonInfo;

public class Test2 {
    public static void main(String[] args) {

        IPersonDao personDao = new PersonDaoImpl();

        //测试删除
        boolean b = personDao.deletePerson(1);
        if(b){
            System.out.println("删除成功");
        }

        //测试插入
        PersonInfo personInfo = new PersonInfo();
        personInfo.setPname("xixi");
        personInfo.setAge(30);
        boolean b1 = personDao.insertPerson(personInfo);
        if(b1){
            System.out.println("插入成功");
        }

    }
}
