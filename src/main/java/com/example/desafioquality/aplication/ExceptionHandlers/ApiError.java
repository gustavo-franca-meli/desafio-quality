package com.example.desafioquality.aplication.ExceptionHandlers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private HttpStatus status;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String debugMessage;

    private List<SubError> errors;

    public List<SubError> getErrors() {
        return errors;
    }

    public void setErrors(List<SubError> errors) {
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }




    public ApiError() {
        timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus statusCode, String message) {
        this();
        setStatus(statusCode);
        this.message = message;
    }


    public ApiError(HttpStatus statusCode, String message, Throwable ex) {
        this();
        setStatus(statusCode);
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}