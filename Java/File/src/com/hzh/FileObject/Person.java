package com.hzh.FileObject;

import java.io.Serializable;

public class Person implements Serializable {
    static final long serialVersionUID = 42L;//解决序列号不同的问题
    private String name;
    private Integer age;
   //private transient Integer age;加了transient之后不可以将其序列化

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
