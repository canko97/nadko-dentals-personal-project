package com.dentistappointments.DentistAppointments;

import com.dentistappointments.DentistAppointments.models.Appointment;
import com.dentistappointments.DentistAppointments.repositories.AppointmentRepository;
import com.dentistappointments.DentistAppointments.repositories.fake.FakeAppointmentRepository;
import com.dentistappointments.DentistAppointments.services.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class AppointmentServiceTest {

    Date date = new Date(2021,06,07);

    @MockBean
    AppointmentService appointmentService;

    @InjectMocks
    AppointmentRepository appointmentRepository;


    @BeforeEach
    public void InitializeRepository(){
        this.appointmentRepository = Mockito.mock(AppointmentRepository.class);
        this.appointmentService = new AppointmentService(appointmentRepository);
    }

    @Test
    void TestGetAllAppointments(){
        Appointment appointment1 = new Appointment(1, 1, 1, date);
        Appointment appointment2 = new Appointment(2, 1, 1, date);
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment1);
        appointments.add(appointment2);
        Mockito.when(appointmentRepository.findAll()).thenReturn(appointments);

        assertEquals(2,appointmentService.getAllAppointments().size());
    }

    @Test
    void TestGetAppointmentById(){
        Appointment expectedAppointment = new Appointment(1, 1, 1, date);
        Mockito.when(appointmentRepository.findById(1)).thenReturn(expectedAppointment);

        assertEquals(expectedAppointment, appointmentService.getAppointmentById(1));
    }

    @Test
    void TestCreateAppointment(){
        Appointment newAppointment = new Appointment(1, 1, 1, date);
        Mockito.when(appointmentRepository.save(newAppointment)).thenReturn(newAppointment);
        appointmentService.createNewAppointment(newAppointment);

        verify(appointmentRepository, times(1)).save(newAppointment);
    }

    @Test
    void TestUpdateAppointment(){
        Appointment appointmentToUpdate = new Appointment(1, 2, 1, date);
        Mockito.when(appointmentRepository.findById(1)).thenReturn(appointmentToUpdate);
        Mockito.when(appointmentRepository.save(appointmentToUpdate)).thenReturn(appointmentToUpdate);

        appointmentService.updateAppointment(1,appointmentToUpdate);

        assertEquals(appointmentToUpdate, appointmentService.updateAppointment(1,appointmentToUpdate));
    }

    @Test
    void TestDeleteAppointment(){
        Appointment appointmentToDelete = new Appointment(1, 2, 1, date);
        int id = appointmentToDelete.getId();

        Mockito.when(appointmentRepository.findById(1)).thenReturn(appointmentToDelete);

        appointmentService.deleteAppointment(id);

        verify(appointmentRepository, times(1)).deleteById(id);
    }

}
