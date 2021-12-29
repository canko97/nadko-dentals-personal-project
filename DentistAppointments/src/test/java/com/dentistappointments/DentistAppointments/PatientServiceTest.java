package com.dentistappointments.DentistAppointments;

import com.dentistappointments.DentistAppointments.models.Patient;
import com.dentistappointments.DentistAppointments.repositories.PatientRepository;
import com.dentistappointments.DentistAppointments.services.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PatientServiceTest {

    @MockBean
    PatientService patientService;

    @InjectMocks
    PatientRepository patientRepository;

    @BeforeEach
    public void InitializeRepository(){
        this.patientRepository = Mockito.mock(PatientRepository.class);
        this.patientService = new PatientService(patientRepository);
    }

    @Test
    void TestGetAllPatients(){
        Patient patient1 = new Patient(1,"John", "Doe", "john@gmail.com", "+3108102923", 1);
        Patient patient2 = new Patient(2,"Jane", "Doe", "jane@gmail.com", "+3108102923", 1);
        List<Patient> patients = new ArrayList();
        patients.add(patient1);
        patients.add(patient2);
        Mockito.when(patientRepository.findAll()).thenReturn(patients);

        assertEquals(2, patientService.getAllPatients().size());
    }

    @Test
    void TestGetPatientById(){
        Patient expectedPatient = new Patient(1,"John", "Doe", "john@gmail.com", "+3108102923", 1);
        Mockito.when(patientRepository.findById(1)).thenReturn(expectedPatient);

        assertEquals(expectedPatient, patientService.getPatientById(1));
    }

    @Test
    void TestCreatePatient(){
        Patient newPatient = new Patient(1,"John", "Doe", "john@gmail.com", "+3108102923", 1);
        Mockito.when(patientRepository.save(newPatient)).thenReturn(newPatient);
        patientService.createPatient(newPatient);

        verify(patientRepository,times(1)).save(newPatient);
    }

    @Test
    void TestUpdatePatient(){
        Patient patientToUpdate = new Patient(1,"Jane", "Doe", "john@gmail.com", "+3108102923", 1);
        Mockito.when(patientRepository.findById(1)).thenReturn(patientToUpdate);
        Mockito.when(patientRepository.save(patientToUpdate)).thenReturn(patientToUpdate);

        patientService.updatePatient(1,patientToUpdate);

        assertEquals(patientToUpdate, patientService.updatePatient(1,patientToUpdate));
    }

    @Test
    void TestDeletePatient(){
        Patient patientToDelete = new Patient(1, "Jane", "Doe", "john@gmail.com", "+3108102923", 1);
        int id = patientToDelete.getId();

        Mockito.when(patientRepository.findById(1)).thenReturn(patientToDelete);

        patientService.deletePatient(id);

        verify(patientRepository, times(1)).deleteById(id);
    }

}
