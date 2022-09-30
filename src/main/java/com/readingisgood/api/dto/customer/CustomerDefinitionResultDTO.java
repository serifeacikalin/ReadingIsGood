package com.readingisgood.api.dto.customer;

import lombok.Data;

@Data
public class CustomerDefinitionResultDTO {
    private Long customerNo;
    private String customerName;
    private String email;
    private String phoneNumber;
    private String address;
    private String identityNumber;
}
