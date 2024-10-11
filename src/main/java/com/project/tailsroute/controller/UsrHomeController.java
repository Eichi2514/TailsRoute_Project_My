package com.project.tailsroute.controller;

import com.project.tailsroute.vo.Member;
import com.project.tailsroute.vo.Rq;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsrHomeController {
    private final Rq rq;

    public UsrHomeController(Rq rq) {
        this.rq = rq;
    }

    @GetMapping("/usr/home/main")
    public String showMain(Model model) {
        boolean isLogined = rq.isLogined();

        if (isLogined) {
            Member member = rq.getLoginedMember();
            model.addAttribute("member", member);
        }

        model.addAttribute("isLogined", isLogined);
        return "usr/home/main";
    }
}
