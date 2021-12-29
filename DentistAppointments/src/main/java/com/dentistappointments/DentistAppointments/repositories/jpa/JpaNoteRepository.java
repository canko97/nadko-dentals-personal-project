package com.dentistappointments.DentistAppointments.repositories.jpa;

import com.dentistappointments.DentistAppointments.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaNoteRepository extends JpaRepository <Note, Integer> {


}
