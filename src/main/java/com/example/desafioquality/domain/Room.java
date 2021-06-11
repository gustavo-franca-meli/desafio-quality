package com.example.desafioquality.domain;

import com.example.desafioquality.domain.Enum.RoomErrorsMessage;

import java.util.regex.Pattern;

public class Room {
    private String name;
    private Double width;
    private Double length;

    public Room() {
    }

    public Room(String name, Double width, Double length) throws IllegalArgumentException {
        setName(name);
        setLength(length);
        setWidth(width);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if(name == null || name.isBlank()) throw new IllegalArgumentException(RoomErrorsMessage.NAME_IS_EMPTY);
        if(!name.substring(0,1).matches("^\\p{Upper}"))throw new IllegalArgumentException(RoomErrorsMessage.NAME_MUST_START_WITH_CAPITAL_LETTER);
        if(name.length() > 30) throw new IllegalArgumentException(RoomErrorsMessage.NAME_LENGTH_EXCEED);

        this.name = name;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        if(width == null)throw  new IllegalArgumentException(RoomErrorsMessage.WIDTH_IS_EMPTY);
        if(width.isNaN())throw new IllegalArgumentException(RoomErrorsMessage.WIDTH_IS_INVALID_NUMBER);
        if(width < 1)throw new IllegalArgumentException(RoomErrorsMessage.WIDTH_MUST_BE_GREATER_THAN_ZERO);
        if(width > 25)throw new IllegalArgumentException(RoomErrorsMessage.WIDTH_IS_MORE_THAN_MAXIMUM);
        this.width = width;
    }

    public Double getLength() {

        return length;
    }

    public void setLength(Double length) {
        if(length == null) throw new IllegalArgumentException(RoomErrorsMessage.LENGTH_IS_EMPTY);
        if(length.isNaN()) throw new IllegalArgumentException(RoomErrorsMessage.LENGTH_IS_INVALID_NUMBER);
        if(length < 1)throw new IllegalArgumentException(RoomErrorsMessage.LENGTH_MUST_BE_GREATER_THAN_ZERO);
        if(length > 33) throw new IllegalArgumentException(RoomErrorsMessage.LENGTH_IS_MORE_THAN_MAXIMUM);
        this.length = length;
    }

    public Double squareMeters(){
        return this.width * this.length;
    }

}
