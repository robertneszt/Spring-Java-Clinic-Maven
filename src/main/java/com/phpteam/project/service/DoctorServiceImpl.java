package com.phpteam.project.service;

import com.phpteam.project.entity.DoctorEntity;
import com.phpteam.project.exception.EntityNotFoundException;
import com.phpteam.project.mapper.MapperHelper;
import com.phpteam.project.model.Doctor;
import com.phpteam.project.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final MapperHelper mapperHelper;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, MapperHelper mapperHelper) {
        this.doctorRepository = doctorRepository;
        this.mapperHelper = mapperHelper;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<DoctorEntity> doctorEntities = doctorRepository.findAll();
        return mapperHelper.convertDoctorEntityListToDoctorList(doctorEntities);
    }

    @Override
    public Doctor getDoctorById(Long docId) {
        Optional<DoctorEntity> foundDoc = doctorRepository.findById(docId);
        return foundDoc.map(mapperHelper::convertDoctorEntityToDoctor).orElse(null);
    }

    @Override
    public Doctor getDoctorByName(String name) {
        Optional<DoctorEntity> foundDoc = doctorRepository.findByName(name);
        if (foundDoc.isEmpty()) {
            throw new EntityNotFoundException("The doctor not found, please enter registered email ");
        } else {
            return mapperHelper.convertDoctorEntityToDoctor(foundDoc.get());
        }
    }

    @Override
    public Doctor getDoctorByEmail(String emailId) {
        Optional<DoctorEntity> foundDoc = doctorRepository.findByEmail(emailId);
        if (foundDoc.isEmpty()) {
            throw new EntityNotFoundException("The doctor not found, please enter registered email ");
        } else {
            return mapperHelper.convertDoctorEntityToDoctor(foundDoc.get());
        }
    }

}
