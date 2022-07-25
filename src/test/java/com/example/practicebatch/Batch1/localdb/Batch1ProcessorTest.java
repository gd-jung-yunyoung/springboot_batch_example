package com.example.practicebatch.Batch1.localdb;

import com.example.practicebatch.entity.Score;
import com.example.practicebatch.job.batch1.Batch1Processor;
import com.example.practicebatch.job.batch1.Batch1Reader;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBatchTest
@TestPropertySource(properties = "JOB_NAME=batch1")
public class Batch1ProcessorTest {

    /*
        Processorのみテストする時。
        Processor側が受け取るObject（このソースの場合Score)を
        テスト用として作成して、それをprocessor.process(score)形で渡す。
     */
    @Autowired
    Batch1Processor processor;

    @Test
    void stepTest() throws Exception {

        Score score = Score.builder()
                .id(10L)
                .mathScore(10)
                .englishScore(10)
                .build();

        Integer expected = 20;
        Integer actual = processor.process(score).sumScore();

        Assert.assertEquals(expected, actual);

    }
}
