package com.attendance.monitoring.faculty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.attendance.monitoring.faculty.model.FacultyModel;


public interface FacultyRepository extends MongoRepository<FacultyModel, String>{

    FacultyModel findByUniqueId(String uniqueId);
    
} 