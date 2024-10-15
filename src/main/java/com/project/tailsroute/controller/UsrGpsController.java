package com.project.tailsroute.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
public class UsrGpsController {

    @PostMapping("/usr/send/gps")
    public ResponseEntity<String> receiveGps(
            @RequestParam String phone,
            @RequestParam double latitude,
            @RequestParam double longitude) {

        // GPS 정보 저장 또는 처리 로직
        System.out.println("Received GPS data: Phone = " + phone +
                ", Latitude = " + latitude +
                ", Longitude = " + longitude);

        // 예시: GPS 데이터를 데이터베이스에 저장하거나 다른 작업 수행
        return ResponseEntity.ok("GPS 정보 수신 완료!");
    }
}
