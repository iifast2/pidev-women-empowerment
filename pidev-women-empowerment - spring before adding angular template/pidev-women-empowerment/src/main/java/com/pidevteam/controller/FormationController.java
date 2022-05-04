package com.pidevteam.controller;

import com.pidevteam.entity.File;
import com.pidevteam.entity.Formation;
import com.pidevteam.payload.Response;
import com.pidevteam.service.DatabaseFileService;
import com.pidevteam.service.FormationService;
import com.pidevteam.service.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/formation")
public class FormationController implements ICrudRepository<Formation> {
    @Autowired
    FormationService formationService ;
    @Autowired
    private DatabaseFileService fileStorageService;

    @PostMapping("/save")
    public Formation save(@RequestBody Formation formation) {
        return formationService.save(formation);
    }

    @PostMapping("/uploadFile/{id}")
    public Response uploadFile(@RequestParam("file") MultipartFile file,@PathVariable("id") Long id) {
        File fileName = fileStorageService.storeFile(file,id);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName.getFileName())
                .toUriString();
        return new Response(fileName.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());

    }

    @PutMapping
    public Formation update(@RequestBody Formation formation) {
        return formationService.update(formation);
    }

   @GetMapping("/{id}")
    public Formation findById(@PathVariable("id") Long id) {
        return formationService.findById(id);
    }

  @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
      formationService.delete(id);
    }

   @GetMapping()
    public List<Formation> findAll() {
        return formationService.findAll();
    }
}
