package com.edu.chmnu.ki_123.c3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void fullWriteTrueWords(){
        String[] sentence = {"cool", "small", "nice", "banana", "blue"};

        String pattern = "[a-zA-Z]";

        String repl = Main.rigthWords(sentence, pattern);

        assertEquals(repl.length(), 27);
    }

    @Test
    void emptyWriteTrueWords(){
        String[] sentence = {"123", "234", "235", "567", "6788"};

        String pattern = "\\d+";

        String repl = Main.rigthWords(sentence, pattern);

        System.out.println(repl);

        assertEquals(repl.length(), 0);
    }

    @Test
    void trueListOfRigthWords(){
        String sentence = "abc 123 bvd 567 lkv";

        String pattern = "\\w+";

        List<String> repl = Main.findWords(sentence, pattern);

        assertEquals(repl.size(), 5);
    }

    @Test
    void noteListOfRigthWords(){
        String sentence = "Abc 123 AVG 567 NICE";

        String pattern = ".,:;\\-\"'\\[\\]\\{}\\*?!";

        List<String> repl = Main.findWords(sentence, pattern);

        assertTrue(repl.isEmpty());
    }

    @Test
    void wordsFromTrueNumbersSpaces(){
        String sentence = "Cool         all               fish";

        String repl = Main.replaceSpaces(sentence);

        assertEquals(repl, "Cool all fish");
    }

    @Test
    void withoutSpaces(){
        String sentence = "                 ";

        String repl = Main.replaceSpaces(sentence);

        assertEquals(repl, "");
    }

}