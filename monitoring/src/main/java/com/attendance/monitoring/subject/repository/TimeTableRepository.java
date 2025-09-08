package com.attendance.monitoring.subject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.attendance.monitoring.subject.model.TimeTableWrapper;
import java.util.List;


public interface TimeTableRepository extends MongoRepository<TimeTableWrapper, String> {
    
    TimeTableWrapper findByUniversityIdAndRoomNumberAndDepartmentAndYear(String universityId, String roomNumber, String department, String year);
}
