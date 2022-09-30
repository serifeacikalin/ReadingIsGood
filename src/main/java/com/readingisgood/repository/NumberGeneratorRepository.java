package com.readingisgood.repository;

import com.readingisgood.constant.SequenceTableName;

public interface NumberGeneratorRepository {

    void initSequence(SequenceTableName tableName, int seqStartValue);

    Long generateNumber(SequenceTableName tableName);
}
