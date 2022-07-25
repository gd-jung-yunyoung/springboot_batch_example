package com.example.practicebatch.job.batch1;

import com.example.practicebatch.record.Batch1Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class Batch1Writer implements ItemWriter<Batch1Result> {


    @Override
    public void write(List<? extends Batch1Result> resultList) throws Exception {

        for (Batch1Result result : resultList) {
            System.out.println(result.sumScore());
        }

    }
}
