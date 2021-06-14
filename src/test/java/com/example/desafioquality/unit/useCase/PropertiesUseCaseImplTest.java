package com.example.desafioquality.unit.useCase;

import com.example.desafioquality.aplication.request.PropertyRequest;
import com.example.desafioquality.aplication.useCase.impl.PropertiesUseCaseImpl;
import com.example.desafioquality.domain.District;
import com.example.desafioquality.domain.Exceptions.EntityNotFoundException;
import com.example.desafioquality.factories.PropertyRequestTest;
import com.example.desafioquality.infrastructure.repositories.DistrictRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;


public class PropertiesUseCaseImplTest {
    private static PropertiesUseCaseImpl propertiesUseCase;
    private static DistrictRepository districtRepository;

    @BeforeAll
    public static void init(){
        districtRepository  = mock(DistrictRepository.class);
        propertiesUseCase = new PropertiesUseCaseImpl(districtRepository);

    }
    @Test
    public void shouldCalculateTotalSquareMetersCorrectly(){
        var propertyRequest = new PropertyRequestTest().withValidFields().create();
        var total = propertiesUseCase.totalSquareMeters(propertyRequest);
        Double totalExpected = propertyRequest.rooms.stream().map((r)-> r.width * r.length).reduce(0.,(acc,cur)-> acc + cur);

        assertEquals(totalExpected,total.totalSquareMeters);
    }
    @Test
    public void shouldThrowIfPropertyRequestIsNull(){
        PropertyRequest propertyRequest = null;
        assertThrows(IllegalArgumentException.class,()->propertiesUseCase.totalSquareMeters(propertyRequest));
    }
    @Test
    public void shouldThrowIfPropertyRequestIsInvalid(){
        PropertyRequest propertyRequest = new PropertyRequestTest().withInvalidFields().create();
        assertThrows(IllegalArgumentException.class,()->propertiesUseCase.totalSquareMeters(propertyRequest));
    }

    @Test
    public void shouldThrowIfPropertyRequestIsInvalidInReturnsBiggerRoomMethod(){
        PropertyRequest propertyRequest = new PropertyRequestTest().withInvalidFields().create();
        assertThrows(IllegalArgumentException.class,()->propertiesUseCase.returnsBiggerRoom(propertyRequest));
    }

    @Test
    public void shouldThrowIfPropertyRequestIsNullInReturnsBiggerRoomMethod(){
        PropertyRequest propertyRequest = null;
        assertThrows(IllegalArgumentException.class,()->propertiesUseCase.returnsBiggerRoom(propertyRequest));
    }

    //US002
    @Test
    public void shouldReturnPropertyValueCorrectly() throws EntityNotFoundException {
        when(districtRepository.find(argThat((District district ) -> district != null &&  district.getName().equals("Centro")))).thenReturn(new District("Centro",1000.));


        var propertyRequest = new PropertyRequestTest().withValidFields().create();
        var expectedValue = 400000.;
        var room = propertiesUseCase.returnValue(propertyRequest);
        assertEquals(expectedValue,room.value);
    }
    @Test
    public void shouldReturnEntityNotFoundWhenDistrictNotExist() throws EntityNotFoundException {
        when(districtRepository.find(argThat((District district ) -> district != null && district.getName().equals("Centro")))).thenThrow(EntityNotFoundException.class);

        var propertyRequest = new PropertyRequestTest().withValidFields().create();
        assertThrows(EntityNotFoundException.class,()->propertiesUseCase.returnValue(propertyRequest));

    }

    //US003
    @Test
    public void shouldReturnARoomBiggest() throws EntityNotFoundException {
        Double width = 20.;
        Double length = 20.;
        Double squareMeters = width * length;

        var propertyRequest = new PropertyRequestTest().withValidFields().withRoom("Room biggest",width,length).create();
        var room = propertiesUseCase.returnsBiggerRoom(propertyRequest);
        assertEquals(squareMeters,room.squareMeters);
    }
    //US0004
    @Test
    public void shouldReturnsNumbersOfSquareMetersEachRoom()  {
        var propertyRequest = new PropertyRequestTest().withValidFields().create();
        var response = propertiesUseCase.returnsNumbersOfSquareMetersEachRoom(propertyRequest);
        var room = propertyRequest.rooms.get(0);
        assertEquals((room.width * room.length),response.rooms.get(0).getSquareMeters());
    }


}
