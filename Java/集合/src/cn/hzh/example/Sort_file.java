package cn.hzh.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Sort_file {
    public static void main(String[] args) throws IOException {
        Sort();
    }

    private static void Sort() throws IOException {
        //创建hashmap集合
        HashMap<String,String> map = new HashMap<>();

        //创建输入流
        BufferedReader reader = new BufferedReader(new FileReader("E:\\Java\\集合\\src\\cn\\hzh\\example\\B_sort.txt"));
        //创建输出流
        BufferedWriter writer = new BufferedWriter(new FileWriter("After_sort.txt"));



        String len;
        while ((len=reader.readLine())!=null){
            String[] split = len.split("\\.");
            map.put(split[0],split[1]);
        }
        for (String s: map.keySet()) {
            String line = map.get(s);
            writer.write(line);
            writer.write("\r\n");
        }
        reader.close();
        writer.close();

    }
}
