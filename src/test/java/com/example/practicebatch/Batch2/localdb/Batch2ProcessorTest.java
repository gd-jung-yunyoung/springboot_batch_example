package com.example.practicebatch.Batch2.localdb;

import com.example.practicebatch.entity.Score;
import com.example.practicebatch.job.batch2.Batch2Processor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBatchTest
@TestPropertySource(properties = "JOB_NAME=batch2")
public class Batch2ProcessorTest {

    /*
        Processorのみテストする時。
        Processor側が受け取るObject（このソースの場合Score)を
        テスト用として作成して、それをprocessor.process(score)形で渡す。
     */
    @Autowired
    Batch2Processor processor;

    @Test
    void stepTest() throws Exception {

        Score score = Score.builder()
                .id(10L)
                .mathScore(10)
                .englishScore(10)
                .build();

        Integer expected = 10;
        Integer actual = processor.process(score).averageScore();

        Assert.assertEquals(expected, actual);

    }
}
