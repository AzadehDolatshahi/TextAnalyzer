package com.company;


import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TextAnalyzer {

    public String completeText;

    // Constructor
    public TextAnalyzer(String text) {
        this.completeText = text;
    }
    // split text into sentences ,String array, by breaking at .?!
    public String[] getSentences() {
        return completeText.split("[.?!]");
    }

    // get number of sentences by length of the String array
    public int getSentenceCount(){
        return getSentences().length;
    }

    // split sentences to words and save in Hashmap with their occurrence
    public Map<String, Integer> getWords() {
        // define the Hashmap with the Words are Keywords and value is the occurrence
        Map<String, Integer> output = new HashMap<>();
        String[] sentences = this.getSentences();
        // iterate over each sentence in the String array and split by space to get words
        for (String sentence: sentences) {
            String[] words = sentence.split(" ");
            for (String word: words) {
                // To avoid getting empty char
                if (word.isEmpty() == false) {
                    String key = word.toLowerCase();
                    // if the word does not exist in Hashmap create Key and assign value 1
                    if (output.get(key) == null) {
                        output.put(key, 1);
                        // if the word(key) exists, add 1 to the value
                    } else {
                        output.put(key, output.get(key) + 1);
                    }
                }
            }
        }
        return  output;
    }


    // get number of words
    public int getWordsCount(){
        Map<String, Integer> words = getWords();
        int sum;
        return  sum = words.values().stream().mapToInt(Integer::intValue).sum();
    }

    // sort map in descending order
    public Map<String, Integer> sortDescendingOrder() {
        Map<String, Integer> words = getWords();
        Map<String, Integer> sortedMap =
                words.entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e2, e1) -> e2, LinkedHashMap::new));
        return  sortedMap;
    }

    // the top 5 most popular words in the text
    public Map<String, Integer> getTopWords() {
        Map<String, Integer> words = sortDescendingOrder();
        Map<String, Integer> topRanking =
                words.entrySet().stream()
                        .limit(5)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return topRanking;
    }




}
