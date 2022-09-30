package com.readingisgood.service.validation.impl;

import com.readingisgood.constant.ReadingIsGoodStatus;
import com.readingisgood.constant.ValidationErrorCode;
import com.readingisgood.entity.Books;
import com.readingisgood.repository.BookRepository;
import com.readingisgood.service.exception.BusinessException;
import com.readingisgood.service.validation.BookValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookValidatorImpl implements BookValidator {

    private BookRepository repository;

    @Override
    public void validate(Books book) throws BusinessException {

        if(book.getId() != null){
            validateForUpdate(book);
        }
        Books relatedBook = repository.findByAuthorNameAndBookNameAndRecordStatusAndStatus(book.getAuthorName(), book.getBookName(), Boolean.TRUE, ReadingIsGoodStatus.AKTIF.getValue());
        if(relatedBook != null && book.getBookNo() == null){
            throw new BusinessException(ValidationErrorCode.BOOK_IS_EXIST);
        }

    }

    private void validateForUpdate(Books book) throws BusinessException {
        Books relatedBook = repository.findById(book.getId()).get();
        if(book.getStock()<0 || (relatedBook.getStock()+book.getStock()<0)){
            throw new BusinessException(ValidationErrorCode.GRATER_THAN_ZERO);
        }
    }
}
