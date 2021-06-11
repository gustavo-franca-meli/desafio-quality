package com.example.desafioquality.factories;

import com.example.desafioquality.aplication.request.RoomRequest;

public class RoomRequestTestFactory {
    private String name;
    private Double width;
    private Double length;
    public RoomRequestTestFactory withValidFields(){
        name = "Quarto";
        width = 10.;
        length = 10.;
        return this;
    }

    public RoomRequest create(){
        return new RoomRequest(name,width,length);
    }

    public RoomRequestTestFactory withInvalidFields() {
        this.length = 50.;
        this.width = null;
        this.name = "";
        return this;
    }
}
