package com.attendance.monitoring.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.monitoring.student.dto.StudentDto;
import com.attendance.monitoring.student.dto.StudentSignupDto;
import com.attendance.monitoring.student.mapper.StudentSignupMapper;
import com.attendance.monitoring.student.model.StudentModel;
import com.attendance.monitoring.student.repository.StudentRepository;
import com.attendance.monitoring.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    
    @Autowired
    private StudentRepository studentRepository;

    private StudentSignupMapper signupMapper = new StudentSignupMapper();

    @Override
    public boolean doStudentSignup(StudentSignupDto dto) {
        StudentModel student = signupMapper.toEntity(dto);
        try {
            this.studentRepository.save(student);
            System.out.println(student.getName());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public StudentDto getSelf(String uniqueRollNumber) {
        try {
            // TODO Auto-generated method stub
            return null;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}
