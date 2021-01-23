package com.liuy.demo4.info;

public class PersonInfo {

    private int pid;
    private String pname;
    private int age;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", age=" + age +
                '}';
    }
}
