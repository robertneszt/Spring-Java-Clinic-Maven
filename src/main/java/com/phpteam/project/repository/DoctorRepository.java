package com.phpteam.project.repository;

import com.phpteam.project.entity.DoctorEntity;
import com.phpteam.project.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    @Query("SELECT e FROM DoctorEntity e WHERE e.email = ?1")
    Optional<DoctorEntity> findByEmail(String emailId);
    @Query("SELECT e FROM DoctorEntity e WHERE e.firstName = ?1")
    Optional<DoctorEntity> findByName(String name);
}
