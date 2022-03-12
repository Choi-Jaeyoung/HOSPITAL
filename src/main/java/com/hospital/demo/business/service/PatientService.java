package com.hospital.demo.business.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.hospital.demo.api.dto.GetPatientDto;
import com.hospital.demo.api.dto.GetPatientsDto;
import com.hospital.demo.data.entity.CodeEntity;
import com.hospital.demo.data.entity.HospitalEntity;
import com.hospital.demo.data.entity.PatientEntity;
import com.hospital.demo.data.entity.VisitEntity;
import com.hospital.demo.data.repository.CodeRepository;
import com.hospital.demo.data.repository.HospitalRepository;
import com.hospital.demo.data.repository.PatientRepository;
import com.hospital.demo.data.repository.VisitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {
    
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private CodeRepository codeRepository;


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


    /**
     * 환자삭제
     * @param patientId
     */
    @Transactional
    public void deletePatient(
        Long patientId
    ) {

        // 환자 검색
        PatientEntity findPatient = patientRepository.findById(patientId).orElse(null);

        if ( findPatient != null ) {
            patientRepository.delete(findPatient);
        }

    }


    /**
     * 환자 상세조회
     * @param patientId
     * @return
     */
    public GetPatientDto.Patient getPatient(
        Long patientId
    ) {

        GetPatientDto.Patient patient = null;

        // 환자조회
        PatientEntity findPatient = patientRepository.findById(patientId).orElse(null);

        if ( findPatient != null ) {

            // 방문 목록 조회
            List<VisitEntity> findVisits = visitRepository.findAllByPatientPatientId(patientId);
            
            patient = GetPatientDto.Patient.builder()
                .patientId(patientId)
                .patientName(findPatient.getPatientName())
                .patientRegistrationNumber(findPatient.getPatientRegistrationNumber())
                .patientGender(
                    codeRepository.findById(findPatient.getPatientGender()).orElse(new CodeEntity()).getCodeName()
                )
                .patientBirth(findPatient.getPatientBirth())
                .patientPhone(findPatient.getPatientPhone())
                .hospitalId(findPatient.getHospital().getHospitalId())
                .hospitalName(findPatient.getHospital().getHospitalName())
                .visits(
                    findVisits.stream()
                        .map(findVisit ->
                            GetPatientDto.Visit.builder()
                                .visitId(findVisit.getVisitId())
                                .visitDate(findVisit.getVisitDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                                .visitStatus(
                                    codeRepository.findById(findVisit.getVisitStatus()).orElse(new CodeEntity()).getCodeName()
                                )
                                .hospitalId(findVisit.getHospital().getHospitalId())
                                .hospitalName(findVisit.getHospital().getHospitalName())
                                .build()
                        )
                        .collect(Collectors.toList())
                )
                .build();
            

        }

        return patient;

    }


    /**
     * 환자 목록조회
     * @return
     */
    public List<GetPatientsDto.Patient> getPatients(

    ) {

        List<GetPatientsDto.Patient> patients = new ArrayList<>();

        List<PatientEntity> findPatients = patientRepository.findAll();

        findPatients.stream().forEach(findPatient -> {

            VisitEntity findVisit = visitRepository.findTopByPatientPatientId(findPatient.getPatientId()).orElse(null);

            patients.add(
                GetPatientsDto.Patient.builder()
                    .patientId(findPatient.getPatientId())
                    .patientName(findPatient.getPatientName())
                    .patientRegistrationNumber(findPatient.getPatientRegistrationNumber())
                    .patientGender(
                        codeRepository.findById(findPatient.getPatientGender()).orElse(new CodeEntity()).getCodeName()
                    )
                    .patientBirth(findPatient.getPatientBirth())
                    .patientPhone(findPatient.getPatientPhone())
                    .lastVisitDate(
                        findVisit != null
                        ?   findVisit.getVisitDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                        :   ""
                    )
                    .build()
            );
            
        });

        return patients;

    }


}
