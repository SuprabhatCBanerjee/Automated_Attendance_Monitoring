package com.attendance.monitoring.student.mapper;

import com.attendance.monitoring.student.dto.StudentSignupDto;
import com.attendance.monitoring.student.model.StudentModel;

public class StudentSignupMapper {
    //toEntity
    public StudentModel toEntity(StudentSignupDto dto){
        StudentModel model = new StudentModel();
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setPhone(dto.getPhone());
        model.setPassword(dto.getPassword());
        model.setDepartment(dto.getDepartment());
        return model;
    }

    public StudentSignupDto toDto(){
        StudentSignupDto dto = new StudentSignupDto();
        return dto;
    }
}
