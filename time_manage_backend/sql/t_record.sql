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

 Date: 15/11/2020 01:29:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_record
-- ----------------------------
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE `t_record` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `user_id` int DEFAULT NULL COMMENT '用户id，关联用户表',
  `tag_id` int DEFAULT NULL COMMENT '标签id，关联标签表',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  `bak1` varchar(1024) DEFAULT NULL,
  `bak2` varchar(1024) DEFAULT NULL,
  `bak3` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `time_idx` (`user_id`,`begin_time`,`end_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
