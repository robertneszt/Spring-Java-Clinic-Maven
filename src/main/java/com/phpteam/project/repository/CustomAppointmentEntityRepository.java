package com.phpteam.project.repository;

import com.phpteam.project.entity.AppointmentEntity;

public interface CustomAppointmentEntityRepository {
<S extends AppointmentEntity> S save(S entity);
}

