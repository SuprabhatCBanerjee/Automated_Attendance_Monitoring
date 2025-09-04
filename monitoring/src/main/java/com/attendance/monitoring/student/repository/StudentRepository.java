package com.attendance.monitoring.student.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.attendance.monitoring.student.model.StudentModel;

public interface StudentRepository extends MongoRepository<StudentModel, String> {
 
    StudentModel findByUniqueRollNumber(String uniqueRollNumber);
}
