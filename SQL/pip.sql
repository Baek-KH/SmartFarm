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

 Date: 19/10/2022 18:26:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pip
-- ----------------------------
DROP TABLE IF EXISTS `pip`;
CREATE TABLE `pip`  (
  `pip_no` int(200) NOT NULL,
  `pip_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pip_category` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pip_period` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pip_min_temp` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pip_max_temp` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pip_min_hum` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pip_max_hum` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pip_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pip
-- ----------------------------
INSERT INTO `pip` VALUES (1, 'aa', 'A', '10', NULL, NULL, NULL, NULL);
INSERT INTO `pip` VALUES (2, 'bb', 'B', '15', NULL, NULL, NULL, NULL);
INSERT INTO `pip` VALUES (3, 'cc', 'C', '12', NULL, NULL, NULL, NULL);
INSERT INTO `pip` VALUES (4, 'dd', 'D', '15', NULL, NULL, NULL, NULL);
INSERT INTO `pip` VALUES (5, 'WJH', 'U', '20', '20', '25', '30', '80');

SET FOREIGN_KEY_CHECKS = 1;
