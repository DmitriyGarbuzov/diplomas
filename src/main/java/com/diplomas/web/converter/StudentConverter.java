package com.diplomas.web.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diplomas.entity.Student;
import com.diplomas.repository.StudentRepository;
import com.diplomas.web.dto.StudentDTO;
import com.google.common.base.Converter;

@Component
public class StudentConverter extends Converter<Student, StudentDTO> {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	protected Student doBackward(StudentDTO dto) {
		Student entity = null;
		if (dto.getUuid() != null) {
			entity = studentRepository.findOneByUuid(dto.getUuid()).orElse(null);
		} else {
			entity = new Student();
			entity.setFirstName(dto.getFirstName());
			entity.setSurname(dto.getSurname());
			entity.setPatronymic(dto.getPatronymic());
		}
		return entity;
	}

	@Override
	protected StudentDTO doForward(Student entity) {
		StudentDTO dto = new StudentDTO();
		dto.setUuid(entity.getUuid());
		dto.setFirstName(entity.getFirstName());
		dto.setPatronymic(entity.getPatronymic());
		dto.setSurname(entity.getSurname());

		return dto;
	}

}
