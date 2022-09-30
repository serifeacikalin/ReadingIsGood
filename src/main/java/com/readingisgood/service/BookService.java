package com.readingisgood.service;

import com.readingisgood.model.book.BookDefinitionModel;
import com.readingisgood.model.book.BookListCriteriaModel;
import com.readingisgood.model.book.BookModel;
import com.readingisgood.service.exception.BusinessException;

import java.util.List;

public interface BookService {

    BookModel save(BookDefinitionModel bookModel) throws BusinessException;

    BookModel update(BookDefinitionModel bookModel) throws BusinessException;

    List<BookModel> listBook(BookListCriteriaModel criteriaModel);
}
