package com.edu.chmnu.ki_123.c3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static String rigthWords(String[] words, String pattern){
        String result = "";
        Pattern p = Pattern.compile(pattern);
        for(String word: words){
            Matcher matcher = p.matcher(word);
            if(!matcher.matches()){
                if(result.length() == 0){
                    result = result.concat(word);
                }
                else{
                    result = result.concat(" ");
                    result = result.concat(word);
                }
            }
            else{
                continue;
            }
        }
        return result;
    }

    public static List<String> findWords(String words, String pattern){
        List<String> phrases = new ArrayList<>();

        Pattern p = Pattern.compile(pattern);

        words = words.replaceAll(".,:;\\-\"()'\\[\\]\\{}", " ");
        String[] values = words.split("\\s+");

        for(String value: values){
            Matcher matcher = p.matcher(value);
            if(matcher.matches()){
                phrases.add(value);
            }
        }

        return phrases;
    }

    public static String replaceSpaces(String sentence){
        sentence = sentence.replaceAll("\\s+", " ");
        return sentence.trim();
    }

    public static void main(String[] args) {
        String[] phrases = {"words", "nice", "123"};
        String pattern = "[a-zA-Z]+";

        String config = rigthWords(phrases, pattern);
        System.out.println(config);

        String sentence1 = "Cool, your is 123";
        String pattern1 = "\\d+";

        List<String> coolPhrases = findWords(sentence1, pattern1);
        System.out.println(coolPhrases);

        String sentence2 = "    Nice    string    ";
        System.out.println(sentence2);
        String trimString = replaceSpaces(sentence2);
        System.out.println(trimString);
    }
}