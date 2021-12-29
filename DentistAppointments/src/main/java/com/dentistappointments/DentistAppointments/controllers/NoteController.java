package com.dentistappointments.DentistAppointments.controllers;

import com.dentistappointments.DentistAppointments.interfaces.iNoteService;
import com.dentistappointments.DentistAppointments.models.Note;
import com.dentistappointments.DentistAppointments.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class NoteController {

    private iNoteService noteService;
    @Autowired
    public NoteController(iNoteService noteService) {
        this.noteService = noteService;
    }

    //create new note
    @PostMapping("/notes")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public Note createNewNote(@RequestBody Note note){
        return noteService.createNewNote(note);
    }

    //get all notes
    @GetMapping("/notes/{patientId}")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public List<Note> getAllNotes( @PathVariable int patientId){
        return noteService.getAllNotesAboutAPatient(patientId);
    }

    //get note by id
    @GetMapping("/notes/single/{id}")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public ResponseEntity<Note> getNoteById(@PathVariable int id){
        Note note = noteService.getNoteById(id);

        return ResponseEntity.ok(note);
    }

    //update note
    @PutMapping ("/notes/single/{id}")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public ResponseEntity<Note> updateNote(@PathVariable("id") int id, @RequestBody Note noteToUpdate){

        Note updatedNote = noteService.updateNote(id,noteToUpdate);
        return ResponseEntity.ok(updatedNote);
    }

    //delete appointment
    @DeleteMapping("/notes/single/{id}")
    @PreAuthorize("hasRole('DENTIST')")
    public ResponseEntity<Map<String, Boolean>> deleteNote(@PathVariable int id){

        Map<String, Boolean> response = noteService.deleteNote(id);
        return ResponseEntity.ok(response);
    }
}
