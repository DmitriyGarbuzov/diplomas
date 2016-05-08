package com.diplomas.service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import com.diplomas.web.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomas.entity.GraduateWork;
import com.diplomas.repository.GraduateWorkRepository;

@Service
public class GoogleDriveService {
    
    @Autowired
    private GraduateWorkRepository graduateWorkRepository;
    
    public String uploadGraduateWork(File file) {
    	return "";
    }
    
    public List<GraduateWork> searchGraduateWorks(String text){
	//TODO : implement with searching via google drive
	return null;
    }
    
    public void removeFile(String selfHref) {

    }

    private List<String> getAllGraduateWorksHrefs() {
    	return graduateWorkRepository
    	.findAll()
    	.stream()
    	.map(GraduateWork::getSelfHref)
    	.collect(Collectors.toList());
    }
}
