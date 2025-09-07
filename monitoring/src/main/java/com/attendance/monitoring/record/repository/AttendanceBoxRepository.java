package com.attendance.monitoring.record.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.attendance.monitoring.record.model.AttendanceBox;

public interface AttendanceBoxRepository extends MongoRepository<AttendanceBox, String> {
    
}
