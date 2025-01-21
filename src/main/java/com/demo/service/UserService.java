package com.demo.service;

import com.demo.dto.UserDTO;
import com.demo.model.User;
import com.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public String createUser(UserDTO userDTO){
        try{
            User user = new User();
            user.setEmail(userDTO.getEmail());
            user.setName(userDTO.getName());
            user.setPhone(userDTO.getPhone());
            user.setLocation(userDTO.getLocation());

            userRepo.save(user);

        }catch (Exception e){
            System.out.println(e);
        }
        return "User created successfully";
    }

}
