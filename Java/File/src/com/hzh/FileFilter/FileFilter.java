package com.hzh.FileFilter;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilter {

    public static void main(String[] args) {

        File file = new File("E:\\BaiduYunDownload");//遍历指定文件夹下的所有文件
        method3(file);
        //method4(file);
        //method5(file);

    }

    private static void method3(File dir) {
        //实现方式一内部匿名类
        /*File [] dirs = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isDirectory()||name.toLowerCase().endsWith(".pdf");
            }
        });*/
        //实现方式二lambda表达式
        File [] dirs = dir.listFiles((d,name)->new File(d,name).isDirectory()||name.toLowerCase().endsWith(".pdf"));
        for (File file:dirs) {
            if(file.isDirectory()){
                method3(file);
            }else{
                System.out.println(file.getName());
            }
        }

    }

    private static void method5(File dir) {

        File [] dirs = dir.listFiles(new java.io.FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.isDirectory()){
                    return true;
                }
                return pathname.getName().toString().toLowerCase().endsWith(".pdf");
            }
        });
        for (File file:dirs) {
            if(file.isDirectory()){
                method5(file);
            }else{
                System.out.println(file);
            }
        }
    }


    private static void method4(File dir) {
        //实现方式三
        File [] dirs = dir.listFiles(new FileFilterImp());
        for (File file:dirs) {
            if(file.isDirectory()){
                method4(file);
            }else{
                System.out.println(file);
            }
        }

    }
}
