package com.pidevteam.service;


import com.pidevteam.exception.FileStorageException;
import com.pidevteam.entity.File;
import com.pidevteam.entity.Formation;
import com.pidevteam.exception.MyFileNotFoundException;
import com.pidevteam.repository.DatabaseFileRepository;
import com.pidevteam.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DatabaseFileService {
    @Autowired
    private DatabaseFileRepository dbFileRepository;
    @Autowired
    FormationRepository formationRepository;

    public File storeFile(MultipartFile file ,Long id) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
       Formation formation = formationRepository.findById(id).orElse(null);


        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            File dbFile = new File(fileName, file.getContentType(), file.getBytes());
            dbFile.setFormation(formation);
            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public File getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }

    public File findById(String id) {
        return dbFileRepository.findById(id).get() ;
    }

    public File save(File file) {   return dbFileRepository.save(file) ;

    }

}