package com.hospital.demo.data.repository;

import com.hospital.demo.data.entity.CodeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<CodeEntity, String> {
    
}
