package com.example.pms.domain.staff.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class StaffForm {
    @NotEmpty(message = "이름을 입력하세요.")
    private String name; //이름

    @NotNull(message = "주민번호를 입력하세요.")
    @Size(min = 13, max = 13, message = "주민등록번호 13자리를 입력하세요.")
    private String personalNum; //주민번호

    @NotEmpty(message = "주소 입력하세요.")
    private String address; //주소

    @NotEmpty(message = "부서를 선택하세요.")
    private String dept; //부서

    private String role; //직위

    @NotEmpty(message = "은행을 선택하세요.")
    private String bank; //은행명

    @NotNull(message = "계좌를 입력하세요.")
    private String account; //계좌

    @NotNull(message = "연락처를 입력하세요.")
    @Size(min = 10, max = 11, message = "연락처를 확인해주세요.")
    private String mobileNum; //연락처

    @NotEmpty(message = "이메일을 입력하세요.")
    private String email; //이메일

    @NotNull(message = "입사일을 선택하세요.")
    private LocalDate startDate; //입사일

    private LocalDate endDate; //퇴사일
}
