package com.hospital.demo.api.controller;

import com.hospital.demo.api.dto.CreateVisitDto.CreateVisitBody;
import com.hospital.demo.api.dto.CreateVisitDto.CreateVisitResponse;
import com.hospital.demo.business.service.VisitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitController {

    @Autowired
    private VisitService visitService;

    

    @PostMapping(value = "/visit")
    public CreateVisitResponse createVisit(
        @RequestBody
        CreateVisitBody requestBody
    ) {
    
        Long hospitalId = requestBody.getHospitalId();
        Long patientId = requestBody.getPatientId();
        String visitStatus = requestBody.getVisitStatus();

        CreateVisitResponse createVisitResponse = null;

        visitService.createVisit(hospitalId, patientId, visitStatus);

        createVisitResponse = CreateVisitResponse.builder()
            .resultMessage("등록 성공!")
            .build();

        return createVisitResponse;
    
    }

}
