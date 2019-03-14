/*
Navicat MySQL Data Transfer

Source Server         : w15104
Source Server Version : 80014
Source Host           : 10.121.199.30:3306
Source Database       : wangfeihu

Target Server Type    : MYSQL
Target Server Version : 80014
File Encoding         : 65001

Date: 2019-03-08 14:09:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `pname` varchar(32) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `createDate` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('4', '2', '2', '2', '1988-12-12 12:32:21', '2');
INSERT INTO `product` VALUES ('5', '2', '2', '2', '1988-12-12 12:32:21', '2');
INSERT INTO `product` VALUES ('6', '2', '2', '2', '1988-12-12 12:32:21', '2');
INSERT INTO `product` VALUES ('7', '2', '2', '2', '1988-12-12 12:32:21', '2');
INSERT INTO `product` VALUES ('8', '2', '2', '2', '1988-12-12 12:32:21', '2');
INSERT INTO `product` VALUES ('9', '2', '2', '2', '1988-12-12 12:32:21', '2');

-- ----------------------------
-- Table structure for tb_class
-- ----------------------------
DROP TABLE IF EXISTS `tb_class`;
CREATE TABLE `tb_class` (
  `class_id` varchar(255) DEFAULT NULL,
  `teacher_num` varchar(255) DEFAULT NULL,
  `student_num` varchar(255) DEFAULT NULL,
  `poision` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_class
-- ----------------------------
INSERT INTO `tb_class` VALUES ('1', '2', '3', '3号楼', '牛班');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `class_id` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `family` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('1', '王一', '牛的学生', '男', '富二代');

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `class_id` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `family` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES ('1', '王八', '教龄数百年', '女', '红一代');
