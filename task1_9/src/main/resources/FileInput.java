package main.resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput {
    private String path;
    private ArrayList<String> fileContent = new ArrayList<>();

    public FileInput(String path) throws FileNotFoundException {
        this.path = path;
        File file = new File(this.path);
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            this.fileContent.add(reader.nextLine());
        }

    }

    public ArrayList<String> getFileContent() {
        return this.fileContent;
    }
}
