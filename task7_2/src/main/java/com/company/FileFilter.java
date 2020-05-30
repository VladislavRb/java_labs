package main.java.com.company;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FileFilter {
    private String mask;
    private ArrayList<String> fileNames;
    private ArrayList<String> extensions = new ArrayList<>();

    public FileFilter(String mask, ArrayList<String> fileNames) {
        this.mask = mask;
        this.fileNames = fileNames;
        for(String filename: this.fileNames) {
            this.extensions.add(this.getExt(filename));
        }
    }

    public FileFilter() {
        this("", new ArrayList<>());
    }

    public String getExt(String filename) {
        return filename.substring(filename.lastIndexOf('.') + 1);
    }

    public String getFileNameWithoutExt(String filename) {
        String extSubstr = "." + this.getExt(filename);
        return filename.replace(extSubstr, "");
    }

    public String fileNameIntoMask(String fileName) {
        String mask = "";
        char ch = fileName.charAt(0);
        int counter = 0;
        for(int i = 0; i < fileName.length(); i++) {
            char currentChar = fileName.charAt(i);
            if(currentChar == ch) {
                counter++;
            }
            else {
                mask += counter;
                counter = 1;
                ch = currentChar;
            }
        }

        return mask + counter;
    }

    public ArrayList<String> filterFileNamesByMask() {
        return this.fileNames.stream()
                .filter(s -> this
                        .fileNameIntoMask(this.getFileNameWithoutExt(s))
                        .equals(this.mask))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
