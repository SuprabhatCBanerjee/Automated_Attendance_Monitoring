package com.attendance.monitoring.leave.service;

import java.util.List;

import com.attendance.monitoring.leave.dto.StudentLeaveDto;

public interface StudentLeaveService {
    public boolean applyLeave(StudentLeaveDto leaveDto);
    public StudentLeaveDto getLeaveById(String id);
    public List<StudentLeaveDto> getAllLeave();
}
