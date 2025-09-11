package com.attendance.monitoring.leave.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.attendance.monitoring.leave.enums.LeaveStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document("studentLeave")
public class StudentLeaveModel {

    @Id
    private String id;
    private String leaveId;
    private String studentName;
    private String studentId;
    private String from;
    private String to;
    private String description;
    private LeaveStatusEnum status;
    private String facultyId; // who takes actions
}
