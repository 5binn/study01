package com.example.pms.domain.staff.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //사원번호
    private String name; //이름
    private String personalNum; //주민번호
    private String address; //주소
    private String dept; //부서
    private String role; //직위
    private String bank; //은행명
    private String account; //계좌
    private String mobileNum; //연락처
    private String email; //이메일
    private LocalDate startDate; //입사일
    private LocalDate endDate; //퇴사일
}
