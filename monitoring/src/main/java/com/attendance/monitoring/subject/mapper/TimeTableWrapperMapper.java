package com.attendance.monitoring.subject.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.attendance.monitoring.subject.dto.TimeTableBoxDto;
import com.attendance.monitoring.subject.dto.TimeTableDto;
import com.attendance.monitoring.subject.dto.TimeTableWrapperDto;
import com.attendance.monitoring.subject.model.TimeTableBox;
import com.attendance.monitoring.subject.model.TimeTableModel;
import com.attendance.monitoring.subject.model.TimeTableWrapper;

@Component
public class TimeTableWrapperMapper {

    private TimeTableMapper tableMapper = new TimeTableMapper();
    private TimeTableboxMapper tableboxMapper = new TimeTableboxMapper();

    //toEntity
    public TimeTableWrapper toEntity(TimeTableWrapperDto dto){
        TimeTableWrapper wrapper = new TimeTableWrapper();
        wrapper.setRoomNumber(dto.getRoomNumber());
        wrapper.setNumberOfClasses(dto.getNumberOfClasses());
        wrapper.setSection(dto.getSection());
        wrapper.setDepartment(dto.getDepartment());

        for(TimeTableBoxDto boxDto : dto.getWeeklyRoutine()){
            TimeTableBox box = new TimeTableBox();
            box = tableboxMapper.toEntity(boxDto);

            for(TimeTableDto tableDto : boxDto.getTimeTable()){
                TimeTableModel table = new TimeTableModel();
                table = tableMapper.toEntity(tableDto);
                box.addTimeTable(table);
            }

            wrapper.addTimeTableBox(box);
        }

        return wrapper;
    }


    //toDto
    public TimeTableWrapperDto toDto(TimeTableWrapper wrapper){

        TimeTableWrapperDto dto = new TimeTableWrapperDto();
        dto.setRoomNumber(wrapper.getRoomNumber());
        dto.setSection(wrapper.getSection());
        dto.setYear(dto.getYear());
        dto.setNumberOfClasses(wrapper.getNumberOfClasses());

        // ArrayList<TimeTableBoxDto> tableBoxDtos = new ArrayList<>();
        // ArrayList<TimeTableDto> tableDtos = new ArrayList<>();

        // for (TimeTableBox timeTableBox : wrapper.getWeeklyRoutine()) {
        //     // TimeTableBoxDto boxDto = new TimeTableBoxDto();
        //     // boxDto.setDay(timeTableBox.getDay());
        //     TimeTableBoxDto boxDto = tableboxMapper.toDto(timeTableBox);
        //     // for (TimeTableModel timeTableModel : ) {     
        //     // }
        //     tableBoxDtos.add(boxDto);
        // }

        // dto.setWeeklyRoutine(tableBoxDtos);
        
        return dto;
    }
}
