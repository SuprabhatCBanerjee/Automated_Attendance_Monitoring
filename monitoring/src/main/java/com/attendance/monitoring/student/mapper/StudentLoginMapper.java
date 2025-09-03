package com.attendance.monitoring.student.mapper;

import com.attendance.monitoring.student.dto.StudentLoginDto;
import com.attendance.monitoring.student.model.StudentModel;

public class StudentLoginMapper {
    
    //toEntity
    public StudentModel toEntity(StudentLoginDto dto){
        StudentModel model = new StudentModel();
        model.setUniqueRollNumber(dto.getUniqueRollNumber());
        model.setPassword(dto.getPassword());
        return null;
    }

    //toDto
    public StudentLoginDto toDto(){
        return null;
    }
}
