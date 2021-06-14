package com.example.desafioquality.aplication.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PropertyValueResponse {
    @JsonProperty("property_name")
    public String name;
    @JsonProperty("property_district")
    public String district;
    @JsonProperty("property_value")
    public Double value;

    public PropertyValueResponse(String name, String district, Double value) {
        this.name = name;
        this.district = district;
        this.value = value;
    }
}
