package com.dentistappointments.DentistAppointments.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('DENTIST') or hasRole('ASSISTANT') or hasRole('USER')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/assistant")
    @PreAuthorize("hasRole('ASSISTANT')")
    public String moderatorAccess() {
        return "Assistant Board.";
    }

    @GetMapping("/dentist")
    @PreAuthorize("hasRole('DENTIST')")
    public String adminAccess() {
        return "Dentist Board.";
    }
}

