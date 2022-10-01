package com.readingisgood.api.request.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.readingisgood.api.dto.book.BookDTO;
import com.readingisgood.api.dto.customer.CustomerDTO;
import com.readingisgood.constant.ApiDoc;
import com.readingisgood.constant.Constant;
import com.readingisgood.constant.ValidationErrorCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Data
public class OrderDefinitionRequest {

    @ApiModelProperty(ApiDoc.Fields.ORDER_COUNT)
    @NotNull(message = ValidationErrorCode.ORDER_DEFINITION_INPUT_EMPTY)
    private Long orderCount;

    @ApiModelProperty(ApiDoc.Fields.ORDER_DATE)
    @NotNull(message = ValidationErrorCode.ORDER_DEFINITION_INPUT_EMPTY)
    @JsonFormat(pattern = Constant.DATE_FORMAT_YYYYMMDD)
    private LocalDate orderDate;

    @ApiModelProperty(ApiDoc.Fields.CUSTOMER_INFO)
    private CustomerDTO customer;

    @ApiModelProperty(ApiDoc.Fields.BOOK_LIST)
    private Set<BookDTO> books;
}
