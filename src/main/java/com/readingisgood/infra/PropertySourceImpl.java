package com.readingisgood.infra;

import com.readingisgood.service.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class PropertySourceImpl implements PropertySource {

    private ReadingIsGoodMessageSource messageSource;

    public PropertySourceImpl(ReadingIsGoodMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String get(String code, Object... args) {
        return messageSource.getMessage(code, args);
    }
}
