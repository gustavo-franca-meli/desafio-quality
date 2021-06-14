package com.example.desafioquality.infrastructure.repositories;

import com.example.desafioquality.domain.District;
import com.example.desafioquality.domain.Exceptions.EntityNotFoundException;

public interface DistrictRepository {
    District find(District onlyName) throws EntityNotFoundException;
    District find(String name) throws EntityNotFoundException;
}
