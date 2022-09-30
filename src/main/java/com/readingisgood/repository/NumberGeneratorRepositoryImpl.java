package com.readingisgood.repository;

import com.readingisgood.constant.SequenceTableName;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;

@Repository
public class NumberGeneratorRepositoryImpl implements NumberGeneratorRepository{

    private EntityManager entityManager;

    public NumberGeneratorRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void initSequence(SequenceTableName tableName, int seqStartValue) {
        String updateSql = "UPDATE ".concat(tableName.getValue()).concat(" SET id = LAST_INSERT_ID(")
                .concat(String.valueOf(seqStartValue)).concat(")");

        Query queryUpdate = entityManager.createNativeQuery(updateSql);
        queryUpdate.executeUpdate();
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Long generateNumber(SequenceTableName tableName) {
        String incrementSql = "UPDATE ".concat(tableName.getValue()).concat(" SET id = LAST_INSERT_ID(id + 1)");
        Query queryUpdate = entityManager.createNativeQuery(incrementSql);
        queryUpdate.executeUpdate();

        Query querySelect = entityManager.createNativeQuery("SELECT LAST_INSERT_ID()");
        BigInteger seqResult = (BigInteger) querySelect.getResultList().get(0);

        return seqResult.longValue();
    }
}
