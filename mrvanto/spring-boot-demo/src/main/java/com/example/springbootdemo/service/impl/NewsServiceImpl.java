package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.entity.News;
import com.example.springbootdemo.mapper.NewsMapper;
import com.example.springbootdemo.service.INewsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewsServiceImpl implements INewsService {
    private static final Logger LOGGER = LogManager.getLogger(NewsServiceImpl.class);
    private static ThreadLocal<String> connContainer = new ThreadLocal<String>();
    @Autowired
    private NewsMapper newsMapper;

    @Transactional
    @Override
    public void saveNews(News news) {
        //newsMapper.insert(news);
        newsMapper.insertSelective(news);
    }
}
