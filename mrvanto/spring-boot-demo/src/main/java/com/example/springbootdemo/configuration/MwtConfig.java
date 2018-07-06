package com.example.springbootdemo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("hubei.wuhan")
public class MwtConfig {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
