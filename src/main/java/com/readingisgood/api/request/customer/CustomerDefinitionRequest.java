package com.readingisgood.api.request.customer;

import com.readingisgood.api.dto.customer.CustomerDTO;
import lombok.Data;

import javax.validation.Valid;

@Data
public class CustomerDefinitionRequest {
     private @Valid CustomerDTO customer;
}
