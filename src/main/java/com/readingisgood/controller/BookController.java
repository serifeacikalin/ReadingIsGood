package com.readingisgood.controller;

import com.readingisgood.api.BookApi;
import com.readingisgood.api.dto.book.BookDTO;
import com.readingisgood.api.dto.book.BookDefinitionResultDTO;
import com.readingisgood.api.request.book.BookDefinitionRequest;
import com.readingisgood.api.request.book.BookListCriteriaRequest;
import com.readingisgood.api.response.book.BookDefinitionResponse;
import com.readingisgood.api.response.book.BookListResponse;
import com.readingisgood.model.book.BookDefinitionModel;
import com.readingisgood.model.book.BookListCriteriaModel;
import com.readingisgood.model.book.BookModel;
import com.readingisgood.service.BookService;
import com.readingisgood.service.MapperService;
import com.readingisgood.service.exception.BusinessException;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController implements BookApi {

    private BookService service;

    private MapperService mapper;

    public BookController(BookService service, MapperService mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public BookDefinitionResponse save(BookDefinitionRequest request) throws BusinessException {
        BookDefinitionModel bookDefinitionModel = mapper.map(request, BookDefinitionModel.class);
        BookModel book = service.save(bookDefinitionModel);
        BookDTO resultDTO = mapper.map(book , BookDTO.class);
        BookDefinitionResponse response = new BookDefinitionResponse();
        response.setBook(resultDTO);
        return response;
    }

    @Override
    public BookDefinitionResponse update(BookDefinitionRequest request) throws BusinessException {
        BookDefinitionModel bookDefinitionModel = mapper.map(request, BookDefinitionModel.class);
        BookModel book = service.update(bookDefinitionModel);
        BookDTO resultDTO = mapper.map(book , BookDTO.class);
        BookDefinitionResponse response = new BookDefinitionResponse();
        response.setBook(resultDTO);
        return response;
    }

    @Override
    public BookListResponse listBooks(BookListCriteriaRequest request) throws BusinessException {
        BookListCriteriaModel criteriaModel = mapper.map(request, BookListCriteriaModel.class);
        BookListResponse response = new BookListResponse();
        response.getBookList().addAll(mapper.map(service.listBook(criteriaModel), BookDefinitionResultDTO.class));
        return response;
    }
}
