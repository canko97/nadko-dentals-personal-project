package com.dentistappointments.DentistAppointments.repositories.jpa;

import com.dentistappointments.DentistAppointments.models.Appointment;
import com.dentistappointments.DentistAppointments.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAppointmentRepository extends JpaRepository<Appointment, Integer> {
}
