package com.ohmin839.jplgr.api;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.parboiled.Parboiled;
import org.parboiled.Rule;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.support.ParsingResult;

import com.ohmin839.jplgr.api.converter.ConversionParser;
import com.ohmin839.jplgr.api.collector.CollectionParser;

public class JplgrApi {
    private static Rule conversionRule = null;
    private static Rule collectionRule = null;
    static {
        conversionRule = Parboiled.createParser(ConversionParser.class).InputLine();
        collectionRule = Parboiled.createParser(CollectionParser.class).InputLine();
    }

    public static String toPolytonicText(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return "";
        }
        ParsingResult<String> result
            = new RecoveringParseRunner<String>(conversionRule).run(text);
        return result.resultValue;
    }

    public static List<String> toPolytonicWordList(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return Collections.emptyList();
        } else {
            ParsingResult<List<String>> result
                = new RecoveringParseRunner<List<String>>(collectionRule).run(text);
            if (Objects.nonNull(result)) {
                return result.resultValue;
            } else {
                return Collections.emptyList();
            }
        } 
    }
}