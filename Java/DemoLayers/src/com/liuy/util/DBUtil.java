package com.liuy.util;

import com.liuy.info.PersonInfo;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 并不是单纯的获取连接了
 * 而是写通用的DML处理
 */
public class DBUtil {
    public static String url;
    public static String user;
    public static String password;
    public static String driver;

    static{
        Properties pro = new Properties();
        try {
            //获取配置路径
            ClassLoader classLoader = DBUtil.class.getClassLoader();
            URL resource = classLoader.getResource("JDBC.properties");

            if(resource !=null){
                String path = resource.getPath();
                pro.load(new FileReader(path));
            }
            //将配置文件加载到集合
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
            //注册驱动
            Class.forName(driver);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static Connection ConnectionUtils() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }

    /*
     * 释放资源方法
     * */
    public static void Close(Statement statement, Connection conn){
        if(statement !=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void Close(ResultSet rs, Statement statement, Connection conn){

        if(rs !=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(statement !=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 将所有数据表的操作,抽离成一个公用的方法;
     * @Param sql 语句
     * @Param sql语句对应的参数
     * @return
     */
    public static boolean executeDML(String sql,Object... params){

        try {
            //获取连接
            Connection connection = ConnectionUtils();

            //获取预处理的对象
            PreparedStatement ps = connection.prepareStatement(sql);

            //设置参数
            if(null != params){

                for(int i = 0 ; i < params.length ; i++){

                    //1:给占位符设置参数;2:获取参数
                    ps.setObject(i+1,params[i]);
                }
            }

            int i = ps.executeUpdate();

            Close(null,ps,connection);

            return i > 0;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return false;
    }


    /**
     * 通用的查询;需要将我们的数据表信息,封装到List里面进行返回
     * @param sql 查询语句
     * @param cls 实体类的字节码对象
     * @param params 查询语句里面的占位符
     * @param <T> 实体类类型泛型
     * @return 就是我们查询到的数据集合
     */
    public static <T> List<T> executeDQL(String sql, Class<T> cls , Object... params) {


        try {
            Connection connection = ConnectionUtils(); //获取连接

            //获取预处理sql
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //设置参数
            if(null != params){

                for(int i = 0 ; i < params.length ; i++){
                    preparedStatement.setObject(i+1,params[i]);
                }

            }

            //执行查询 得到结果集
            ResultSet resultSet = preparedStatement.executeQuery();

            //获取元数据(我们的列名)
            ResultSetMetaData metaData = resultSet.getMetaData();
            //列的总数
            int columnCount = metaData.getColumnCount();

            //用来保存我们所有的表数据
            List<T> list = new ArrayList<T>();
            T t;//用来保存我们一条数据

            //遍历结果集
            while(resultSet.next()){ //每一行记录的遍历过程中

                t = cls.newInstance();//根据字节码文件,构建一个实体类的对象

                //获取所有列的数据
                for(int i = 1 ; i <= columnCount ; i++){

                    //你的查询语句有时候有别名
                    String columnLabel = metaData.getColumnLabel(i);

                    //根据列名获取我们的记录
                    Object object = resultSet.getObject(columnLabel);

                    //需要将拿到的这一列的记录,放到t对象指定的属性里面;
                    //需要拿到这个t对象的属性,然后赋值;

                    //解决方案2: 如果Object是NULL没有必要设置了
                    if (null != object) {
                        try {
                            Field field = cls.getDeclaredField(columnLabel);//根据属性的名称通过反射获取他的属性对象
                            //暴力反射,忽略安全机制
                            field.setAccessible(true);
                            //Timestamp需要转为String类型,不然会报错
                            if(object instanceof Timestamp ){
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                String creaT=sdf.format(object);
                                object = creaT;
                            }
                            field.set(t, object);
                        } catch (NoSuchFieldException e) {
                            //代表我们当前这个实体类里面,没有这个属性
                        }
                    }
                }

                //需要将t对象保存到list
                list.add(t);
            }

            Close(resultSet,preparedStatement,connection);

            return list;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }

}







