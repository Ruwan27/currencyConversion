package com.example.currencyConversion.response;

import com.example.currencyConversion.common.StatusCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private StatusCode status;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime timestamp;
    private Object payload;

    private ApiResponse() {
        timestamp = LocalDateTime.now();
    }

    public static ApiResponse forStatus(@NonNull StatusCode status) {
        ApiResponse response = new ApiResponse();
        response.status = status;
        return response;
    }

    public ApiResponse withMessage(String message, String... params) {
        this.message = String.format(message, params);
        return this;
    }

    public ApiResponse withPayload(Object payload) {
        this.payload = payload;
        return this;
    }

}

