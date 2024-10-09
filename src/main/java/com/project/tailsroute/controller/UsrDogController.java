package com.project.tailsroute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsrDogController {

    @GetMapping("/usr/dog/add")
    public String showAdd(Model model) {
        return "/usr/dog/add";
    }
}
