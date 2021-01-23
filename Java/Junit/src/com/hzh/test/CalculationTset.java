package com.hzh.test;

import com.hzh.calculation.Calculation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/*
*  Junit测试
*  Assert.assertEquals(5,div); 断言操作 判断div是不是5
*
* */

public class CalculationTset {
    //最开始执行这个方法
    @Before
    public void init(){
        System.out.println("init....");
    }
    @After
     public void end(){
        System.out.println("end....");
    }
    @Test
    public void AddTest(){
        Calculation c = new Calculation();
        int add = c.Add(1, 3);
        Assert.assertEquals(4,add);
    }

    @Test
    public void SubTest(){
        Calculation c = new Calculation();
        int sub = c.Sub(10, 5);
        Assert.assertEquals(5,sub);
    }

    @Test
    public void DivTest(){
        Calculation c = new Calculation();
        int div=0;
        try {
            div = c.Div(10, 0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            Assert.assertEquals(5,div);
        }

    }

    @Test
    public void MultTest(){
        Calculation c = new Calculation();
        int mult = c.Mult(1, 3);
        System.out.println("ing....");
        Assert.assertEquals(3,mult);
    }
}
