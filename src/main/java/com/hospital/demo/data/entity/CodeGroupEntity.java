package com.hospital.demo.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TB_CODE_GROUP")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CodeGroupEntity {


    // ----------------- ID
    @Id
    @Column(name = "CODE_GROUP", length = 10)
    private String codeGroup;


    // ----------------- Columns
    @Column(name = "GROUP_NAME", nullable = false, length = 10)
    private String groupName;

    @Column(name = "GROUP_DESC", nullable = false, length = 10)
    private String groupDesc;


}   
