package com.hzh.map;

import java.util.Arrays;

public class TestHashMap {
    public static void main(String[] args) {

        java.util.HashMap map1;

        HashMap map = new HashMap();

        map.put(23,"zs");
        map.put(36,"liis");
        map.put(48,"ww");
        map.put(86,"nj");
        map.put(67,"jk");
        map.put(23,"mk");
        map.put(47,"ml");

        System.out.println(map.size());
        System.out.println(map.get(8));
        System.out.println(Arrays.toString(map.table));
        System.out.println(map);

    }
}
