package com.dentistappointments.DentistAppointments.repositories.fake;

import com.dentistappointments.DentistAppointments.models.Note;
import com.dentistappointments.DentistAppointments.repositories.NoteRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FakeNoteRepository implements NoteRepository {

    private List<Note> notes = new ArrayList<>();

    Date date = new Date(2021, 06,06);

    public FakeNoteRepository() {
        notes.add(new Note(1,1,1, date, "content"));
        notes.add(new Note(2,1,1, date, "content"));
        notes.add(new Note(3,1,1, date, "content"));
        notes.add(new Note(4,1,1, date, "content"));
        notes.add(new Note(5,1,1, date, "content"));
        notes.add(new Note(6,1,1, date, "content"));
        notes.add(new Note(7,1,1, date, "content"));
    }

    @Override
    public List<Note> findAll() {
        return notes;
    }

    @Override
    public Note findById(int id) {
        for(Note note: notes){
            if(note.getId() == id){
                return note;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Note save(Note note) {
        notes.add(note);
        return note;
    }

    @Override
    public void deleteById(int id) {
        notes.remove(id);
    }
}
