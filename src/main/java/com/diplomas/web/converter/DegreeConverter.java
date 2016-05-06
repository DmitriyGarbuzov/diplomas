package com.diplomas.web.converter;

import org.springframework.stereotype.Component;

import com.diplomas.entity.Degree;
import com.diplomas.web.dto.DegreeDTO;
import com.google.common.base.Converter;

@Component
public class DegreeConverter extends Converter<Degree,DegreeDTO>{

    @Override
    protected Degree doBackward(DegreeDTO dto) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    protected DegreeDTO doForward(Degree entity) {
	DegreeDTO dto = new DegreeDTO();
	dto.setDegreeName(entity.getDegreeKey());
	return dto;
    }

}
