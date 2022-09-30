package com.readingisgood.api.request.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.readingisgood.api.dto.order.OrderDTO;
import com.readingisgood.constant.ApiDoc;
import com.readingisgood.constant.Constant;
import com.readingisgood.constant.ValidationErrorCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class BookListCriteriaRequest {

    @ApiModelProperty(ApiDoc.Fields.BOOK_NO)
    private Long bookNo;

    @ApiModelProperty(ApiDoc.Fields.BOOK_NAME)
    private String bookName;

    @ApiModelProperty(ApiDoc.Fields.AUTHOR_NAME)
    private String authorName;

    @ApiModelProperty(ApiDoc.Fields.CREATED_USER)
    private String createdUser;

    @ApiModelProperty(ApiDoc.Fields.PUBLICATION_YEAR)
    @JsonFormat(pattern = Constant.DATE_FORMAT_YYYY)
    private String  publicationYear;

    @ApiModelProperty(ApiDoc.Fields.STOCK)
    @Positive(message = ValidationErrorCode.GRATER_THAN_ZERO)
    private Long stock;

    @ApiModelProperty(ApiDoc.Fields.ORDER_INFO)
    private OrderDTO order;
}
