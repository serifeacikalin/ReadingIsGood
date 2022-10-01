package com.readingisgood.service.validation.impl;

import com.readingisgood.entity.Books;
import com.readingisgood.model.book.BookDefinitionModel;
import com.readingisgood.model.book.BookListCriteriaModel;
import com.readingisgood.model.book.BookModel;
import com.readingisgood.repository.BookRepository;
import com.readingisgood.service.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class BookValidatorImplTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookValidatorImpl validator;

    @Test
    public void  validate_shoulThrowBusinessException_whenStockLessZero() throws BusinessException {
        Mockito.lenient().when(repository.findByAuthorNameAndBookNameAndRecordStatusAndStatus(anyString(),anyString(),anyBoolean(),anyString())).thenReturn(book);
        Mockito.lenient().when(repository.findById(anyLong())).thenReturn(Optional.of(book));
        BusinessException thrown = assertThrows(
                BusinessException.class,
                () -> validator.validate(book)
        );

        assertTrue(thrown.getCodeList().size()>0);
    }

    private static Books book = new Books();
    private static final Long BOOK_NO = 1111L;

    static {
        book.setId(1l);
        book.setBookName("kitap1");
        book.setAuthorName("yazar1");
        book.setBookNo(BOOK_NO);
        book.setPublicationYear("2022");
        book.setStock(-1l);
    }
}