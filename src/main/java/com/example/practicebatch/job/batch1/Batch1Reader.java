package com.example.practicebatch.job.batch1;

import com.example.practicebatch.dao.ScoreDao;
import com.example.practicebatch.entity.Score;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.stream.Stream;

@Component
@Slf4j
public class Batch1Reader extends AbstractItemCountingItemStreamItemReader<Score> implements ItemReader<Score> {

    private final ScoreDao scoreDao;

    private Stream<Score> stream;

    private Iterator<Score> iterator;

    public Batch1Reader(ScoreDao scoreDao) {

        super.setName(this.getClass().getSimpleName());
        this.scoreDao = scoreDao;
    }

    @Override
    protected Score doRead() {
        if(iterator.hasNext()) return iterator.next();
        return null;
    }

    @Override
    protected void doOpen() {
        stream = scoreDao.selectScoreInfo(2);
        iterator = stream.iterator();
    }

    @Override
    protected void doClose() {
        stream.close();
    }

}
