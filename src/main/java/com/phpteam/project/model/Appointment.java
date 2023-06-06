package com.phpteam.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {

    private Long id;
    private Integer doctor;
    private Integer patient;
    private LocalDateTime datetime;
    private String status;

//Transient

    private String doctorName;
    private String patientName;
}
