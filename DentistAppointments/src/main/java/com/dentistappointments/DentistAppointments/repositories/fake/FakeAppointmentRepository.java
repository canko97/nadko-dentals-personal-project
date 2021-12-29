package com.dentistappointments.DentistAppointments.repositories.fake;

import com.dentistappointments.DentistAppointments.models.Appointment;
import com.dentistappointments.DentistAppointments.repositories.AppointmentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FakeAppointmentRepository implements AppointmentRepository {

    private List<Appointment> appointments = new ArrayList<>();

    Date date = new Date(2021, 06,06);

    public FakeAppointmentRepository() {

        appointments.add(new Appointment(1, 1, 1, date));
        appointments.add(new Appointment(2, 1, 1, date));
        appointments.add(new Appointment(3, 1, 1, date));
        appointments.add(new Appointment(4, 1, 1, date));
        appointments.add(new Appointment(5, 1, 1, date));
        appointments.add(new Appointment(6, 1, 1, date));
        appointments.add(new Appointment(7, 1, 1, date));
    }

    @Override
    public List<Appointment> findAll() {
        return appointments;
    }

    @Override
    public Appointment findById(int id) {
        for(Appointment appointment: appointments){
            if(appointment.getId() == id){
                return appointment;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Appointment save(Appointment appointment) {
        appointments.add(appointment);
        return appointment;
    }

    @Override
    public void deleteById(int id) {
        appointments.remove(id);
    }
}
