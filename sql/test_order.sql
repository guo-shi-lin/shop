/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : test_order

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 08/04/2022 10:05:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `order_no` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单编号',
  `buy_num` int NOT NULL COMMENT '商品购买数量',
  `state` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单状态(0=待支付,1=已支付)',
  `sale_price` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '销售单价(单位分)',
  `sale_amount` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '销售价格(单位分)',
  `real_price` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '真实单价(单位分)',
  `real_amount` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '真实价格(单位分)',
  `pay_amount` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '支付价格(单位分)',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1, 2, 1, '20221121623', 1, 1, 310000, 310000, 290000, 290000, 290000, '2022-01-12 16:22:28', '2022-01-12 16:22:28');
INSERT INTO `order_info` VALUES (2, 1, 1, '20211121624', 1, 1, 670000, 670000, 650000, 650000, 650000, '2022-01-12 16:24:16', '2022-01-12 16:24:16');
INSERT INTO `order_info` VALUES (3, 3, 1, '20220112162815478', 1, 1, 280000, 280000, 249900, 249900, 249900, '2022-01-12 16:28:15', '2022-01-12 16:28:15');

SET FOREIGN_KEY_CHECKS = 1;
