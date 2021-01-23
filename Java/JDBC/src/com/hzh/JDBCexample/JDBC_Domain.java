package com.hzh.JDBCexample;

import java.util.List;

public class JDBC_Domain {
    public static void main(String[] args) {
        JDBC_Demo j = new JDBC_Demo();
        /*List<Person> people = j.FindAll();
        for (Person person : people) {
            System.out.println(person);
        }*/
        List<Person> people = j.FindAll1();
        for (Person personList:people) {
            System.out.println(personList);
        }

    }
}
