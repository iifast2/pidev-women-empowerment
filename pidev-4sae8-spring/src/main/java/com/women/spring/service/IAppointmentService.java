package com.women.spring.service;

import com.women.spring.model.Appointment;
import com.women.spring.model.Reclamation;

import java.util.List;

public interface IAppointmentService {
    public void addAppointment (Appointment appointment);
    public void deleteAppointment(Long id);
    public void updateAppointment(Appointment appointment);
    public List<Appointment> findAppointmentByTitle(String title);
}
