package com.example.desafioquality.domain.Exceptions;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String notFound) {
        super(notFound);
    }
}
