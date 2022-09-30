package com.readingisgood.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Messages {

    private MessageSource messageSource;

    @Autowired
    public Messages(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String get(final String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    public String get(final String key, final Object... objects) {
        return messageSource.getMessage(key, objects, LocaleContextHolder.getLocale());
    }
}
