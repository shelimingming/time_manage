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

 Date: 15/11/2020 01:29:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(255) DEFAULT NULL COMMENT '标签名',
  `color` varchar(255) DEFAULT NULL COMMENT '标签颜色',
  `type` tinyint DEFAULT NULL COMMENT '标签类别',
  `creator` int DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  `bak1` varchar(1024) DEFAULT NULL,
  `bak2` varchar(1024) DEFAULT NULL,
  `bak3` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `creator_idx` (`creator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
