package com.readingisgood.api.dto.order;

import com.readingisgood.api.dto.book.BookDTO;
import com.readingisgood.api.dto.customer.CustomerDTO;
import com.readingisgood.constant.FieldLength;
import com.readingisgood.constant.ValidationErrorCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class OrderDefinitionResultDTO {

    @NotNull(message = ValidationErrorCode.ORDER_DEFINITION_INPUT_EMPTY)
    @Size(max = FieldLength.ORDER_NO, message = ValidationErrorCode.INVALID_INPUT)
    private Long orderNo;

    @NotNull(message = ValidationErrorCode.ORDER_DEFINITION_INPUT_EMPTY)
    private Long orderCount;

    private Set<BookDTO> books;

    private CustomerDTO customer;
}
