package com.readingisgood.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

@UtilityClass
public class RandomUtil {

    public String generateTokenId() {
        return generateGuid();
    }

    public String generateGuid() {
        return UUID.randomUUID().toString();
    }

    public String createCustomerNo(String phoneNumber) {
        String lastTwoDigit = phoneNumber.substring((phoneNumber.length() - 2));

        // TODO Decide on a better algorithm
        return RandomStringUtils.randomNumeric(3) + lastTwoDigit + RandomStringUtils.randomNumeric(3);
    }
}
