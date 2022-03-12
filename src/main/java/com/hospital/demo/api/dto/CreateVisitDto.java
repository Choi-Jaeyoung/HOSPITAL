package com.hospital.demo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CreateVisitDto {

    //=== Bodys ======================================================
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateVisitBody {
    
        private Long hospitalId;
        private Long patientId;
        private String visitStatus;
    
    }

    //=== Responses ======================================================
    @Getter
    @AllArgsConstructor
    @Builder
    public static class CreateVisitResponse {
    
        private String resultMessage;
    
    }


}
