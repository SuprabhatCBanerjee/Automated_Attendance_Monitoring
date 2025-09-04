package com.attendance.monitoring.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.attendance.monitoring.student.model.StudentModel;
import com.attendance.monitoring.student.repository.StudentRepository;

@Component
public class StudentLoginDetailsService implements UserDetailsService{

    @Autowired
    private StudentRepository studentRepository;
 
    @Override
    public UserDetails loadUserByUsername(String uniqueRoll) throws UsernameNotFoundException {
        try {
           
            StudentModel studentModel = this.studentRepository.findByUniqueRollNumber(uniqueRoll);
            
            if (studentModel == null) {
                throw new UsernameNotFoundException("Usernot found with that roll : " + uniqueRoll);
            }

            // return new User(studentModel.getUniqueRollNumber(), studentModel.getPassword(), Collections.emptyList());
            return User.withUsername(studentModel.getUniqueRollNumber())
                .password(studentModel.getPassword())
                .roles("STUDENT")
                .build();
        } catch (Exception e) {
            //e.printStackTrace();
            throw new UsernameNotFoundException(uniqueRoll);
        }
    }
}
