package com.example.springbootdemo.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Configuration
public class TestConfigure {
    private static final Logger LOGGER = LogManager.getLogger(TestConfigure.class);

    @Bean
    public MwtConfig mwtConfig(){
        return new MwtConfig();
    }

    public static void main(String[] args) {
        Calendar dar = Calendar.getInstance();
        Integer[] arr = {5,3,1,2,7};
        List<Integer> arrList = Arrays.asList(arr);
        Collections.sort(arrList, Integer::compareTo);
        LOGGER.info(arrList.toString());

    }
}
