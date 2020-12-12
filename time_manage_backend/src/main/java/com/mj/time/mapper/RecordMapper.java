package com.mj.time.mapper;

import com.mj.time.domain.Record;

import java.util.HashMap;
import java.util.List;

public interface RecordMapper {
    /**
     *  根据主键删除数据库的记录,t_record
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,t_record
     *
     * @param record
     */
    int insert(Record record);

    /**
     *  动态字段,写入数据库记录,t_record
     *
     * @param record
     */
    int insertSelective(Record record);

    /**
     *  根据指定主键获取一条数据库记录,t_record
     *
     * @param id
     */
    Record selectByPrimaryKey(Integer id);

    List<Record> selectByMap(HashMap map);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_record
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Record record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_record
     *
     * @param record
     */
    int updateByPrimaryKey(Record record);

    int insertBatchSelective(List<Record> records);

    int updateBatchByPrimaryKeySelective(List<Record> records);
}