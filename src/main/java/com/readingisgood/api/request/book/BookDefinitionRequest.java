package com.readingisgood.api.request.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.readingisgood.api.dto.book.BookDTO;
import com.readingisgood.api.request.ValidatedRequest;
import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;

@Data
public class BookDefinitionRequest implements ValidatedRequest {

    @ApiModelProperty(ApiDoc.Fields.BOOK_INFO)
    private @Valid BookDTO bookInfo;
    @JsonIgnore
    @Override
    public String localizeValidationFields(String fieldName) {
        return fieldName;
    }
}
