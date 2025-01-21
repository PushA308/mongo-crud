package com.demo.service;


import com.demo.dto.UserDTO;
import com.demo.model.User;
import com.demo.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepo userRepo;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUserCreation(){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("piyush@gmail.com");
        userDTO.setPhone("9876543210");
        userDTO.setName("piyush atram");
        userDTO.setLocation("mumbai");

        Mockito.when(userRepo.save(Mockito.any())).thenReturn(new Object());

        assertNotNull(userService.createUser(userDTO));

    }

}
