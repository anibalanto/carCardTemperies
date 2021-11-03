package com.temperies.carcard.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO <T>{
    String code;
    String msg;
    Date date = new Date();
    @JsonInclude(JsonInclude.Include.NON_NULL)
    T additionalData;

    public ErrorDTO(String code, String msg, T additionalData) {
        this.code = code;
        this.msg = msg;
        this.additionalData = additionalData;
    }

    public ErrorDTO(String data_error, String cannot_make_data_operation) {
        this.code = code;
        this.msg = msg;
    }
}
