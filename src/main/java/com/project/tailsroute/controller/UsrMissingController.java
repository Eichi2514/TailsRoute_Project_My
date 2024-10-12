package com.project.tailsroute.controller;

import com.project.tailsroute.service.MissingService;
import com.project.tailsroute.vo.Member;
import com.project.tailsroute.vo.Rq;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UsrMissingController {
    private final Rq rq;

    public UsrMissingController(Rq rq) {
        this.rq = rq;
    }


    @Autowired
    private MissingService missingService;

    @GetMapping("/usr/missing/write")
    public String showWrite(Model model) {
        boolean isLogined = rq.isLogined();

        if (isLogined) {
            Member member = rq.getLoginedMember();
            model.addAttribute("member", member);
        }

        model.addAttribute("isLogined", isLogined);

        return "/usr/missing/write";
    }


    @PostMapping("/usr/missing/write")
    public String write(@RequestParam("name") String name, @RequestParam("reportDate") String reportDate, @RequestParam("reportTime") String reportTime, @RequestParam("missingLocation") String missingLocation, @RequestParam("breed") String breed,
                        @RequestParam("color") String color, @RequestParam("gender") String gender, @RequestParam(value = "age", required = false) Integer age, @RequestParam(value = "RFID", required = false) String RFID,
                        @RequestParam("dog_photo") MultipartFile file, @RequestParam("trait") String trait) {

        boolean isLogined = rq.isLogined();

        String reportDate2 = reportDate + " " + reportTime;

        String age2 = "모름";
        if (age != null) age2 = Integer.toString(age);


        // 파일 처리 로직
        String photoPath = null;
        if (!file.isEmpty()) {
            int number = missingService.lastNumber(); // 데이터베이스에서 가져온 마지막 ID
            number++;

            String filePath = "src/main/resources/static/resource/photo/missing" + number + ".png";
            try {
                // 파일 저장 전에 이미지 크기 조절
                Thumbnails.of(file.getInputStream()).size(80, 80) // 원하는 사이즈로 조정
                        .toFile(new File(filePath));

                photoPath = "/resource/photo/missing" + number + ".png"; // 웹에서 접근할 수 있는 경로
            } catch (IOException e) {
                return "redirect:/usr/dog/add";
            }
        }

        // 데이터베이스에 반려견 정보 저장
        missingService.write(rq.getLoginedMemberId(), name, reportDate2, missingLocation, breed, color, gender, age2, RFID, photoPath, trait);

        return "redirect:/usr/home/main"; // 메인 페이지로 리다이렉트
    }

}
