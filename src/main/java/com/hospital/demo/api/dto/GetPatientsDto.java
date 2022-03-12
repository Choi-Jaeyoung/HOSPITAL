package com.hospital.demo.api.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class GetPatientsDto {

    //=== Infos ======================================================
    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class Patient {
    
        private Long patientId;
        private String patientName;
        private String patientRegistrationNumber;
        private String patientGender;
        private String patientBirth;
        private String patientPhone;
        private String lastVisitDate;
    
    }


    //=== Responses ======================================================
    @Getter
    @AllArgsConstructor
    @Builder
    public static class GetPatientsResponse {
    
        @Builder.Default
        private List<Patient> patients = new ArrayList<>();
    
    }


}