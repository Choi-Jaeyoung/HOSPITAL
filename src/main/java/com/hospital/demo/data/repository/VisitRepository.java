package com.hospital.demo.data.repository;

import java.util.List;
import java.util.Optional;

import com.hospital.demo.data.entity.VisitEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<VisitEntity, Long> {

    List<VisitEntity> findAllByPatientPatientId(Long patientId);

    Optional<VisitEntity> findTopByPatientPatientId(Long patientId);
    
}