package com.readingisgood.constant;

public class ValidationErrorCode {

    private ValidationErrorCode() {
    }

    public static final String SYSTEM_ERROR = "0000";
    public static final String CUSTOMER_IS_EXIST = "H-0001";
    public static final String BOOK_DEFINITION_INPUT_EMPTY = "H-0002";
    public static final String GRATER_THAN_ZERO = "H-0003";
    public static final String EMAIL_ADDRESS_INVALID = "H-0004";
    public static final String PHONE_NUMBER_INVALID = "H-0005";
    public static final String CUSTOMER_DEFINITION_INPUT_EMPTY = "H-0006";
    public static final String IDENTITY_NUMBER_INVALID = "H-0007";
    public static final String ORDER_DEFINITION_INPUT_EMPTY = "H-0008";
    public static final String INVALID_INPUT = "H-0009";
    public static final String BOOK_IS_EXIST = "H-0010";
    public static final String CUSTOMER_IS_NOT_EXIST = "H-0011";
    public static final String BOOK_IS_NOT_EXIST = "H-0012";

    public static final String ORDER_COUNT_GREATER_THAN_BOOK_STOCK = "H-0013";
}
