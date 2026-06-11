package com.lautaro.springboot.error.springboot_error.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.lautaro.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.lautaro.springboot.error.springboot_error.models.domain.User;
import com.lautaro.springboot.error.springboot_error.services.UserService;




@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping
    public String index() {
        //int value = 100 / 0;
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return "OK 200!";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id")Long id) {
       User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("User with id: " +" not found"));
       System.out.println(user);
        
        return user;
    }
}
