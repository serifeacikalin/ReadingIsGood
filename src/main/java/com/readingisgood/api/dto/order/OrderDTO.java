package com.readingisgood.api.dto.order;

import com.readingisgood.constant.ApiDoc;
import com.readingisgood.constant.FieldLength;
import com.readingisgood.constant.ValidationErrorCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class OrderDTO {

    @ApiModelProperty(ApiDoc.Fields.ORDER_NO)
    @NotNull(message = ValidationErrorCode.ORDER_DEFINITION_INPUT_EMPTY)
    @Size(max = FieldLength.ORDER_NO, message = ValidationErrorCode.INVALID_INPUT)
    private Long orderNo;

    @ApiModelProperty(ApiDoc.Fields.ORDER_COUNT)
    @NotNull(message = ValidationErrorCode.ORDER_DEFINITION_INPUT_EMPTY)
    private Long orderCount;
}
