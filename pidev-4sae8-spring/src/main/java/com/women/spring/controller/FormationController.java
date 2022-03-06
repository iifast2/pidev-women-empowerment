package com.women.spring.controller;

import com.women.spring.model.File;
import com.women.spring.model.Formation;
import com.women.spring.payload.Response;
import com.women.spring.service.DatabaseFileService;
import com.women.spring.service.FormationService;
import com.women.spring.service.ICrudRepository;
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

    @PutMapping("/uploadFile/{id}")
    public File uploadFile(@RequestParam("file") MultipartFile file,@PathVariable("id") Long id) {
        File fileName = fileStorageService.storeFile(file);
    fileName.getFormation().setId(id);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName.getFileName())
                .toUriString();

        return fileName;
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
