package com.diplomas.service;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.dropbox.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomas.entity.GraduateWork;
import com.diplomas.repository.GraduateWorkRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DropBoxService {

    private static final Logger logger = LoggerFactory
            .getLogger(DropBoxService.class);

    @Autowired
    private GraduateWorkRepository graduateWorkRepository;

    //TODO:[Buzov] Maybe move to file recources
    private static final String access_token = "nqHMfD0M2tAAAAAAAAAAB4AGJ4xLj1qrXGWespuoTtDMIF7YQYXEFGHm39dIeXKl";

    private DbxClient client;

    public String uploadGraduateWork(MultipartFile file) {
        DbxClient client = getClient();
        String filePath = "/" + file.getOriginalFilename();
        try {
            client.uploadFile(filePath,
                    DbxWriteMode.add(), file.getSize(), file.getInputStream());
            logger.debug("Successful upload file to dropbox '{}' ", filePath);
        } catch (Exception e) {
            logger.error("Can't upload file to dropbox '{}' , exception '{}'", filePath, e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
        String href = null;
        try {
            href = client.createShareableUrl("/" + file.getOriginalFilename());
            logger.debug("Successful get shared link to file '{}', href '{}' ", filePath, href);
        } catch (DbxException e) {
            logger.error("Can't upload file to dropbox '{}' , exception '{}'", filePath, e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
        return href;
    }

    public List<GraduateWork> searchGraduateWorks(String text) {
        //List<String> fileNames = getAllGraduateWorksFileNames();
        DbxClient client = getClient();
        try {
            client.searchFileAndFolderNames("/",text);
        } catch (DbxException e) {
            logger.error("Can't search inside dropbox  files , exception '{}'", e.getLocalizedMessage());
            throw new RuntimeException(e);
        }

        return Collections.EMPTY_LIST;
    }

    public void removeGraduateWork(String fileName) {
        String filePath = "/" + fileName;
        DbxClient client = getClient();
        try {
            client.delete(filePath);
            logger.debug("Successful remove file from dropbox '{}' ", filePath);
        } catch (DbxException e) {
            logger.error("Can't remove file from dropbox '{}' , exception '{}'", filePath, e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }

    private List<String> getAllGraduateWorksFileNames() {
        return graduateWorkRepository
                .findAll()
                .stream()
                .map(GraduateWork::getSelfHref)
                .collect(Collectors.toList());
    }


    //Native support functions
    private DbxClient getClient() {
        if (client == null) {
            client = getDropBoxClient();
        }
        return client;
    }

    private DbxClient getDropBoxClient() {
        DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0", Locale.getDefault().toString());
        DbxClient client = new DbxClient(config, access_token);
        try {
            logger.debug("Linked account of drop box : " + client.getAccountInfo().displayName);
        } catch (DbxException e) {
            logger.error("Check connection to dropbox '{}'  fail, exception '{}'", access_token, e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
        return client;
    }
}
