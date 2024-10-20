package com.project.tailsroute.service;

import com.project.tailsroute.repository.DeterminedLocationRepository;
import com.project.tailsroute.vo.DeterminedLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeterminedLocationService {

    @Autowired
    DeterminedLocationRepository determinedLocationRepository;


    public List<DeterminedLocation> All() {
        return determinedLocationRepository.All();
    }
}
