package com.example.desafioquality.domain.factories;

import com.example.desafioquality.aplication.request.PropertyRequest;
import com.example.desafioquality.aplication.useCase.PropertiesUseCase;
import com.example.desafioquality.domain.District;
import com.example.desafioquality.domain.Property;

import java.util.stream.Collectors;

public class PropertyFactory {

    public Property create( PropertyRequest dto){
        if(dto == null) throw new IllegalArgumentException("PropertyRequest cannot be null");
        var rooms = dto.rooms.stream().map(RoomFactory::create).collect(Collectors.toList());
        return new Property(dto.propertyName, DistrictFactory.create(dto.districtName),rooms);
    }
}
