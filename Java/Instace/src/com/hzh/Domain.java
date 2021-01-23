package com.hzh;

public class Domain {
    public static void main(String[] args) {
        People people = new People();
        Student student = new Student();
        boolean aa=student instanceof People ;
        System.out.println(aa);
        boolean bb=people instanceof Student;
        System.out.println(bb);
    }
}
