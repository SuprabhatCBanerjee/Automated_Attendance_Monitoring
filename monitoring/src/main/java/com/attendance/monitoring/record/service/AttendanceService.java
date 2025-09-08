package com.attendance.monitoring.record.service;

import java.util.List;

import com.attendance.monitoring.record.dto.AttendanceBoxDto;

public interface AttendanceService {
    public boolean saveAttendance(List<AttendanceBoxDto> dtos);
}
