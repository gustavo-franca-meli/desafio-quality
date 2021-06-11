package com.example.desafioquality.aplication.request;

import com.example.desafioquality.domain.Enum.PropertyErrosMessage;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class PropertyRequest {
    @NotBlank(message = PropertyErrosMessage.NAME_IS_EMPTY)
    @JsonProperty("prop_name")
    public String propertyName;
    @NotBlank(message = PropertyErrosMessage.DISTRICT_IS_EMPTY)
    @JsonProperty("prop_district")
    public String districtName;
    @NotNull(message = PropertyErrosMessage.ROOM_IS_EMPTY)
    @Valid
    public List<RoomRequest> rooms;

    public PropertyRequest(String propertyName, String districtName, List<RoomRequest> rooms) {
        this.propertyName = propertyName;
        this.districtName = districtName;
        this.rooms = rooms;
    }

    public PropertyRequest() {
    }
}
