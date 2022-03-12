package com.hospital.demo.api.controller;

import com.hospital.demo.api.dto.CreatePatientDto.CreatePatientBody;
import com.hospital.demo.api.dto.CreatePatientDto.CreatePatientResponse;
import com.hospital.demo.api.dto.UpdatePatientDto.UpdatePatientBody;
import com.hospital.demo.api.dto.UpdatePatientDto.UpdatePatientResponse;
import com.hospital.demo.business.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
    

    @PostMapping("/patient")
    public CreatePatientResponse createPatient(
        @RequestBody
        CreatePatientBody requestBody
    ) {
    
        Long hospitalId = requestBody.getHospitalId();
        String patientName = requestBody.getPatientName();
        String patientGender = requestBody.getPatientGender();
        String patientBirth = requestBody.getPatientBirth();
        String patientPhone = requestBody.getPatientPhone();

        CreatePatientResponse createPatientResponse = null;

        // 환자 정보 생성
        patientService.createPatient(hospitalId, patientName, patientGender, patientBirth, patientPhone);

        createPatientResponse = CreatePatientResponse.builder()
            .resultMessage("등록 성공!")
            .build();

        return createPatientResponse;
    
    }

    
    @PutMapping("/patient")
    public UpdatePatientResponse updatePatient(
        @RequestBody
        UpdatePatientBody requestBody
    ) {
    
        Long patientId = requestBody.getPatientId();
        String patientName = requestBody.getPatientName();
        String patientGender = requestBody.getPatientGender();
        String patientBirth = requestBody.getPatientBirth();
        String patientPhone = requestBody.getPatientPhone();

        UpdatePatientResponse updatePatientResponse = null;

        // 환자 정보 생성
        patientService.updatePatient(patientId, patientName, patientGender, patientBirth, patientPhone);

        updatePatientResponse = UpdatePatientResponse.builder()
            .resultMessage("수정 성공!")
            .build();

        return updatePatientResponse;
    
    }

}