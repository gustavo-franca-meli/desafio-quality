package com.example.desafioquality.factories;

import com.example.desafioquality.aplication.request.PropertyRequest;
import com.example.desafioquality.aplication.request.RoomRequest;

import java.util.ArrayList;
import java.util.List;

public class PropertyRequestTest {
    private String propertyName;
    private String districtName;
    private List<RoomRequest> rooms;
    public PropertyRequestTest withValidFields(){
        rooms = new ArrayList<>();
        rooms.add(new RoomRequestTestFactory().withValidFields().create());
        rooms.add(new RoomRequestTestFactory().withValidFields().create());
        rooms.add(new RoomRequestTestFactory().withValidFields().create());
        rooms.add(new RoomRequestTestFactory().withValidFields().create());
        propertyName = "Apartamento";
        districtName = "Bananal";
        return this;
    }

    public PropertyRequest create(){
        return new PropertyRequest(propertyName,districtName,rooms);
    }

    public PropertyRequestTest withInvalidFields() {
        rooms = new ArrayList<>();
        rooms.add(new RoomRequestTestFactory().withInvalidFields().create());
        propertyName = "apartamentooooooooooooooooooooooooooooooodasdasasdasdasddasasdasd";
        districtName = "aananalasdasdasdasdasdasdasdasdasdadaasdasdasdasdsdsdsdasdasdasdasdad";
        return this;
    }
}
