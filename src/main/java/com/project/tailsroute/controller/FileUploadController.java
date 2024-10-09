package com.project.tailsroute.controller;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class FileUploadController {
    @PostMapping
    public String handleFileUpload(@RequestParam("dog_photo") MultipartFile file) {
        // 파일 처리 로직
        if (!file.isEmpty()) {
            String filePath = "src/main/resources/static/resource/poto/" + file.getOriginalFilename();
            try {
                // 파일 저장 전에 이미지 크기 조절
                Thumbnails.of(file.getInputStream())
                        .size(80, 80) // 원하는 사이즈로 조정
                        .toFile(new File(filePath));

                return "파일 업로드 성공!";
            } catch (IOException e) {
                return "파일 업로드 실패: " + e.getMessage();
            }
        }
        return "파일이 비어 있습니다.";
    }
}
