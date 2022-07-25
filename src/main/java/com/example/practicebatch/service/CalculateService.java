package com.example.practicebatch.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    public Integer getSumScore(Integer mathScore, Integer englishScore) {
        return mathScore+englishScore;
    }

    public Integer getAverageScore(Integer mathScore, Integer englishScore) {
        return (mathScore+englishScore) / 2;
    }

}
