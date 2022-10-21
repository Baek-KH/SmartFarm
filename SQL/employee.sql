/*
 Navicat Premium Data Transfer

 Source Server         : MariaDB
 Source Server Type    : MariaDB
 Source Server Version : 100803
 Source Host           : localhost:3306
 Source Schema         : spring

 Target Server Type    : MariaDB
 Target Server Version : 100803
 File Encoding         : 65001

 Date: 19/10/2022 18:25:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `emp_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `emp_no` int(11) NULL DEFAULT NULL,
  `emp_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `emp_pw` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `emp_email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `emp_admin` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  INDEX `emp_id`(`emp_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('아이디', 1, '이름', 'aasdf', '한글이메일', 'admin');
INSERT INTO `employee` VALUES ('asdf', 2, '수정11', 'asdf', '수정수정111', 'admin');
INSERT INTO `employee` VALUES ('asdgasdg', 3, 'asdgasdg', 'asgdagag', 'agaagaagga', 'regular');
INSERT INTO `employee` VALUES ('test', 5, 'test', 'test', 'testmtmt', NULL);
INSERT INTO `employee` VALUES ('test1', 6, 'test1', 'test', 'test', 'admin');
INSERT INTO `employee` VALUES ('test111', 7, 'tester', '12345', '이메일', 'regular');
INSERT INTO `employee` VALUES ('admin', 12, '관리자', '12345', '', 'admin');
INSERT INTO `employee` VALUES (NULL, 13, '관리자', NULL, 'admin@admin.com', 'regular');
INSERT INTO `employee` VALUES ('aa', 14, '44', '12345', '', 'regular');
INSERT INTO `employee` VALUES ('regular', 15, '사원', '12345', '사원 @', 'regular');

SET FOREIGN_KEY_CHECKS = 1;
