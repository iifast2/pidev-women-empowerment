package com.pidevteam.service;

import com.pidevteam.entity.Appointment;

import java.util.List;

public interface IAppointmentService {
    public void addAppointment (Appointment appointment);
    public void deleteAppointment(Long id);
    public void updateAppointment(Appointment appointment);
    public List<Appointment> findAppointmentByTitle(String title);
}
