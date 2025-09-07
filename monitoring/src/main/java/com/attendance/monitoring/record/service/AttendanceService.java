package com.attendance.monitoring.record.service;

import com.attendance.monitoring.record.dto.AttendanceBoxDto;

public interface AttendanceService {
    public boolean saveAttendance(AttendanceBoxDto dto);
}
