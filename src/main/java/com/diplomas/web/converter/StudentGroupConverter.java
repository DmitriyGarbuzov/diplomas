package com.diplomas.web.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diplomas.entity.StudentGroup;
import com.diplomas.repository.StudentGroupRepository;
import com.diplomas.web.dto.StudentGroupDTO;
import com.google.common.base.Converter;

@Component
public class StudentGroupConverter extends Converter<StudentGroup,StudentGroupDTO>{
    
    @Autowired
    private StudentGroupRepository studentGroupRepository;
    
    @Autowired
    private CathedraConverter cathedraConverter;
    
    @Override
    protected StudentGroup doBackward(StudentGroupDTO dto) {
	return studentGroupRepository.findOne(dto.getId());
    }

    @Override
    protected StudentGroupDTO doForward(StudentGroup entity) {
	StudentGroupDTO dto = new StudentGroupDTO();
	dto.setId(entity.getId());
	dto.setGroupName(entity.getGroupName());
	dto.setCathedra(Optional.ofNullable(entity.getCathedra())
		.map(cathedraConverter::convert)
		.orElse(null));
	return dto;
    }

}
