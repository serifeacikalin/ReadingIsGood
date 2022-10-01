package com.readingisgood.api.dto.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.readingisgood.api.request.ValidatedRequest;
import com.readingisgood.constant.ApiDoc;
import com.readingisgood.constant.Constant;
import com.readingisgood.constant.FieldLength;
import com.readingisgood.constant.ValidationErrorCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
public class BookDTO implements ValidatedRequest {

    private Long id;

    @ApiModelProperty(ApiDoc.Fields.BOOK_NO)
    @Size(max = FieldLength.BOOK_NO, message = ValidationErrorCode.INVALID_INPUT)
    private Long bookNo;

    @ApiModelProperty(ApiDoc.Fields.BOOK_NAME)
    @NotNull(message = ValidationErrorCode.BOOK_DEFINITION_INPUT_EMPTY)
    private String bookName;

    @ApiModelProperty(ApiDoc.Fields.AUTHOR_NAME)
    @NotNull(message = ValidationErrorCode.BOOK_DEFINITION_INPUT_EMPTY)
    private String authorName;

    @ApiModelProperty(ApiDoc.Fields.PUBLICATION_YEAR)
    @NotNull(message = ValidationErrorCode.BOOK_DEFINITION_INPUT_EMPTY)
    @JsonFormat(pattern = Constant.DATE_FORMAT_YYYY)
    private String  publicationYear;

    @ApiModelProperty(ApiDoc.Fields.CREATED_USER)
    @NotNull(message = ValidationErrorCode.BOOK_DEFINITION_INPUT_EMPTY)
    private String createdUser;

    @ApiModelProperty(ApiDoc.Fields.STOCK)
    @Positive(message = ValidationErrorCode.GRATER_THAN_ZERO)
    private Long stock;

    @ApiModelProperty(ApiDoc.Fields.AMOUNT)
    @DecimalMax(value = FieldLength.BOOK_MAX_AMOUNT, message = ValidationErrorCode.INVALID_INPUT)
    @NotNull(message = ValidationErrorCode.BOOK_DEFINITION_INPUT_EMPTY)
    private BigDecimal amount;
    @JsonIgnore
    @Override
    public String localizeValidationFields(String fieldName) {
        return fieldName;
    }
}
