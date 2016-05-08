package com.diplomas.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diplomas.entity.Degree;
import com.diplomas.repository.DegreeRepository;
import com.diplomas.web.dto.DegreeDTO;
import com.google.common.base.Converter;

@Component
public class DegreeConverter extends Converter<Degree, DegreeDTO> {
	
	@Autowired
	private DegreeRepository degreeRepository;
	
	@Override
	protected Degree doBackward(DegreeDTO dto) {
		return degreeRepository.findOne(dto.getId());
	}

	@Override
	protected DegreeDTO doForward(Degree entity) {
		DegreeDTO dto = new DegreeDTO();
		dto.setId(entity.getId());
		dto.setDegreeName(entity.getDegreeKey());
		return dto;
	}

}
