package com.example.desafioquality.unit.domain;

import com.example.desafioquality.domain.Enum.RoomErrorsMessage;
import com.example.desafioquality.domain.Room;
import com.example.desafioquality.factories.RoomTestFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


public class RoomTest {


    @Test
    public void shouldReturnTrowWhenNameFieldIsNull(){
         assertEquals(RoomErrorsMessage.NAME_IS_EMPTY,assertThrows(IllegalArgumentException.class,()->new Room(null,10.,10.)).getMessage());
    }

    @Test
    public void shouldReturnTrowWhenNameFieldDoesNotStartWithACapitalLetter(){
        assertEquals(RoomErrorsMessage.NAME_MUST_START_WITH_CAPITAL_LETTER,assertThrows(IllegalArgumentException.class,()->new Room("quarto",10.,10.)).getMessage());
    }

    @Test
    public void shouldReturnTrowWhenNameFieldContainsMoreThanThirtyCharacters(){
        assertEquals(RoomErrorsMessage.NAME_LENGTH_EXCEED,assertThrows(IllegalArgumentException.class,()->new Room("A123456789012345678901234567890",10.,10.)).getMessage());
    }
    @Test
    public void shouldReturnTheSameNameWhenEnteringAValidName(){
        var name = "Quarto";
        assertEquals(name, new Room(name,10.,10.).getName());
    }
    @Test
    public void shouldReturnTrowWhenWidthFieldIsNull(){
        assertEquals(RoomErrorsMessage.WIDTH_IS_EMPTY,assertThrows(IllegalArgumentException.class,()->new Room("Quarto",null,10.)).getMessage());
    }

    @Test
    public void shouldReturnTrowWhenWidthFieldMustBeAValidNumber(){
        assertEquals(RoomErrorsMessage.WIDTH_IS_INVALID_NUMBER,assertThrows(IllegalArgumentException.class,()->new Room("Quarto",Double.NaN,10.)).getMessage());
    }

    @Test
    public void shouldReturnTrowWhenWidthFieldIsGreaterThanTwentyFiveMeters(){
        assertEquals(RoomErrorsMessage.WIDTH_IS_MORE_THAN_MAXIMUM,assertThrows(IllegalArgumentException.class,()->new Room("Quarto",26.,10.)).getMessage());
    }
    @Test
    public void shouldReturnTrowWhenWidthFieldIsLessOrEqualThanZeroMeters(){
        assertEquals(RoomErrorsMessage.WIDTH_MUST_BE_GREATER_THAN_ZERO,assertThrows(IllegalArgumentException.class,()->new Room("Quarto",-1.,10.)).getMessage());
    }

    @Test
    public void shouldReturnTheSameLengthWhenEnteringAValidWidth(){
        var name = "Quarto";
        var width = 10.;
        assertEquals(width, new Room(name,width,10.).getWidth());
    }


    @Test
    public void shouldReturnTrowWhenLengthFieldIsNull(){
        assertEquals(RoomErrorsMessage.LENGTH_IS_EMPTY,assertThrows(IllegalArgumentException.class,()->new Room("Quarto",10.,null)).getMessage());
    }

    @Test
    public void shouldReturnTrowWhenLengthFieldMustBeAValidNumber(){
        assertEquals(RoomErrorsMessage.LENGTH_IS_INVALID_NUMBER,assertThrows(IllegalArgumentException.class,()->new Room("Quarto",10.,Double.NaN)).getMessage());
    }

    @Test
    public void shouldReturnTrowWhenLengthFieldIsGreaterThanTwentyFiveMeters(){
        assertEquals(RoomErrorsMessage.LENGTH_IS_MORE_THAN_MAXIMUM,assertThrows(IllegalArgumentException.class,()->new Room("Quarto",10.,36.)).getMessage());
    }
    @Test
    public void shouldReturnTrowWhenLengthFieldIsLessOrEqualThanZeroMeters(){
        assertEquals(RoomErrorsMessage.LENGTH_MUST_BE_GREATER_THAN_ZERO,assertThrows(IllegalArgumentException.class,()->new Room("Quarto",10.,-1.)).getMessage());
    }

    @Test
    public void shouldReturnTheSameLengthWhenEnteringAValidLength(){
        var name = "Quarto";
        var width = 10.;
        var length = 10.;
        assertEquals(length, new Room(name,width,length).getWidth());
    }
    @Test
    public void shouldCalculateTotalSquareMetersCorrectly(){
       Room room = new RoomTestFactory().withFields("Quarto",15.,12.).create();
       assertEquals(180.,room.squareMeters());
    }



}
