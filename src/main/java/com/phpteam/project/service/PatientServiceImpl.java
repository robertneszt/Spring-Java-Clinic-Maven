package com.phpteam.project.service;

import com.phpteam.project.entity.DoctorEntity;
import com.phpteam.project.entity.PatientEntity;
import com.phpteam.project.exception.EntityNotFoundException;
import com.phpteam.project.mapper.MapperHelper;
import com.phpteam.project.model.Patient;
import com.phpteam.project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final MapperHelper mapperHelper;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, MapperHelper mapperHelper) {
        this.patientRepository = patientRepository;
        this.mapperHelper = mapperHelper;
    }

    @Override
    public List<Patient> getAllPatients() {
        var patientEntities = patientRepository.findAll();
        return mapperHelper.convertPatientEntityListToPatientList(patientEntities);
    }

    @Override
    public Patient getPatientById(Long patId) {
        Optional<PatientEntity> foundPat = patientRepository.findById(patId);
        return foundPat.map(mapperHelper::convertPatientEntityToPatient).orElse(null);
    }

    @Override
    public Patient getPatientByEmail(String patEmail) {
        Optional<PatientEntity> foundPat = patientRepository.findByEmail(patEmail);
        if (foundPat.isEmpty()) {
            throw new EntityNotFoundException("The patient not found, please enter registered email ");
        } else {
            return foundPat.map(mapperHelper::convertPatientEntityToPatient).orElse(null);
        }
    }

    @Override
    public void savePatient(Patient patient) {
        PatientEntity patientEntity = mapperHelper.convertPatientToPatientEntity(patient);
        patientRepository.save(patientEntity);
    }
    @Override
    public void deletePatient(Long patId) {
        Optional<PatientEntity> foundPat = patientRepository.findById(patId);

        if (foundPat.isPresent()) {
            PatientEntity patientEntity = foundPat.get();
            patientRepository.delete(patientEntity);
        } else {
            throw new EntityNotFoundException("The patient not found, please enter a registered patient ID. ");
        }
    }
}
