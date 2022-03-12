package com.hospital.demo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UpdatePatientDto {

    //=== Bodys ======================================================
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdatePatientBody {
    
        private Long patientId;
        private String patientName;
        private String patientGender;
        private String patientBirth;
        private String patientPhone;
    
    }

    
    //=== Responses ======================================================
    @Getter
    @AllArgsConstructor
    @Builder
    public static class UpdatePatientResponse {
    
        private String resultMessage;
    
    }


}
