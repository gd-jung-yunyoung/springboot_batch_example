package com.example.practicebatch.job.batch1;

import com.example.practicebatch.entity.Score;
import com.example.practicebatch.record.Batch1Result;
import com.example.practicebatch.service.CalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class Batch1Processor implements ItemProcessor<Score, Batch1Result> {

    private final CalculateService calculateService;

    public Batch1Processor(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @Override
    public Batch1Result process(Score score) throws Exception {

        Integer mathScore = score.getMathScore();
        Integer englishScore = score.getEnglishScore();

        Integer sumScore = calculateService.getSumScore(mathScore, englishScore);

        return new Batch1Result(sumScore);
    }
}
