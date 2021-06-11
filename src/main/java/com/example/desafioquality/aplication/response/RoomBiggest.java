package com.example.desafioquality.aplication.response;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomBiggest {
    @JsonProperty("room_biggest_name")
    public String name;
    @JsonProperty("room_biggest_width")
    public Double width;
    @JsonProperty("room_biggest_length")
    public Double length;
    @JsonProperty("room_biggest_square_meters")
    public Double squareMeters;

    public RoomBiggest(String name, Double width, Double length, Double squareMeters) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.squareMeters = squareMeters;
    }
}
