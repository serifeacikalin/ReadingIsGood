package com.readingisgood.api.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.readingisgood.api.request.ValidatedRequest;
import com.readingisgood.constant.ApiDoc;
import com.readingisgood.constant.Constant;
import com.readingisgood.constant.FieldLength;
import com.readingisgood.constant.ValidationErrorCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class OrderDTO implements ValidatedRequest {

    private Long id;

    @ApiModelProperty(ApiDoc.Fields.ORDER_NO)
    @NotNull(message = ValidationErrorCode.ORDER_DEFINITION_INPUT_EMPTY)
    @Size(max = FieldLength.ORDER_NO, message = ValidationErrorCode.INVALID_INPUT)
    private Long orderNo;

    @ApiModelProperty(ApiDoc.Fields.ORDER_COUNT)
    @NotNull(message = ValidationErrorCode.ORDER_DEFINITION_INPUT_EMPTY)
    private Long orderCount;

    @NotNull(message = ValidationErrorCode.ORDER_DEFINITION_INPUT_EMPTY)
    @JsonFormat(pattern = Constant.DATE_FORMAT_YYYYMMDD)
    private LocalDate orderDate;
    @JsonIgnore
    @Override
    public String localizeValidationFields(String fieldName) {
        return fieldName;
    }
}
