package com.example.practicebatch.dao;

import com.example.practicebatch.config.FirstDbConfig;
import com.example.practicebatch.entity.Score;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.Suppress;
import org.seasar.doma.message.Message;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Dao
@FirstDbConfig
@Component
public interface ScoreDao {

    @Select
    @Suppress(messages = Message.DOMA4274)
    Stream<Score> selectScoreInfo(Integer size);
}
