package com.project.tailsroute.service;

import com.project.tailsroute.repository.DogRepository;
import com.project.tailsroute.repository.MissingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissingService {
    @Autowired
    private MissingRepository missingRepository;

    public int lastNumber() {
        Integer number = missingRepository.lastNumber();
        return (number != null) ? number : 0; // null일 경우 0을 반환
    }

    public void write(int loginedMemberId, String name, String reportDate, String missingLocation, String breed, String color, String gender, String age, String rfid, String photoPath, String trait) {
        missingRepository.write(loginedMemberId, name, reportDate, missingLocation, breed, color, gender, age, rfid, photoPath, trait);
    }
}
