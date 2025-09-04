package com.attendance.monitoring.security;


import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.attendance.monitoring.faculty.model.FacultyModel;

public class FacultyLoginDetails  implements UserDetails{
    
    private FacultyModel facultyModel;

    public FacultyLoginDetails(FacultyModel facultyModel){
        this.facultyModel = facultyModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<SimpleGrantedAuthority> set = new HashSet<>();
        return set;
    }

    @Override
    public String getUsername() {
        return this.facultyModel.getUniqueId();
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
