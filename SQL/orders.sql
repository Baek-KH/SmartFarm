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

 Date: 19/10/2022 18:26:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orders_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `buyer_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `orders_product` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `orders_qty` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `orders_date` date NULL DEFAULT NULL,
  `orders_arr_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`orders_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('2', '1', '상추', '1000', '2022-10-17', '2022-10-22');

SET FOREIGN_KEY_CHECKS = 1;
