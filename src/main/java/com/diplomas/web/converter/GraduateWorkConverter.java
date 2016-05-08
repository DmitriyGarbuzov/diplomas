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
		GraduateWork entity = null;
		if (dto.getUuid() != null 
				&& graduateWorkRepository.findOneByUuid(dto.getUuid()) != null) {
			//TODO : implement update
		} else {
			entity = new GraduateWork();
			entity.setSubject(dto.getSubject());
			entity.setYear(dto.getYear());
			entity.setDegree(Optional.ofNullable(dto.getDegree())
					.map(degreeConverter.reverse()::convert)
					.orElse(null));
			entity.setStudent(Optional.ofNullable(dto.getStudent())
					.map(studentConverter.reverse()::convert)
					.orElse(null));
			
			entity.setHeadWork(Optional.ofNullable(dto.getHeadWork())
					.map(headWorkConverter.reverse()::convert)
					.orElse(null));
			
			//TODO : implement with GoogleDrive
			entity.setFileName("fileName.doc");
			entity.setSelfHref("http://vk.com");
		}
		return entity;
	}

    @Override
    protected GraduateWorkDTO doForward(GraduateWork entity) {
	GraduateWorkDTO dto = new GraduateWorkDTO();
	dto.setUuid(entity.getUuid());
	dto.setSubject(entity.getSubject());
	dto.setSelfHref(entity.getSelfHref());
	dto.setFileName(entity.getFileName());
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
