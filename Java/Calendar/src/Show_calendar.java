import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class Show_calendar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入你想查询的日期,例如(2020-12-23)");
        String date = s.next();
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date r = df.parse(date);


            Calendar ca = new GregorianCalendar();

            ca.setTime(r);

            //得到当前时间是几号
            int day = ca.get(Calendar.DATE);

            //将时间设置为本月的一号
            ca.set(Calendar.DATE,1);

            //获取一号是星期几
            int weekday = ca.get(Calendar.DAY_OF_WEEK);

            //得到这个月最大天数
            int actualMaximum = ca.getActualMaximum(Calendar.DATE);

            System.out.println("一\t二\t三\t四\t五\t六\t日");
            if(weekday==1){
                weekday=8;
                for (int i = 1; i <weekday-1 ; i++) {
                    System.out.print("\t");
                }
            }else{
                for (int i = 1; i <weekday-1 ; i++) {
                    System.out.print("\t");
                }
            }

            for (int i = 1; i <=actualMaximum ; i++) {

                if(i==day){
                    System.out.print("*");
                }
                System.out.print(i+"\t");

                int i1 = ca.get(Calendar.DAY_OF_WEEK);
                if(i1==Calendar.SUNDAY){
                    System.out.println();
                }

                ca.add(Calendar.DATE,1);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
