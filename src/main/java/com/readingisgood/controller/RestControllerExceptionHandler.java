package com.readingisgood.controller;

import com.readingisgood.api.dto.BaseResponseMessageDTO;
import com.readingisgood.api.request.ValidatedRequest;
import com.readingisgood.api.response.BaseResponse;
import com.readingisgood.service.PropertySource;
import com.readingisgood.service.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

import static com.readingisgood.constant.ValidationErrorCode.SYSTEM_ERROR;

@Slf4j
@ControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String VALIDATION_MESSAGE_FIELD_NAME = "%fieldName%";

    private static final String VALIDATION_MESSAGE_DYNAMIC_VALUE = "%dynamicValue%";

    private PropertySource propertySource;

    public RestControllerExceptionHandler(PropertySource propertySource) {
        this.propertySource = propertySource;
    }

    @ExceptionHandler(BusinessException.class)
    public @ResponseBody ResponseEntity<BaseResponse> handleException(final BusinessException e){
        if(e.getDynamicValue() != null ){
            return handleException(HttpStatus.NOT_ACCEPTABLE , prepareBaseResponse(e.getCodeList(), e.getDynamicValue()));
        }

        return handleException(HttpStatus.NOT_ACCEPTABLE, prepareBaseResponse(e.getCodeList()));
    }

    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody ResponseEntity<BaseResponse> handleException(final RuntimeException e){
        log.error("ERROR", e);
        return handleException(HttpStatus.INTERNAL_SERVER_ERROR, prepareBaseResponse(Arrays.asList(SYSTEM_ERROR)));
    }

    private BaseResponse prepareBaseResponse(List<String> errorCodeList) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResultCode(BaseResponse.ResultCode.ERROR);
        baseResponse.setMessageList(new ArrayList<>());
        errorCodeList.forEach(errorCode -> baseResponse.getMessageList().add(new BaseResponseMessageDTO(errorCode, propertySource.get(errorCode))));

        return baseResponse;
    }

    private BaseResponse prepareBaseResponse(List<String> errorCodeList, String dynamicValue) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResultCode(BaseResponse.ResultCode.ERROR);
        baseResponse.setMessageList(new ArrayList<>());
        errorCodeList.forEach(errorCode -> baseResponse.getMessageList().add(new BaseResponseMessageDTO(errorCode, propertySource.get(errorCode).replace(VALIDATION_MESSAGE_DYNAMIC_VALUE, dynamicValue))));

        return baseResponse;
    }

    private ResponseEntity handleException(HttpStatus status, Object body){
        return ResponseEntity.status(status).body(body);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
       Map<String, String> errors = new HashMap<>();
       ex.getBindingResult().getAllErrors().forEach( error ->
               errors.put(ex.getBindingResult().getTarget() instanceof ValidatedRequest ?
                       ((ValidatedRequest) ex.getBindingResult().getTarget()).localizeValidationFields(getField((FieldError) error)) :
                               ((FieldError) error).getField(),
                       error.getDefaultMessage()));

       return handleException(HttpStatus.NOT_ACCEPTABLE , prepareBaseResponse(errors));
    }

    private String getField(FieldError error) {
        String fullPathErrorField = error.getField();
        String[] splited = fullPathErrorField.split("\\.");

        return splited.length > 0 ? splited[splited.length - 1] : fullPathErrorField;
    }

    private BaseResponse prepareBaseResponse(Map<String, String> errors) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResultCode(BaseResponse.ResultCode.ERROR);
        baseResponse.setMessageList(new ArrayList<>());
        errors.forEach((fieldName, errorCode) -> baseResponse.getMessageList().add(new BaseResponseMessageDTO(errorCode, propertySource.get(errorCode).replace(VALIDATION_MESSAGE_FIELD_NAME, fieldName))));

        return baseResponse;
    }
}
