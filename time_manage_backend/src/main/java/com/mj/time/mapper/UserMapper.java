package com.mj.time.mapper;

import com.mj.time.domain.User;

import java.util.List;

public interface UserMapper {
    /**
     *  根据主键删除数据库的记录,t_user
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,t_user
     *
     * @param record
     */
    int insert(User record);

    /**
     *  动态字段,写入数据库记录,t_user
     *
     * @param record
     */
    int insertSelective(User record);

    /**
     *  根据指定主键获取一条数据库记录,t_user
     *
     * @param id
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 根据微信的openid查找用户
     * @param wxOpenId
     * @return
     */
    User selectByWXOpenId(String wxOpenId);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_user
     *
     * @param record
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_user
     *
     * @param record
     */
    int updateByPrimaryKey(User record);

    int insertBatchSelective(List<User> records);

    int updateBatchByPrimaryKeySelective(List<User> records);
}