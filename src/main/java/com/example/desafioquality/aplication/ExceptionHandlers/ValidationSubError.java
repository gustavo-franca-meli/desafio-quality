package com.example.desafioquality.aplication.ExceptionHandlers;


public class ValidationSubError extends SubError {
    public String object;
    public String field;
    public ValidationSubError(String message, String object, String field) {
        super(message);
        this.object = object;
        this.field = field;
    }
}
