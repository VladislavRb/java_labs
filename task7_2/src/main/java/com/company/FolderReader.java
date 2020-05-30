package main.java.com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class FolderReader {
    private String folderName;
    private ArrayList<String> fileNameList = new ArrayList<>();

    public FolderReader(String folderName) {
        this.folderName = folderName;
        File folder = new File(this.folderName);
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            this.fileNameList.add(fileEntry.getName());
        }
    }

    public ArrayList<String> getFileNameList() {
        return fileNameList;
    }
}
