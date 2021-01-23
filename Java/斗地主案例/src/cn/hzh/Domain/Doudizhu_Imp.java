package cn.hzh.Domain;

import java.util.*;

public class Doudizhu_Imp {
    public static void main(String[] args) {
        //定义poke集合
        List<String> poke = new ArrayList<String>();
        //定义花色数组
        String [] color = {"♠","♥","♣","♦"};
        //定义poke的数字
        String [] number = {"3","4","5","6","7","8","9","10","J","Q","K","A","2",};
        //把54张牌全部添加到poke集合里面
        poke.add("小王");
        poke.add("大王");
        for (String numbers:number) {
            for (String colors:color) {
                poke.add(colors+numbers);
            }
        }
        Collections.shuffle(poke);
        //定义玩家与底牌
        List<String> play1 = new ArrayList<String>();
        List<String> play2 = new ArrayList<String>();
        List<String> play3 = new ArrayList<String>();
        List<String> dipai = new ArrayList<String>();
        for(int i=0;i<poke.size();i++){
            String p = poke.get(i);
            if(i%3==0){
                play1.add(p);
            }
            else if(i%3==1){
                play2.add(p);
            }
            else if(i%3==2){
                play3.add(p);
            }
            if(i>=51){
                dipai.add(p);
            }
        }
      

        System.out.println("玩家一"+play1);
        System.out.println("玩家二"+play2);
        System.out.println("玩家三"+play3);
        System.out.println("底牌"+dipai);
    }
}
