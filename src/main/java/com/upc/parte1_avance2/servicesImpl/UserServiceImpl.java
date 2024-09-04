package com.upc.parte1_avance2.servicesImpl;

import com.upc.parte1_avance2.entities.User;
import com.upc.parte1_avance2.repositories.UserRepository;
import com.upc.parte1_avance2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long userID) {
        userRepository.deleteById(userID);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        if(userRepository.existsById(user.getId())){
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User searchUser(Long userID) {
        return userRepository.findById(userID).get();
    }

    @Override
    public List<User> searchUsersByName(String prefix){
        return userRepository.findUserByNameStartingWith(prefix);
    }
    @Override
    public List<User>searchUsersByCreatedAtBetween(LocalDate from, LocalDate to){
        return userRepository.findUsersByCreatedAtBetween(from, to);
    }
}
