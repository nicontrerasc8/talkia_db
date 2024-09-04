package com.upc.parte1_avance2.controllers;

import com.upc.parte1_avance2.dtos.UserDTO;
import com.upc.parte1_avance2.entities.User;
import com.upc.parte1_avance2.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        user = userService.createUser(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/user")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        user = userService.updateUser(user);
        return modelMapper.map(user, UserDTO.class);

    }

    @GetMapping("/users")
    public List<UserDTO> listUsers(){
        List<User> list = userService.listUsers();
        List<UserDTO> listDTO = modelMapper.map(list, List.class);
        return listDTO;
    }

    @GetMapping("/user/identity/{id}")
    public UserDTO searchUser(@PathVariable Long id){
        User user = userService.searchUser(id);
        return modelMapper.map(user, UserDTO.class);

    }

    @GetMapping("/user/name/{prefix}")
    public List<UserDTO> searchUsersByName(@PathVariable String prefix){
        List<User> list = userService.searchUsersByName(prefix);
        List<UserDTO> listDTO = modelMapper.map(list, List.class);
        return listDTO;
    }
    @GetMapping("/user/date/{from}_{to}")
    public List<UserDTO>searchUsersByCreatedAtBetween(@PathVariable LocalDate from, @PathVariable LocalDate to){
        List<User> list = userService.searchUsersByCreatedAtBetween(from, to);
        List<UserDTO> listDTO = modelMapper.map(list, List.class);
        return listDTO;
    }
}
