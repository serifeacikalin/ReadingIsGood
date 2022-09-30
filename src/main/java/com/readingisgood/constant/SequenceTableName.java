package com.readingisgood.constant;

public enum SequenceTableName implements BaseEnum<SequenceTableName, String>{

    CUSTOMER_NO_SEQ("customer_no_seq", "customerNoGeneratorImpl"),

    ORDER_NO_SEQ("order_no_seq", "orderNoGeneratorImpl"),

    BOOK_NO_SEQ("book_no_seq", "bookNoGeneratorImpl");

    private String value;

    private String text;

    SequenceTableName(String value, String text){
        this.value = value;
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
