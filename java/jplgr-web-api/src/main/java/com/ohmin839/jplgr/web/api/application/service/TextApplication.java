package com.ohmin839.jplgr.web.api.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohmin839.jplgr.api.JplgrApi;
import com.ohmin839.jplgr.web.api.domain.repository.TRawWordRepository;

@Service
public class TextApplication {
    @Autowired
    private TRawWordRepository tRawWordRepository;

    public void collectWords(String text) {
        String converted = JplgrApi.toPolytonicText(text);
        List<String> split = JplgrApi.toPolytonicWordList(converted);
        if (split.isEmpty()) {
            return;
        }
        tRawWordRepository.insertWords(split);
    }
}
