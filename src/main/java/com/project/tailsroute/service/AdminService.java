package com.project.tailsroute.service;

import com.project.tailsroute.repository.AdminRepository;
import com.project.tailsroute.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public void initData() {
        adminRepository.initData();
    }
}