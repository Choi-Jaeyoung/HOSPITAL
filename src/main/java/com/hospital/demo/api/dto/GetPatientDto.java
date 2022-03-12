package com.hospital.demo.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class GetPatientDto {

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
        private Long hospitalId;
        private String hospitalName;

        private List<Visit> visits;
    
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class Visit {
    
        private Long visitId;
        private String visitDate;
        private String visitStatus;
        private Long hospitalId;
        private String hospitalName;

    }


    //=== Responses ======================================================
    @Getter
    @AllArgsConstructor
    @Builder
    public static class GetPatientResponse {
       
        private Patient patient;
    
    }


}