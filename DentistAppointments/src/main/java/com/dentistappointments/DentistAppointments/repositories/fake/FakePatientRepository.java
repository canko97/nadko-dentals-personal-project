package com.dentistappointments.DentistAppointments.repositories.fake;

import com.dentistappointments.DentistAppointments.models.Patient;
import com.dentistappointments.DentistAppointments.repositories.PatientRepository;
import com.dentistappointments.DentistAppointments.repositories.jpa.JpaPatientRepository;

import java.util.ArrayList;
import java.util.List;

public class FakePatientRepository implements PatientRepository {

    private List<Patient> patients = new ArrayList<>();

    public FakePatientRepository() {
        patients.add(new Patient(1,"John", "Doe", "john@gmail.com", "+3108102923", 1));
        patients.add(new Patient(2,"John", "Doe", "john@gmail.com", "+3108102923", 1));
        patients.add(new Patient(3,"John", "Doe", "john@gmail.com", "+3108102923", 1));
        patients.add(new Patient(4,"John", "Doe", "john@gmail.com", "+3108102923", 1));
        patients.add(new Patient(5,"John", "Doe", "john@gmail.com", "+3108102923", 1));
        patients.add(new Patient(6,"John", "Doe", "john@gmail.com", "+3108102923", 1));
        patients.add(new Patient(7,"John", "Doe", "john@gmail.com", "+3108102923", 1));
    }

    @Override
    public List<Patient> findAll() {
        return patients;
    }

    @Override
    public Patient findById(int id) {
        for (Patient patient: patients) {
            if(patient.getId() == id){
                return patient;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Patient save(Patient user) {
        patients.add(user);
        return user;
    }

    @Override
    public void deleteById(int id) {
        patients.remove(id);
    }

}
