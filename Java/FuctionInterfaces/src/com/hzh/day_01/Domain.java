package com.hzh.day_01;

public class Domain {
    public static void Show(MyFunctionInterface MyInter){
        MyInter.method();
    }


    public static void main(String[] args) {
        //用接口实现类做参数
        Show(new MyFunctionInterfaceImp());


        //用匿名内部类做参数
        Show(new MyFunctionInterface() {
            @Override
            public void method() {
                System.out.println("调用了匿名内部类方法");
            }
        });

        //使用Lambda表达式作为参数
        Show(()-> System.out.println("调用了Lambda表达式方法"));
    }
}
