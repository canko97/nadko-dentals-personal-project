package com.dentistappointments.DentistAppointments.repositories.jpa;

import com.dentistappointments.DentistAppointments.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPatientRepository extends JpaRepository<Patient, Integer> {
}
