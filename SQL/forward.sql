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

 Date: 19/10/2022 18:25:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for forward
-- ----------------------------
DROP TABLE IF EXISTS `forward`;
CREATE TABLE `forward`  (
  `forward_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `pip_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `forward_qty` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `forward_content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `forward_date` date NULL DEFAULT NULL,
  `forward_check` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`forward_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forward
-- ----------------------------
INSERT INTO `forward` VALUES ('1', 'test', NULL, 'test', NULL, 'checked');
INSERT INTO `forward` VALUES ('2', 'test', NULL, 'test', NULL, 'checked');
INSERT INTO `forward` VALUES ('3', 'test', NULL, 'test', NULL, 'checked');
INSERT INTO `forward` VALUES ('4', 'test', NULL, 'test', NULL, 'checked');
INSERT INTO `forward` VALUES ('5', 'test', NULL, 'test', NULL, 'checked');
INSERT INTO `forward` VALUES ('6', '상추', '100', '없음', '2022-10-19', NULL);
INSERT INTO `forward` VALUES ('7', ' lettuce', '100', '', '2022-10-19', 'checked');

SET FOREIGN_KEY_CHECKS = 1;
