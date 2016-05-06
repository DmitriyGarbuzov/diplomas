package com.diplomas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomas.entity.GraduateWork;
import com.diplomas.repository.GraduateWorkRepository;

@Service
public class GoogleDriveService {
    
    @Autowired
    private GraduateWorkRepository graduateWorkRepository;

    public List<GraduateWork> searchGraduateWorks(String searchText){
	//TODO : implement with searching via google drive
	return null;
    }
}
