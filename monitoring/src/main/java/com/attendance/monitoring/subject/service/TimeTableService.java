package com.attendance.monitoring.subject.service;

import java.util.List;

import com.attendance.monitoring.subject.dto.TimeTableBoxDto;
import com.attendance.monitoring.subject.dto.TimeTableDto;
import com.attendance.monitoring.subject.dto.TimeTableWrapperDto;
import com.attendance.monitoring.subject.model.TimeTableWrapper;

public interface TimeTableService {
    public TimeTableWrapper saveTable(TimeTableWrapperDto wrapperDto);
    public TimeTableWrapperDto getTimeTable(String universityId, String roomNumber, String department);
    public List<TimeTableDto> getDailyRoutine(List<TimeTableBoxDto> tableBoxDto, String day);
    public TimeTableDto getOnePeriod(List<TimeTableDto> timeTableDtos, String time);
}
