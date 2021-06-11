package com.example.desafioquality.aplication.useCase.impl;

import com.example.desafioquality.aplication.request.PropertyRequest;
import com.example.desafioquality.aplication.response.TotalSquareMetersResponse;
import com.example.desafioquality.aplication.useCase.PropertiesUseCase;
import com.example.desafioquality.domain.Property;
import com.example.desafioquality.domain.factories.PropertyFactory;
import org.springframework.stereotype.Service;

@Service
public class PropertiesUseCaseImpl implements PropertiesUseCase {
    @Override
    public TotalSquareMetersResponse totalSquareMeters(PropertyRequest request) throws IllegalArgumentException {
        if(request == null) throw new IllegalArgumentException("request cannot be null");
        Property property = new PropertyFactory().create(request);
        return new TotalSquareMetersResponse(property.getName(), property.totalSquareMeters());
    }
}
