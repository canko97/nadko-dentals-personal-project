package com.dentistappointments.DentistAppointments.interfaces;

import com.dentistappointments.DentistAppointments.models.Patient;

import java.util.List;

public interface iPatientService {

    List<Patient> getAllPatients();

    Patient createPatient(Patient patient);

    List<Patient> getDentistPatients(int dentistId);

    Patient getPatientById(int id);

    Patient updatePatient(int id, Patient patientToUpdate);

    void deletePatient ( int id );
}
