package com.project.tailsroute.vo;

import java.io.IOException;

import com.project.tailsroute.service.MemberService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Rq {

    @Getter
    private boolean isLogined;
    @Getter
    private int loginedMemberId;
    @Getter
    private Member loginedMember;

    private HttpServletRequest req;
    private HttpServletResponse resp;

    private HttpSession session;

    public Rq(HttpServletRequest req, HttpServletResponse resp, MemberService memberService) {
        this.req = req;
        this.resp = resp;
        this.session = req.getSession();

        HttpSession httpSession = req.getSession();

        if (httpSession.getAttribute("loginedMemberId") != null) {
            isLogined = true;
            loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
            loginedMember = memberService.getMemberById(loginedMemberId);
        }
        this.req.setAttribute("rq", this);
    }

    public void logout() {
        session.removeAttribute("loginedMemberId");
        session.removeAttribute("loginedMember");

    }

    public void login(Member member) {
        session.setAttribute("loginedMemberId", member.getId());
        session.setAttribute("loginedMember", member);

    }

    public void initBeforeActionInterceotor() {
        System.err.println("Rq 실행");

    }

    public String getCurrentUri() {
        String currentUri = req.getRequestURI();
        String queryString = req.getQueryString();

        if (currentUri != null && queryString != null) {
            currentUri += "?" + queryString;
        }

        return currentUri;
    }
}
