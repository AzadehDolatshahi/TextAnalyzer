package com.company;


import java.net.*;
import java.io.*;

public class TextReadInternet {

    public static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);

        in.close();

        String output = response.toString().replaceAll("<[^>]*>", "").replaceAll("\\s+", " ");
        return output;
    }

}