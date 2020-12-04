package com.company;


public class Main {
    public static void main(String[] args) {

        // give path
        String path = "/Users/azadehwork/Desktop/text.txt";

        // reads file to String, decomposes to sentences and words
        TextAnalyzer analyzer = new TextAnalyzer(ReadFile.getText(path));

        // iterate through sentences array to print all sentences
        int countSentences = analyzer.getSentenceCount();
        String [] sentences = analyzer.getSentences();
        for (int i = 0 ; i < countSentences ; i++) {
            System.out.println(sentences[i]);
        }
        // get Sentence Count
        System.out.println(analyzer.getSentenceCount());

        //get Words Count
        System.out.println(analyzer.getWordsCount());


        // get top 5 words
        System.out.println(analyzer.getTopWords());


    }
}
