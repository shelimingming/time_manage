package com.mj.time.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * 自增主键
     * 表字段 : t_user.id
     */
    private Integer id;

    /**
     * 用户名
     * 表字段 : t_user.username
     */
    private String username;

    /**
     * 密码
     * 表字段 : t_user.password
     */
    private String password;

    /**
     * 手机号
     * 表字段 : t_user.mobile
     */
    private String mobile;

    /**
     * 用户昵称
     * 表字段 : t_user.nickname
     */
    private String nickname;

    /**
     * 性别 0:未知 1:男 2:女
     * 表字段 : t_user.sex
     */
    private Byte sex;

    /**
     * 地址
     * 表字段 : t_user.address
     */
    private String address;

    /**
     * 生日
     * 表字段 : t_user.birthday
     */
    private Date birthday;

    /**
     * 头像
     * 表字段 : t_user.headimg
     */
    private String headimg;

    /**
     * 状态
     * 表字段 : t_user.status
     */
    private Byte status;

    /**
     * 创建时间
     * 表字段 : t_user.create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * 表字段 : t_user.modify_time
     */
    private Date modifyTime;

    /**
     * 微信openid
     * 表字段 : t_user.wx_open_id
     */
    private String wxOpenId;

    /**
     * 
     * 表字段 : t_user.bak1
     */
    private String bak1;

    /**
     * 
     * 表字段 : t_user.bak2
     */
    private String bak2;

    /**
     * 
     * 表字段 : t_user.bak3
     */
    private String bak3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 自增主键 字段:t_user.id
     *
     * @return t_user.id, 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:t_user.id
     *
     * @param id the value for t_user.id, 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 用户名 字段:t_user.username
     *
     * @return t_user.username, 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 用户名 字段:t_user.username
     *
     * @param username the value for t_user.username, 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取 密码 字段:t_user.password
     *
     * @return t_user.password, 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 密码 字段:t_user.password
     *
     * @param password the value for t_user.password, 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取 手机号 字段:t_user.mobile
     *
     * @return t_user.mobile, 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置 手机号 字段:t_user.mobile
     *
     * @param mobile the value for t_user.mobile, 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取 用户昵称 字段:t_user.nickname
     *
     * @return t_user.nickname, 用户昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置 用户昵称 字段:t_user.nickname
     *
     * @param nickname the value for t_user.nickname, 用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取 性别 0:未知 1:男 2:女 字段:t_user.sex
     *
     * @return t_user.sex, 性别 0:未知 1:男 2:女
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置 性别 0:未知 1:男 2:女 字段:t_user.sex
     *
     * @param sex the value for t_user.sex, 性别 0:未知 1:男 2:女
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取 地址 字段:t_user.address
     *
     * @return t_user.address, 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置 地址 字段:t_user.address
     *
     * @param address the value for t_user.address, 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取 生日 字段:t_user.birthday
     *
     * @return t_user.birthday, 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置 生日 字段:t_user.birthday
     *
     * @param birthday the value for t_user.birthday, 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取 头像 字段:t_user.headimg
     *
     * @return t_user.headimg, 头像
     */
    public String getHeadimg() {
        return headimg;
    }

    /**
     * 设置 头像 字段:t_user.headimg
     *
     * @param headimg the value for t_user.headimg, 头像
     */
    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    /**
     * 获取 状态 字段:t_user.status
     *
     * @return t_user.status, 状态
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置 状态 字段:t_user.status
     *
     * @param status the value for t_user.status, 状态
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取 创建时间 字段:t_user.create_time
     *
     * @return t_user.create_time, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:t_user.create_time
     *
     * @param createTime the value for t_user.create_time, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 更新时间 字段:t_user.modify_time
     *
     * @return t_user.modify_time, 更新时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置 更新时间 字段:t_user.modify_time
     *
     * @param modifyTime the value for t_user.modify_time, 更新时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取 微信openid 字段:t_user.wx_open_id
     *
     * @return t_user.wx_open_id, 微信openid
     */
    public String getWxOpenId() {
        return wxOpenId;
    }

    /**
     * 设置 微信openid 字段:t_user.wx_open_id
     *
     * @param wxOpenId the value for t_user.wx_open_id, 微信openid
     */
    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    /**
     * 获取  字段:t_user.bak1
     *
     * @return t_user.bak1, 
     */
    public String getBak1() {
        return bak1;
    }

    /**
     * 设置  字段:t_user.bak1
     *
     * @param bak1 the value for t_user.bak1, 
     */
    public void setBak1(String bak1) {
        this.bak1 = bak1 == null ? null : bak1.trim();
    }

    /**
     * 获取  字段:t_user.bak2
     *
     * @return t_user.bak2, 
     */
    public String getBak2() {
        return bak2;
    }

    /**
     * 设置  字段:t_user.bak2
     *
     * @param bak2 the value for t_user.bak2, 
     */
    public void setBak2(String bak2) {
        this.bak2 = bak2 == null ? null : bak2.trim();
    }

    /**
     * 获取  字段:t_user.bak3
     *
     * @return t_user.bak3, 
     */
    public String getBak3() {
        return bak3;
    }

    /**
     * 设置  字段:t_user.bak3
     *
     * @param bak3 the value for t_user.bak3, 
     */
    public void setBak3(String bak3) {
        this.bak3 = bak3 == null ? null : bak3.trim();
    }
}