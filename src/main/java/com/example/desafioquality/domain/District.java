package com.example.desafioquality.domain;

import com.example.desafioquality.domain.Enum.DistrictErrorMessage;

public class District {
    private String name;



    private Double squareMetersPrice;

    public District(String name, Double squareMetersPrice) {
       this(name);
      setSquareMetersPrice(squareMetersPrice);
    }

    public District(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank())throw  new IllegalArgumentException(DistrictErrorMessage.NAME_IS_EMPTY);
        if(name.length() > 45)throw new IllegalArgumentException(DistrictErrorMessage.NAME_LENGTH_EXCEED);
        this.name = name;
    }
    public Double getSquareMetersPrice() {
        return squareMetersPrice;
    }

    public void setSquareMetersPrice(Double squareMetersPrice) {
        if(name == null )throw  new IllegalArgumentException(DistrictErrorMessage.SQUARE_METERS_NOT_FOUND);
        this.squareMetersPrice = squareMetersPrice;
    }
}
