package com.readingisgood.api;

import com.readingisgood.api.request.book.BookDefinitionRequest;
import com.readingisgood.api.request.book.BookListCriteriaRequest;
import com.readingisgood.api.response.book.BookDefinitionResponse;
import com.readingisgood.api.response.book.BookListResponse;
import com.readingisgood.constant.ApiDoc;
import com.readingisgood.service.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RequestMapping("kitap")
@Api(tags = ApiDoc.API_NAME_BOOK, description = ApiDoc.Summary.BOOK_SERVICE_SUMMARY)
public interface BookApi {

    @ApiOperation(value = ApiDoc.Description.SAVE_BOOK, notes = ApiDoc.Summary.SAVE_BOOK)
    @PostMapping("ekle")
    BookDefinitionResponse save(@RequestBody BookDefinitionRequest request) throws BusinessException;

    @ApiOperation(value = ApiDoc.Description.UPDATE_BOOK, notes = ApiDoc.Summary.UPDATE_BOOK)
    @PostMapping(value = "guncelle")
    BookDefinitionResponse update(@RequestBody BookDefinitionRequest request) throws BusinessException;

    @ApiOperation(value = ApiDoc.Description.LIST_BOOK, notes = ApiDoc.Summary.LIST_BOOK)
    @PostMapping("listele")
    BookListResponse listBooks(@Valid @RequestBody BookListCriteriaRequest request) throws BusinessException;
}
