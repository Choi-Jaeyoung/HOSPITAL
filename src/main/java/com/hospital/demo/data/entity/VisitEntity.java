package com.hospital.demo.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TB_VISIT")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class VisitEntity {


    // ----------------- ID
    @Id
    @Column(name = "VISIT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitId;


    // ----------------- Columns
    @Column(name = "VISIT_DATE", nullable = false)
    private LocalDateTime visitDate;
    @Column(name = "VISIT_STATUS", nullable = false, length = 10)
    private String visitStatus;


    // ----------------- Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOSPITAL_ID", nullable = false, unique = true)
    private HospitalEntity hospital;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID", nullable = false, unique = true)
    private PatientEntity patient;
    




}
