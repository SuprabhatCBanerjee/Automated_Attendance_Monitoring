package com.attendance.monitoring.faculty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.monitoring.faculty.dto.FacultySignupDto;
import com.attendance.monitoring.faculty.mapper.FacultySignupMapper;
import com.attendance.monitoring.faculty.model.FacultyModel;
import com.attendance.monitoring.faculty.repository.FacultyRepository;
import com.attendance.monitoring.faculty.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService{
    
    @Autowired
    private FacultyRepository facultyRepository;

    private FacultySignupMapper facultySignupMapper = new FacultySignupMapper();

    @Override
    public boolean facultySignup(FacultySignupDto dto) {
        FacultyModel facultyModel = facultySignupMapper.toEntity(dto);
        try {
            this.facultyRepository.save(facultyModel);
            System.out.println(facultyModel.getName());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
