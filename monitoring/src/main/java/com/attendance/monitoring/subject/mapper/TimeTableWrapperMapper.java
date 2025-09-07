package com.attendance.monitoring.subject.mapper;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.attendance.monitoring.subject.dto.TimeTableBoxDto;
import com.attendance.monitoring.subject.dto.TimeTableWrapperDto;
import com.attendance.monitoring.subject.model.TimeTableBox;
import com.attendance.monitoring.subject.model.TimeTableWrapper;

@Component
public class TimeTableWrapperMapper {

    @Autowired
    private TimeTableboxMapper tableboxMapper;

    //toEntity
    public TimeTableWrapper toEntity(TimeTableWrapperDto dto){

        if (dto == null) return null;
        TimeTableWrapper wrapper = new TimeTableWrapper();
        wrapper.setRoomNumber(dto.getRoomNumber());
        wrapper.setNumberOfClasses(dto.getNumberOfClasses());
        wrapper.setSection(dto.getSection());
        wrapper.setDepartment(dto.getDepartment());

        wrapper.setWeeklyRoutine(dto.getWeeklyRoutine() == null
                ? new ArrayList<>() 
                : dto.getWeeklyRoutine().stream().map(tableboxMapper::toEntity).collect(Collectors.toList()));   

       
        return wrapper;

    }


    //toDto
    public TimeTableWrapperDto toDto(TimeTableWrapper wrapper){

        TimeTableWrapperDto dto = new TimeTableWrapperDto();
        dto.setRoomNumber(wrapper.getRoomNumber());
        dto.setSection(wrapper.getSection());
        dto.setYear(dto.getYear());
        dto.setNumberOfClasses(wrapper.getNumberOfClasses());

          // map weekly routine
        ArrayList<TimeTableBoxDto> tableBoxDtos = new ArrayList<>();
        if (wrapper.getWeeklyRoutine() != null) {
            for (TimeTableBox timeTableBox : wrapper.getWeeklyRoutine()) {
                TimeTableBoxDto boxDto = tableboxMapper.toDto(timeTableBox);
                tableBoxDtos.add(boxDto);
            }
        }
        dto.setWeeklyRoutine(tableBoxDtos);
     
        
        return dto;
    }
}
