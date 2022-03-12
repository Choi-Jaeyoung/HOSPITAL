package com.hospital.demo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CreatePatientDto {

    //=== Bodys ======================================================
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreatePatientBody {
    
        private Long hospitalId;
        private String patientName;
        private String patientGender;
        private String patientBirth;
        private String patientPhone;
    
    }

    //=== Infos ======================================================



    //=== Responses ======================================================
    @Getter
    @AllArgsConstructor
    @Builder
    public static class CreatePatientResponse {
    
        private int resultCode;
        private String resultMessage;
    
        
    
    }


}
