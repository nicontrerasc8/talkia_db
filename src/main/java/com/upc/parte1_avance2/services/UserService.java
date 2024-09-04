package com.upc.parte1_avance2.services;

import com.upc.parte1_avance2.entities.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public interface UserService {
    public User createUser(User user);
    public void deleteUser(Long userID);
    public User updateUser(User user);
    public List<User> listUsers();
    public User searchUser(Long userID);
    public List<User> searchUsersByName(String prefix);
    public List<User>searchUsersByCreatedAtBetween(LocalDate from, LocalDate to);
}
