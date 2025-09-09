package com.attendance.monitoring.subject.service.impl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.monitoring.subject.dto.TimeTableBoxDto;
import com.attendance.monitoring.subject.dto.TimeTableDto;
import com.attendance.monitoring.subject.dto.TimeTableWrapperDto;
import com.attendance.monitoring.subject.mapper.TimeTableWrapperMapper;
import com.attendance.monitoring.subject.model.TimeTableWrapper;
import com.attendance.monitoring.subject.repository.TimeTableRepository;
import com.attendance.monitoring.subject.service.TimeTableService;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    private TimeTableRepository tableRepository;

    // private TimeTableWrapperMapper wrapperMapper = new TimeTableWrapperMapper();
    @Autowired
    private TimeTableWrapperMapper wrapperMapper;

    @Override
    public TimeTableWrapper saveTable(TimeTableWrapperDto wrapperDto) {
        try {

            TimeTableWrapper wrapper = wrapperMapper.toEntity(wrapperDto);
            this.tableRepository.save(wrapper);
            return wrapper;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }   
    }

    @Override
    public TimeTableWrapperDto getTimeTable(String universityId, String roomNumber, String department, String year) {
        try {
            TimeTableWrapper wrapper = this.tableRepository.findByUniversityIdAndRoomNumberAndDepartmentAndYear(universityId, roomNumber, department, year);
            TimeTableWrapperDto wrapperDto = this.wrapperMapper.toDto(wrapper);
            return wrapperDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<TimeTableDto> getDailyRoutine(List<TimeTableBoxDto> tableBoxDtos, String day) {
        List<TimeTableDto> periods = new ArrayList<>();
        TimeTableBoxDto boxDto = new TimeTableBoxDto();
        try {
            boxDto = tableBoxDtos.stream().filter(d -> d.getDay().equals(day)).findFirst().orElse(null);
            periods = boxDto.getTimeTable();
            return periods;
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public TimeTableDto getOnePeriod(List<TimeTableDto> timeTableDtos, String time) {
        try {
            TimeTableDto tableDto = timeTableDtos.stream().filter(s -> classTimeCompare(s.getClassStart(), s.getClassEnd(), time)).findFirst().orElse(null);
            return tableDto;
        } catch (Exception e) {
            return null;
        }
    }


    protected boolean classTimeCompare(String start, String end, String checkIn){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime startTime = LocalTime.parse(start, formatter);
        LocalTime endTime = LocalTime.parse(end, formatter);
        LocalTime checkInTime = LocalTime.parse(checkIn, formatter);

        if (!checkInTime.isBefore(startTime) && !checkInTime.isAfter(endTime)) {
            return true;
        }
        return false;
    }

}
