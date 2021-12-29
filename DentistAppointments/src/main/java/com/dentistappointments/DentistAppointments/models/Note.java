package com.dentistappointments.DentistAppointments.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dentist_id")
    private int dentistId;
    @Column(name = "patient_id")
    private int patientId;
    @Temporal(TemporalType.TIMESTAMP) //TIMESTAMP == date + time
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name = "note_date")
    private Date noteDate;
    @Column(name = "content")
    private String content;

    public Note() {
    }

    public Note(int id, int dentistId, int patientId, Date noteDate, String content) {
        this.id = id;
        this.dentistId = dentistId;
        this.patientId = patientId;
        this.noteDate = noteDate;
        this.content = content;
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

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
