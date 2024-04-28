package com.ohmin839.jplgr.cli.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import com.ohmin839.jplgr.api.JplgrApi;

public class App {
    public static void main(String[] args) throws IOException {
        new App().doMain(System.in, System.out, args);
    }

    void doMain(InputStream inputStream, PrintStream printStream, String... args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        reader.lines().forEach(line -> printStream.println(JplgrApi.toPolytonicText(line)));
    }
}
