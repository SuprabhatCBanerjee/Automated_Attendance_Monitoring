package com.attendance.monitoring.student.mapper;

import com.attendance.monitoring.student.dto.StudentDto;
import com.attendance.monitoring.student.model.StudentModel;

public class StudentMapper {
    //toEntity
    public StudentModel toEntity(StudentDto dto){
        StudentModel model = new StudentModel();
        model.setName(dto.getName());
        model.setAddress(dto.getAddress());
        model.setEmail(dto.getEmail());
        model.setPhone(dto.getPhone());
        model.setStudentPhoto(dto.getStudentPhoto());
        model.setUniqueRollNumber(dto.getUniqueRollNumber());
        model.setDepartment(dto.getDepartment());
        model.setYear(dto.getYear());
        model.setSemester(dto.getSemester());
        model.setCourseName(dto.getCourseName());
        model.setCoursePeriod(dto.getCoursePeriod());
        return model;
    }

    //toDto
    public StudentDto toDto(StudentModel model){
        StudentDto dto = new StudentDto();
        dto.setName(model.getName());
        dto.setAddress(model.getAddress());
        dto.setEmail(model.getEmail());
        dto.setPhone(model.getPhone());
        dto.setStudentPhoto(model.getStudentPhoto());
        dto.setUniqueRollNumber(model.getUniqueRollNumber());
        dto.setDepartment(model.getDepartment());
        dto.setYear(model.getYear());
        dto.setSemester(model.getSemester());
        dto.setCourseName(model.getCourseName());
        dto.setCoursePeriod(model.getCoursePeriod());
        return dto;
    }

}
