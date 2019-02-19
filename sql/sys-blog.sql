

CREATE DATABASE  `sys-blog` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use `sys-blog`;

/*
Navicat MySQL Data Transfer

Source Server         : SSSS
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : sys_blog

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `suject` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `blog` VALUES ('5', '今天天气真好', '一起出去玩啊', 'gxl');

