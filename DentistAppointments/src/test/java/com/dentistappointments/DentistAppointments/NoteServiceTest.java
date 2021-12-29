package com.dentistappointments.DentistAppointments;

import com.dentistappointments.DentistAppointments.models.Note;
import com.dentistappointments.DentistAppointments.repositories.NoteRepository;
import com.dentistappointments.DentistAppointments.repositories.fake.FakeNoteRepository;
import com.dentistappointments.DentistAppointments.services.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class NoteServiceTest {

    @MockBean
    NoteService noteService;

    @InjectMocks
    NoteRepository noteRepository;

    Date date = new Date(2021, 06,06);

    @BeforeEach
    public void InitializeRepository(){
        this.noteRepository = Mockito.mock(NoteRepository.class);
        this.noteService = new NoteService(noteRepository);
    }

    @Test
    void TestGetAllNotes(){
        Note note1 = new Note(1,1,1, date, "content");
        Note note2 = new Note(2,1,1, date, "content");
        Note note3 = new Note(2,1,2, date, "content");
        List<Note> notes = new ArrayList<>();
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        Mockito.when(noteRepository.findAll()).thenReturn(notes);

        assertEquals(2,noteService.getAllNotesAboutAPatient(1).size());
    }

    @Test
    void TestGetNoteById(){
        Note expectedNote = new Note(1,1,1, date, "content");
        Mockito.when(noteRepository.findById(1)).thenReturn(expectedNote);

        assertEquals(expectedNote, noteService.getNoteById(1));
    }

    @Test
    void TestCreateNote(){
        Note newNote = new Note(1,1,1, date, "content");
        Mockito.when(noteRepository.findById(1)).thenReturn(newNote);
        noteService.createNewNote(newNote);

        verify(noteRepository, times(1)).save(newNote);
    }

    @Test
    void TestUpdateNote(){
        Note noteToUpdate = new Note(1,2,1,date,"content");
        Mockito.when(noteRepository.findById(1)).thenReturn(noteToUpdate);
        Mockito.when(noteRepository.save(noteToUpdate)).thenReturn(noteToUpdate);

        noteService.updateNote(1,noteToUpdate);

        assertEquals(noteToUpdate, noteService.updateNote(1,noteToUpdate));
    }

    @Test
    void TestDeleteAppointment(){
        Note noteToDelete = new Note(1,2,1,date,"content");
        int id = noteToDelete.getId();
        Mockito.when(noteRepository.findById(1)).thenReturn(noteToDelete);

        noteService.deleteNote(id);

        verify(noteRepository, times(1)).deleteById(id);
    }
}
