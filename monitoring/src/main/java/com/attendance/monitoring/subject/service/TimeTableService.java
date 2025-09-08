package com.attendance.monitoring.subject.service;

import com.attendance.monitoring.subject.dto.TimeTableWrapperDto;
import com.attendance.monitoring.subject.model.TimeTableWrapper;

public interface TimeTableService {
    public TimeTableWrapper saveTable(TimeTableWrapperDto wrapperDto);
    public TimeTableWrapperDto getTimeTable(String universityId, String roomNumber, String department, String year);
}
