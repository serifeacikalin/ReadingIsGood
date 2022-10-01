package com.readingisgood.api.request.order;

import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerOrderReportCriteria {

    @ApiModelProperty(ApiDoc.Fields.CUSTOMER_NO)
    private Long customerNo;

    @ApiModelProperty(ApiDoc.Fields.START_DATE)
    private LocalDate startDate;

    @ApiModelProperty(ApiDoc.Fields.END_DATE)
    private LocalDate endDate;
}
