package com.illumio.demo;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordMatchCounterAppTest {

    private WordMatchCounterApp wordMatchCounterApp;

    @BeforeEach
    void init() {
        wordMatchCounterApp = new WordMatchCounterApp("src/main/resources/PreDefinedWords");;
    }

    @Test
    void testWordCount() {
        wordMatchCounterApp.countWordMatches("src/main/resources/input.txt");
        Map<String, Integer> wordMatchCountMap = wordMatchCounterApp.getWordMatchCountMap();

        Assert.assertEquals(wordMatchCountMap.get("ai"), Integer.valueOf(1));
        Assert.assertEquals(wordMatchCountMap.get("name"), Integer.valueOf(3));
    }

    @Test
    void testEmptyPredefinedWordCount() {
        wordMatchCounterApp = new WordMatchCounterApp("src/main/resources/PreDefinedWordsEmptyFile");;
        wordMatchCounterApp.countWordMatches("src/main/resources/input.txt");
        Map<String, Integer> wordMatchCountMap = wordMatchCounterApp.getWordMatchCountMap();
        Assert.assertTrue(wordMatchCountMap.isEmpty());
    }

    @Test
    void testEmptyInputWordCount() {
        wordMatchCounterApp = new WordMatchCounterApp("src/main/resources/PreDefinedWords");;
        wordMatchCounterApp.countWordMatches("src/main/resources/Emptyinput.txt");
        Map<String, Integer> wordMatchCountMap = wordMatchCounterApp.getWordMatchCountMap();
        Assert.assertTrue(wordMatchCountMap.isEmpty());
    }

    @Test
    void testBothEmptyFileWordCount() {
        wordMatchCounterApp = new WordMatchCounterApp("src/main/resources/PreDefinedWordsEmptyFile");;
        wordMatchCounterApp.countWordMatches("src/main/resources/Emptyinput.txt");
        Map<String, Integer> wordMatchCountMap = wordMatchCounterApp.getWordMatchCountMap();
        Assert.assertTrue(wordMatchCountMap.isEmpty());
    }

    @Test
    void testCaseInsenstiveWordCount() {
        wordMatchCounterApp = new WordMatchCounterApp("src/main/resources/PreDefinedWords");
        wordMatchCounterApp.countWordMatches("src/main/resources/caseinsenstiveinput.txt");
        Map<String, Integer> wordMatchCountMap = wordMatchCounterApp.getWordMatchCountMap();

        Assert.assertEquals(wordMatchCountMap.get("ai"), Integer.valueOf(1));
        Assert.assertEquals(wordMatchCountMap.get("name"), Integer.valueOf(3));
        Assert.assertEquals(wordMatchCountMap.get("how"), Integer.valueOf(2));
    }
}