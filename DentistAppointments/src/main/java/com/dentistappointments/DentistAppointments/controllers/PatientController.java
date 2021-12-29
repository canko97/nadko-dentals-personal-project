package com.dentistappointments.DentistAppointments.controllers;

import com.dentistappointments.DentistAppointments.interfaces.iPatientService;
import com.dentistappointments.DentistAppointments.models.Patient;
import com.dentistappointments.DentistAppointments.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class PatientController {

    private iPatientService patientService;
    @Autowired
    public PatientController(iPatientService patientService) {
        this.patientService = patientService;
    }

    //get all patients
    @GetMapping("/patients")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public List<Patient> getAllPatients(){

        return patientService.getAllPatients();
    }

    //add patient
    @PostMapping("/patients")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public Patient createPatient(@RequestBody Patient patient){

        return patientService.createPatient(patient);
    }

    //get a specific dentist's patients
    @GetMapping("/patients/{dentistId}")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public List<Patient> getDentistPatients(@PathVariable int dentistId){

        return patientService.getDentistPatients(dentistId);
    }

    //get patient by id rest api
    @GetMapping("/patients/single/{id}")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id){
        Patient patient = patientService.getPatientById(id);
        return ResponseEntity.ok(patient);
    }

    //update patient rest api
    @PutMapping("/patients/single/{id}")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public ResponseEntity<Patient> updatePatient(@PathVariable int id, @RequestBody Patient patientToUpdate){
        Patient updatedPatient = patientService.updatePatient(id, patientToUpdate);
        return ResponseEntity.ok(updatedPatient);
    }

    //delete patient rest api
    @DeleteMapping("/patients/single/{id}")
    @PreAuthorize("hasRole('DENTIST')")
    public void deletePatient(@PathVariable int id){

        patientService.deletePatient(id);
    }
}
