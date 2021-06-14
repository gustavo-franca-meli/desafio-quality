package com.example.desafioquality.aplication.useCase;

import com.example.desafioquality.aplication.request.PropertyRequest;
import com.example.desafioquality.aplication.response.RoomBiggestResponse;
import com.example.desafioquality.aplication.response.RoomsSquareMetersResponse;
import com.example.desafioquality.aplication.response.TotalSquareMetersResponse;
import com.example.desafioquality.domain.Exceptions.EntityNotFoundException;
import org.springframework.http.ResponseEntity;

public interface PropertiesUseCase {
    TotalSquareMetersResponse totalSquareMeters(PropertyRequest request);

    RoomBiggestResponse returnsBiggerRoom(PropertyRequest request) throws EntityNotFoundException;

    RoomsSquareMetersResponse returnsNumbersOfSquareMetersEachRoom(PropertyRequest request);
}
