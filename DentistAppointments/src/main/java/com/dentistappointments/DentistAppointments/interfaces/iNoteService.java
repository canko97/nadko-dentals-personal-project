package com.dentistappointments.DentistAppointments.interfaces;

import com.dentistappointments.DentistAppointments.models.Note;

import java.util.List;
import java.util.Map;

public interface iNoteService {

    List<Note> getAllNotesAboutAPatient(int patientId);

    Note createNewNote (Note note);

    Note getNoteById ( int id );

    Note updateNote (int id, Note noteToUpdate);

    Map<String, Boolean> deleteNote(int id);
}
