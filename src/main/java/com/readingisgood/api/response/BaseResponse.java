package com.readingisgood.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.readingisgood.api.dto.BaseResponseMessageDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseResponse {

    public BaseResponse() {
        this.resultCode = ResultCode.SUCCESS;
        this.resultDescription = ResultCode.SUCCESS_DESCRIPTION;
    }

    @Getter
    @JsonProperty("islemSonuc")
    private String resultCode;

    @Getter
    @JsonProperty("islemSonucAciklama")
    private String resultDescription;

    @Getter
    @JsonProperty("islemSonucZamani")
    private LocalDateTime time = LocalDateTime.now();

    @Getter
    @Setter
    @JsonProperty("mesajListesi")
    private List<BaseResponseMessageDTO> messageList;

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
        this.resultDescription = ResultCode.resultCodeMap.get(resultCode);
    }

    public static class ResultCode {

        private ResultCode(){

        }

        public static final String ERROR = "0";
        public static final String SUCCESS = "1";
        public static final String WARNING = "2";

        public static final String ERROR_DESCRIPTION = "Hatalı";
        public static final String SUCCESS_DESCRIPTION = "Başarılı";
        public static final String WARNING_DESCRIPTION = "Uyarı";

        private static Map<String , String > resultCodeMap;

        static {
            resultCodeMap = new HashMap<>();
            resultCodeMap.put(ERROR, ERROR_DESCRIPTION);
            resultCodeMap.put(SUCCESS, SUCCESS_DESCRIPTION);
            resultCodeMap.put(WARNING, WARNING_DESCRIPTION);
        }
    }
}
