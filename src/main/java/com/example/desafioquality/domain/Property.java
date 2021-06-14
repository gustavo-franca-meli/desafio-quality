package com.example.desafioquality.domain;

import com.example.desafioquality.domain.Enum.PropertyErrosMessage;

import java.util.List;
import java.util.Optional;

public class Property {
    private String name;
    private District district;
    private List<Room> rooms;

    public Property(String name, District district, List<Room> rooms) {
        setName(name);
        setDistrict(district);
        setRooms(rooms);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank())throw  new IllegalArgumentException(PropertyErrosMessage.NAME_IS_EMPTY);
        if(!name.substring(0,1).matches("\\p{Upper}")) throw  new IllegalArgumentException(PropertyErrosMessage.NAME_MUST_START_WITH_CAPITAL_LETTER);
        if(name.length() > 30)throw new IllegalArgumentException(PropertyErrosMessage.NAME_LENGTH_EXCEED);
        this.name = name;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        if(district == null)throw new IllegalArgumentException(PropertyErrosMessage.DISTRICT_IS_EMPTY);
        this.district = district;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        if(rooms == null)throw new IllegalArgumentException(PropertyErrosMessage.ROOM_IS_EMPTY);
        if(rooms.isEmpty())throw  new IllegalArgumentException(PropertyErrosMessage.ROOM_IS_REQUIRED);
        this.rooms = rooms;
    }
    public Double totalSquareMeters() {
        return rooms.stream().reduce(0.,(acc, cur)->cur.squareMeters() + acc,Double::sum);
    }

    public Optional<Room> roomBiggest() {
        return rooms.stream().reduce((acc, cur)-> acc.squareMeters() >= cur.squareMeters()?acc: cur);
    }

    public Double value() {
        if(district.getSquareMetersPrice() == null)throw new IllegalArgumentException(PropertyErrosMessage.DISTRICT_SQUARE_METERS_PRICE_IS_INVALID);
        return totalSquareMeters() * district.getSquareMetersPrice();
    }
}
