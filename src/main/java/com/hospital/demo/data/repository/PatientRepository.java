package com.hospital.demo.data.repository;

import com.hospital.demo.data.entity.PatientEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    
}