package com.company;

import main.java.com.company.FileFilter;
import main.java.com.company.FolderReader;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String mask = "123";
        FolderReader folderReader = new FolderReader("files");
        FileFilter fileFilter = new FileFilter(mask, folderReader.getFileNameList());
        ArrayList<String> filteredFileNames = fileFilter.filterFileNamesByMask();
        for(String str: filteredFileNames) {
            System.out.println(str);
        }
    }
}
