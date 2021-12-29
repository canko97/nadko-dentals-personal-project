package com.dentistappointments.DentistAppointments.repositories;

import com.dentistappointments.DentistAppointments.models.Appointment;

import java.util.List;

public interface AppointmentRepository {

    List<Appointment> findAll();

    Appointment findById(int id);

    Appointment save(Appointment appointment);

    void deleteById(int id);
}
