package com.example.practicebatch.job.config;

import com.example.practicebatch.entity.Score;
import com.example.practicebatch.job.batch1.Batch1Processor;
import com.example.practicebatch.job.batch1.Batch1Reader;
import com.example.practicebatch.job.batch1.Batch1Writer;
import com.example.practicebatch.job.batch2.Batch2Processor;
import com.example.practicebatch.job.batch2.Batch2Reader;
import com.example.practicebatch.job.batch2.Batch2Writer;
import com.example.practicebatch.record.Batch1Result;
import com.example.practicebatch.record.Batch2Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration

public class JobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    @ConditionalOnProperty(name = "JOB_NAME", havingValue = "batch1")
    public Job batch1Job(Step batch1Process) {
        return jobBuilderFactory.get("batch1")
                .incrementer(new RunIdIncrementer())
                .start(batch1Process)
                .build();
    }

    @Bean
    public Step batch1Process(Batch1Reader reader, Batch1Processor processor, Batch1Writer writer) {
        return stepBuilderFactory.get("batch1-result")
                .<Score, Batch1Result> chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    @ConditionalOnProperty(name = "JOB_NAME", havingValue = "batch2")
    public Job batch2Job(Step batch2Process) {
        return jobBuilderFactory.get("batch2")
                .incrementer(new RunIdIncrementer())
                .start(batch2Process)
                .build();
    }

    @Bean
    public Step batch2Process(Batch2Reader reader, Batch2Processor processor, Batch2Writer writer) {
        return stepBuilderFactory.get("batch2-result")
                .<Score, Batch2Result> chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
