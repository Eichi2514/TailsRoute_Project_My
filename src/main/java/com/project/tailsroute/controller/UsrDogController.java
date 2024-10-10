package com.project.tailsroute.controller;

import com.project.tailsroute.service.DogService;
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
public class UsrDogController {


    @Autowired
    private DogService dogService;

    @GetMapping("/usr/dog/add")
    public String showAdd(Model model) {
        return "/usr/dog/add";
    }


    @PostMapping("/usr/dog/upload")
    public String upload(@RequestParam("dog_name") String dogName, @RequestParam(value = "dog_weight", required = false) Double dogWeight, @RequestParam("dog_type") String dogType, @RequestParam("dog_photo") MultipartFile file) {

        // 파일 처리 로직
        String photoPath = null;
        if (!file.isEmpty()) {
            int number = dogService.dogNumber(); // 데이터베이스에서 가져온 마지막 ID
            number++;

            String filePath = "src/main/resources/static/resource/dogAdd/photo" + number + ".png";
            try {
                // 파일 저장 전에 이미지 크기 조절
                Thumbnails.of(file.getInputStream()).size(80, 80) // 원하는 사이즈로 조정
                        .toFile(new File(filePath));

                photoPath = "/resource/dogAdd/photo" + number + ".png"; // 웹에서 접근할 수 있는 경로
            } catch (IOException e) {
                return "redirect:/usr/dog/add";
            }
        }

        // 데이터베이스에 반려견 정보 저장
        dogService.upload(1, dogName, dogWeight, dogType, photoPath);

        return "redirect:/usr/home/main"; // 메인 페이지로 리다이렉트
    }

}
