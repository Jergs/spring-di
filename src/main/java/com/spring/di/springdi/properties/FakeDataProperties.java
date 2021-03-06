package com.spring.di.springdi.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class FakeDataProperties {

    @Value("${di.username}")
    private String username;
    @Value("${di.password}")
    private String password;
    @Value("${di.url}")
    private String jdbcUrl;
}
