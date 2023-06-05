package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SuggestionEngineTest {

    @Test
    public void testSuggestion() throws IOException {
        SuggestionEngine suggestEngine = new SuggestionEngine();
        suggestEngine.loadDictionaryData(Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));

        Assertions.assertTrue(suggestEngine.generateSuggestions("heig-t").contains("height"));
    }

    @Test
    public void failSuggestion() throws IOException{
        SuggestionEngine suggestEngine = new SuggestionEngine();
        suggestEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").getPath()));

        assertFalse(suggestEngine.generateSuggestions("hello").contains("hello"));
    }

    @Test
    public void generateSuggestionIncorrectSpelling(){
        SuggestionEngine suggestEngine = new SuggestionEngine();

        String word = "Heighht";

        String suggestions = suggestEngine.generateSuggestions(word);

        assertFalse(suggestions.equals(word), "Suggestions shouldn't be empty for misspelled words");
    }

}
