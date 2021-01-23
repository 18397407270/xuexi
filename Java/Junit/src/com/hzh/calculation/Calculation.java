package com.hzh.calculation;

public class Calculation {

    public int Add(int ...a){
        int sum=0;
        for(int i:a){
            sum+=i;
        }
        return sum;
    }

    public int Sub(int a,int b){
        return a-b;
    }

    public int Div(int a, int b){
        return a/b;
    }

    public int Mult(int a,int b){
        return a*b;
    }
}
