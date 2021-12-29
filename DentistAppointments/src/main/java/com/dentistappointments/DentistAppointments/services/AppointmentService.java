package com.dentistappointments.DentistAppointments.services;

import com.dentistappointments.DentistAppointments.interfaces.iAppointmentService;
import com.dentistappointments.DentistAppointments.models.Appointment;
import com.dentistappointments.DentistAppointments.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentService implements iAppointmentService {

    AppointmentRepository appointmentRepository;
    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments(){

        return appointmentRepository.findAll();
    }

    public List<Appointment> getAllDentistAppointments(int dentistId) {
        List<Appointment> allAppointments = getAllAppointments();
        List<Appointment> allDentistAppointments = new ArrayList<>();
        allAppointments.forEach(appointment -> {
            if(appointment.getDentistId() == dentistId){
                allDentistAppointments.add(appointment);
            }
        });
        return allDentistAppointments;
    }

    public Appointment createNewAppointment(Appointment appointment){

        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointmentById( int id){
        Appointment appointment = appointmentRepository.findById(id);

        return appointment;
    }

    public Appointment updateAppointment(int id, Appointment appointmentToUpdate){
        Appointment appointment = appointmentRepository.findById(id);

        appointment.setDentistId(appointmentToUpdate.getDentistId());
        appointment.setPatientId(appointmentToUpdate.getPatientId());
        appointment.setAppointmentDate(appointmentToUpdate.getAppointmentDate());

        Appointment updatedAppointment = appointmentRepository.save(appointment);
        return updatedAppointment;
    }

    public Map<String, Boolean> deleteAppointment( int id){
        Appointment appointment = appointmentRepository.findById(id);

        appointmentRepository.deleteById(appointment.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
