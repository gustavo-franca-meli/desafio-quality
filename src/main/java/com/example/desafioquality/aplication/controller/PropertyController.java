package com.example.desafioquality.aplication.controller;


import com.example.desafioquality.aplication.request.PropertyRequest;
import com.example.desafioquality.aplication.response.TotalSquareMetersResponse;
import com.example.desafioquality.aplication.useCase.PropertiesUseCase;
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
}
