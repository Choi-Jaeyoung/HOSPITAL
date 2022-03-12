package com.hospital.demo.data.entity;

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
@Table(name="TB_PATIENT")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PatientEntity {


    // ----------------- ID
    @Id
    @Column(name = "PATIENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;


    // ----------------- Columns
    @Column(name = "PATIENT_NAME", nullable =  false, length = 45)    
    private String patientName;
    @Column(name = "PATIENT_REGISTRATION_NUMBER", nullable =  false, length = 13)    
    private String patientRegistrationNumber;
    @Column(name = "PATIENT_GENDER", nullable =  false, length = 10)    
    private String patientGender;
    @Column(name = "PATIENT_BIRTH", length = 10)    
    private String patientBirth;
    @Column(name = "PATIENT_PHONE", length = 20)    
    private String patientPhone;


    // ----------------- Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOSPITAL_ID", nullable = false, unique = true)
    private HospitalEntity hospital;


}