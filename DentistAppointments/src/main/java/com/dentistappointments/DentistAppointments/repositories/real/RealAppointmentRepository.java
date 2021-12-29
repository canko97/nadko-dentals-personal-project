package com.dentistappointments.DentistAppointments.repositories.real;

import com.dentistappointments.DentistAppointments.models.Appointment;
import com.dentistappointments.DentistAppointments.repositories.AppointmentRepository;
import com.dentistappointments.DentistAppointments.repositories.jpa.JpaAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RealAppointmentRepository  implements AppointmentRepository {

    @Autowired
    JpaAppointmentRepository jpaAppointmentRepository;

    @Override
    public List<Appointment> findAll() {
        return  jpaAppointmentRepository.findAll();
    }

    @Override
    public Appointment findById(int id) {
        return jpaAppointmentRepository.findById(id).get();
    }

    @Override
    public Appointment save(Appointment appointment){
        return jpaAppointmentRepository.save(appointment);
    }

    @Override
    public void deleteById(int id){

        jpaAppointmentRepository.deleteById(id);
    }
}
