package com.attendance.monitoring.leave.mapper;

import org.springframework.stereotype.Component;

import com.attendance.monitoring.leave.dto.StudentLeaveDto;
import com.attendance.monitoring.leave.model.StudentLeaveModel;

@Component
public class StudentLeaveMapper {
    
    //toEntity
    public StudentLeaveModel toEntity(StudentLeaveDto dto){
        
        StudentLeaveModel model = new StudentLeaveModel();
        model.setLeaveId(dto.getLeaveId());
        model.setDescription(dto.getDescription());
        model.setFacultyId(dto.getFacultyId());
        model.setFrom(dto.getFrom());
        model.setTo(dto.getTo());
        model.setStudentName(dto.getStudentName());
        model.setStudentId(dto.getStudentId());
        model.setStatus(dto.getStatus());
        
        return model;
    }

    //toDto
    public StudentLeaveDto toDto(StudentLeaveModel leaveModel){

        StudentLeaveDto dto = new StudentLeaveDto();
        dto.setLeaveId(leaveModel.getLeaveId());
        dto.setDescription(leaveModel.getDescription());
        dto.setFacultyId(leaveModel.getFacultyId());
        dto.setFrom(leaveModel.getFrom());
        dto.setTo(leaveModel.getTo());
        dto.setStudentName(leaveModel.getStudentName());
        dto.setStudentId(leaveModel.getStudentId());
        dto.setStatus(leaveModel.getStatus());
        
        return dto;
    }
}
