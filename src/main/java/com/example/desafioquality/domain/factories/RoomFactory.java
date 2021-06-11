package com.example.desafioquality.domain.factories;

import com.example.desafioquality.aplication.request.RoomRequest;
import com.example.desafioquality.domain.Room;

public class RoomFactory {

    public static Room create(RoomRequest dto){
        return new Room(dto.name,dto.width,dto.length);
    }
}
