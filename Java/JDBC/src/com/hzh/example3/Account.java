package com.hzh.example3;

import com.hzh.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
*模拟转账业务
* 用事务进行管理,以防出现错误导致转账异常
* */

public class Account {
    public static void main(String[] args) {

        Connection connection =null;
        PreparedStatement psnt1=null;
        PreparedStatement psnt2=null;
        try {
           connection = JDBCUtils.ConnectionUtils();
           //开启事务
           connection.setAutoCommit(false);

           String sql1 = "update account set money = money-? where id=?";
           String sql2 = "update account set money = money+? where id=?";

           psnt1 = connection.prepareStatement(sql1);
           psnt2 = connection.prepareStatement(sql2);
           //设置参数
           psnt1.setDouble(1,500);
           psnt1.setInt(2,1);

           psnt2.setDouble(1,500);
           psnt2.setInt(2,2);

           psnt1.executeUpdate();
           /*int a = 3/0;*/
           psnt2.executeUpdate();

           //提交事务
           connection.commit();

        } catch (Exception throwables) {
            if(connection!=null){
                try {
                    //一旦有错误就进行回滚
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throwables.printStackTrace();
        }finally {
            JDBCUtils.Close(psnt1,connection);
            JDBCUtils.Close(psnt2,null);
        }
    }
}
