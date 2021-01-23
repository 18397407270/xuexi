package com.hzh.day_01;

public class Domain1 {
    public void Show(MyFunctionInterface MyInter){
        MyInter.method();
    }
    public void print(){
        System.out.println("使用了方法调用方法");
    }
    public void print_show(){

       /* Show(()->this.print());*/
        Show(this::print);
    }


    public static void main(String[] args) {
        new Domain1().print_show();

    }
}
