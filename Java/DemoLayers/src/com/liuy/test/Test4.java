package com.liuy.test;

import com.liuy.info.Person;
import com.liuy.info.PersonInfo;
import com.liuy.info.UserInfo;
import com.liuy.util.DBUtil;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {

        String sql = "select * from user";

        List<Person> person = DBUtil.executeDQL(sql, Person.class);

        for(Person u : person){
            System.out.println(u);
        }

        System.out.println("======================================================");

        /*String sql2 = "select pid,pname,page age from person";
        List<PersonInfo> personInfos = DBUtil.executeDQL(sql2, PersonInfo.class);
        for(PersonInfo p : personInfos){
            System.out.println(p);
        }*/
    }
}
