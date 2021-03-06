package com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services;

import com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Appointment;
import com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.Idao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements Idao<Appointment> {

    private Idao<Appointment> appointmentDao;

    public Idao<Appointment> getAppointmentDao() {
        return appointmentDao;
    }

    public void setAppointmentDao(Idao<Appointment> appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public AppointmentService(Idao<Appointment> appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @Override
    public Appointment register(Appointment appointment) {
       return appointmentDao.register(appointment);
    }

    @Override
    public Appointment search(Integer id) {
       return appointmentDao.search(id);
    }

    @Override
    public Appointment update(Integer id, Appointment appointment) {
        return appointmentDao.update(id, appointment);
    }

    @Override
    public void delete(Integer id) {
        appointmentDao.delete(id);
    }


    @Override
    public List<Appointment> searchAll() {
        return appointmentDao.searchAll();
    }
}
