package com.hzh.example;

public class Calculation {

    @Check
    public void Add(){
        System.out.println("1+0="+(1+0));
    }

    @Check
    public void Sub(){
        System.out.println("1-0="+(1-0));
    }

    @Check
    public void Mult(){
        System.out.println("1*0="+(1*0));
    }

    @Check
    public void Div(){
        System.out.println("1/0="+(1/0));
    }

    public void Show(){
        System.out.println("没有Bug,测试一切正常");
    }
}
