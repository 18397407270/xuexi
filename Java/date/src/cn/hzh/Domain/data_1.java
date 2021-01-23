package cn.hzh.Domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class data_1 {
    public static void main(String[] args) throws ParseException {
         //Date类的使用
         date_2();

         //自定义格式输出日期
         date_3();

         //Calendar类Get方法的使用
         date_4();

         //Calendar类set方法的使用
         date_5();

         //Calendar类add方法的使用
         date_6();

    }

    private static void date_6() {
        System.out.println("====================add方法===============");
        Calendar calendar =Calendar.getInstance();
        calendar.add(Calendar.YEAR,2);
        calendar.add(Calendar.MONTH,-2);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;//西方0-11月  东方1-12月
        int day = calendar.get(Calendar.DATE);
        System.out.println(year+"-"+month+"-"+day);


    }

    private static void date_5() {
        System.out.println("======================set方法==============");
        Calendar calendar =Calendar.getInstance();
        calendar.set(Calendar.YEAR,2021);
        calendar.set(Calendar.MONTH,10);
        calendar.set(Calendar.DATE,17);
//      calendar.set(2021,10,17);//直接设置年月日

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;//西方0-11月  东方1-12月
        int day = calendar.get(Calendar.DATE);

        System.out.println(year+"-"+month+"-"+day);
    }

    private static void date_4() {
        Calendar calendar =Calendar.getInstance();
        System.out.println("====================get()方法=================");
        //get方法
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;//西方0-11月  东方1-12月
        int day = calendar.get(Calendar.DATE);
        int week = calendar.get(Calendar.WEDNESDAY);
        System.out.println("week:"+week);
        System.out.println(year+"-"+month+"-"+day);
        
    }

    private static void date_3() throws ParseException {
        Date date = new Date();
        //自定义格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
        String d = dateFormat.format(date);

        //解析,若不符合格式,则会抛出异常
        Date date1 = dateFormat.parse(d);
        System.out.println("通过parse方法解析得到:"+date1);
        //异常
        /*
        Date date2 = dateFormat.parse("4565614");
        System.out.println(date2);
        */
        System.out.println(date);
        System.out.println(d);

        System.out.println("======================");

        //完整格式
        DateFormat fulltime = DateFormat.getDateInstance(DateFormat.FULL);

        //长格式
        DateFormat longtime = DateFormat.getDateInstance(DateFormat.LONG);
        //短格式
        DateFormat shorttime = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);

        //标椎格式
        DateFormat medtime = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);

        System.out.println(fulltime.format(date));
        System.out.println(longtime.format(date));
        System.out.println(shorttime.format(date));
        System.out.println(medtime.format(date));

    }

    private static void date_2() {

        Calendar c = Calendar.getInstance();
        c.set(2017, 4, 17, 0, 0, 0);
        Date date = new Date();
        //获取1970年到现在的毫秒数
        long endtime = c.getTimeInMillis();
        System.out.println("starttime:"+date.getTime());
        System.out.println("endtime:"+endtime);
        System.out.println( date.getTime()-endtime );

        //输出当前日期
        System.out.println(date.toString());

        //设置时间距1970年多少毫秒
        Date date1 = new Date(1605975681034L);

        System.out.println(date1);

        Date date2 = new Date(1494950400021L);

        System.out.println(date2);


    }
}
