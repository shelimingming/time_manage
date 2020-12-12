package com.mj.time.service.impl;

import com.mj.time.domain.Record;
import com.mj.time.mapper.RecordMapper;
import com.mj.time.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class RecordServiceImpl implements RecordService
{
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public List<Record> selectRecord(Integer userId, Date beginTime, Date endTime, Integer tagId) {
        HashMap map = new HashMap();
        map.put("userId",userId);
        if(beginTime!=null){
            map.put("beginTime",beginTime);
        }
        if(endTime!=null){
            map.put("endTime",endTime);
        }
        if(tagId!=null){
            map.put("tagId",tagId);
        }
        List<Record> recordList = recordMapper.selectByMap(map);
        return recordList;
    }

    @Override
    public void addRecord(Record record) {
        record.setCreateTime(new Date());
        record.setModifyTime(new Date());
        int insert = recordMapper.insert(record);
    }
}
