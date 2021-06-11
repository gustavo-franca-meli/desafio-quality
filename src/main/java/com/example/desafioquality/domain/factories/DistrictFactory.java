package com.example.desafioquality.domain.factories;

import com.example.desafioquality.domain.District;

public class DistrictFactory {

    public static District create(String name){
        return new District(name);
    }

}
