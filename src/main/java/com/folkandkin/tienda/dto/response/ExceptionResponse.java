package com.folkandkin.tienda.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class ExceptionResponse {
    private int statusCode;
    private String message;
    private Map<String, String> detail;
}
