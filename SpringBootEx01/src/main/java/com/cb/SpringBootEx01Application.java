package com.cb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
//@PropertySource("classpath:config/message_application.properties")
public class SpringBootEx01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEx01Application.class, args);
    }

    @Bean
    MessageSource messageSource(){
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:config/message_application");
        return source;
    }

    @Bean
    MessageSource errorSource(){
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:config/error_application");
        return source;
    }

}
