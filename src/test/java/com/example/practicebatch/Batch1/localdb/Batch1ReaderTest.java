package com.example.practicebatch.Batch1.localdb;

import com.example.practicebatch.job.batch1.Batch1Reader;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.step.NoWorkFoundStepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBatchTest
@TestPropertySource(properties = "JOB_NAME=batch1")
public class Batch1ReaderTest {


    /*
        Reader側のみテストする時
     */

    @Autowired
    Batch1Reader reader;


    @Test
    void stepTest() throws Exception {

        reader.open(new ExecutionContext());
        System.out.println(reader.read().getEnglishScore());
        System.out.println(reader.read().getMathScore());

    }
}
