package com.dentistappointments.DentistAppointments.services;

import com.dentistappointments.DentistAppointments.exception.ResourceNotFoundException;
import com.dentistappointments.DentistAppointments.interfaces.iNoteService;
import com.dentistappointments.DentistAppointments.models.Note;
import com.dentistappointments.DentistAppointments.repositories.NoteRepository;
import com.dentistappointments.DentistAppointments.repositories.jpa.JpaNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService implements iNoteService {

    NoteRepository noteRepository;
    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotesAboutAPatient(int patientId){
        List<Note> allNotes = noteRepository.findAll();
        List<Note> filteredNotes = new ArrayList<>();
        allNotes.forEach(note -> {
            if(note.getPatientId() == patientId){
                filteredNotes.add(note);
            }
        });
        return filteredNotes;
    }

    public Note createNewNote(Note note){

        return noteRepository.save(note);
    }

    public Note getNoteById( int id){
        Note note = noteRepository.findById(id);

        return note;
    }

    public Note updateNote(int id, Note noteToUpdate){
        Note note = noteRepository.findById(id);

        note.setDentistId(noteToUpdate.getDentistId());
        note.setPatientId(noteToUpdate.getPatientId());
        note.setNoteDate(noteToUpdate.getNoteDate());
        note.setContent(noteToUpdate.getContent());

        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }

    public Map<String, Boolean> deleteNote(int id){
        Note note = noteRepository.findById(id);

        noteRepository.deleteById(note.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
