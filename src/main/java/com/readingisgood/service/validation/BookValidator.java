package com.readingisgood.service.validation;

import com.readingisgood.entity.Books;
import com.readingisgood.service.exception.BusinessException;

public interface BookValidator {

    void validate(Books book) throws BusinessException;
}
