package com.example.desafioquality.factories;

import com.example.desafioquality.domain.District;
import com.example.desafioquality.domain.Property;
import com.example.desafioquality.domain.Room;

import java.util.List;

public class RoomTestFactory {
    private String validName = "Apartamento";
    private Double validWidth = 10.;
    private Double validLength = 10.;
    private String name;
    private Double width;
    private Double length;
    public RoomTestFactory withNameNull(){
        this.name = null;
        return  this;
    }

    public RoomTestFactory withValidName(){
        this.name = validName;
        return  this;
    }

    public RoomTestFactory withValidFields(){
        withValidName();
        withValidWidth();
        widthValidLength();
        return this;
    }

    private RoomTestFactory withValidWidth() {
        width = validWidth;
        return this;

    }

    private RoomTestFactory widthValidLength() {
        length = validLength;
        return this;

    }

    public RoomTestFactory withMoreThanFortyFiveCharactersInName(){
        this.name = "A12345678901234567890123456789012345678901234567890";
        return this;
    }


    public Room create(){
        return  new Room(name,width,length);
    }

    public RoomTestFactory withFields(String name, Double width, Double length) {
        this.length = length;
        this.name = name;
        this.width = width;
        return  this;
    }
}
