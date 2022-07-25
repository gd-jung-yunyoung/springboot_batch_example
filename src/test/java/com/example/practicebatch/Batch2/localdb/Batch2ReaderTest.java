package com.example.practicebatch.Batch2.localdb;

import com.example.practicebatch.job.batch2.Batch2Reader;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBatchTest
@TestPropertySource(properties = "JOB_NAME=batch2")
public class Batch2ReaderTest {


    /*
        Reader側のみテストする時
     */

    @Autowired
    Batch2Reader reader;


    @Test
    void stepTest() throws Exception {

        reader.open(new ExecutionContext());
        System.out.println(reader.read().getEnglishScore());
        System.out.println(reader.read().getMathScore());

    }
}
