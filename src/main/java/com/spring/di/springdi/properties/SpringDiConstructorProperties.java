package com.spring.di.springdi.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConstructorBinding
@ConfigurationProperties("di")
@AllArgsConstructor
public class SpringDiConstructorProperties {

    private final String username;
    private final String password;
    private final String url;
}
