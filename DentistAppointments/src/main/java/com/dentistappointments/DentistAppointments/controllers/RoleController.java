package com.dentistappointments.DentistAppointments.controllers;

import com.dentistappointments.DentistAppointments.models.ERole;
import com.dentistappointments.DentistAppointments.models.Role;
import com.dentistappointments.DentistAppointments.repositories.jpa.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/populate")
    public void PopulateRoles(){
        Role role_user = new Role(1, ERole.ROLE_USER);
        Role role_assistant = new Role(2, ERole.ROLE_ASSISTANT);
        Role role_dentist = new Role(3, ERole.ROLE_DENTIST);

        roleRepository.save(role_user);
        roleRepository.save(role_assistant);
        roleRepository.save(role_dentist);
    }

}
