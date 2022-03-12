package com.hospital.demo.data.repository;

import com.hospital.demo.data.entity.VisitEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<VisitEntity, Long> {
    
}