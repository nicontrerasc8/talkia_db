package com.upc.parte1_avance2.repositories;

import com.upc.parte1_avance2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByNameStartingWith(String prefix);
    List<User>findUsersByCreatedAtBetween(LocalDate from, LocalDate to);
}
