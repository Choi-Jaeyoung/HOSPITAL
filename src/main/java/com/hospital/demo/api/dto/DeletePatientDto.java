package com.hospital.demo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class DeletePatientDto {
    

    //=== Responses ======================================================
    @Getter
    @AllArgsConstructor
    @Builder
    public static class DeletePatientResponse {
    
        private String resultMessage;
    
    }


}
