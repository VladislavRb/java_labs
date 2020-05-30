package com.company;

import FileIO.FileInput;
import FileIO.FileOutput;
import entities.Poem;
import entities.PoemList;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInput fileInput = new FileInput("files/poems.txt");
        FileOutput fileOutput = new FileOutput("files/sorted_poems.txt");

        String fileContent = fileInput.getFileContent();
        ArrayList<Poem> sortedPoems = (new PoemList(fileContent)).getSortedPoems();
        fileOutput.writePoems(sortedPoems);

        fileOutput.closeStream();
    }
}
