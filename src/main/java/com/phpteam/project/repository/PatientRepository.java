package com.phpteam.project.repository;

import com.phpteam.project.entity.PatientEntity;
import com.phpteam.project.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    @Query("SELECT e FROM PatientEntity e WHERE e.email = ?1")
    Optional<PatientEntity> findByEmail(String patEmailId);
}
