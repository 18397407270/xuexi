package cn.hzh.main;

public class Many_sum {

    public static void main(String[] args) {
        int s = add(1,2,3,4,5);
        add2("1",1.2,5,6,7);
        System.out.println(s);
    }
    //不同类型多参数定义
    private static void add2(String a,double b,int...c) {
        System.out.println(a);
        System.out.println(b);
        for (int i : c) {
            System.out.println(i);
        }

    }
    //同类型单一参数定义
    private static int add(int...array) {
        int sum=0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }
}
