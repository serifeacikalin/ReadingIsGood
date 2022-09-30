package com.readingisgood.service;

import com.readingisgood.constant.SequenceTableName;
import com.readingisgood.service.repository.NumberGenerator;

public interface NumberGeneratorFactory {

    NumberGenerator createGenerator(SequenceTableName tableName);
}
