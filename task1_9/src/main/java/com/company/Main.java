package com.company;

import main.resources.FileInput;
import main.resources.FileOutput;
import main.resources.TextMapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInput fileInput = new FileInput("files/input.txt");
        FileOutput fileOutput = new FileOutput("files/output.txt");
        ArrayList<String> lines = fileInput.getFileContent();
        String[] searchWordsArray = {"золотом", "привет", "и", "каймой", "в"};
        ArrayList<String> searchWords = new ArrayList<>(Arrays.asList(searchWordsArray));

        TextMapper textMapper = new TextMapper(lines, searchWords);
        ArrayList<String> sortedSearchedWords = textMapper.getSortedSearchWords();
        for(String s: sortedSearchedWords) {
            fileOutput.writeLine(s);
        }
        fileOutput.closeStream();
    }
}
