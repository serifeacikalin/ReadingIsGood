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
public class CustomerNoGeneratorImpl implements NumberGenerator {

    private NumberGeneratorRepository numberGeneratorRepository;

    public CustomerNoGeneratorImpl(NumberGeneratorRepository numberGeneratorRepository) {
        this.numberGeneratorRepository = numberGeneratorRepository;
    }

    @Override
    public Long generate() {
        Long seqResult = numberGeneratorRepository.generateNumber(SequenceTableName.CUSTOMER_NO_SEQ);
        String prefix = DateHelper.toYYMM(LocalDate.now()).concat(Constant.MODULE_CODE);
        String seqNo = StringUtils.leftPad(seqResult.toString() , FieldLength.CUSTOMER_NO - prefix.length(), "0");

        if(seqResult > FieldLength.CUSTOMER_NO_MAX_VALUE){
            numberGeneratorRepository.initSequence(SequenceTableName.CUSTOMER_NO_SEQ, FieldLength.CUSTOMER_NO_SEQ_START_VALUE);
        }
        return Long.parseLong(prefix.concat(seqNo));
    }
}
