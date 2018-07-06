package com.example.springbootdemo.configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("druid.servlet")
public class DruidConfiguration {

    private static final Logger LOGGER = LogManager.getLogger(DruidConfiguration.class);

    @Bean
    public ServletRegistrationBean druidServlet() {
        LOGGER.info("init Druid Servlet Configuration ");
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), this.urlMappings.split(","));
        // IP白名单
        servletRegistrationBean.addInitParameter("allow", this.allow);
        // IP黑名单(共同存在时，deny优先于allow)
        servletRegistrationBean.addInitParameter("deny", this.deny);
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", this.loginUsername);
        servletRegistrationBean.addInitParameter("loginPassword", this.loginPassword);
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", this.resetEnable);
        return servletRegistrationBean;
    }

    private String urlMappings;
    private String allow;
    private String deny;
    private String loginUsername;
    private String loginPassword;
    private String resetEnable;


    public String getUrlMappings() {
        return urlMappings;
    }

    public void setUrlMappings(String urlMappings) {
        this.urlMappings = urlMappings;
    }

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getDeny() {
        return deny;
    }

    public void setDeny(String deny) {
        this.deny = deny;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getResetEnable() {
        return resetEnable;
    }

    public void setResetEnable(String resetEnable) {
        this.resetEnable = resetEnable;
    }
}
