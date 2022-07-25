package com.example.practicebatch.Batch1.localdb;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


/*
    Jobを一括でテストする時。
    データソースは実体ソース側のapplication.ymlをそのまま使用する。
 */
@RunWith(SpringRunner.class) // SpringBootTestでJunitを使う。という宣言
@SpringBootTest
@SpringBatchTest
@TestPropertySource(properties = "JOB_NAME=batch1") // JobConfigurationに二つ以上のJobがある時は明示しないといけない。
public class Batch1JobTest {

    // TestConfig.javaクラスを作ってAutowiredするように実装
    // Intellijではエラーに表示されるが、問題はない。
    @Autowired
    JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    void jobTest() throws Exception {
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        Assert.assertEquals(jobExecution.getStatus(), BatchStatus.COMPLETED);

    }
}
