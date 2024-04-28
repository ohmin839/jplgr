package com.ohmin839.jplgr.cli.collector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedHashSet;
import java.util.Set;

import com.ohmin839.jplgr.api.JplgrApi;

public class App {
    public static void main(String[] args) throws IOException {
        new App().doMain(System.in, System.out, args);
    }

    void doMain(InputStream inputStream, PrintStream printStream, String... args) throws IOException {
        Set<String> wordSet = new LinkedHashSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        reader.lines()
            .map(line -> JplgrApi.toPolytonicWordList(line))
            .forEach(words -> wordSet.addAll(words));
        wordSet.forEach(word -> printStream.println(word));
    }
}
