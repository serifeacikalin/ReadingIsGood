package com.readingisgood.service.repository.impl;

import com.readingisgood.constant.Constant;
import com.readingisgood.constant.FieldLength;
import com.readingisgood.constant.SequenceTableName;
import com.readingisgood.repository.NumberGeneratorRepository;
import com.readingisgood.service.repository.NumberGenerator;
import com.readingisgood.util.DateHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderNoGeneratorImpl implements NumberGenerator {

    private NumberGeneratorRepository numberGeneratorRepository;

    public OrderNoGeneratorImpl(NumberGeneratorRepository numberGeneratorRepository) {
        this.numberGeneratorRepository = numberGeneratorRepository;
    }

    @Override
    public Long generate() {
        Long seqResult = numberGeneratorRepository.generateNumber(SequenceTableName.ORDER_NO_SEQ);
        String prefix = DateHelper.toYYMM(LocalDate.now()).concat(Constant.MODULE_CODE);
        String seqNo = StringUtils.leftPad(seqResult.toString() , FieldLength.ORDER_NO - prefix.length(), "0");

        if(seqResult > FieldLength.ORDER_NO_MAX_VALUE){
            numberGeneratorRepository.initSequence(SequenceTableName.ORDER_NO_SEQ, FieldLength.ORDER_NO_SEQ_START_VALUE);
        }
        return Long.parseLong(prefix.concat(seqNo));
    }
}
