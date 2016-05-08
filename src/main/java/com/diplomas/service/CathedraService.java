package com.diplomas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomas.repository.CathedraRepository;
import com.diplomas.web.converter.CathedraConverter;
import com.diplomas.web.dto.CathedraDTO;

@Service
public class CathedraService {

	@Autowired
	private CathedraRepository cathedraRepository;

	@Autowired
	private CathedraConverter cathedraConverter;

	public List<CathedraDTO> getAllCathedras() {
		return cathedraRepository
				.findAll()
				.stream()
				.map(cathedraConverter::convert)
				.collect(Collectors.toList());
	}
}
