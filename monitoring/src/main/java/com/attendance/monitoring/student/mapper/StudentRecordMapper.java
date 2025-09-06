package com.attendance.monitoring.student.mapper;

import org.springframework.stereotype.Component;

import com.attendance.monitoring.student.dto.StudentRecordDto;
import com.attendance.monitoring.student.model.StudentRecordModel;

@Component
public class StudentRecordMapper {
    //toEntity
    public StudentRecordModel toEntity(StudentRecordDto dto){
        StudentRecordModel model = new StudentRecordModel();
        model.setStudentId(dto.getStudentId());
        model.setValidationCount(dto.getValidationCount());
        model.setClassIn(dto.getClassIn());
        model.setClassOut(dto.getClassOut());
        return model;
    }

    //toDto
}
