package com.women.spring.controller;

import com.women.spring.model.File;
import com.women.spring.model.Formation;
import com.women.spring.payload.Response;
import com.women.spring.service.DatabaseFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private DatabaseFileService fileStorageService;

    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
        File fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName.getFileName())
                .toUriString();

        return new Response(fileName.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }



    @GetMapping("/{id}")
    public File findById(@PathVariable("id") String id) {
        return fileStorageService.findById(id);
    }

}
