package com.example.desafioquality.aplication.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RoomsSquareMetersResponse {
    @JsonProperty("property_name")
    public String propertyName;
    public List<RoomResponse> rooms;

    public RoomsSquareMetersResponse(String name, List<RoomResponse> roomsResponse) {
        this.propertyName = name;
        rooms = roomsResponse;
    }
}
