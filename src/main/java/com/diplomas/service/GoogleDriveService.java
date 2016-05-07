package com.diplomas.service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

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
    
    public List<GraduateWork> searchGraduateWorks(String searchText){
	//TODO : implement with searching via google drive
	return null;
    }
    
//    private List<Immutable<String,String> getAlld(){
//    	return null;
//    }
    
    private List<String> getAllGraduateWorksHrefs() {
    	return graduateWorkRepository
    	.findAll()
    	.stream()
    	.map(GraduateWork::getSelfHref)
    	.collect(Collectors.toList());
    }
}
