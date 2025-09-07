package com.attendance.monitoring.subject.mapper;

import org.springframework.stereotype.Component;

import com.attendance.monitoring.subject.dto.TimeTableDto;
import com.attendance.monitoring.subject.model.TimeTableModel;

@Component
public class TimeTableMapper {
    
    //toEntity
    public TimeTableModel toEntity(TimeTableDto dto){
        
        if (dto == null) return null;
        TimeTableModel model = new TimeTableModel();
        model.setSubjectId(dto.getSubjectId());
        model.setFacultyId(dto.getFacultyId());
        model.setPeriodNumber(dto.getPeriodNumber());
        model.setClassStart(dto.getClassStart());
        model.setClassEnd(dto.getClassEnd());
        return model;
    }

    //toDto
    public TimeTableDto toDto(TimeTableModel model){

        if (model == null) return null;
        TimeTableDto dto = new TimeTableDto();
        dto.setSubjectId(model.getSubjectId());
        dto.setFacultyId(model.getFacultyId());
        dto.setPeriodNumber(model.getPeriodNumber());
        dto.setClassStart(model.getClassStart());
        dto.setClassEnd(model.getClassEnd());
        return dto;
    }
}
