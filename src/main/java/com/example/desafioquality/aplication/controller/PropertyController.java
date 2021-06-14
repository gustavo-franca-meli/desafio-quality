package com.example.desafioquality.aplication.controller;


import com.example.desafioquality.aplication.request.PropertyRequest;
import com.example.desafioquality.aplication.response.PropertyValueResponse;
import com.example.desafioquality.aplication.response.RoomBiggestResponse;
import com.example.desafioquality.aplication.response.RoomsSquareMetersResponse;
import com.example.desafioquality.aplication.response.TotalSquareMetersResponse;
import com.example.desafioquality.aplication.useCase.PropertiesUseCase;
import com.example.desafioquality.domain.Exceptions.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("properties/")
public class PropertyController {
    private PropertiesUseCase propertiesUseCase;

    public PropertyController(PropertiesUseCase propertiesUseCase) {
        this.propertiesUseCase = propertiesUseCase;
    }


    @PostMapping("totalSquareMeters")
    public ResponseEntity<TotalSquareMetersResponse> totalSquareMeters(@Valid @RequestBody PropertyRequest request){
        return ResponseEntity.ok(propertiesUseCase.totalSquareMeters(request));
    }

    @PostMapping("value")
    public ResponseEntity<PropertyValueResponse> returnValueOfProperty(@Valid @RequestBody PropertyRequest request) throws EntityNotFoundException {
        return ResponseEntity.ok(propertiesUseCase.returnValue(request));
    }


    @PostMapping("roomBiggest")
    public ResponseEntity<RoomBiggestResponse> returnsBiggerRoom(@Valid @RequestBody PropertyRequest request) throws EntityNotFoundException {
        return ResponseEntity.ok(propertiesUseCase.returnsBiggerRoom(request));
    }
    @PostMapping("roomsSquareMeters")
    public ResponseEntity<RoomsSquareMetersResponse> returnsNumbersOfSquareMetersEachRoom(@Valid @RequestBody PropertyRequest request)  {
        return ResponseEntity.ok(propertiesUseCase.returnsNumbersOfSquareMetersEachRoom(request));
    }
}
