package com.example.desafioquality.integration;

import com.example.desafioquality.aplication.controller.PropertyController;
import com.example.desafioquality.aplication.request.PropertyRequest;
import com.example.desafioquality.aplication.useCase.impl.PropertiesUseCaseImpl;
import com.example.desafioquality.factories.PropertyRequestTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTest {
    @Autowired
    MockMvc mockMvc;

    private PropertyRequest propertyRequest;
    private String requestJson;
    private ObjectMapper mapper;


    @BeforeEach
    void setup() throws JsonProcessingException {
         propertyRequest = new PropertyRequestTest().withValidFields().create();
          mapper = new ObjectMapper();
        requestJson = mapper.writeValueAsString(propertyRequest);

    }

    // US0001 - totalSquareMeters
    @Test
    public void shouldReturnTotalSquareMetersResponseWithAllFields() throws Exception {
        mockMvc.perform(post("/properties/totalSquareMeters").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.total_square_meters").exists())
                .andExpect(jsonPath("$.prop_name").isNotEmpty());
    }
    @Test
    public void shouldReturnTotalSquareMetersCorrectly() throws Exception {

        var expectedTotalSquareMeters = propertyRequest.rooms.stream().map(r -> r.length * r.width).reduce((acc,cur)->acc + cur).get();
        mockMvc.perform(post("/properties/totalSquareMeters").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.total_square_meters").value(expectedTotalSquareMeters));
    }
    @Test
    public void shouldReturnPropertyNameCorrectly() throws Exception {
        mockMvc.perform(post("/properties/totalSquareMeters").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.prop_name").value(propertyRequest.propertyName));
    }

    @Test void shouldReturnBadRequestForNullJsonRequest() throws Exception {
        String nullJson ="{}";
        mockMvc.perform(post("/properties/totalSquareMeters").contentType(MediaType.APPLICATION_JSON).content(nullJson))
                .andExpect(status().isBadRequest());
    }

    @Test void shouldReturnBadRequestWithErrorsFieldsInBody() throws Exception {
        String nullJson ="{}";
        mockMvc.perform(post("/properties/totalSquareMeters").contentType(MediaType.APPLICATION_JSON).content(nullJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").isNotEmpty())
                .andExpect(jsonPath("$.message").isNotEmpty())
                .andExpect(jsonPath("$.errors").isArray())
                .andExpect(jsonPath("$.errors[0].object").isNotEmpty())
                .andExpect(jsonPath("$.errors[0].field").isNotEmpty())
                .andExpect(jsonPath("$.errors[0].message").isNotEmpty());
    }
    @Test void shouldReturnBadRequestWhenRoomsFieldIsNull() throws Exception {
        String nullJson ="{}";
        propertyRequest.rooms = null;
        requestJson = mapper.writeValueAsString(propertyRequest);
        mockMvc.perform(post("/properties/totalSquareMeters").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isBadRequest());
    }
    @Test void shouldReturnBadRequestWhenPropertyNameIsNull() throws Exception {
        String nullJson ="{}";
        propertyRequest.propertyName = null;
        requestJson = mapper.writeValueAsString(propertyRequest);
        mockMvc.perform(post("/properties/totalSquareMeters").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isBadRequest());
    }
    @Test  void shouldReturnBadRequestWhenDistrictNameIsNull() throws Exception {
        String nullJson ="{}";
        propertyRequest.districtName = null;
        requestJson = mapper.writeValueAsString(propertyRequest);
        mockMvc.perform(post("/properties/totalSquareMeters").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isBadRequest());
    }
    // US0002 - valueOfProperty
    @Test
    public void shouldReturnPropertyValueWithAllFields() throws Exception {
        mockMvc.perform(post("/properties/value").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.property_value").isNumber())
                .andExpect(jsonPath("$.property_district").isNotEmpty())
                .andExpect(jsonPath("$.property_name").isNotEmpty());
    }
    @Test
    public void shouldReturnPropertyValueCorrectly() throws Exception {
        var expectedValue = 8029600.;
        mockMvc.perform(post("/properties/value").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.property_value").value(expectedValue));
    }

    @Test
    public void shouldReturnNotFoundWhenDistrictIsNotFound() throws Exception {
        propertyRequest.districtName = "District that doesn't exist";
        requestJson = mapper.writeValueAsString(propertyRequest);
        mockMvc.perform(post("/properties/value").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value("NOT_FOUND"));
    }


    // US0003 - roomBiggest
    @Test
    public void shouldReturnRoomBiggestWithAllFields() throws Exception {
        mockMvc.perform(post("/properties/roomBiggest").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.room_biggest_name").exists())
                .andExpect(jsonPath("$.room_biggest_width").isNumber())
                .andExpect(jsonPath("$.room_biggest_length").isNumber())
                .andExpect(jsonPath("$.room_biggest_square_meters").isNumber());
    }
    @Test
    public void shouldReturnRoomBiggestCorrectly() throws Exception {
        mockMvc.perform(post("/properties/roomBiggest").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.room_biggest_name").value("Quarto"))
                .andExpect(jsonPath("$.room_biggest_square_meters").value(100.));
    }

    // US0004 - RoomsSquareMeters

    @Test
    public void shouldReturnRoomsWithAllFields() throws Exception {
        mockMvc.perform(post("/properties/roomsSquareMeters").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.property_name").exists())
                .andExpect(jsonPath("$.rooms").isArray())
                .andExpect(jsonPath("$.rooms[0].room_length").isNumber())
                .andExpect(jsonPath("$.rooms[0].room_width").isNumber())
                .andExpect(jsonPath("$.rooms[0].room_square_meters").isNumber())
                .andExpect(jsonPath("$.rooms[0].room_name").isNotEmpty());
    }
    @Test
    public void shouldReturnRoomsWithSquareMetersCorrectly() throws Exception {
        mockMvc.perform(post("/properties/roomsSquareMeters").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.rooms[0].room_square_meters").value(100.))
                .andExpect(jsonPath("$.rooms[1].room_square_meters").value(100.))
                .andExpect(jsonPath("$.rooms[2].room_square_meters").value(100.))
                .andExpect(jsonPath("$.rooms[3].room_square_meters").value(100.));
    }

}
