/*
 Navicat Premium Data Transfer

 Source Server         : 47.105.163.206
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 47.105.163.206:3306
 Source Schema         : time_manage

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 15/11/2020 01:32:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `mobile` varchar(30) DEFAULT NULL COMMENT '手机号',
  `nickname` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `sex` tinyint DEFAULT NULL COMMENT '性别 0:男 1:女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `headimg` varchar(500) DEFAULT NULL COMMENT '头像',
  `status` tinyint DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  `bak1` varchar(1024) DEFAULT NULL,
  `bak2` varchar(1024) DEFAULT NULL,
  `bak3` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `username_idx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
