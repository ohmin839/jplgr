package com.ohmin839.jplgr.web.api.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TRawWordMapper {
    int insertWords(@Param("words") List<String> words);
}
