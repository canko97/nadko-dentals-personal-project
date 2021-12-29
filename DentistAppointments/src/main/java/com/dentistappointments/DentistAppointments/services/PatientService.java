package com.dentistappointments.DentistAppointments.services;

import com.dentistappointments.DentistAppointments.interfaces.iPatientService;
import com.dentistappointments.DentistAppointments.models.Patient;
import com.dentistappointments.DentistAppointments.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService implements iPatientService {

    private PatientRepository patientRepository;
    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients(){

        return patientRepository.findAll();
    }

    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public List<Patient> getDentistPatients(int dentistId){
        List<Patient> allPatients = getAllPatients();
        List<Patient> dentistPatients = new ArrayList<>();
        allPatients.forEach(patient ->{
            if(patient.getDentistId() == dentistId){
                dentistPatients.add(patient);
            }
        });

        return dentistPatients;
    }

    public Patient getPatientById( int id){
        Patient patient = patientRepository.findById(id);

        return patient;
    }

    public Patient updatePatient( int id, Patient patientToUpdate){
        Patient patient = patientRepository.findById(id);

        patient.setFirstName(patientToUpdate.getFirstName());
        patient.setLastName(patientToUpdate.getLastName());
        patient.setEmail(patientToUpdate.getEmail());
        patient.setPhone(patientToUpdate.getPhone());

        Patient updatedPatient = patientRepository.save(patient);
        return updatedPatient;
    }

    public void deletePatient(int id){
        Patient patient = patientRepository.findById(id);

        patientRepository.deleteById(patient.getId());
    }
}
