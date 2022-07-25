package com.example.practicebatch.job.batch2;

import com.example.practicebatch.record.Batch2Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class Batch2Writer implements ItemWriter<Batch2Result> {


    @Override
    public void write(List<? extends Batch2Result> resultList) throws Exception {

        for (Batch2Result result : resultList) {
            System.out.println(result.averageScore());
        }

    }
}
