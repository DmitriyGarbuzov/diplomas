package com.diplomas.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomas.repository.GraduateWorkRepository;
import com.diplomas.web.converter.GraduateWorkConverter;
import com.diplomas.web.dto.GraduateWorkDTO;

@Service
public class GraduateWorkService {
    
    @Autowired
    private GraduateWorkConverter graduateWorkConverter; 
    
    @Autowired
    private GraduateWorkRepository graduateWorkRepository;
    
    @Autowired
    private GoogleDriveService googleDriveService;

    public List<GraduateWorkDTO> getGraduateWorksByDegreePK(Long degreePk) {
	return graduateWorkRepository
		.findAllByDegreeId(degreePk)
		.stream()
		.map(graduateWorkConverter::convert)
		.collect(Collectors.toList());
    }
    
	public GraduateWorkDTO saveGraduateWork(GraduateWorkDTO dto) {
		return Optional.ofNullable(
				graduateWorkRepository.save(graduateWorkConverter.reverse().convert(dto))
				)
				.map(graduateWorkConverter::convert)
				.orElse(null);
	}
    
    public GraduateWorkDTO updateGraduateWork(GraduateWorkDTO dto) {
    	//TODO: implement update in Google Drive
    	return null;
    }
    
    public GraduateWorkDTO getGraduateWork(UUID uuid) {
    	return Optional.ofNullable(
    			graduateWorkRepository.findOneByUuid(uuid)
    			)
    			.map(graduateWorkConverter::convert)
    			.orElse(null);
    }
    
	public void deleteGraduateWork(UUID uuid) {
		//TODO: implement remove from Google Drive
		graduateWorkRepository.deleteByUuid(uuid);
	}
    
    public List<GraduateWorkDTO> searchGraduateWorks(String text) {
    	return googleDriveService.searchGraduateWorks(text)
    			.stream()
    			.map(graduateWorkConverter::convert)
    			.collect(Collectors.toList());
    }
}
