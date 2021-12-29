package com.dentistappointments.DentistAppointments.controllers;

import com.dentistappointments.DentistAppointments.interfaces.iAppointmentService;
import com.dentistappointments.DentistAppointments.models.Appointment;
import com.dentistappointments.DentistAppointments.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class AppointmentController {

    private iAppointmentService appointmentService;
    @Autowired
    public AppointmentController(iAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    //get all appointments
    @GetMapping("/appointments")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    //get all dentist appointments
    @GetMapping("/appointments/{dentistId}")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public List<Appointment> getAllDentistAppointments(@PathVariable int dentistId){
        return appointmentService.getAllDentistAppointments(dentistId);
    }

    //create new appointment
    @PostMapping("/appointments")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public Appointment createNewAppointment(@RequestBody Appointment appointment){
        return appointmentService.createNewAppointment(appointment);
    }

    //get appointment by id
    @GetMapping("/appointments/single/{id}")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable int id){
        Appointment appointment = appointmentService.getAppointmentById(id);

        return ResponseEntity.ok(appointment);
    }

    //update appointment
    @PutMapping ("/appointments/single/{id}")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT')")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") int id, @RequestBody Appointment appointmentToUpdate){

        Appointment updatedAppointment = appointmentService.updateAppointment(id,appointmentToUpdate);
        return ResponseEntity.ok(updatedAppointment);
    }

    //delete appointment
    @DeleteMapping("/appointments/single/{id}")
    @PreAuthorize("hasRole('DENTIST')")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable int id){

        Map<String, Boolean> response = appointmentService.deleteAppointment(id);
        return ResponseEntity.ok(response);
    }

}
