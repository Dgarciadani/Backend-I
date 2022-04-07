package com.grego.Final_Project_Refactor_clase24.services;

import com.grego.Final_Project_Refactor_clase24.domain.Appointment;
import com.grego.Final_Project_Refactor_clase24.dto.AppointmentDTO;

import java.util.List;

public interface IAppointmentService {
    public AppointmentDTO getAppointment(Integer id);
    public Appointment saveAppointment(Appointment appointment);
    public void deleteAppointment(Integer id);
    public List<AppointmentDTO> getAllAppointments();

}
