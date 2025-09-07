package com.attendance.monitoring.subject.mapper;

import org.springframework.stereotype.Component;

import com.attendance.monitoring.subject.dto.TimeTableDto;
import com.attendance.monitoring.subject.model.TimeTableModel;

@Component
public class TimeTableMapper {
    
    //toEntity
    public TimeTableModel toEntity(TimeTableDto dto){
        TimeTableModel model = new TimeTableModel();
        // model.setRoomNumber(dto.getRoomNumber());
        // model.setNumberOfClasses(dto.getNumberOfClasses());
        model.setFacultyId(dto.getFacultyId());
        model.setSubjectId(dto.getSubjectId());
        model.setClassStart(dto.getClassStart());
        model.setClassEnd(dto.getClassEnd());
        // model.setDay(dto.getDay());
        // model.setSection(dto.getSection());
        model.setPeriodNumber(dto.getPeriodNumber());
        return model;
    }

    //toDto
    public TimeTableDto toDto(TimeTableModel model){
        TimeTableDto dto = new TimeTableDto();
        // dto.setRoomNumber(model.getRoomNumber());
        // dto.setNumberOfClasses(model.getNumberOfClasses());
        dto.setFacultyId(model.getFacultyId());
        dto.setSubjectId(model.getSubjectId());
        dto.setClassStart(model.getClassStart());
        dto.setClassEnd(model.getClassEnd());
        // dto.setDay(model.getDay());
        // dto.setSection(model.getSection());
        dto.setPeriodNumber(model.getPeriodNumber());
        return dto;
    }
}
