package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.News;
import com.example.springbootdemo.service.INewsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {
    private static final Logger LOGGER = LogManager.getLogger(HelloController.class);

    @RequestMapping("/hello/{time}")
    public String index(HttpServletRequest request, @PathVariable int time){
        LOGGER.info("--info--request.getLocalPort=" + Thread.currentThread());
        LOGGER.warn("--warn--");
        LOGGER.error("--error--");
        try {
            if(time > 0){
                Thread.sleep(time * 1000);
                return "sleep";
            }

        }catch (Exception ex){
        }

        return "hello world";
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/ribbon-hello")
    public String helloConsumer(){
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }

    @Autowired
    private INewsService newsService;
    @RequestMapping(value = "/mybatis-test")
    public Object test1(){
        LOGGER.info("--info--request.getLocalPort=" + Thread.currentThread());
        News news = new News();
        news.setTitle("mwt");
        news.setContent("mwt11111");
        newsService.saveNews(news);
        return news;
    }

    @RequestMapping("/test1")
    public String helloConsumer1(@RequestParam(name = "hehe",required = false) String a,
                                 HttpServletRequest request, HttpServletResponse response){
        LOGGER.info(request.getSession().getId());
        Cookie cookie = new Cookie("name1234", "mwt1234");
        cookie.setPath("/");
        //cookie.setHttpOnly(true);
        //cookie.setSecure(true);
        response.addCookie(cookie);
        int a1 = 1/0;
        return a;
    }
}
