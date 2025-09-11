package com.attendance.monitoring.student.service;

import com.attendance.monitoring.student.dto.StudentDto;
import com.attendance.monitoring.student.dto.StudentSignupDto;

public interface StudentService {
    
    public boolean doStudentSignup(StudentSignupDto dto);
    public StudentDto getSelf(String uniqueRollNumber);// for self account fetch
    
    
}
