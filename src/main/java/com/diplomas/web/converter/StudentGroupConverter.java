package com.diplomas.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diplomas.entity.StudentGroup;
import com.diplomas.repository.StudentGroupRepository;
import com.diplomas.web.dto.StudentGroupDTO;
import com.google.common.base.Converter;

@Component
public class StudentGroupConverter extends Converter<StudentGroup, StudentGroupDTO> {

	@Autowired
	private StudentGroupRepository studentGroupRepository;

	@Override
	protected StudentGroup doBackward(StudentGroupDTO dto) {
		StudentGroup entity = null;
		if (dto.getId() != null) {
			entity = studentGroupRepository.findOne(dto.getId());
		} else {
			entity = new StudentGroup();
			entity.setGroupName(dto.getGroupName());
			studentGroupRepository.save(entity);
		}
		return entity;
	}

	@Override
	protected StudentGroupDTO doForward(StudentGroup entity) {
		StudentGroupDTO dto = new StudentGroupDTO();
		dto.setId(entity.getId());
		dto.setGroupName(entity.getGroupName());
		return dto;
	}

}
