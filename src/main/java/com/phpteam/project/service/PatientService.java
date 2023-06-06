package com.phpteam.project.service;

import com.phpteam.project.model.Doctor;
import com.phpteam.project.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient getPatientById(Long patId);

    Patient getPatientByEmail(String patEmail);

    void savePatient(Patient patient);

    void deletePatient(Long patId);

}
