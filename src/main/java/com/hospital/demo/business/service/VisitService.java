package com.hospital.demo.business.service;

import java.time.LocalDateTime;

import com.hospital.demo.data.entity.HospitalEntity;
import com.hospital.demo.data.entity.PatientEntity;
import com.hospital.demo.data.entity.VisitEntity;
import com.hospital.demo.data.repository.HospitalRepository;
import com.hospital.demo.data.repository.PatientRepository;
import com.hospital.demo.data.repository.VisitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VisitService {

    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private VisitRepository visitRepository;
    

    /**
     * 방문정보 생성
     * @param hospitalId
     * @param patientId
     * @param visitStatus
     */
    @Transactional
    public void createVisit(
        Long hospitalId
        ,   Long patientId
        ,   String visitStatus
    ) {

        // 병원검색
        HospitalEntity findHospital = hospitalRepository.findById(hospitalId).orElse(null);

        // 환자검색
        PatientEntity findPatient = patientRepository.findById(patientId).orElse(null);

        if (
            findHospital != null
            &&  findPatient != null
        ) {

            // 방문 객체생성
            VisitEntity newVisit = VisitEntity.builder()
                .visitDate(LocalDateTime.now())
                .visitStatus(visitStatus)
                .hospital(findHospital)
                .patient(findPatient)
                .build();

            visitRepository.save(newVisit);

        }
        

    }

}
