package com.example.desafioquality.factories;

import com.example.desafioquality.domain.District;
import com.example.desafioquality.domain.Property;
import com.example.desafioquality.domain.Room;

import java.util.ArrayList;
import java.util.List;

public class PropertyTestFactory {
    public static String validName = "Apartamento";
    private District validDistrict = new DistrictTestFactory().withValidName().create();
    private String name;
    private District district;
    private List<Room> rooms;
    public PropertyTestFactory withNameNull(){
        this.name = null;
        return  this;
    }

    public PropertyTestFactory withValidName(){
        this.name = validName;
        return  this;
    }

    public PropertyTestFactory withValidDistrict(){
        this.district = validDistrict;
        return this;

    }
    public PropertyTestFactory withValidRooms(){
        List<Room> rooms = new ArrayList<>();
        rooms.add(new RoomTestFactory().withValidFields().create());
        rooms.add(new RoomTestFactory().withValidFields().create());
        rooms.add(new RoomTestFactory().withValidFields().create());
        rooms.add(new RoomTestFactory().withValidFields().create());
        this.rooms = rooms;
        return this;
    }
    public PropertyTestFactory withCustomRoom(List<Room> rooms){
        this.rooms = rooms;
        return  this;
    }

    public PropertyTestFactory withMoreThanFortyFiveCharactersInName(){
        this.name = "A12345678901234567890123456789012345678901234567890";
        return this;
    }

    public  PropertyTestFactory withValidFields(){
        withValidDistrict();
        withValidName();
        withValidRooms();
        return  this;
    }


    public Property create(){
        return  new Property(name,district,rooms);
    }

    public PropertyTestFactory withNameNullAndOthersValid() {
        withValidRooms();
        withValidDistrict();
        return this;
    }

    public PropertyTestFactory withNameStartWithLowerCaseLetterAndOtherValid() {
        this.name = "propriedade";
        withValidDistrict();
        withValidRooms();
        return this;
    }

    public PropertyTestFactory withValidAndDiferentRooms(){
        List<Room> rooms = new ArrayList<>();
        rooms.add(new RoomTestFactory().withValidFields().create());
        rooms.add(new RoomTestFactory().withValidFields().create());
        rooms.add(new RoomTestFactory().withValidFields().create());
        rooms.add(new RoomTestFactory().withValidFields().create());
        this.rooms = rooms;
        return this;
    }
}
