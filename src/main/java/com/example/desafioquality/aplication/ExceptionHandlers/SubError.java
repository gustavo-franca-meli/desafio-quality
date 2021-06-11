package com.example.desafioquality.aplication.ExceptionHandlers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubError {
    public String message;

    public String debugMessage;

    public SubError(String message) {
        this.message = message;
    }
}