package com.readingisgood.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ReadingIsGoodMessageSource {

    @Autowired
    MessageSource messageSource;

    public ReadingIsGoodMessageSource(){

    }
    public String getMessage(String code, Object... args){
        String message = this.messageSource.getMessage(code, args, Locale.getDefault());
        return this.replaceForLogForgingAttacks(message);
    }

//    public String getMessage(String code,Locale locale, Object... args){
//        String message = this.messageSource.getMessage(code, args, locale);
//        return this.replaceForLogForgingAttacks(message);
//    }
//
//    public String getMessage(String code, String defaultMessage, Locale locale, Object... args){
//        String message = this.messageSource.getMessage(code, args, defaultMessage, locale);
//        return this.replaceForLogForgingAttacks(message);
//    }

    public String replaceForLogForgingAttacks(String message){
        message = message.replace('\n', '_').replace('\r', '_').replace('\t', '_');
        return message;
    }
}
