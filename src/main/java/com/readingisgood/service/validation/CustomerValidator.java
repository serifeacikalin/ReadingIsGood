package com.readingisgood.service.validation;

import com.readingisgood.entity.Customer;
import com.readingisgood.service.exception.BusinessException;

public interface CustomerValidator {
    void validate(Customer customer) throws BusinessException;
}
