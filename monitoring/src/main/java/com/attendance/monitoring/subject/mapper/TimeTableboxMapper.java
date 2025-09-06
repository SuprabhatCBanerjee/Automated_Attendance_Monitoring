package com.attendance.monitoring.subject.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.attendance.monitoring.subject.dto.TimeTableBoxDto;
import com.attendance.monitoring.subject.dto.TimeTableDto;
import com.attendance.monitoring.subject.model.TimeTableBox;
import com.attendance.monitoring.subject.model.TimeTableModel;

@Component
public class TimeTableboxMapper {
    //toEntity
    public TimeTableBox toEntity(TimeTableBoxDto dto){
        TimeTableBox box = new TimeTableBox();
        for(TimeTableDto tableDto : dto.getTimeTable()){
            TimeTableModel timeTableModel = new TimeTableModel();
            timeTableModel.setRoomNumber(tableDto.getRoomNumber());
            timeTableModel.setSubjectId(tableDto.getSubjectId());
            timeTableModel.setFacultyId(tableDto.getFacultyId());
            timeTableModel.setClassStart(tableDto.getClassStart());
            timeTableModel.setClassEnd(tableDto.getClassEnd()); 
            timeTableModel.setDay(tableDto.getDay());
            timeTableModel.setDepartment(tableDto.getDepartment());
            timeTableModel.setNumberOfClasses(tableDto.getNumberOfClasses());
            timeTableModel.setPeriodNumber(tableDto.getPeriodNumber());
            box.addTimeTable(timeTableModel);
        }
        return box;
    }

    //toDto
    public TimeTableBoxDto toDto(TimeTableBox box){
        TimeTableBoxDto dto = new TimeTableBoxDto();
        ArrayList<TimeTableDto> tableDtos = new ArrayList<>();

        for(TimeTableModel model : box.getTimeTable()){
            TimeTableDto tableDto = new TimeTableDto();
            tableDto.setRoomNumber(model.getRoomNumber());
            tableDto.setSubjectId(model.getSubjectId());
            tableDto.setFacultyId(model.getFacultyId());
            tableDto.setClassStart(model.getClassStart());
            tableDto.setClassEnd(model.getClassEnd()); 
            tableDto.setDay(model.getDay());
            tableDto.setDepartment(model.getDepartment());
            tableDto.setNumberOfClasses(model.getNumberOfClasses());
            tableDto.setPeriodNumber(model.getPeriodNumber());
            //
            tableDtos.add(tableDto);            
        }

        dto.setTimeTable(tableDtos);

        return dto;
    }
}
