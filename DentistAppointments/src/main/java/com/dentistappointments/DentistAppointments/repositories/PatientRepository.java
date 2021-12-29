package com.dentistappointments.DentistAppointments.repositories;

import com.dentistappointments.DentistAppointments.models.Patient;

import java.util.List;

public interface PatientRepository {
    List<Patient> findAll();

    Patient findById(int id);

    Patient save(Patient patient);

    void deleteById(int id);
}
