/*
 Navicat Premium Data Transfer

 Source Server         : 47.105.163.206
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : 47.105.163.206:3306
 Source Schema         : time_manage

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 21/11/2020 15:37:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_todo
-- ----------------------------
DROP TABLE IF EXISTS `t_todo`;
CREATE TABLE `t_todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id，关联用户表',
  `tag_id` int(11) DEFAULT NULL COMMENT '标签id，表示类别，关联标签表',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `level` varchar(255) DEFAULT NULL COMMENT '重要紧急程度',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `bak1` varchar(1024) DEFAULT NULL,
  `bak2` varchar(1024) DEFAULT NULL,
  `bak3` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
