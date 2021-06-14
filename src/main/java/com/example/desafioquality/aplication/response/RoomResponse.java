package com.example.desafioquality.aplication.response;

import com.example.desafioquality.aplication.request.RoomRequest;
import com.example.desafioquality.domain.Room;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomResponse extends RoomRequest {

    @JsonProperty("room_square_meters")
    public Double squareMeters;

    public RoomResponse(String name, Double width, Double length, Double squareMeters) {
        super(name, width, length);
        this.squareMeters = squareMeters;
    }

    public RoomResponse() {

    }

    public RoomResponse(Room room) {
        this(room.getName(), room.getWidth(), room.getLength(),room.squareMeters());
    }

    public Double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Double squareMeters) {
        this.squareMeters = squareMeters;
    }

}
