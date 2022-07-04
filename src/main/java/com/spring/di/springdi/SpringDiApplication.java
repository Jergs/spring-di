package com.spring.di.springdi;

import com.spring.di.springdi.properties.SpringDiProperties;
import com.spring.di.springdi.properties.SpringDiConstructorProperties;
import com.spring.di.springdi.controllers.*;
import com.spring.di.springdi.properties.FakeDataProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.spring.di")
@SpringBootApplication
@EnableConfigurationProperties(SpringDiConstructorProperties.class)
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
        FakeDataProperties fakeDataProperties = (FakeDataProperties) ctx.getBean("fakeDataProperties");
        System.out.println(fakeDataProperties.getUsername() + " " + fakeDataProperties.getPassword() + " " + fakeDataProperties.getJdbcUrl());

        System.out.println("-------Config Properties Bean");
        SpringDiProperties springDiProperties = (SpringDiProperties) ctx.getBean("springDiProperties");
        System.out.println(springDiProperties.getUsername());
        System.out.println(springDiProperties.getPassword());
        System.out.println(springDiProperties.getUrl());

        System.out.println("-------Config Constructor Properties Bean");
        SpringDiConstructorProperties springDiConstructorProperties = ctx.getBean(SpringDiConstructorProperties.class);
        System.out.println(springDiConstructorProperties.getUsername());
        System.out.println(springDiConstructorProperties.getPassword());
        System.out.println(springDiConstructorProperties.getUrl());
    }

}
