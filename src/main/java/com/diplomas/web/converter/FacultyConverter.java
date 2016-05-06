package com.diplomas.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diplomas.entity.Faculty;
import com.diplomas.repository.FacultyRepository;
import com.diplomas.web.dto.FacultyDTO;
import com.google.common.base.Converter;

@Component
public class FacultyConverter extends Converter<Faculty,FacultyDTO>{
    
    @Autowired
    private FacultyRepository facultyRepository; 
    
    @Override
    protected Faculty doBackward(FacultyDTO dto) {
	return facultyRepository
		.findOneByFacultyName(dto.getFacultyName())
		.orElse(null);
    }

    @Override
    protected FacultyDTO doForward(Faculty entity) {
	FacultyDTO dto = new FacultyDTO();
	dto.setFacultyName(entity.getFacultyName());
	return dto;
    }

}
