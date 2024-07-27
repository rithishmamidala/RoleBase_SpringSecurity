package com.ust.UstProjects.service;

import com.ust.UstProjects.model.Person;
import com.ust.UstProjects.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupUserDetailsToService implements UserDetailsService {

    @Autowired
    private PersonRepo personRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> user = personRepo.findByUsername(username);
        return user.map(GroupUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));

    }
}
