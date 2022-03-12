package com.hospital.demo.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TB_CODE")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CodeEntity {


    // ----------------- ID
    @Id
    @Column(name = "CODE", length = 10)
    private String code;


    // ----------------- Columns
    @Column(name = "CODE_NAME", nullable = false, length = 10)
    private String codeName;


    // ----------------- Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODE_GROUP", nullable = false)
    private CodeGroupEntity codeGroup;




}
