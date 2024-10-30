package com.project.tailsroute.controller;

import com.project.tailsroute.service.WebPushService;
import com.project.tailsroute.vo.Rq;
import nl.martijndwars.webpush.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebPushController {
    private final Rq rq;
    public WebPushController(Rq rq) {
        this.rq = rq;
    }

    @Value("${Public_Key}")
    private String PUBLIC_KEY;

    @Value("${Private_Key}")
    private String PRIVATE_KEY;

    @Autowired
    private WebPushService webPushService;

    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribe(@RequestBody Subscription subscription) {
        System.err.println("컨트롤러 실행됨");
        System.err.println("구독 정보: " + subscription);

        try {
            int memberId = rq.getLoginedMemberId();
            webPushService.saveSubscription(memberId, subscription); // 리포지토리에 구독 정보 저장
            return ResponseEntity.ok("Subscribed successfully");
        } catch (Exception e) {
            e.printStackTrace(); // 예외 스택 추적 출력
            System.err.println("오류 메시지: " + e.getMessage()); // 오류 메시지 추가 출력
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Subscription failed");
        }
    }


    @GetMapping("/subscribe")
    public String test1(Model model) {
        model.addAttribute("PUBLIC_KEY", PUBLIC_KEY);
        return "usr/missing/WebPush";
    }
}
