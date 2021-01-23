package com.hzh.day_05;
//这是一个功能接口,因此可以用作一个lambda表达式赋值目标或方法参考。
//生产数据
import java.util.function.Supplier;

public class Lambda_supplier {
    public static void main(String[] args) {
        int arr[] ={100,52,14,20};

        int max1 = getMax(() -> {
                    int max = arr[0];
                    for (int i : arr) {
                        if (i > max) {
                            max = i;
                        }
                    }
                    return max;
                }
        );
        System.out.println(max1);
    }
    public static int getMax(Supplier<Integer> sup){
        return sup.get();
    }
}
