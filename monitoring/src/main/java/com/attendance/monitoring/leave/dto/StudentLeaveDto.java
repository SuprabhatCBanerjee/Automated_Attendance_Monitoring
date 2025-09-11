package com.attendance.monitoring.leave.dto;

import com.attendance.monitoring.leave.enums.LeaveStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentLeaveDto {
    private String leaveId;
    private String studentName;
    private String studentId;
    private String from;
    private String to;
    private String description;
    private LeaveStatusEnum status;
    private String facultyId; 
}
