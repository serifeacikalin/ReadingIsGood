package com.readingisgood.service.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception{

    public BusinessException(List<String> codeList){
        super();
        this.codeList = codeList;
    }

    public BusinessException(String code){
        super();
        this.codeList = new ArrayList<>();
        this.codeList.add(code);
    }

    public BusinessException(String code , String dynamicValue){
        super();
        this.codeList = new ArrayList<>();
        this.codeList.add(code);
        this.dynamicValue = dynamicValue;
    }

    @Getter
    @Setter
    private List<String> codeList;

    @Getter
    private String dynamicValue;
}
