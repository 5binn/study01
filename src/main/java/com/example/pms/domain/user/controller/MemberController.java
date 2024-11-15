package com.example.pms.domain.user.controller;

import com.example.pms.domain.user.entity.MemberForm;
import com.example.pms.domain.user.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/create")
    public String create(MemberForm memberForm) {
        return "member/form";
    }

    @PostMapping("/create")
    public String create(@Valid MemberForm memberForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/form";
        }
        if (!memberForm.getPassword().equals(memberForm.getPwChk())) {
            bindingResult.rejectValue("pwChk", "PWINCORRECT", "두 비밀번호가 일치하지 않습니다.");
            return "member/form";
        }
        try {
            memberService.create(memberForm);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }
        return "redirect:/login";
    }
}
