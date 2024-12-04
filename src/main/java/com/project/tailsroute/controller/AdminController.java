package com.project.tailsroute.controller;

import com.project.tailsroute.service.AdminService;
import com.project.tailsroute.service.MemberService;
import com.project.tailsroute.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/admin/init/data")
    public String initData() {

        boolean member = memberService.isMemberExist();

        if(!member) {
            adminService.initData();
        }

        return "redirect:usr/home/main2";
    }
}
