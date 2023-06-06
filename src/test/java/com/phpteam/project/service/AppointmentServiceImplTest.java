package com.phpteam.project.service;

import com.phpteam.project.entity.AppointmentEntity;
import com.phpteam.project.mapper.MapperHelper;
import com.phpteam.project.model.Appointment;
import com.phpteam.project.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AppointmentServiceImplTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private MapperHelper mapperHelper;

    @InjectMocks
    private AppointmentServiceImpl appointmentService;

//    @Test
//    void saveAppointment() {
//        // Arrange
//        Appointment appointment = new Appointment();
//        AppointmentEntity appointmentEntity = new AppointmentEntity();
//        when(mapperHelper.convertAppointmentToAppointEntity(any(Appointment.class))).thenReturn(appointmentEntity);
//        lenient().when(appointmentRepository.save(any(AppointmentEntity.class))).thenReturn(appointmentEntity);
//
//        // Act
//        appointmentService.saveAppointment(appointment);
//
//        // Assert
//        verify(appointmentRepository, times(1)).save(appointmentEntity);
//    }

//    @Test
//    void getAppointmentById_found() {
//        // Arrange
//        Long aptId = 1L;
//        Appointment appointment = new Appointment();
//        AppointmentEntity appointmentEntity = new AppointmentEntity();
//        lenient().when(appointmentRepository.findById(aptId)).thenReturn(Optional.of(appointmentEntity));
//        when(mapperHelper.convertAppointmentEntityToAppointment(appointmentEntity)).thenReturn(appointment);
//
//        // Act
//        Appointment foundAppointment = appointmentService.getAppointmentById(aptId);
//
//        // Assert
//        assertNotNull(foundAppointment);
//        assertEquals(appointment, foundAppointment);
//    }

    @Test
    void getAppointmentById_notFound() {
        // Arrange
        Long aptId = 9L;
       lenient().when(appointmentRepository.findById(aptId)).thenReturn(Optional.empty());

        // Act
        Appointment foundAppointment = appointmentService.getAppointmentById(aptId);

        // Assert
        assertNull(foundAppointment);
    }
}