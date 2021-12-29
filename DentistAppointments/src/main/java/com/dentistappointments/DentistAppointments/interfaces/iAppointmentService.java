package com.dentistappointments.DentistAppointments.interfaces;

import com.dentistappointments.DentistAppointments.models.Appointment;

import java.util.List;
import java.util.Map;

public interface iAppointmentService {

    List<Appointment> getAllAppointments ();

    List<Appointment> getAllDentistAppointments(int dentistId);

    Appointment createNewAppointment (Appointment appointment);

    Appointment getAppointmentById (int id);

    Appointment updateAppointment (int id, Appointment appointmentToUpdate);

    Map<String, Boolean> deleteAppointment(int id);

}
