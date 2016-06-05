package com.diplomas.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.diplomas.entity.GraduateWork;
import com.diplomas.repository.HeadWorkRepository;
import com.diplomas.repository.StudentGroupRepository;
import com.diplomas.repository.StudentRepository;
import com.diplomas.web.dto.SearchDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomas.repository.GraduateWorkRepository;
import com.diplomas.web.converter.GraduateWorkConverter;
import com.diplomas.web.dto.GraduateWorkDTO;

@Service
public class GraduateWorkService {

	private static final Logger logger = LoggerFactory
			.getLogger(GraduateWorkService.class);

    @Autowired
    private GraduateWorkConverter graduateWorkConverter; 
    
    @Autowired
    private GraduateWorkRepository graduateWorkRepository;
    
    @Autowired
    private GoogleDriveService googleDriveService;

	@Autowired
	private HeadWorkRepository headWorkRepository;

	@Autowired
	private StudentGroupRepository studentGroupRepository;

	@Autowired
	private StudentRepository studentRepository;
    
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

    public GraduateWorkDTO getGraduateWork(UUID uuid) {
    	return Optional.ofNullable(
    			graduateWorkRepository.findOneByUuid(uuid)
    			)
    			.map(graduateWorkConverter::convert)
    			.orElse(null);
    }
    
	public GraduateWorkDTO deleteGraduateWork(UUID uuid) {
		GraduateWork entity = graduateWorkRepository.findOneByUuid(uuid);
		GraduateWorkDTO dto = Optional.ofNullable(entity)
				.map(graduateWorkConverter::convert)
				.orElse(null);
		googleDriveService.removeGraduateWork(entity.getFileName());
		if(entity != null) {
			try {
				studentRepository.delete(entity.getStudent());
				studentGroupRepository.delete(entity.getGroup());
				headWorkRepository.delete(entity.getHeadWork());
			} catch (Exception e) {
				logger.error("An error has been occured ",e);
			}
		}
		graduateWorkRepository.deleteByUuid(uuid);
		return dto;
	}

}
