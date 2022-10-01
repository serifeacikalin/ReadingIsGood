package com.readingisgood.infra;

import com.readingisgood.api.response.BaseResponse;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Not Acceptable", response = BaseResponse.ResultCode.class),
        @ApiResponse(code = 500, message = "Internal Error", response = BaseResponse.ResultCode.class)
})
public @interface DefaultApiResponses {
}
