package com.readingisgood.model.exception;

import lombok.Getter;


@Getter
public class ApiException extends RuntimeException {
    private ErrorCode errorCode;

    public ApiException() {

    }

    public ApiException(final String message, final ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
