package com.attendance.monitoring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.attendance.monitoring.faculty.model.FacultyModel;
import com.attendance.monitoring.faculty.repository.FacultyRepository;

@Service
public class FacultyLoginDetailsService implements UserDetailsService {
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
         FacultyModel faculty = facultyRepository.findByUniqueId(username);

         if (faculty == null) {
            throw new UsernameNotFoundException("Faculty not found with id : "+username);   
         }
                return User.withUsername(faculty.getUniqueId())
                        .password(faculty.getPassword())
                        .roles("FACULTY")
                        .build();
             
    }
}