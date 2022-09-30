package com.readingisgood.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponseMessageDTO {

    @JsonProperty("kod")
    private String code;

    @JsonProperty("mesaj")
    private String message;
}
