package com.spring.di.springdi;

import com.spring.di.springdi.config.SpringDiConfig;
import com.spring.di.springdi.config.SpringDiConstructorConfig;
import com.spring.di.springdi.controllers.*;
import com.spring.di.springdi.datasource.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.spring.di")
@SpringBootApplication
@EnableConfigurationProperties(SpringDiConstructorConfig.class)
public class SpringDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringDiApplication.class, args);
        MyController myController = (MyController) ctx.getBean("myController");

        // Primary
        System.out.println(myController.sayHello());

        // property injected (DI)
        PropertyInjectedController propertyInjectedController =
                (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        // setter injected (DI)
        SetterInjectedController setterInjectedController =
                (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        // constructor injected (DI)
        ConstructorInjectedController constructorInjectedController =
                (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        // Profiles (i18n)
        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        // Pets
        PetController petController = (PetController) ctx.getBean("petController");
        System.out.println(petController.whichIsTheBestPet());

        System.out.println("-------Fake Data Source");
        FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean("fakeDataSource");
        System.out.println(fakeDataSource.getUsername() + " " + fakeDataSource.getPassword() + " " + fakeDataSource.getJdbcUrl());

        System.out.println("-------Config Properties Bean");
        SpringDiConfig springDiConfig = (SpringDiConfig) ctx.getBean("springDiConfig");
        System.out.println(springDiConfig.getUsername());
        System.out.println(springDiConfig.getPassword());
        System.out.println(springDiConfig.getUrl());

        System.out.println("-------Config Constructor Properties Bean");
        SpringDiConstructorConfig springDiConstructorConfig = ctx.getBean(SpringDiConstructorConfig.class);
        System.out.println(springDiConstructorConfig.getUsername());
        System.out.println(springDiConstructorConfig.getPassword());
        System.out.println(springDiConstructorConfig.getUrl());
    }

}
