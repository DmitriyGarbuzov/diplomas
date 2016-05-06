package com.diplomas.web.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diplomas.entity.GraduateWork;
import com.diplomas.repository.GraduateWorkRepository;
import com.diplomas.web.dto.GraduateWorkDTO;
import com.google.common.base.Converter;

@Component
public class GraduateWorkConverter extends Converter<GraduateWork,GraduateWorkDTO>{
    
    @Autowired
    private HeadWorkConverter headWorkConverter;
    
    @Autowired
    private DegreeConverter degreeConverter;
    
    @Autowired
    private StudentConverter studentConverter;
    
    @Autowired
    private GraduateWorkRepository graduateWorkRepository;
    
    @Override
    protected GraduateWork doBackward(GraduateWorkDTO dto) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    protected GraduateWorkDTO doForward(GraduateWork entity) {
	GraduateWorkDTO dto = new GraduateWorkDTO();
	dto.setUuid(entity.getUuid());
	dto.setSubject(entity.getSubject());
	dto.setSelfHref(entity.getSelfHref());
	dto.setYear(entity.getYear());
	dto.setHeadWork(Optional.ofNullable(entity.getHeadWork())
		.map(headWorkConverter::convert)
		.orElse(null));
	dto.setDegree(Optional.ofNullable(entity.getDegree())
		.map(degreeConverter::convert)
		.orElse(null));
	dto.setStudent(Optional.ofNullable(entity.getStudent())
		.map(studentConverter::convert)
		.orElse(null));
	return dto;
    }

}
