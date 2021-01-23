package com.hzh.work;

public class Test {
    public static void main(String[] args) {
        DuXie d = new DuXie();
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    d.add(new Object());
                }
            },"写操作"+i).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    d.get(j);
                }
            },"读操作"+i).start();
        }

    }
}
