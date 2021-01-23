package com.hzh.main;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {

        method1();
        method2();
        method3();
        File file = new File("E:\\BaiduYunDownload");//遍历指定文件夹下的所有文件
        method4(file);
        method5(file);//遍历指定文件类型

    }

    private static void method5(File dir) {
        File [] dirs = dir.listFiles();

        for (File file:dirs) {
            if(file.isDirectory()){
                method5(file);
            }else{
                String s = file.toString();
                if(s.endsWith(".pdf")){
                    System.out.println(s);
                }
            }
        }
    }

    private static void method4(File dir) {
        System.out.println(dir);
        File [] dirs = dir.listFiles();

        for (File file:dirs) {
            if(file.isDirectory()){
                method4(file);
            }else{
                System.out.println(file);
            }
        }

    }

    private static void method3() throws IOException {
        File f1= new File("E:\\Java\\File\\a.txt");
        boolean newFile = f1.createNewFile();
        System.out.println(newFile);


    }

    private static void method2() {
        String s = "a.txt";
        File file = new File("C:\\Users\\hzh\\Documents\\Downloads");
        File f = new File(file,s);
        System.out.println(f.getAbsolutePath());
        //判断文件是否存在
        if(file.exists()){
            System.out.println(file.getName());//得到文件名称
            System.out.println(file.getAbsoluteFile());//得到文件绝对路径
            System.out.println(file.getPath());//得到文件相对路径
            System.out.println(file.getParent());//得到文件父路径
            System.out.println(file.isFile());//是否为一个文件
            System.out.println(file.isDirectory());//是否为一个文件夹
        }


    }

    private static void method1() {
        /*在写文件路径时不要把路径写死了,因为在不同的系统分隔符不一样
         * C:\Users\hzh\Documents\Downloads要写成C:"+separator+"Users"+separator+"hzh"+separator+"Documents"+separator+"Downloads
         * */

        String pathSeparator = File.pathSeparator;//路径分隔符
        System.out.println(pathSeparator);//Windows是;  Linux是:

        String separator = File.separator;//文件分隔符
        System.out.println(separator);//windows是\    Linux是/
    }
}
