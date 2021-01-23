package com.hzh.work;

import java.util.ArrayList;
import java.util.List;

public class DuXie {
    List list = new ArrayList();
    Object wr = new Object();
    boolean IsRead = false;
    boolean IsWrite = false;

    public void add(Object o){
        while (IsRead){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (wr){
            while (IsWrite){
                try {
                    wr.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            IsWrite  = true;
            list.add(o);
            System.out.println(Thread.currentThread().getName()+"正在写数据");
            IsWrite = false;
        }

    }

    public Object get(int index){
        if(index> list.size()){
            throw new ArrayIndexOutOfBoundsException("下标越界");
        }
        while (IsWrite){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try{
            IsRead = true;
            return list.get(index);
        }finally {
            System.out.println(Thread.currentThread().getName()+"正在读数据");
            IsRead = false;
        }

    }
}
