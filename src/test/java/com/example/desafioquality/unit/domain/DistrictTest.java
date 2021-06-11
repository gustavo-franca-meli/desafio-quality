package com.example.desafioquality.unit.domain;


import com.example.desafioquality.domain.Enum.DistrictErrorMessage;
import com.example.desafioquality.domain.Enum.PropertyErrosMessage;
import com.example.desafioquality.factories.DistrictTestFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

public class DistrictTest {

    @Test
    public void shouldReturnThrowWhenNameFieldIsNull(){
        assertEquals(DistrictErrorMessage.NAME_IS_EMPTY,assertThrows(IllegalArgumentException.class,()-> new DistrictTestFactory().withNameNull().create()).getMessage());
    }
    @Test
    public void shouldReturnThrowWhenNameFieldIsGreaterThanFortyFiveCharacters(){
        assertEquals(DistrictErrorMessage.NAME_LENGTH_EXCEED,assertThrows(IllegalArgumentException.class,()-> new DistrictTestFactory().withMoreThanFortyFiveCharactersInName().create()).getMessage());
    }
}
