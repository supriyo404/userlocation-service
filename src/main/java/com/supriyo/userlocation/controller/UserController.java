package com.supriyo.userlocation.controller;

import ch.qos.logback.classic.spi.LoggerContextAware;
import com.supriyo.userlocation.dto.UserLocationDTO;
import com.supriyo.userlocation.entity.User;
import com.supriyo.userlocation.service.UserService;
import org.apache.logging.log4j.spi.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ulservice")
public class UserController {


    Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @GetMapping("/users-location")
    @CrossOrigin("*")
    public ResponseEntity<List<UserLocationDTO>> findAllUsersLocation(){
       List<UserLocationDTO> response =userService.getAllUsersLocation();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<String> createUser(@RequestBody User user){
        MDC.put("test",user.getFirstName());
        log.info("Creating new user..");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.saveUser(user));
    }

    @GetMapping("/all-users")
    @CrossOrigin("*")
    public ResponseEntity<List<User>> findAllUsers(){
        MDC.put("test",null);
        log.info("Find All User is being called ...");
        List<User> response =userService.getAllUser();
        return ResponseEntity.ok(response);
    }
}
