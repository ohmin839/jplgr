package com.ohmin839.jplgr.web.api.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ohmin839.jplgr.web.api.domain.mapper.TRawWordMapper;

@Repository
public class TRawWordRepository {
    @Autowired
    private TRawWordMapper tRawWordMapper;

    @Transactional
    public int insertWords(List<String> words) {
        return tRawWordMapper.insertWords(words);
    }
}
