package com.hospital.demo.api.controller;

import com.hospital.demo.api.dto.CreatePatientDto.CreatePatientBody;
import com.hospital.demo.api.dto.CreatePatientDto.CreatePatientResponse;
import com.hospital.demo.business.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
    

    @PostMapping(
        value = "/patient"
    )
    public CreatePatientResponse createPatient(
        @RequestBody
        CreatePatientBody requestBody
    ) {
    
        Long hospitalId = requestBody.getHospitalId();
        String patientName = requestBody.getPatientName();
        String patientGender = requestBody.getPatientGender();
        String patientBirth = requestBody.getPatientBirth();
        String patientPhone = requestBody.getPatientPhone();

        System.out.println(requestBody.toString());

        CreatePatientResponse createPatientResponse = null;

        // 환자 정보 생성
        patientService.createPatient(hospitalId, patientName, patientGender, patientBirth, patientPhone);

        return createPatientResponse;
    
    }

}