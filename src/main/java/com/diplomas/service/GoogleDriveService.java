package com.diplomas.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomas.entity.GraduateWork;
import com.diplomas.repository.GraduateWorkRepository;
import org.springframework.web.multipart.MultipartFile;

import static com.diplomas.service.cloud.GoogleDriveConnector.getClient;

@Service
public class GoogleDriveService {

    private static final Logger logger = LoggerFactory
            .getLogger(GoogleDriveService.class);

    @Autowired
    private GraduateWorkRepository graduateWorkRepository;


    public String uploadGraduateWork(MultipartFile file) {
        File body = new File();
        body.setName(file.getOriginalFilename());
        body.setMimeType(file.getContentType());
        body.setOriginalFilename(file.getOriginalFilename());
        body.setShared(true);
        body.setSize(file.getSize());
        body.setViewersCanCopyContent(true);
        Drive client = getClient();
        java.io.File tmpFile = new java.io.File(file.getOriginalFilename());
        try {
            file.transferTo(tmpFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileContent content = new FileContent(file.getContentType(),tmpFile);
        try {
            body = client
                    .files()
                    .create(body,content)
                    .execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return body.getWebViewLink();
    }

    public List<GraduateWork> searchGraduateWorks(String text) {

        return Collections.EMPTY_LIST;
    }

    public void removeGraduateWork(String fileName) {
    }

    private List<String> getAllGraduateWorksFileNames() {
        return graduateWorkRepository
                .findAll()
                .stream()
                .map(GraduateWork::getSelfHref)
                .collect(Collectors.toList());
    }

}
