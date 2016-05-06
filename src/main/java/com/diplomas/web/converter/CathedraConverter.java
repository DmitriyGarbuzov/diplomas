package com.diplomas.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diplomas.entity.Cathedra;
import com.diplomas.repository.CathedraRepository;
import com.diplomas.web.dto.CathedraDTO;
import com.google.common.base.Converter;

@Component
public class CathedraConverter extends Converter<Cathedra, CathedraDTO>{
    
    @Autowired
    private CathedraRepository cathedraRepository;
    
    @Override
    protected Cathedra doBackward(CathedraDTO dto) {
	return cathedraRepository.findOne(dto.getId());
    }

    @Override
    protected CathedraDTO doForward(Cathedra entity) {
	CathedraDTO dto = new CathedraDTO();
	dto.setId(entity.getId());
	dto.setCathedraName(entity.getCathedraName());
	return dto;
    }

}
