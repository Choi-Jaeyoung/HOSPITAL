package com.hospital.demo.data.repository;

import com.hospital.demo.data.entity.CodeGroupEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeGroupRepository extends JpaRepository<CodeGroupEntity, String> {
    
}
