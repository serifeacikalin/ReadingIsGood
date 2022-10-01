package com.readingisgood.api.request.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.readingisgood.api.request.ValidatedRequest;
import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerOrderReportCriteria implements ValidatedRequest {

    @ApiModelProperty(ApiDoc.Fields.CUSTOMER_NO)
    private Long customerNo;

    @ApiModelProperty(ApiDoc.Fields.START_DATE)
    private LocalDate startDate;

    @ApiModelProperty(ApiDoc.Fields.END_DATE)
    private LocalDate endDate;
    @JsonIgnore
    @Override
    public String localizeValidationFields(String fieldName) {
        return fieldName;
    }
}
