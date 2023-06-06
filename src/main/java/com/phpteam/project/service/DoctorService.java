package com.phpteam.project.service;

import com.phpteam.project.model.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors();



    Doctor getDoctorById(Long docId);
    Doctor getDoctorByName(String name);
    Doctor getDoctorByEmail(String emailId);


}
