package com.mj.time.mapper;

import com.mj.time.domain.Tag;

import java.util.List;

public interface TagMapper {
    /**
     *  根据主键删除数据库的记录,t_tag
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,t_tag
     *
     * @param record
     */
    int insert(Tag record);

    /**
     *  动态字段,写入数据库记录,t_tag
     *
     * @param record
     */
    int insertSelective(Tag record);

    /**
     *  根据指定主键获取一条数据库记录,t_tag
     *
     * @param id
     */
    Tag selectByPrimaryKey(Integer id);

    List<Tag> selectByUserId(Integer userId);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_tag
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_tag
     *
     * @param record
     */
    int updateByPrimaryKey(Tag record);

    int insertBatchSelective(List<Tag> records);

    int updateBatchByPrimaryKeySelective(List<Tag> records);
}