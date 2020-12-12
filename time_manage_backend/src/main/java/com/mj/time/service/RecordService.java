package com.mj.time.service;

import com.mj.time.domain.Record;

import java.util.Date;
import java.util.List;

public interface RecordService {
    List<Record> selectRecord(Integer userId, Date beginTime, Date endTime, Integer tagId);

    void addRecord(Record record);
}
