package com.example.desafioquality.unit.domain;

import com.example.desafioquality.domain.Enum.PropertyErrosMessage;
import com.example.desafioquality.domain.Property;
import com.example.desafioquality.domain.Room;
import com.example.desafioquality.factories.PropertyTestFactory;
import com.example.desafioquality.factories.RoomTestFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PropertyTest {

    @Test
    public void shouldReturnTrowWhenNameFieldIsNull(){
        assertEquals(PropertyErrosMessage.NAME_IS_EMPTY,assertThrows(IllegalArgumentException.class,()->new PropertyTestFactory().withNameNullAndOthersValid().create()).getMessage());
    }

    @Test
    public void shouldReturnTrowWhenNameFieldDoesNotStartWithACapitalLetter(){
        assertEquals(PropertyErrosMessage.NAME_MUST_START_WITH_CAPITAL_LETTER,assertThrows(IllegalArgumentException.class,()->new PropertyTestFactory().withNameStartWithLowerCaseLetterAndOtherValid().create()).getMessage());
    }

    @Test
    public void shouldReturnTrowWhenNameFieldContainsMoreThanThirtyCharacters(){
        assertEquals(PropertyErrosMessage.NAME_LENGTH_EXCEED,assertThrows(IllegalArgumentException.class,()->new PropertyTestFactory().withValidRooms().withValidDistrict().withMoreThanFortyFiveCharactersInName().create()).getMessage());
    }
    @Test
    public void shouldReturnTheSameNameWhenEnteringAValidName(){
        assertEquals(PropertyTestFactory.validName, new PropertyTestFactory().withValidFields().create().getName());
    }
    @Test
    public  void shouldReturnThrowWhenDistrictIsNull(){
        assertEquals(PropertyErrosMessage.DISTRICT_IS_EMPTY,assertThrows(IllegalArgumentException.class,()->new PropertyTestFactory().withValidRooms().withValidName().create()).getMessage());
    }

    @Test void shouldReturnThrowWhenRoomsIsNull(){
        assertEquals(PropertyErrosMessage.ROOM_IS_EMPTY,assertThrows(IllegalArgumentException.class,()->new PropertyTestFactory().withValidDistrict().withValidName().create()).getMessage());
    }
    @Test void shouldReturnThrowWhenRoomsIsLessThanOne(){
        var emptyRooms = new ArrayList<Room>();
        assertEquals(PropertyErrosMessage.ROOM_IS_REQUIRED,assertThrows(IllegalArgumentException.class,()->new PropertyTestFactory().withValidFields().withCustomRoom(emptyRooms).create()).getMessage());
    }

    @Test
    public void shouldCalculateTotalSquareMetersCorrectly(){
        List<Room> rooms = new ArrayList<>();
        rooms.add(new RoomTestFactory().withFields("Quarto",5.,5.).create());
        rooms.add(new RoomTestFactory().withFields("Sala",10.,10.).create());
        rooms.add(new RoomTestFactory().withFields("Cozinha",15.,10.).create());
        rooms.add(new RoomTestFactory().withFields("Quarto 2",10.,15.).create());
        Double expectedTotal = 425.;
        Property property = new PropertyTestFactory().withValidName().withValidDistrict().withCustomRoom(rooms).create();
        assertEquals(expectedTotal,property.totalSquareMeters());
    }

}
