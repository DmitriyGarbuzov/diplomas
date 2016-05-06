package com.diplomas.web.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diplomas.entity.Student;
import com.diplomas.repository.StudentRepository;
import com.diplomas.web.dto.StudentDTO;
import com.google.common.base.Converter;

@Component
public class StudentConverter extends Converter<Student,StudentDTO> {
    
    @Autowired
    private StudentGroupConverter studentGroupConverter; 
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Override
    protected Student doBackward(StudentDTO dto) {
	return studentRepository.findOneByUuid(dto.getUuid())
		.orElse(null);
    }

    @Override
    protected StudentDTO doForward(Student entity) {
	StudentDTO dto = new StudentDTO();
	dto.setUuid(entity.getUuid());
	dto.setFirstName(entity.getFirstName());
	dto.setPatronymic(entity.getPatronymic());
	dto.setSurname(entity.getSurname());
	dto.setGroup(Optional.ofNullable(entity.getGroup())
		.map(studentGroupConverter::convert)
		.orElse(null));
	
	return dto;
    }

}
