package com.diplomas.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diplomas.entity.HeadWork;
import com.diplomas.repository.HeadWorkRepository;
import com.diplomas.web.dto.HeadWorkDTO;
import com.google.common.base.Converter;

@Component
public class HeadWorkConverter extends Converter<HeadWork, HeadWorkDTO> {

	@Autowired
	private HeadWorkRepository headWorkRepository;

	@Override
	protected HeadWork doBackward(HeadWorkDTO dto) {
		HeadWork entity = null;
		if (dto.getUuid() != null) {
			entity = headWorkRepository.findOneByUuid(dto.getUuid()).orElse(null);
		} else {
			entity = new HeadWork();
			entity.setFirstName(dto.getFirstName());
			entity.setSurname(dto.getSurname());
			entity.setPatronymic(dto.getPatronymic());
			headWorkRepository.save(entity);
		}
		return entity;
	}

	@Override
	protected HeadWorkDTO doForward(HeadWork entity) {
		HeadWorkDTO dto = new HeadWorkDTO();
		dto.setUuid(entity.getUuid());
		dto.setFirstName(entity.getFirstName());
		dto.setSurname(entity.getSurname());
		dto.setPatronymic(entity.getPatronymic());
		return dto;
	}

}
