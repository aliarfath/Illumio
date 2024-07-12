package com.illumio.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordMatchCounterApp {

    private Set<String> predefinedWordSet;
    private Map<String, Integer> wordMatchCountMap;

    public Map<String, Integer> getWordMatchCountMap() {
        return wordMatchCountMap;
    }

    public WordMatchCounterApp(String preDefinedWordfilePath) {
        predefinedWordSet = new HashSet<>();
        wordMatchCountMap = new HashMap<>();
        loadPredefinedWords(preDefinedWordfilePath);
    }
    public static void main(String[] args) {
        System.out.println("Hello");
        WordMatchCounterApp wordMatchCounterApp = new WordMatchCounterApp("src/main/resources/PreDefinedWords");
        wordMatchCounterApp.countWordMatches("src/main/resources/input.txt");
        wordMatchCounterApp.printWordCounts();
    }

    public void countWordMatches(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.length() > 256) {
                        continue;
                    }
                    String lowerCaseWord = word.toLowerCase();
                    if (predefinedWordSet.contains(lowerCaseWord)) {
                        wordMatchCountMap.put(lowerCaseWord, wordMatchCountMap.getOrDefault(lowerCaseWord, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error while counting word match" + e.getMessage());
        }
    }

    public void printWordCounts() {
        System.out.printf("%-20s %s%n", "Predefined word", "Match count");
        for (Map.Entry<String, Integer> entry : wordMatchCountMap.entrySet()) {
            System.out.printf("%-20s %d%n", entry.getKey(), entry.getValue());
        }
    }

    private void loadPredefinedWords(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > 256) {
                    continue;
                }
                predefinedWordSet.add(line.toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Error while loading pre defined words " + e.getMessage());
        }
    }
}
