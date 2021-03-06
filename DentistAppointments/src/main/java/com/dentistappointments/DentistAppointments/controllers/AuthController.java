package com.dentistappointments.DentistAppointments.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentistappointments.DentistAppointments.models.ERole;
import com.dentistappointments.DentistAppointments.models.Role;
import com.dentistappointments.DentistAppointments.models.User;
import com.dentistappointments.DentistAppointments.payload.request.LoginRequest;
import com.dentistappointments.DentistAppointments.payload.request.SignupRequest;
import com.dentistappointments.DentistAppointments.payload.response.JwtResponse;
import com.dentistappointments.DentistAppointments.payload.response.MessageResponse;
import com.dentistappointments.DentistAppointments.repositories.jpa.RoleRepository;
import com.dentistappointments.DentistAppointments.repositories.jpa.UserRepository;
import com.dentistappointments.DentistAppointments.security.jwt.JwtUtils;
import com.dentistappointments.DentistAppointments.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role dentistRole = roleRepository.findByName(ERole.ROLE_DENTIST)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(dentistRole);
        } else {
            strRoles.forEach(role -> {
                if (role.equals("dentist")){
                    Role dentistRole = roleRepository.findByName(ERole.ROLE_DENTIST)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(dentistRole);
                }else if(role.equals("assistant")){
                    Role assistantRole = roleRepository.findByName(ERole.ROLE_ASSISTANT)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(assistantRole);
                }
//                switch (role) {
//                    case "dentist":
//                        Role adminRole = roleRepository.findByName(ERole.ROLE_DENTIST)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(adminRole);
//
//                        break;
//                    case "assistant":
//                        Role modRole = roleRepository.findByName(ERole.ROLE_ASSISTANT)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(modRole);
//
//                        break;
//                    default:
//                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(userRole);
//                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
