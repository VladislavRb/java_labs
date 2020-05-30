package com.company;

import main.resources.TextMapper;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String text = "Lorem Ipsum is simply dummy text.\nLorem Ipsum has been the industry's standard dummy text ever since the 1500s.\nIt has survived not only five centuries, but also the leap into electronic typesetting.\nIt was popularised in the 1960s with the release of Letraset sheets.";
        TextMapper textMapper = new TextMapper(text, 'd', 1);
        ArrayList<String> newLines = textMapper.getMappedLines();

        for(String str: newLines) {
            System.out.println(str);
        }
    }
}
