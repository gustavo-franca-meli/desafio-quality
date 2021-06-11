package com.example.desafioquality.factories;

import com.example.desafioquality.domain.District;

public class DistrictTestFactory {
    private String validName = "Bananal";
    private String name;
    public DistrictTestFactory withNameNull(){
        this.name = null;
        return  this;
    }

    public DistrictTestFactory withValidName(){
        this.name = validName;
        return  this;
    }
    public DistrictTestFactory withMoreThanFortyFiveCharactersInName(){
        this.name = "A12345678901234567890123456789012345678901234567890";
        return this;
    }


    public District create(){
        return  new District(name);
    }

}
