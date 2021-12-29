package com.dentistappointments.DentistAppointments.repositories.real;

import com.dentistappointments.DentistAppointments.models.Patient;
import com.dentistappointments.DentistAppointments.repositories.PatientRepository;
import com.dentistappointments.DentistAppointments.repositories.jpa.JpaPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RealPatientRepository implements PatientRepository {

    @Autowired
    JpaPatientRepository jpaPatientRepository;

    @Override
    public List<Patient> findAll() {
        return jpaPatientRepository.findAll();
    }

    @Override
    public Patient findById(int id) {
        return jpaPatientRepository.findById(id).get();
    }

    @Override
    public Patient save(Patient patient) {
        return jpaPatientRepository.save(patient);
    }

    @Override
    public void deleteById(int id) {
        jpaPatientRepository.deleteById(id);
    }
}
