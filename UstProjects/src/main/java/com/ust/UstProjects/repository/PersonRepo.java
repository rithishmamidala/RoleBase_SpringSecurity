package com.ust.UstProjects.repository;

import com.ust.UstProjects.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person,Integer> {

    Optional<Person> findByUsername(String username);
}