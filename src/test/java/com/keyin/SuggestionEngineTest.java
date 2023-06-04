package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class SuggestionEngineTest {

    @Test
    public void testSuggestion() throws IOException {
        SuggestionEngine suggestEngine = new SuggestionEngine();
        suggestEngine.loadDictionaryData(Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));

        Assertions.assertTrue(suggestEngine.generateSuggestions("heig-t").contains("height"));
    }



}
