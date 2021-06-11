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

    @Test
    public void shouldReturnTotalSquareMetersResponseWithAllFields() throws Exception {
        mockMvc.perform(post("/properties/totalSquareMeters").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(print())
                .andExpect(jsonPath("$.total_square_meters").exists())
                .andExpect(jsonPath("$.prop_name").isNotEmpty());
    }
    @Test
    public void shouldReturnTotalSquareMetersCorrectly() throws Exception {

        var expectedTotalSquareMeters = propertyRequest.rooms.stream().map(r -> r.length * r.width).reduce((acc,cur)->acc + cur).get();

        System.out.println(requestJson);

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
                .andDo(print())
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
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    @Test void shouldReturnBadRequestWhenDistrictNameIsNull() throws Exception {
        String nullJson ="{}";
        propertyRequest.districtName = null;
        requestJson = mapper.writeValueAsString(propertyRequest);
        mockMvc.perform(post("/properties/totalSquareMeters").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
