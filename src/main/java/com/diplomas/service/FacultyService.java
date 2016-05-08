package com.diplomas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomas.repository.FacultyRepository;
import com.diplomas.web.converter.FacultyConverter;
import com.diplomas.web.dto.FacultyDTO;

@Service
public class FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private FacultyConverter facultyConverter;
	
	public List<FacultyDTO> getAllFaculties() {
		return facultyRepository
				.findAll()
				.stream()
				.map(facultyConverter::convert)
				.collect(Collectors.toList()); 
	}
}
