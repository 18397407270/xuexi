package cn.hzh.Domain;

import javax.swing.*;
import java.awt.*;

public class Time_clock {
    private static void creat_GUI(){
        //布局时钟位置
        JFrame f = new JFrame("Clock");
        JLabel L1 = new JLabel("Clock");
        Font font = new Font("宋体",Font.BOLD,20);
        L1.setFont(font);
        L1.setHorizontalAlignment(JLabel.CENTER);
        f.add(L1,"Center");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250,100);

        f.setVisible(true);

        //开始线程
        Thread t = new MyThread(L1);
        t.start();
    }
    public static void main(String[] args) {
        creat_GUI();

    }
}
