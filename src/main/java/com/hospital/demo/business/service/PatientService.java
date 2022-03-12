package com.hospital.demo.business.service;

import java.util.UUID;

import com.hospital.demo.data.entity.HospitalEntity;
import com.hospital.demo.data.entity.PatientEntity;
import com.hospital.demo.data.repository.HospitalRepository;
import com.hospital.demo.data.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {
    
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private HospitalRepository hospitalRepository;


    /**
     * 환자등록
     *  - 환자등록번호 서버 자동생성
     * @param hospitalId
     * @param patientName
     * @param patientGender
     * @param patientBirth
     * @param patientPhone
     */
    @Transactional
    public void createPatient(
        Long hospitalId
        ,   String patientName
        ,   String patientGender
        ,   String patientBirth
        ,   String patientPhone
    ) {

        // 병원 조회
        HospitalEntity findHospital = hospitalRepository.findById(hospitalId).orElse(null);

        if ( findHospital != null ) {

            // 환자등록번호 자동 생성 13자리
            String patientRegistrationNumber = UUID.randomUUID().toString().substring(0, 13);
            
            // 환자 객체 생성
            PatientEntity newPatient = PatientEntity.builder()
                .patientName(patientName)
                .patientRegistrationNumber(patientRegistrationNumber)
                .patientGender(patientGender)
                .patientBirth(patientBirth)
                .patientPhone(patientPhone)
                .hospital(findHospital)
                .build();

            patientRepository.save(newPatient);

        }

    }


    /**
     * 환자 수정
     * @param patientId
     * @param patientName
     * @param patientGender
     * @param patientBirth
     * @param patientPhone
     */
    @Transactional
    public void updatePatient(
        Long patientId
        ,   String patientName
        ,   String patientGender
        ,   String patientBirth
        ,   String patientPhone
    ) {

        // 환자정보 조회
        PatientEntity findPatient = patientRepository.findById(patientId).orElse(null);

        if( findPatient != null ) {
            
            if ( patientName != null ) {
                findPatient.setPatientName(patientName);
            }
            if ( patientGender != null ) {
                findPatient.setPatientGender(patientGender);
            }
            if ( patientBirth != null ) {
                findPatient.setPatientBirth(patientBirth);
            }
            if ( patientPhone != null ) {
                findPatient.setPatientPhone(patientPhone);
            }

        }

    }


}
