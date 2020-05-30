package FileIO;

import entities.Poem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileOutput {
    private FileWriter outputStream;

    public FileOutput(String path) throws IOException {
        this.outputStream = new FileWriter(path);
    }

    public void writeLine(String line) throws IOException {
        this.outputStream.write(line + "\n");
    }

    public void writePoems(ArrayList<Poem> poems) {
        for(int i = 0; i < poems.size(); i++) {
            try {
                for(String line: poems.get(i).getLines()) {
                    this.writeLine(line);
                }

                if(i != poems.size() - 1) {
                    this.writeLine("//");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void closeStream() throws IOException {
        this.outputStream.close();
    }
}
