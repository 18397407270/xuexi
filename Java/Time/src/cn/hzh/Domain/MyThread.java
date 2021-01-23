package cn.hzh.Domain;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {
    private JLabel clock;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
    public MyThread(JLabel clock){
        this.clock = clock;
    }
    @Override
    public void run(){
        while (true){
            clock.setText(this.getTime());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private String getTime(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = format.format(date);
        return d;
    }



}
