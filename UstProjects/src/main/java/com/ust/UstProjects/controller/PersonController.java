package com.ust.UstProjects.controller;

import com.ust.UstProjects.model.Person;
import com.ust.UstProjects.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String setPassword(@RequestBody Person person)
    {
        String encodePassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodePassword);
        personRepo.save(person);
        return "hi " +person.getUsername()+ " registration successful";

    }

}