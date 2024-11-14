package com.example.pms.global;


import com.example.pms.domain.staff.entity.Staff;
import com.example.pms.domain.staff.repository.StaffRepository;
import com.example.pms.domain.staff.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class InitData implements InitializingBean {

    private final StaffService staffService;
    private final StaffRepository staffRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    public void init() {
        Staff staff1 = Staff.builder()
                .name("홍길동")
                .personalNum("800621-1221313")
                .address("서울어딘가")
                .dept("개발부")
                .role("과장")
                .bank("농협")
                .account("20-91238-0123")
                .mobileNum("010-1234-1243")
                .email("asdasd@asdasd")
                .startDate(LocalDate.now())
                .endDate(null)
                .build();
        staffRepository.save(staff1);
        Staff staff2 = Staff.builder()
                .name("홍길순")
                .personalNum("800621-1221313")
                .address("서울어딘가")
                .dept("개발부")
                .role("과장")
                .bank("농협")
                .account("20-91238-0123")
                .mobileNum("010-1234-1243")
                .email("asdasd@asdasd")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusMonths(1))
                .build();
        staffRepository.save(staff2);
        Staff staff3 = Staff.builder()
                .name("홍길짱")
                .personalNum("800621-3211313")
                .address("서울어딘가")
                .dept("영업부")
                .role("사원")
                .bank("농협")
                .account("20-91238-0123")
                .mobileNum("010-1234-1243")
                .email("aaaa@asdasd")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusMonths(4))
                .build();
        staffRepository.save(staff3);
        Staff staff4 = Staff.builder()
                .name("홍장동")
                .personalNum("950121-1221313")
                .address("서울어딘가")
                .dept("개발부")
                .role("사원")
                .bank("농협")
                .account("20-91238-0123")
                .mobileNum("010-1234-1243")
                .email("asssW@asdasd")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusMonths(1))
                .build();
        staffRepository.save(staff4);
        Staff staff5 = Staff.builder()
                .name("박길순")
                .personalNum("890621-1221313")
                .address("서울어딘가")
                .dept("관리")
                .role("대리")
                .bank("농협")
                .account("20-91238-0123")
                .mobileNum("010-1234-1243")
                .email("asdd@asdasdsas")
                .startDate(LocalDate.now())
                .endDate(null)
                .build();
        staffRepository.save(staff5);

    }
}
