package com.pidevteam.service;

import com.pidevteam.entity.Appointment;
import com.pidevteam.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl {
    @Autowired
    AppointmentRepo appointmentRepo;



    public Appointment addAppointment(Appointment appointment) {

        return appointmentRepo.save(appointment);

    }
    public List<Appointment> GetAppointments(){
        return appointmentRepo.findAll();
    }
    public void deleteAppointment(Long id){
        appointmentRepo.deleteById(id);
    }
    public Appointment updateAppointment(Appointment appointment){
        return appointmentRepo.save(appointment);
    }
	public List<Appointment> findAppointmentBytitle(String title) {
		return appointmentRepo.findAppointmentByTitle(title);
		
		
	}
	


}
