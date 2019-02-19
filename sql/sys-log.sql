
CREATE DATABASE  `sys-log` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use `sys-log`;

/*
Navicat MySQL Data Transfer

Source Server         : SSSS
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : sys-log

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=267 DEFAULT CHARSET=utf8;
