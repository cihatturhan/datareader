package com.cihatturhan.datareader.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    public String message;
    public int code;

}