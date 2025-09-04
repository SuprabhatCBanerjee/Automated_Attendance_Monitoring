package com.attendance.monitoring.faculty.mapper;

import com.attendance.monitoring.faculty.dto.FacultySignupDto;
import com.attendance.monitoring.faculty.model.FacultyModel;

public class FacultySignupMapper {
    //toEntity
    public FacultyModel toEntity(FacultySignupDto dto){
        FacultyModel model = new FacultyModel();
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setDesignation(dto.getDesignation());
        model.setUniqueId(dto.getUniqueId());
        model.setPassword(dto.getPassword());
        return model;
    }

    //toDto
    public FacultySignupDto toDto(){
        return null;
    }
}
