package com.hospital.demo.data.repository;

import com.hospital.demo.data.entity.HospitalEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<HospitalEntity, Long> {
    
}