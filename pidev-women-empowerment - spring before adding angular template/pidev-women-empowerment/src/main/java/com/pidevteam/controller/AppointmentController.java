package com.pidevteam.controller;

import com.pidevteam.entity.Appointment;
import com.pidevteam.service.AppointmentServiceImpl;
import com.pidevteam.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentServiceImpl appointmentService;
    @Autowired
    UserServiceImpl userService ;
    @PostMapping("/appointment")

    public Appointment addAppointment(@RequestBody Appointment appointment) {
        appointment.setUser(userService.findOne(SecurityContextHolder.getContext().getAuthentication().getName()));

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
