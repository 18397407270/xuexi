package com.liuy.demo4.test;

import com.liuy.demo4.dao.PersonDaoImpl;
import com.liuy.demo4.info.PersonInfo;

public class Test1 {
    public static void main(String[] args) {

        //我需要去对person进行修改和删除的操作;
        PersonDaoImpl personDao = new PersonDaoImpl();
        boolean flag = personDao.delete(2);//根据id删除这个信息
        if(flag){
            System.out.println("删除成功");
        }

        PersonInfo personInfo = new PersonInfo();
        personInfo.setPid(1);
        personInfo.setPname("hahaha");

        //修改person的信息
        if(personDao.update(personInfo)){
            System.out.println("修改成功");
        }

    }
}
