package com.diplomas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomas.repository.DegreeRepository;
import com.diplomas.web.converter.DegreeConverter;
import com.diplomas.web.dto.DegreeDTO;

@Service
public class DegreeService {

	@Autowired
	private DegreeRepository degreeRepository;
	
	@Autowired
	private DegreeConverter degreeConverter;
	
	public List<DegreeDTO> getAllDegrees() {
		return degreeRepository
				.findAll()
				.stream()
				.map(degreeConverter::convert)
				.collect(Collectors.toList()); 
	}
}
