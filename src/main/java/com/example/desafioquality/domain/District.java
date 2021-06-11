package com.example.desafioquality.domain;

import com.example.desafioquality.domain.Enum.DistrictErrorMessage;

public class District {
    private String name;



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
}
