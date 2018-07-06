package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.News;

public interface NewsMapper {
    int deleteByPrimaryKey(Long objid);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Long objid);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
}