package com.hospital.demo.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SearchType {
    NAME("NAME", "이름"),
    REGISTRATION("REGISTRATION", "환자등록번호"),
    BIRTH("BIRTH", "생년월일"); 

    private final String type;
    private final String desc;

}
