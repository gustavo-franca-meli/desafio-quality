package com.example.desafioquality.aplication.request;


import com.example.desafioquality.domain.Enum.RoomErrorsMessage;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RoomRequest {
    @NotBlank(message = RoomErrorsMessage.NAME_IS_EMPTY)
    @JsonProperty("room_name")
    public String name;
    @NotNull(message = RoomErrorsMessage.WIDTH_IS_EMPTY)
    @JsonProperty("room_width")
    public Double width;
    @NotNull(message = RoomErrorsMessage.LENGTH_IS_EMPTY)
    @JsonProperty("room_length")
    public Double length;

    public RoomRequest() {
    }

    public RoomRequest(String name, Double width, Double length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }
}
