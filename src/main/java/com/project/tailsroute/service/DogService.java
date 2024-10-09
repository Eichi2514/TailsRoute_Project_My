package com.project.tailsroute.service;

import com.project.tailsroute.repository.DogRepository;
import com.project.tailsroute.repository.MemberRepository;
import com.project.tailsroute.vo.Dog;
import com.project.tailsroute.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

}
