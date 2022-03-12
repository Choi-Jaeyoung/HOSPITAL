# 환자 관리 인터페이스

## 📄개요

- **사용기술**

> Springboot 2.6.4
h2 Database
lombok
querydsl
> 

- **기본설정**

> 포트: 8080
내부톰캣 구동 후 [http://localhost:8080/h2-console](http://localhost:8080/h2-console) 에서 DB 확인
> 

- **ERD**
    
    ![erd.png](https://user-images.githubusercontent.com/75962573/158026081-0e699228-31b4-4358-8fe3-1d0e8204d2e0.png)
    

```jsx
**※ 초기 데이터 DDL (classpath 경로의 data.sql 참고)**
INSERT INTO TB_CODE_GROUP
(CODE_GROUP,   GROUP_NAME,   GROUP_DESC)
VALUES
('성별코드',   '성별코드',   '성별을 표시'),
('방문상태코드',   '방문상태코드',   '환자방문의 상태'),
('진료과목코드',   '진료과목코드',   '진료과목'),
('진료유형코드',   '진료유형코드',   '진료의 유형');

INSERT INTO TB_CODE
(CODE_GROUP,   CODE,   CODE_NAME)
VALUES
('성별코드',   'M',   '남'),
('성별코드',   'F',   '여'),
('방문상태코드',   '1',   '방문중'),
('방문상태코드',   '2',   '종료'),
('방문상태코드',   '3',   '취소'),
('진료과목코드',   '01',   '내과'),
('진료과목코드',   '02',   '안과'),
('진료유형코드',   'D',   '약처방'),
('진료유형코드',   'T',   '검사');

INSERT INTO TB_HOSPITAL
(HOSPITAL_NAME,   HOSPITAL_CENTER_NUMBER,   HOSPITAL_HEAD_NAME)
VALUES
('A병원',   '45-123456',   '최재영'),
('B병원',   '87-658425',   '홍길동');
```

---

## ⚒️인터페이스 정의

| 기능명 | 환자 생성 
| :---: | --- 
| 요청</br>(예시) | POST    http://localhost:8080/patient</br>-H        accept: application/json</br>-d         {</br>                "hospitalId" : 2</br>               ,"patientName" : "아무개"</br>               ,"patientGender" : "M"</br>               ,"patientBirth" : "19921106"</br>               ,"patientPhone" : "01051031594”</br>             } 
| 응답</br>(예시) | {</br>    “resultMessage” : “등록 성공!”</br>} 

| 기능명 | 환자 수정 |
| --- | --- |
| 요청
(예시) | PUT       http://localhost:8080/patient/1
-H        accept: application/json
-d         {
               "patientName" : "강호동"
               ,"patientGender" : "F"
               ,"patientBirth" : "19921107"
               ,"patientPhone" : "01000000000”
             } |
| 응답
(예시) | {
    “resultMessage” : “수정 성공!”
} |

| 기능명 | 환자 삭제 |
| --- | --- |
| 요청
(예시) | DELETE http://localhost:8080/patient/1
-H        accept: application/json |
| 응답
(예시) | {
    “resultMessage” : “삭제 성공!”
} |

| 기능명 | 환자 방문 생성 |
| --- | --- |
| 요청
(예시) | POST    http://localhost:8080/visit
-H        accept: application/json
-d         {
               "hospitalId" : 2
               ,"patientId" : 1
               ,"visitStatus" : "1”
             } |
| 응답
(예시) | {
    “resultMessage” : “등록 성공!”
} |

| 기능명 | 환자 상세조회 |
| --- | --- |
| 요청
(예시) | GET    http://localhost:8080/patient/1
-H        accept: application/json |
| 응답
(예시) | {
      "patient": {
            "patientId": 1,
            "patientName": "아무개",
            "patientRegistrationNumber": "a77a4b02-ad5c",
            "patientGender": "남",
            "patientBirth": "19921106",
            "patientPhone": "01051031594",
            "hospitalId": 2,
            "hospitalName": "B병원",
            "visits": [
                  {
                        "visitId": 1,
                        "visitDate": "2022-03-13",
                        "visitStatus": "방문중",
                        "hospitalId": 2,
                        "hospitalName": "B병원"
                  }
            ]
      }
} |

| 기능명 | 환자 생성 |
| --- | --- |
| 요청
(예시) | GET       http://localhost:8080/patients?searchType=NAME&keyword=아무&pageSize=10&pageNo=1
-H        accept: application/json

※ searchType : NAME(이름) / REGISTRATION(환자등록번호) / BIRTH(생년월일) |
| 응답
(예시) | {
      "patients": [
            {
                  "patientId": 1,
                  "patientName": "아무개",
                  "patientRegistrationNumber": "a77a4b02-ad5c",
                  "patientGender": "남",
                  "patientBirth": "19921106",
                  "patientPhone": "01051031594",
                  "lastVisitDate": "2022-03-13"
            }
      ]
} |
