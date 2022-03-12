package com.hospital.demo.api.controller;

import java.util.List;

import com.hospital.demo.api.dto.CreatePatientDto.CreatePatientBody;
import com.hospital.demo.api.dto.CreatePatientDto.CreatePatientResponse;
import com.hospital.demo.api.dto.DeletePatientDto.DeletePatientResponse;
import com.hospital.demo.api.dto.GetPatientDto;
import com.hospital.demo.api.dto.GetPatientDto.GetPatientResponse;
import com.hospital.demo.api.dto.GetPatientsDto;
import com.hospital.demo.api.dto.GetPatientsDto.GetPatientsResponse;
import com.hospital.demo.api.dto.UpdatePatientDto.UpdatePatientBody;
import com.hospital.demo.api.dto.UpdatePatientDto.UpdatePatientResponse;
import com.hospital.demo.business.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    
    @PutMapping("/patient/{patientId}")
    public UpdatePatientResponse updatePatient(
        @RequestBody
        UpdatePatientBody requestBody
        ,
        @PathVariable("patientId")
        Long patientId
    ) {
    
        String patientName = requestBody.getPatientName();
        String patientGender = requestBody.getPatientGender();
        String patientBirth = requestBody.getPatientBirth();
        String patientPhone = requestBody.getPatientPhone();

        UpdatePatientResponse updatePatientResponse = null;

        // 환자 정보 수정
        patientService.updatePatient(patientId, patientName, patientGender, patientBirth, patientPhone);

        updatePatientResponse = UpdatePatientResponse.builder()
            .resultMessage("수정 성공!")
            .build();

        return updatePatientResponse;
    
    }

    

    
    @DeleteMapping("/patient/{patientId}")
    public DeletePatientResponse deletePatient(
        @PathVariable("patientId")
        Long patientId
    ) {

        DeletePatientResponse deletePatientResponse = null;

        // 환자 정보 삭제
        patientService.deletePatient(patientId);

        deletePatientResponse = DeletePatientResponse.builder()
            .resultMessage("삭제 성공!")
            .build();

        return deletePatientResponse;
    
    }


    
    
    @GetMapping("/patient/{patientId}")
    public GetPatientResponse getPatient(
        @PathVariable("patientId")
        Long patientId
    ) {

        GetPatientResponse getPatientResponse = null;

        // 환자 정보 조회
        GetPatientDto.Patient patient = patientService.getPatient(patientId);

        getPatientResponse = GetPatientResponse.builder()
            .patient(patient)
            .build();

        return getPatientResponse;
    
    }

    
    @GetMapping("/patients")
    public GetPatientsResponse getPatients(
        
    ) {

        GetPatientsResponse getPatientsResponse = null;

        // 환자 정보 조회
        List<GetPatientsDto.Patient> patients = patientService.getPatients();

        getPatientsResponse = GetPatientsResponse.builder()
            .patients(patients)
            .build();

        return getPatientsResponse;
    
    }


}