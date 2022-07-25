package com.example.practicebatch.job.batch2;

import com.example.practicebatch.entity.Score;
import com.example.practicebatch.record.Batch1Result;
import com.example.practicebatch.record.Batch2Result;
import com.example.practicebatch.service.CalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class Batch2Processor implements ItemProcessor<Score, Batch2Result> {

    private final CalculateService calculateService;

    public Batch2Processor(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @Override
    public Batch2Result process(Score score) throws Exception {

        Integer mathScore = score.getMathScore();
        Integer englishScore = score.getEnglishScore();

        Integer averageScore = calculateService.getAverageScore(mathScore, englishScore);

        return new Batch2Result(averageScore);
    }
}
