package com.hospital.demo.data.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hospital.demo.code.SearchType;
import com.hospital.demo.data.entity.PatientEntity;
import com.hospital.demo.data.entity.QPatientEntity;
import com.querydsl.jpa.impl.JPAQuery;

import org.springframework.stereotype.Repository;

@Repository
public class PatientQueryRepository {
    
    @PersistenceContext
    private EntityManager em;

    public List<PatientEntity> searchPatient(
        SearchType searchType
        ,   String keyword
        ,   Long pageSize
        ,   Long pageNo
    ) {

        List<PatientEntity> patients = new ArrayList<>();

        JPAQuery<PatientEntity> query = new JPAQuery<>(em);
        QPatientEntity patient = QPatientEntity.patientEntity;

        patients = query.from(patient)
            .where(
                (
                    SearchType.NAME.equals(searchType)
                    &&  !"".equals(keyword)
                    ?   patient.patientName.contains(keyword)
                    :   null
                ),
                (
                    SearchType.BIRTH.equals(searchType)
                    &&  !"".equals(keyword)
                    ?   patient.patientBirth.contains(keyword)
                    :   null
                ),
                (
                    SearchType.REGISTRATION.equals(searchType)
                    &&  !"".equals(keyword)
                    ?   patient.patientRegistrationNumber.contains(keyword)
                    :   null
                )
            )
            .limit(pageSize)
            .offset((pageNo-1)*pageSize)
            .fetch();

        return patients;

    }

}
