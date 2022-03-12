package com.hospital.demo.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TB_HOSPITAL")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class HospitalEntity {


    // ----------------- ID
    @Id
    @Column(name = "HOSPITAL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;

    
    // ----------------- Columns
    @Column(name = "HOSPITAL_NAME", nullable = false, length = 45)
    String hospitalName;
    @Column(name = "HOSPITAL_CENTER_NUMBER", nullable = false, length = 20)
    String hospitalCenterNumber;
    @Column(name = "HOSPITAL_HEAD_NAME", nullable = false, length = 10)
    String hospitalHeadName;


}