package com.attendance.monitoring.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.attendance.monitoring.faculty.model.FacultyModel;
import com.attendance.monitoring.faculty.repository.FacultyRepository;

@Component
public class FacultyLoginDetailsService implements UserDetailsService{

    @Autowired 
    private FacultyRepository facultyRepository;

    @Override
    public UserDetails loadUserByUsername(String uniqueId) throws UsernameNotFoundException {
        try {
            FacultyModel facultyModel = this.facultyRepository.findByUniqueId(uniqueId);
            if (facultyModel == null) {
                throw new UsernameNotFoundException("faculty not found with id : "+uniqueId);
            }

            // return new User(facultyModel.getUniqueId(), facultyModel.getPassword(), Collections.emptyList());
            return User.withUsername(facultyModel.getUniqueId())
                        .password(facultyModel.getPassword())
                        .roles("FACULTY")
                        .build();
        } catch (Exception e) {
            //e.printStackTrace();
            throw new UsernameNotFoundException(uniqueId);
        }    
    } 
     
}
