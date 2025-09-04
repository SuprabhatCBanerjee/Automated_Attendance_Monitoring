package com.attendance.monitoring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.attendance.monitoring.student.model.StudentModel;
import com.attendance.monitoring.student.repository.StudentRepository;

@Service
public class StudentLoginDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
     StudentModel student = studentRepository.findByUniqueRollNumber(username);
        if (student == null) {
            throw new UsernameNotFoundException("Student not found");
        }

        return User.withUsername(student.getUniqueRollNumber())
                .password(student.getPassword())
                .roles("STUDENT")
                .build();

    }
}
