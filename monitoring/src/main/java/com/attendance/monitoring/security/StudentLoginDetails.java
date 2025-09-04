package com.attendance.monitoring.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.attendance.monitoring.student.model.StudentModel;

public class StudentLoginDetails implements UserDetails{
    
    private StudentModel studentModel;

    public StudentLoginDetails(StudentModel studentModel){
        this.studentModel = studentModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<SimpleGrantedAuthority> set = new HashSet<>();
        return set;
    }

    @Override
    public String getUsername() {
        return this.studentModel.getUniqueRollNumber();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
