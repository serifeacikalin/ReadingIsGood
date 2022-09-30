package com.readingisgood.api.response.book;

import com.readingisgood.api.dto.book.BookDTO;
import com.readingisgood.api.response.BaseResponse;
import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BookDefinitionResponse extends BaseResponse {

    @ApiModelProperty(ApiDoc.Fields.BOOK_INFO)
    private BookDTO book;
}
