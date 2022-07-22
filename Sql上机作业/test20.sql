/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : test20

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2020-12-01 08:28:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` varchar(255) NOT NULL,
  `name` varchar(255) default NULL,
  `age` int(11) default NULL,
  `score` float default NULL,
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1101', '张三', '23', '50');
INSERT INTO `student` VALUES ('1102', '李四', '24', '30');
INSERT INTO `student` VALUES ('1103', '张四', '25', '31');
INSERT INTO `student` VALUES ('1104', '赵武', '22', '88');
INSERT INTO `student` VALUES ('1106', '赵七', '20', '46');
INSERT INTO `student` VALUES ('1107', '赵七', '20', '56');
INSERT INTO `student` VALUES ('1108', '小米', '26', '32');
INSERT INTO `student` VALUES ('1109', '小米', '26', '32');
