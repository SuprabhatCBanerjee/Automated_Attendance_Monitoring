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
        // box.setRoomNumber(dto.getRoomNumber());
        // box.setDepartment(dto.getDepartment());
        // box.setSection(dto.getSection());
        box.setDay(dto.getDay());
        // box.setNumberOfClasses(dto.getNumberOfClasses());

        for(TimeTableDto tableDto : dto.getTimeTable()){
            TimeTableModel timeTableModel = new TimeTableModel();
            // timeTableModel.setRoomNumber(tableDto.getRoomNumber());
            timeTableModel.setSubjectId(tableDto.getSubjectId());
            timeTableModel.setFacultyId(tableDto.getFacultyId());
            timeTableModel.setClassStart(tableDto.getClassStart());
            timeTableModel.setClassEnd(tableDto.getClassEnd()); 
            // timeTableModel.setDay(tableDto.getDay());
            // timeTableModel.setDepartment(tableDto.getDepartment());
            // timeTableModel.setNumberOfClasses(tableDto.getNumberOfClasses());
            timeTableModel.setPeriodNumber(tableDto.getPeriodNumber());
            box.addTimeTable(timeTableModel);
        }
        return box;
    }

    //toDto
    public TimeTableBoxDto toDto(TimeTableBox box){

        TimeTableBoxDto dto = new TimeTableBoxDto();

        // dto.setRoomNumber(box.getRoomNumber());
        dto.setDay(box.getDay());
        // dto.setDepartment(box.getDepartment());
        // dto.setNumberOfClasses(box.getNumberOfClasses());

        ArrayList<TimeTableDto> tableDtos = new ArrayList<>();

        for(TimeTableModel model : box.getTimeTable()){
            
            TimeTableDto tableDto = new TimeTableDto();
           
            tableDto.setSubjectId(model.getSubjectId());
            tableDto.setFacultyId(model.getFacultyId());
            tableDto.setClassStart(model.getClassStart());
            tableDto.setClassEnd(model.getClassEnd()); 
            
            tableDto.setPeriodNumber(model.getPeriodNumber());
            //
            tableDtos.add(tableDto);            
        }

        dto.setTimeTable(tableDtos);

        return dto;
    }
}
