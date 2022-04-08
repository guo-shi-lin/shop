/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : test_user

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 08/04/2022 10:05:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户名称',
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `head_img_uri` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户头像uri',
  `gender` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '性别：0-未设置；1-男；2-女；',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '赵四', '1', NULL, 1, '15755085666', '2022-01-11 17:08:20', '2022-01-11 17:08:23', '2022-01-11 17:08:25');
INSERT INTO `user` VALUES (2, '张三', '123456', NULL, 1, '123456', '2022-01-11 17:48:56', '2022-01-11 17:48:56', '2022-01-11 17:48:56');

SET FOREIGN_KEY_CHECKS = 1;
