package com.example.desafioquality.aplication.useCase;

import com.example.desafioquality.aplication.request.PropertyRequest;
import com.example.desafioquality.aplication.response.TotalSquareMetersResponse;
import org.springframework.http.ResponseEntity;

public interface PropertiesUseCase {
    TotalSquareMetersResponse totalSquareMeters(PropertyRequest request);
}
