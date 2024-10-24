package com.project.tailsroute.controller;

import com.project.tailsroute.repository.GpsAlertRepository;
import com.project.tailsroute.service.DogService;
import com.project.tailsroute.service.GpsAlertService;
import com.project.tailsroute.service.MemberService;
import com.project.tailsroute.util.Ut;
import com.project.tailsroute.vo.Dog;
import com.project.tailsroute.vo.GpsAlert;
import com.project.tailsroute.vo.Member;
import com.project.tailsroute.vo.Rq;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsrMemberController {

    @Value("${GOOGLE_MAP_API_KEY}")
    private String API_KEY;

    private final Rq rq;

    public UsrMemberController(Rq rq) {
        this.rq = rq;
    }

    @Autowired
    private MemberService memberService;

    @Autowired
    private DogService dogService;

    @Autowired
    private GpsAlertService gpsAlertService;

    @GetMapping("/usr/member/login")
    public String showMain(Model model) {
        boolean isLogined = rq.isLogined();

        if (isLogined) {
            Member member = rq.getLoginedMember();
            model.addAttribute("member", member);
        }

        model.addAttribute("isLogined", isLogined);

        return "usr/member/login";
    }

    @PostMapping("/usr/member/doLogin")
    @ResponseBody // 로그인 결과를 JSON 형태로 반환
    public String doLogin(HttpServletRequest req, @RequestParam("loginId") String loginId, @RequestParam("loginPw") String loginPw) {

        System.err.println(loginId);

        if (Ut.isEmptyOrNull(loginId)) {
            return Ut.jsHistoryBack("F-1", "loginId 입력 x");
        }
        if (Ut.isEmptyOrNull(loginPw)) {
            return Ut.jsHistoryBack("F-2", "loginPw 입력 x");
        }

        Member member = memberService.getMemberByLoginId(loginId);
        if (member == null) {
            return Ut.jsHistoryBack("F-3", Ut.f("%s는(은) 존재 x", loginId));
        }

        if (member.getLoginPw().equals(loginPw) == false) {
            return Ut.jsHistoryBack("F-4", Ut.f("비밀번호 틀림"));
        }

        rq.login(member);

        return Ut.jsReplace("S-1", Ut.f("%s님 환영합니다", member.getNickname()), "/usr/home/main");
    }

    @RequestMapping("/usr/member/doLogout")
    @ResponseBody
    public String doLogout(HttpServletRequest req) {

        rq.logout();

        return Ut.jsReplace("S-1", Ut.f("로그아웃 되었습니다"), "/usr/home/main");
    }

    @GetMapping("/usr/member/myPage")
    public String showMyPage(Model model) {
        boolean isLogined = rq.isLogined();

        if (isLogined) {
            Member member = rq.getLoginedMember();
            model.addAttribute("member", member);
        }

        Dog dog = dogService.getDogfile(rq.getLoginedMemberId());

        boolean locationChack;

        if (dog != null) {
        GpsAlert gpsAlert = gpsAlertService.getGpsAlert(dog.getId());
            if (gpsAlert == null) {
                locationChack = false;
            }else {
                locationChack = true;

                String location = gpsAlertService.getPlaceName(gpsAlert.getLatitude(), gpsAlert.getLongitude());
                location = location.substring(5);
                model.addAttribute("location", location);
            }
            model.addAttribute("locationChack", locationChack);
        }

        model.addAttribute("isLogined", isLogined);
        model.addAttribute("dog", dog);

        return "usr/member/myPage";
    }
}
