package com.grego.Final_Project_Refactor_clase24.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grego.Final_Project_Refactor_clase24.domain.Appointment;
import com.grego.Final_Project_Refactor_clase24.dto.AppointmentDTO;
import com.grego.Final_Project_Refactor_clase24.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public AppointmentDTO getAppointment(Integer id) {
        AppointmentDTO appointmentDTO = null;
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment != null) {
            appointmentDTO = objectMapper.convertValue(appointment, AppointmentDTO.class);
        }
        return appointmentDTO;
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public void deleteAppointment(Integer id) {

    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return null;
    }
}
