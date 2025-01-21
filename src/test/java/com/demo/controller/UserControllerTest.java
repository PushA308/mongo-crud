package com.demo.controller;

import com.demo.dto.UserDTO;
import com.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class UserControllerTest {

    @Mock
    UserService userService;

    private MockMvc mockMvc;


    @InjectMocks
    UserControllerTest userControllerTest;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userControllerTest).build();
    }

    @Test
    public void testUserCreationController() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("piyush@gmail.com");
        userDTO.setPhone("9876543210");
        userDTO.setName("piyush atram");
        userDTO.setLocation("mumbai");

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(userDTO);

        // Mock the userService.createUser method to return a meaningful response.
        Mockito.when(userService.createUser(Mockito.any())).thenReturn("User created successfully");

        mockMvc.perform(post("/create")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  // Assuming a success status is expected (200 OK)
                .andExpect(content().string("User created successfully"))  // Assert the returned response
                .andReturn();
    }


}
