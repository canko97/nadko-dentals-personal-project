package com.dentistappointments.DentistAppointments.repositories;

import com.dentistappointments.DentistAppointments.models.Note;

import java.util.List;

public interface NoteRepository {

    List<Note> findAll();

    Note findById(int id);

    Note save(Note note);

    void deleteById (int id);
}
