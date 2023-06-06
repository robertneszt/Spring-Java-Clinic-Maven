package com.phpteam.project.service;

import com.phpteam.project.model.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    void saveAppointment(Appointment appointment);

    Appointment getAppointmentById(Long theId);

    List<Appointment> getAppointmentsByDocId(Integer docId);

    List<Appointment> getAppointmentsByPatId(Integer patId);

    List<Appointment> getAppointmentsByDocPhone(String docPhone);

    List<Appointment> getAppointmentsByPatPhone(String patPhone);

    List<Appointment> getAppointmentsByDocEmail(String docEmail);

    List<Appointment> getAppointmentsByPatEmail(String patEmail);

    void deleteAppointment(Long appId);

    void deleteAppointmentsForPatientId(Integer patId);


}
