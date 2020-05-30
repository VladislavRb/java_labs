package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput {
    private String fileContent = "";

    public FileInput(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            this.fileContent += reader.nextLine() + "\n";
        }

    }

    public String getFileContent() {
        return this.fileContent;
    }
}
