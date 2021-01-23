package com.hzh.day_05;

import java.util.function.Consumer;

public class Lambda_consume_Andthen1 {
    public static void main(String[] args) {

        String[] s ={"迪丽热巴,女","古力娜扎,女","胡歌,男"};
        //实现方式一
       /* for (String i:s){
            Consume(i,
                    (name1)-> {
                        String[] split = name1.split(",");
                        System.out.print("姓名:"+split[0]+"   ");
                    },
                    (name2)-> {
                        String[] split = name2.split(",");
                        System.out.println("姓别:"+split[1]);
                    }
            );
        }*/
        //实现方式二
        Consume(s,
                (name1)-> {
                    String[] split = name1.split(",");
                    System.out.print("姓名:"+split[0]+"   ");
                },
                (name2)-> {
                    String[] split = name2.split(",");
                    System.out.println("姓别:"+split[1]);
                }
        );
    }
    public static void Consume(/*String s*/ String [] s,Consumer<String> co1,Consumer<String> co2){
     //实现方式一
     /*co1.andThen(co2).accept(s);*/
     //实现方式二
        for(String s1:s){
            co1.andThen(co2).accept(s1);
        }

    }
}
