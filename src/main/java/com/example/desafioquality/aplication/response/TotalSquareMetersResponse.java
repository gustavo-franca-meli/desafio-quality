package com.example.desafioquality.aplication.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalSquareMetersResponse {
   @JsonProperty("prop_name")
    public String propertyName;
   @JsonProperty("total_square_meters")
    public Double totalSquareMeters;

    public TotalSquareMetersResponse(String propertyName, Double totalSquareMeters) {
        this.propertyName = propertyName;
        this.totalSquareMeters = totalSquareMeters;
    }

    public TotalSquareMetersResponse() {
    }
}
