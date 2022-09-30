package com.readingisgood.api.response.book;

import com.readingisgood.api.dto.book.BookDefinitionResultDTO;
import com.readingisgood.api.response.BaseResponse;
import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookListResponse extends BaseResponse {

    @ApiModelProperty(ApiDoc.Fields.BOOK_LIST)
    private List<BookDefinitionResultDTO> bookList = new ArrayList<>();
}
