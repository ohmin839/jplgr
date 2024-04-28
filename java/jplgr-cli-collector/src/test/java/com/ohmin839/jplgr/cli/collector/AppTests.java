package com.ohmin839.jplgr.cli.collector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class AppTests {
    static private final String UTF8 = "UTF-8";
    static private final String EOL = System.getProperty("line.separator");

    @Test
    void testDoMain() throws Exception {
        InputStream inputStream = null;
        PrintStream printStream = null;
        try {
            inputStream = new ByteArrayInputStream("ὁ ἄνθρωπός τις".getBytes(UTF8));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            printStream = new PrintStream(outputStream);
    
            App app = new App();
            app.doMain(inputStream, printStream);
    
            String actual = new String(outputStream.toByteArray(), UTF8);
            String expected = "ὁ" + EOL + "ἄνθρωπός" + EOL + "τις" + EOL;
            assertEquals(expected, actual);
        } finally {
            inputStream.close();
            printStream.close();
        }
    }
}
