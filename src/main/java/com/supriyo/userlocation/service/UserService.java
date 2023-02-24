package com.supriyo.userlocation.service;

import com.supriyo.userlocation.dto.UserLocationDTO;
import com.supriyo.userlocation.entity.User;
import com.supriyo.userlocation.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    public List<UserLocationDTO> getAllUsersLocation(){
        return userRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());

    }


    public String saveUser(User user){
        userRepository.save(user);
        log.info("new user created.");
        return "user data saved.";
    }

    public List<User> getAllUser(){
     log.info("Fetching all users");
        return userRepository.findAll();
    }

    private UserLocationDTO entityToDto(User user){

        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setUserId(user.getId());
        userLocationDTO.setEmail(user.getEmail());
        userLocationDTO.setPlace(user.getLocation().getPlace());
        userLocationDTO.setLongitude(user.getLocation().getLongitude());
        userLocationDTO.setLatitude(user.getLocation().getLatitude());

        return userLocationDTO;
    }
}
