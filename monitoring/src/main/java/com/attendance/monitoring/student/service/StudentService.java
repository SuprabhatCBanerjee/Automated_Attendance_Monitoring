package com.attendance.monitoring.student.service;

import com.attendance.monitoring.student.dto.StudentSignupDto;

public interface StudentService {
    
    public boolean doStudentSignup(StudentSignupDto dto);
    
}
