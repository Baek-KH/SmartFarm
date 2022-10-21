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

 Date: 19/10/2022 18:25:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attendence
-- ----------------------------
DROP TABLE IF EXISTS `attendence`;
CREATE TABLE `attendence`  (
  `emp_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `emp_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `att_work_on` datetime NULL DEFAULT NULL,
  `att_work_off` datetime NULL DEFAULT NULL,
  `att_work_date` date NULL DEFAULT NULL,
  `att_dayoff` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendence
-- ----------------------------
INSERT INTO `attendence` VALUES ('admin', '관리자', '2022-10-11 17:04:01', '2022-10-14 18:02:07', '2022-10-11', NULL);
INSERT INTO `attendence` VALUES ('test', 'test', '2022-10-11 17:52:10', '2022-10-11 17:53:00', '2022-10-11', NULL);
INSERT INTO `attendence` VALUES ('admin', '관리자', '2022-10-12 09:53:05', '2022-10-14 18:02:07', '2022-10-12', NULL);
INSERT INTO `attendence` VALUES ('test111', 'tester', '2022-10-12 10:00:01', NULL, '2022-10-12', NULL);
INSERT INTO `attendence` VALUES ('admin', '관리자', '2022-10-13 09:47:06', '2022-10-14 18:02:07', '2022-10-13', NULL);
INSERT INTO `attendence` VALUES ('admin', '관리자', '2022-10-14 09:48:54', '2022-10-14 18:03:12', '2022-10-14', NULL);
INSERT INTO `attendence` VALUES ('admin', '관리자', '2022-10-17 09:35:24', NULL, '2022-10-17', NULL);
INSERT INTO `attendence` VALUES ('admin', '관리자', '2022-10-18 10:01:12', '2022-10-18 18:41:30', '2022-10-18', NULL);
INSERT INTO `attendence` VALUES ('admin', '관리자', '2022-10-19 10:37:30', NULL, '2022-10-19', NULL);

SET FOREIGN_KEY_CHECKS = 1;
