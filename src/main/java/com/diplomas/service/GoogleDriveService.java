package com.diplomas.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.diplomas.service.cloud.GoogleDriveAPIHelper;
import com.diplomas.util.FileHelper;
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

    public String uploadGraduateWork(MultipartFile file) {
        return GoogleDriveAPIHelper.uploadFile(FileHelper.writeToFile(file), file.getContentType(), "");
    }

    public List<String> searchGraduateWorks(String text) {
        return GoogleDriveAPIHelper.searchFiles(text);
    }

    public void removeGraduateWork(String selfHref) {

    }
}
