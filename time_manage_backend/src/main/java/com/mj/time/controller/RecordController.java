package com.mj.time.controller;

import com.mj.time.common.CommonResponse;
import com.mj.time.controller.base.BaseController;
import com.mj.time.domain.Record;
import com.mj.time.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/time/record")
public class RecordController extends BaseController {
    @Autowired
    private RecordService recordService;

    @PostMapping
    public CommonResponse<Object> create(@RequestBody Record record) {
        record.setUserId(userId);
        recordService.addRecord(record);
        return new CommonResponse<Object>();
    }

    @GetMapping
    public CommonResponse<List<Record>> query(Date beginTime,Date endTime,Integer tagId){
        List<Record> recordList = recordService.selectRecord(userId, beginTime, endTime, tagId);
        return new CommonResponse<List<Record>>(recordList);
    }
}