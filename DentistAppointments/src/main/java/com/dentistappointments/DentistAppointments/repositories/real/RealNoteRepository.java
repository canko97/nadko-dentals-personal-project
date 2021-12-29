package com.dentistappointments.DentistAppointments.repositories.real;

import com.dentistappointments.DentistAppointments.models.Note;
import com.dentistappointments.DentistAppointments.repositories.NoteRepository;
import com.dentistappointments.DentistAppointments.repositories.jpa.JpaNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RealNoteRepository implements NoteRepository {

    @Autowired
    JpaNoteRepository jpaNoteRepository;

    @Override
    public List<Note> findAll() {
        return jpaNoteRepository.findAll();
    }

    @Override
    public Note findById(int id) {
        return jpaNoteRepository.findById(id).get();
    }

    @Override
    public Note save(Note note) {
        return jpaNoteRepository.save(note);
    }

    @Override
    public void deleteById(int id) {
        jpaNoteRepository.deleteById(id);
    }
}
