package com.attendance.monitoring.subject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.attendance.monitoring.subject.model.TimeTableWrapper;


public interface TimeTableRepository extends MongoRepository<TimeTableWrapper, String> {
    
    TimeTableWrapper findByUniversityIdAndRoomNumberAndDepartment(String universityId, String roomNumber, String department);
}
