package com.readingisgood.model.customer;

import lombok.Data;

@Data
public class CustomerModel {
    private Long customerNo;
    private String customerName;
    private String email;
    private String phoneNumber;
    private String address;
    private String identityNumber;
}
