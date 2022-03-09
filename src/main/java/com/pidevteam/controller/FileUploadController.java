package com.pidevteam.controller;

import com.pidevteam.entity.File;
import com.pidevteam.service.DatabaseFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private DatabaseFileService fileStorageService;

   /* @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
        File fileName = fileStorageService.storeFile(file,id);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName.getFileName())
                .toUriString();

        return new Response(fileName.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }*/



    @GetMapping("/{id}")
    public File findById(@PathVariable("id") String id) {
        return fileStorageService.findById(id);
    }

}
