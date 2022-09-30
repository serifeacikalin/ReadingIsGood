package com.readingisgood.api.dto.book;

import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookDefinitionResultDTO {

    @ApiModelProperty(ApiDoc.Fields.BOOK_NO)
    private Long bookNo;

    @ApiModelProperty(ApiDoc.Fields.BOOK_NAME)
    private String bookName;

    @ApiModelProperty(ApiDoc.Fields.AUTHOR_NAME)
    private String authorName;

    @ApiModelProperty(ApiDoc.Fields.PUBLICATION_YEAR)
    private String  publicationYear;

    @ApiModelProperty(ApiDoc.Fields.CREATED_USER)
    private String createdUser;

    @ApiModelProperty(ApiDoc.Fields.STOCK)
    private Long stock;

    @ApiModelProperty(ApiDoc.Fields.AMOUNT)
    private BigDecimal amount;
}
