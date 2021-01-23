package com.hzh.FileFilter;

import java.io.File;
import java.io.FileFilter;
import java.util.logging.Filter;

public class FileFilterImp implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if(pathname.isDirectory()){
            return true;
        }
        return pathname.getName().toString().toLowerCase().endsWith(".pdf");
    }
}
