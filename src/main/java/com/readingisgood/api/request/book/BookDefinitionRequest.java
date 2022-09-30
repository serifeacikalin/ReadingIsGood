package com.readingisgood.api.request.book;

import com.readingisgood.api.dto.book.BookDTO;
import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;

@Data
public class BookDefinitionRequest {

    @ApiModelProperty(ApiDoc.Fields.BOOK_INFO)
    private @Valid BookDTO bookInfo;
}
