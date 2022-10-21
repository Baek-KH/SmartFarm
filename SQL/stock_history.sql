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

 Date: 19/10/2022 18:27:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for stock_history
-- ----------------------------
DROP TABLE IF EXISTS `stock_history`;
CREATE TABLE `stock_history`  (
  `stock_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `stock_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `stock_in` int(255) NULL DEFAULT NULL,
  `stock_out` int(255) NULL DEFAULT NULL,
  `stock_qty` int(11) NULL DEFAULT NULL,
  `stock_date` datetime NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock_history
-- ----------------------------
INSERT INTO `stock_history` VALUES (' cabbage', '양배추', 1000, 0, 1000, '2022-10-13 18:36:02');
INSERT INTO `stock_history` VALUES (' cabbage', '양배추', 0, 500, 500, '2022-10-13 18:36:07');
INSERT INTO `stock_history` VALUES (' lettuce', '상추', 500, 0, 500, '2022-10-13 18:36:12');
INSERT INTO `stock_history` VALUES (' cabbage', '양배추', 0, 100, 400, '2022-10-13 18:36:14');
INSERT INTO `stock_history` VALUES ('test1', 'test', 300, 0, 300, '2022-10-13 18:36:41');
INSERT INTO `stock_history` VALUES ('test2', '테스트2', 6000, 0, 6000, '2022-10-13 18:36:46');
INSERT INTO `stock_history` VALUES ('test2', '테스트2', 0, 400, 5600, '2022-10-13 18:36:52');
INSERT INTO `stock_history` VALUES ('test2', '테스트2', 0, 5500, 100, '2022-10-13 18:37:25');
INSERT INTO `stock_history` VALUES (' lettuce', '상추', 0, 0, 500, '2022-10-17 11:16:58');
INSERT INTO `stock_history` VALUES ('no4', 'tomato', 500, 0, 500, '2022-10-19 18:17:42');
INSERT INTO `stock_history` VALUES ('no4', 'tomato', 0, 100, 400, '2022-10-19 18:21:23');

SET FOREIGN_KEY_CHECKS = 1;
