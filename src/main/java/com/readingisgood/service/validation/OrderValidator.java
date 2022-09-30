package com.readingisgood.service.validation;

import com.readingisgood.entity.Order;
import com.readingisgood.service.exception.BusinessException;

public interface OrderValidator {

    void validate(Order order) throws BusinessException;
}
