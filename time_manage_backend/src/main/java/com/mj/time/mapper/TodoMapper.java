package com.mj.time.mapper;

import com.mj.time.domain.Todo;

import java.util.List;

public interface TodoMapper {
    /**
     *  根据主键删除数据库的记录,t_todo
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,t_todo
     *
     * @param record
     */
    int insert(Todo record);

    /**
     *  动态字段,写入数据库记录,t_todo
     *
     * @param record
     */
    int insertSelective(Todo record);

    /**
     *  根据指定主键获取一条数据库记录,t_todo
     *
     * @param id
     */
    Todo selectByPrimaryKey(Integer id);

    List<Todo> selectByUserId(Integer userId);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_todo
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Todo record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_todo
     *
     * @param record
     */
    int updateByPrimaryKey(Todo record);

    int insertBatchSelective(List<Todo> records);

    int updateBatchByPrimaryKeySelective(List<Todo> records);
}