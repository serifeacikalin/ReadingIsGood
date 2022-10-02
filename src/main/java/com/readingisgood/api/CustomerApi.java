package com.readingisgood.api;

import com.readingisgood.api.request.customer.CustomerDefinitionRequest;
import com.readingisgood.api.request.customer.CustomerListCriteriaRequest;
import com.readingisgood.api.response.customer.CustomerDefinitionResponse;
import com.readingisgood.api.response.customer.CustomerListResponse;
import com.readingisgood.constant.ApiDoc;
import com.readingisgood.infra.InboundService;
import com.readingisgood.service.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/musteri")
@Api(tags = ApiDoc.API_NAME_CUSTOMER, description = ApiDoc.Summary.CUSTOMER_SERVICE_SUMMARY)
public interface CustomerApi {

    @InboundService
    @ApiOperation(value = ApiDoc.Description.SAVE_CUSTOMER, notes = ApiDoc.Summary.SAVE_CUSTOMER)
    @PostMapping(value = "ekle")
    CustomerDefinitionResponse save(@Valid @RequestBody CustomerDefinitionRequest request) throws BusinessException;

    @InboundService
    @ApiOperation(value = ApiDoc.Description.UPDATE_CUSTOMER, notes = ApiDoc.Summary.UPDATE_CUSTOMER)
    @PostMapping(value = "guncelle")
    CustomerDefinitionResponse update(@Valid @RequestBody CustomerDefinitionRequest request) throws BusinessException;

    @InboundService
    @ApiOperation(value = ApiDoc.Description.LIST_BOOK, notes = ApiDoc.Summary.LIST_BOOK)
    @PostMapping("listele")
    CustomerListResponse listCustomer(@Valid @RequestBody CustomerListCriteriaRequest request) throws BusinessException;

    @InboundService
    @ApiOperation(value = ApiDoc.Description.GET_CUSTOMER_DETAIL, notes = ApiDoc.Summary.GET_CUSTOMER_DETAIL)
    @GetMapping("getir/{id}")
    CustomerDefinitionResponse getCustomerDetail(@PathVariable final Long id);
}
