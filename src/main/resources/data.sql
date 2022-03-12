INSERT INTO TB_CODE_GROUP
    (
        CODE_GROUP
        ,   GROUP_NAME
        ,   GROUP_DESC
    )
    VALUES
    (
        '성별코드'
        ,   '성별코드'
        ,   '성별을 표시'
    ),
    (
        '방문상태코드'
        ,   '방문상태코드'
        ,   '환자방문의 상태'
    ),
    (
        '진료과목코드'
        ,   '진료과목코드'
        ,   '진료과목'
    ),
    (
        '진료유형코드'
        ,   '진료유형코드'
        ,   '진료의 유형'
    );

INSERT INTO TB_CODE
    (
        CODE_GROUP
        ,   CODE
        ,   CODE_NAME
    )
    VALUES
    (
        '성별코드'
        ,   'M'
        ,   '남'
    ),
    (
        '성별코드'
        ,   'F'
        ,   '여'
    ),
    (
        '방문상태코드'
        ,   '1'
        ,   '방문중'
    ),
    (
        '방문상태코드'
        ,   '2'
        ,   '종료'
    ),
    (
        '방문상태코드'
        ,   '3'
        ,   '취소'
    ),
    (
        '진료과목코드'
        ,   '01'
        ,   '내과'
    ),
    (
        '진료과목코드'
        ,   '02'
        ,   '안과'
    ),
    (
        '진료유형코드'
        ,   'D'
        ,   '약처방'
    ),
    (
        '진료유형코드'
        ,   'T'
        ,   '검사'
    );

INSERT INTO TB_HOSPITAL
    (
        HOSPITAL_NAME
        ,   HOSPITAL_CENTER_NUMBER
        ,   HOSPITAL_HEAD_NAME
    )
    VALUES
    (
        'A병원'
        ,   '45-123456'
        ,   '최재영'
    )
    ,   
    (
        'B병원'
        ,   '87-658425'
        ,   '홍길동'
    );