package com.attendance.monitoring.subject.mapper;

import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.attendance.monitoring.subject.dto.TimeTableBoxDto;
import com.attendance.monitoring.subject.model.TimeTableBox;


@Component
public class TimeTableboxMapper {

    @Autowired
    private TimeTableMapper tableMapper;
    //toEntity
    public TimeTableBox toEntity(TimeTableBoxDto dto){
        if (dto == null) return null;
        TimeTableBox box = new TimeTableBox();
        box.setDay(dto.getDay());
        box.setTimeTable(dto.getTimeTable() == null
                ? new java.util.ArrayList<>()
                : dto.getTimeTable().stream().map(tableMapper::toEntity).collect(Collectors.toList()));
        return box;
    }

    //toDto
    public TimeTableBoxDto toDto(TimeTableBox box){

        TimeTableBoxDto dto = new TimeTableBoxDto();
        dto.setDay(box.getDay());
        dto.setTimeTable(box.getTimeTable() == null
                ? Collections.emptyList()
                : box.getTimeTable().stream().map(tableMapper::toDto).collect(Collectors.toList()));
        return dto;
    }
}
