package com.hospital.demo.data.repository;

import java.util.List;

import com.hospital.demo.data.entity.VisitEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<VisitEntity, Long> {

    List<VisitEntity> findAllByPatientPatientId(Long patientId);
    
}