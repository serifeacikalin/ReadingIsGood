package com.readingisgood.service;

import com.readingisgood.constant.SequenceTableName;
import com.readingisgood.service.repository.NumberGenerator;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NumberGeneratorFactoryImpl implements NumberGeneratorFactory {

    private Map<String, NumberGenerator> numberGeneratorMap;

    public NumberGeneratorFactoryImpl(Map<String, NumberGenerator> numberGeneratorMap) {
        this.numberGeneratorMap = numberGeneratorMap;
    }

    @Override
    public NumberGenerator createGenerator(SequenceTableName tableName) {
        return numberGeneratorMap.get(tableName.getText());
    }
}
