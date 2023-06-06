package com.phpteam.project.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phpteam.project.entity.AppointmentEntity;
import com.phpteam.project.entity.DoctorEntity;
import com.phpteam.project.entity.PatientEntity;
import com.phpteam.project.model.Appointment;
import com.phpteam.project.model.Doctor;
import com.phpteam.project.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MapperHelper {

    @Autowired
    public ObjectMapper mapper;

    public MapperHelper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Doctor> convertDoctorEntityListToDoctorList(List<DoctorEntity> entities) {
        List<Doctor> doctors = new ArrayList<>();
        for (DoctorEntity entity : entities) {
            doctors.add(mapper.convertValue(entity, Doctor.class));
        }
        return doctors;
    }

    public DoctorEntity convertDoctorToDoctorEntity(Doctor doctor) {
        return mapper.convertValue(doctor, DoctorEntity.class);
    }

    public Doctor convertDoctorEntityToDoctor(DoctorEntity doctorEntity) {
        return mapper.convertValue(doctorEntity, Doctor.class);
    }

    public List<Patient> convertPatientEntityListToPatientList(List<PatientEntity> patientEntityList) {
        List<Patient> patientList = new ArrayList<>(patientEntityList.size());
        for (PatientEntity patientEntity : patientEntityList) {
            patientList.add(mapper.convertValue(patientEntity, Patient.class));
        }
        return patientList;
    }

    public Patient convertPatientEntityToPatient(PatientEntity patientEntity) {
        return mapper.convertValue(patientEntity, Patient.class);
    }

    public AppointmentEntity convertAppointmentToAppointEntity(Appointment appointment) {
        return AppointmentEntity.builder().id(appointment.getId()).doctorId(appointment.getDoctor().longValue()).patientId(appointment.getPatient().longValue()).datetime(appointment.getDatetime()).status(appointment.getStatus()).build();
    }

    public Appointment convertAppointmentEntityToAppointment(AppointmentEntity appointmentEntity) {
        return Appointment.builder().id(appointmentEntity.getId()).datetime(appointmentEntity.getDatetime()).doctor(appointmentEntity.getDoctorId().intValue()).patient(appointmentEntity.getPatientId().intValue()).status(appointmentEntity.getStatus()).build();

    }

    public List<Appointment> convertAppointmentEntityListToAppointmentList(List<AppointmentEntity> appointmentEntity) {

        List<Appointment> appointmentList = new ArrayList<>(appointmentEntity.size());
        for (AppointmentEntity entity : appointmentEntity) {
            appointmentList.add(convertAppointmentEntityToAppointment(entity));
        }
        return appointmentList;
    }

    public PatientEntity convertPatientToPatientEntity(Patient patient) {
        return mapper.convertValue(patient, PatientEntity.class);
    }
}
