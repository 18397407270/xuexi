package com.hzh.map;

public interface Map {

    //定义方法
    Object put(Object key,Object value);

    Object get(Object key);

    int size();

    boolean isEmpty();

    //内部接口
    interface Entry{
        Object getValue();
        Object getKey();
    }
}
