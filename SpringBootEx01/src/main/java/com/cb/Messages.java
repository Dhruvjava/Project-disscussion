package com.cb;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Messages {

    @Autowired
    MessageSource messageSource;

    @Autowired
    MessageSource errorSource;

    MessageSourceAccessor messageSourceAccessor;

    MessageSourceAccessor errorSourceAccessor;

    @PostConstruct
    public void init(){
        messageSourceAccessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
        errorSourceAccessor = new MessageSourceAccessor(errorSource, Locale.ENGLISH);
    }

    public String getMessage(String code){
        return messageSourceAccessor.getMessage(code);
    }

    public String getError(String code){
        return errorSourceAccessor.getMessage(code);
    }

}
