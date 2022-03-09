package com.pidevteam.controller;

import com.pidevteam.entity.Events;
import com.pidevteam.service.EventsServiceInt;
import com.pidevteam.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
public class EventsController {
    @Autowired
    private EventsServiceInt service;
     @Autowired
    FileStorageService fileStorageService ;
    @PostMapping("/Events")

    public ResponseEntity<String> saveEvnets(@RequestParam ("nom") String nom, @RequestParam ("description") String desc,

    @RequestParam ("dateDeb") Date dateDeb, @RequestParam ("dateFin") Date dateFin,

    @RequestParam ("location") String location , @RequestParam ("tarif") float tarif ,@RequestParam ("nbPlace") int  nbP,@RequestParam("upload")
    MultipartFile upload)
    {
        Events events = new Events() ;
        events.setNom(nom);
        events.setDescription(desc);
        events.setDateD(dateDeb);
        events.setDateF(dateFin);
        events.setLocalisation(location);
        events.setTarif(tarif);
        events.setNbreDePlaces(nbP);
        events.setImage(fileStorageService.storeFile(upload));

        Integer id = service.saveEvents(events);
        return new ResponseEntity<String>("events with "+id+"has been saved", HttpStatus.OK);
    }

    @GetMapping("/EventList")
    public ResponseEntity<List<Events>> getAllEventsdetails()
    {
        List<Events> list=service.getAllEvents();
        return new ResponseEntity<List<Events>>(list,HttpStatus.OK);
    }

    @GetMapping("/getEvnetsbyid/{id}")
    public ResponseEntity<Events> getEventsById(@PathVariable("id") Integer id)
    {
        Events ev= service.getEventsById(id);
        return new ResponseEntity<Events>(ev,HttpStatus.OK);

    }
    @PutMapping ("/updateEvnets/{idE}")
   public Events UpdateEvents(@RequestBody Events E , @PathVariable Integer idE){
        return service.UpdateEvent(E, idE);
    }
    /*
 public ResponseEntity<String>updateevnets(@PathVariable("id") Integer id, @RequestBody Events events)
 {
     Events evFromDb= service.getEventsById(id);
     evFromDb.setNom(events.getNom());
     evFromDb.setDescription(events.getDescription());
     evFromDb.setImage(events.getImage());
     evFromDb.setDateD(events.getDateD());
     evFromDb.setDateF(events.getDateF());
     evFromDb.setLocalisation(events.getLocalisation());
     evFromDb.setMap(events.getMap());
     evFromDb.setTarif(events.getTarif());
     evFromDb.setNbreDePlaces(events.getNbreDePlaces());
     evFromDb.setEtat(events.getEtat());
     evFromDb.setType(events.getType());
     return new ResponseEntity<String>("Events with"+id+"has been updated",HttpStatus.OK);

 }
 */

 @DeleteMapping("deleteevent/{id}")
 public ResponseEntity<String> deleteEvents(@PathVariable("id") Integer id)
 {
     service.deleteEvent(id);
     return  new ResponseEntity<String>("event with"+id+"has deleted",HttpStatus.OK);
 }



    @GetMapping("/events/{nom}")

    public List<Events> getByNom(@PathVariable("nom")String nom) {


        return service.findByNom(nom);
    }

}
