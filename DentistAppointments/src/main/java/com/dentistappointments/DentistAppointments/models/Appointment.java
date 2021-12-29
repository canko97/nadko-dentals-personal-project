package com.dentistappointments.DentistAppointments.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dentist_id")
    private int dentistId;
    @Column(name = "patient_id")
    private int patientId;
    @Temporal(TemporalType.TIMESTAMP) //TIMESTAMP == date + time
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name = "appointment_date")
    private Date appointmentDate;

    public Appointment() {
    }

    public Appointment(int id, int dentistId, int patientId, Date appointmentDate) {
        this.id = id;
        this.dentistId = dentistId;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDentistId() {
        return dentistId;
    }

    public void setDentistId(int dentistId) {
        this.dentistId = dentistId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}


