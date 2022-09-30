package com.readingisgood.model.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    DEFAULT(HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED),
    BAD_REQUEST(HttpStatus.BAD_REQUEST),
    UNAVAILABLE(HttpStatus.CONFLICT);

    ErrorCode(final HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    private HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
