package com.project.tailsroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.tailsroute.repository.MemberRepository;
import com.project.tailsroute.vo.Member;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member getMemberById(int id) {
        return memberRepository.getMemberById(id);
    }
}
