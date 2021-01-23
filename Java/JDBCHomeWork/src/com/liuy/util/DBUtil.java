package com.liuy.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBUtil {

    //通过连接池获取数据库连接
    static DataSource dataSource;

    static{
        //加载配置文件
        Properties properties = new Properties();
        InputStream resourceAsStream = DBUtil.class.getClassLoader().getResourceAsStream("druid.properties");

        try {
            properties.load(resourceAsStream);

            //根据配置文件获取一个数据源
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){

        try {
            return dataSource.getConnection();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
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
            Connection connection = getConnection();

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
            Connection connection = getConnection(); //获取连接

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
                    if(null != object){
                        try {
                            Field field = cls.getDeclaredField(columnLabel);//根据属性的名称通过反射获取他的属性对象
                            field.setAccessible(true);
                            field.set(t,object);
                        } catch (NoSuchFieldException e) {
                            //代表我们当前这个实体类里面,没有这个属性
                        }
                    }
                }

                //需要将t对象保存到list
                list.add(t);
            }

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
