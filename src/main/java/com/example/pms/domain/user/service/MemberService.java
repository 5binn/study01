package com.example.pms.domain.user.service;


import com.example.pms.domain.user.entity.Member;
import com.example.pms.domain.user.entity.MemberForm;
import com.example.pms.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(MemberForm memberForm) {
        Member member = Member.builder()
                .username(memberForm.getUsername())
                .password(passwordEncoder.encode(memberForm.getPassword()))
                .build();
        memberRepository.save(member);
    }
}

