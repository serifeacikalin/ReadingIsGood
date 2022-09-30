package com.readingisgood.api.request.order;

import com.readingisgood.constant.FieldLength;
import com.readingisgood.constant.ValidationErrorCode;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class OrderListCriteriaRequest {

    @Size(max = FieldLength.ORDER_NO, message = ValidationErrorCode.INVALID_INPUT)
    private Long orderNo;

    @Size(max = FieldLength.CUSTOMER_NO, message = ValidationErrorCode.INVALID_INPUT)
    private Long customerNo;
}
