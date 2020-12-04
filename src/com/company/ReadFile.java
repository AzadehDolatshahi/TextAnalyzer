package com.company;

import java.io.*;
public class ReadFile {

    public static String getText (String path) {
        String textOutput = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String next = null;
            while ((next = reader.readLine()) != null) {
                textOutput = textOutput + next;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return  textOutput;

    }
}