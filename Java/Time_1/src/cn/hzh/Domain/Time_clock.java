package cn.hzh.Domain;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time_clock extends JFrame implements Runnable {
    //创建进程
    Thread clock =new Thread(this);

    //初始化窗口
    public Time_clock(){
        //设置窗体标题
        super("电子时钟");

        //设置窗体大小
        this.setSize(250,100);

        //设置字体颜色
        this.setFont(new Font("Times New Roman",Font.BOLD,25));

        //窗体居中
        setLocationRelativeTo(null);

        //启动线程
        clock.start();

        //设置不可以拉伸窗口
        this.setResizable(false);

        //可视化窗口
        this.setVisible(true);
    }
    //主函数
    public static void main(String[] args) {
        Time_clock t = new Time_clock();
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //重写线程run方法
    @Override
    public void run() {
        while (true){
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    //重写画笔方法
    @Override
    public void paint(Graphics g){
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = format.format(date);
        g.setColor(Color.white);
        Dimension dim=getSize();
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(Color.red);
        g.drawString(s, 20, 80);
    }

}
