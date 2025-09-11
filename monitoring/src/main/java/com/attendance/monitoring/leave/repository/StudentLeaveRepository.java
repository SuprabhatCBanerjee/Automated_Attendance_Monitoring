package com.attendance.monitoring.leave.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.attendance.monitoring.leave.model.StudentLeaveModel;


public interface StudentLeaveRepository extends MongoRepository<StudentLeaveModel, String> {
    StudentLeaveModel findByLeaveId(String leaveId);
}
