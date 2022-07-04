package com.spring.di.springdi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("di")
public class SpringDiConfig {

    private String username;
    private String password;
    private String url;
}
