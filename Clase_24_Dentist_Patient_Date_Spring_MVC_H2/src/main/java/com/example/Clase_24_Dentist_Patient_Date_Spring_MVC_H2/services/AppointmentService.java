package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Appointment;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.Idao;

import java.util.List;

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
    public Appointment search(int id) {
       return appointmentDao.search(id);
    }

    @Override
    public Appointment update(int id, Appointment appointment) {
        return appointmentDao.update(id, appointment);
    }

    @Override
    public void delete(int id) {
        appointmentDao.delete(id);
    }


    @Override
    public List<Appointment> searchAll() {
        return appointmentDao.searchAll();
    }
}
