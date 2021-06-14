package com.example.desafioquality.aplication.useCase.impl;

import com.example.desafioquality.aplication.request.PropertyRequest;
import com.example.desafioquality.aplication.response.RoomBiggestResponse;
import com.example.desafioquality.aplication.response.RoomResponse;
import com.example.desafioquality.aplication.response.RoomsSquareMetersResponse;
import com.example.desafioquality.aplication.response.TotalSquareMetersResponse;
import com.example.desafioquality.aplication.useCase.PropertiesUseCase;
import com.example.desafioquality.domain.Enum.RoomErrorsMessage;
import com.example.desafioquality.domain.Exceptions.EntityNotFoundException;
import com.example.desafioquality.domain.Property;
import com.example.desafioquality.domain.factories.PropertyFactory;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PropertiesUseCaseImpl implements PropertiesUseCase {
    @Override
    public TotalSquareMetersResponse totalSquareMeters(PropertyRequest request) throws IllegalArgumentException {
        if(request == null) throw new IllegalArgumentException("request cannot be null");
        Property property = new PropertyFactory().create(request);
        return new TotalSquareMetersResponse(property.getName(), property.totalSquareMeters());
    }

    @Override
    public RoomBiggestResponse returnsBiggerRoom(PropertyRequest request) throws EntityNotFoundException {
        if(request == null) throw new IllegalArgumentException("request cannot be null");
        Property property = new PropertyFactory().create(request);
        var room = property.roomBiggest();
        if(room.isPresent())
        return new RoomBiggestResponse(room.get().getName(),room.get().getWidth(),room.get().getLength(),room.get().squareMeters());

        throw  new EntityNotFoundException(RoomErrorsMessage.NOT_FOUND);
    }

    @Override
    public RoomsSquareMetersResponse returnsNumbersOfSquareMetersEachRoom(PropertyRequest request) {
        if(request == null) throw new IllegalArgumentException("request cannot be null");
        Property property = new PropertyFactory().create(request);
        var roomsResponse = property.getRooms().stream().map(RoomResponse::new).collect(Collectors.toList());
        return new RoomsSquareMetersResponse(property.getName(),roomsResponse);
    }
}
