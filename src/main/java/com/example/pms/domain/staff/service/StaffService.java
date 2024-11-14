package com.example.pms.domain.staff.service;


import com.example.pms.domain.staff.entity.Staff;
import com.example.pms.domain.staff.entity.StaffForm;
import com.example.pms.domain.staff.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StaffService {
    private final StaffRepository staffRepository;

    public Page<Staff> getListByName(String name, int page) {
        Pageable pageable = PageRequest.of(page, 6, changeDesc());
        return staffRepository.findByName(name, pageable);
    }

    public Page<Staff> getRetiredList(String name,int page) {
        Pageable pageable = PageRequest.of(page, 6, changeDesc());
        return staffRepository.findByNameAndEndDateNotNull(name,pageable);
    }

    public Page<Staff> getHiredList(String name,int page) {
        Pageable pageable = PageRequest.of(page, 6, changeDesc());
        return staffRepository.findByNameAndEndDateIsNull(name, pageable);
    }

    public Sort changeDesc() {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("id"));
        return Sort.by(sorts);
    }

    public void register(StaffForm staffForm) {
        Staff staff = Staff.builder()
                .name(staffForm.getName())
                .personalNum(staffForm.getPersonalNum().substring(0, 6) + "-"
                        + staffForm.getPersonalNum().substring(6))
                .address(staffForm.getAddress())
                .dept(staffForm.getDept())
                .role(staffForm.getRole())
                .bank(staffForm.getBank())
                .account(staffForm.getAccount())
                .mobileNum(staffForm.getMobileNum().substring(0, 3) + "-"
                        + staffForm.getMobileNum().substring(3, 7) + "-"
                        + staffForm.getMobileNum().substring(7))
                .email(staffForm.getEmail())
                .startDate(staffForm.getStartDate())
                .build();
        staffRepository.save(staff);
    }

    public void delete(List<Long> staffId) {
        staffRepository.deleteAllById(staffId);
    }

}
