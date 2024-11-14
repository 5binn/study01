package com.example.pms.domain.staff.controller;

import com.example.pms.domain.staff.entity.Staff;
import com.example.pms.domain.staff.entity.StaffForm;
import com.example.pms.domain.staff.service.StaffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;


    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "name", defaultValue = "") String name,
                       @RequestParam(value = "state", defaultValue = "") String state) {
        Page<Staff> paging;
        if (state.equals("hired")) {
            paging = this.staffService.getHiredList(name, page);
        } else if (state.equals("retired")) {
            paging = this.staffService.getRetiredList(name, page);
        } else {
            paging = this.staffService.getListByName(name, page);
        }
        model.addAttribute("paging", paging);
        model.addAttribute("name", name);
        model.addAttribute("state", state);
        return "staff/list";
    }

    @GetMapping("/list/{state}")
    public String list(@PathVariable(value = "state") String state,
                       Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        if (state.equals("retired")) {
            Page<Staff> paging = this.staffService.getRetiredList(page);
            model.addAttribute("paging", paging);
            return "staff/list::#staffListCon";
        } else if (state.equals("hired")) {
            Page<Staff> paging = this.staffService.getHiredList(page);
            model.addAttribute("paging", paging);
            return "staff/list::#staffListCon";
        } else {
            Page<Staff> paging = this.staffService.getList(page);
            model.addAttribute("paging", paging);
            return "staff/list::#staffListCon";
        }
    }

    @GetMapping("/register")
    public String register(StaffForm staffForm) {
        return "staff/form";
    }

    @PostMapping("/register")
    public String register(@Valid StaffForm staffForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "staff/form";
        }
        this.staffService.register(staffForm);
        return "redirect:/staff/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("staffId") List<Long> staffId) {
        this.staffService.delete(staffId);
        return "redirect:/staff/list";
    }

}
