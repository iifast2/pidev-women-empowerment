package com.women.spring.controller;

import com.women.spring.model.Appointment;
import com.women.spring.model.Reclamation;
import com.women.spring.service.AppointmentServiceImpl;
import com.women.spring.service.ReclamationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentServiceImpl appointmentService;
    @PostMapping("/appointment")

    public Appointment addAppointment(@RequestBody Appointment appointment) {

        return appointmentService.addAppointment(appointment);
    }
    @GetMapping("/appointment")
    public List<Appointment> GetReclamations(){
        return appointmentService.GetAppointments();
    }

    @DeleteMapping("/appointment/{id}")
    public void deleteAppointment(@PathVariable("id") long id){
        appointmentService.deleteAppointment(id);

    }
    @PutMapping("/appointment")

    public Appointment updateAppointment(@RequestBody Appointment appointment) {

        return appointmentService.updateAppointment(appointment);
    }
    
   
	@GetMapping("/appointment/{title}")
	
	public List<Appointment> getAppointmentByTitle(@PathVariable("title")String title) {


		return appointmentService.findAppointmentBytitle(title);
	}
}
