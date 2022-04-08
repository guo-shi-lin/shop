/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : test_product

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 08/04/2022 10:05:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品名称',
  `product_no` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品编码',
  `product_cover_img_uri` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品封面图片',
  `sale_price` int UNSIGNED NULL DEFAULT 0 COMMENT '商品销售价格(单位分)',
  `real_price` int UNSIGNED NULL DEFAULT 0 COMMENT '商品真实价格(单位分)',
  `product_introduce` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '商品介绍',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_product_name_no_price`(`product_name`, `product_no`, `sale_price`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 'iPhone 13 粉色256G', '1', 'https://img10.360buyimg.com/seckillcms/s250x250_jfs/t1/127115/33/21061/45399/61dbdb81Ea0d3a529/9bbfa59c972ef222.jpg', 670000, 650000, '117天历史最低价', '2022-01-12 14:48:36', '2022-01-12 14:48:39');
INSERT INTO `product` VALUES (2, '飞天茅台53度500ml', '2', 'https://img11.360buyimg.com/seckillcms/s250x250_jfs/t1/106706/10/20885/195961/61dbec8fE2b374dc2/6f2514e535200811.jpg', 310000, 290000, '54天历史最低价', '2022-01-12 14:49:21', '2022-01-12 14:49:23');
INSERT INTO `product` VALUES (3, 'Reno7系列 爆款8+128G星夜黑', '3', 'https://img13.360buyimg.com/seckillcms/s250x250_jfs/t1/95971/24/21341/121144/61d818f9Ec8354c4c/ae259c5e63a6c708.jpg', 280000, 249900, '47天历史最低价', '2022-01-12 14:50:07', '2022-01-12 14:50:09');
INSERT INTO `product` VALUES (4, '稻香村坚果礼盒上品臻礼1200g', '4', 'https://img14.360buyimg.com/seckillcms/s250x250_jfs/t1/167828/20/23039/181952/61c299d7E40884f05/733e55e58097215b.jpg', 15000, 9900, '1年历史最低价', '2022-01-12 15:00:38', '2022-01-12 15:00:42');
INSERT INTO `product` VALUES (5, '微星(msi)武士 电竞游戏本', '5', 'https://img14.360buyimg.com/seckillcms/s250x250_jfs/t1/158762/8/22607/84753/61b05eabE9aeb1483/2408cc178394a487.jpg', 650000, 600000, '245天历史最低价', '2022-01-12 15:02:11', '2022-01-12 15:02:15');
INSERT INTO `product` VALUES (6, '山姆烘烤开心果 480g*2罐装 原色无漂白 儿童孕妇零食坚果炒货', '6', 'https://img10.360buyimg.com/jdcms/s150x150_jfs/t1/150358/34/11299/67357/5fd875b9E3e5356fd/4623609dc12b0503.jpg.webp', 4000, 3200, '117天历史最低价', '2022-01-12 14:48:36', '2022-01-12 14:48:39');
INSERT INTO `product` VALUES (7, '琦王新货带皮腰果500克原味 坚果休闲零食紫皮盐焗腰果仁 腰果500g*1袋', '7', 'https://img10.360buyimg.com/jdcms/s150x150_jfs/t1/147898/6/21128/269777/61ebab04Eae9932a6/19ad9ca6c4ce330e.jpg.webp', 1980, 1690, '54天历史最低价', '2022-01-12 14:49:21', '2022-01-12 14:49:23');
INSERT INTO `product` VALUES (8, 'Reno7系列 爆款6+128G星夜黑', '8', 'https://img13.360buyimg.com/seckillcms/s250x250_jfs/t1/95971/24/21341/121144/61d818f9Ec8354c4c/ae259c5e63a6c708.jpg', 280000, 249900, '47天历史最低价', '2022-01-12 14:50:07', '2022-01-12 14:50:09');
INSERT INTO `product` VALUES (9, '琦王开口松子手剥东北松子500g大颗粒原味坚果零食炒货2021新货 开口松子230克×1袋', '9', 'https://img12.360buyimg.com/jdcms/s150x150_jfs/t1/125987/16/20885/279962/61ebab04Eb0eff2ff/2f43d2a96797508e.jpg.webp', 9900, 9500, '1年历史最低价', '2022-01-12 15:00:38', '2022-01-12 15:00:42');
INSERT INTO `product` VALUES (10, '琦王新货原味开心果500g无漂白坚果零食本色开心果干果仁 开心果250g*1袋', '10', 'https://img11.360buyimg.com/jdcms/s150x150_jfs/t1/149666/29/21212/245761/61ebab04E9e1b99e9/e0c2158174fdc23a.jpg.webp', 5000, 4890, '245天历史最低价', '2022-01-12 15:02:11', '2022-01-12 15:02:15');
INSERT INTO `product` VALUES (11, '农博汇 新疆185手剥纸皮核桃薄皮核桃 自营4斤坚果炒货零食礼包年货礼盒', '11', 'https://img20.360buyimg.com/jdcms/s150x150_jfs/t1/216864/15/9589/409406/61cdda6aE5bb50c0a/949909f076af96c2.jpg.webp', 10000, 9860, '117天历史最低价', '2022-01-12 14:48:36', '2022-01-12 14:48:39');
INSERT INTO `product` VALUES (12, '良品铺子 烤面筋香辣味辣皮辣片网红辣条味儿时小零食休闲小吃200g', '12', 'https://img13.360buyimg.com/jdcms/s150x150_jfs/t1/222263/39/9507/194920/61e9251bEd68ad19c/af1aaed3074925c8.jpg.webp', 2000, 1860, '54天历史最低价', '2022-01-12 14:49:21', '2022-01-12 14:49:23');
INSERT INTO `product` VALUES (13, '柴火大院 红花生米（中粒 红皮 生花生米 东北五谷杂粮 粗粮 真空装 大米伴侣 粥米搭档） 1kg 春节年货', '13', 'https://img13.360buyimg.com/jdcms/s150x150_jfs/t1/209365/21/4681/306248/6163e497E0c5c3384/7fced2e5b48e2c36.jpg.webp', 4500, 4390, '47天历史最低价', '2022-01-12 14:50:07', '2022-01-12 14:50:09');
INSERT INTO `product` VALUES (14, '稻香村坚果礼盒上品臻礼1200g1', '14', 'https://img14.360buyimg.com/seckillcms/s250x250_jfs/t1/167828/20/23039/181952/61c299d7E40884f05/733e55e58097215b.jpg', 15000, 9900, '1年历史最低价', '2022-01-12 15:00:38', '2022-01-12 15:00:42');
INSERT INTO `product` VALUES (15, '神话 麻辣鸭腿 卤味鸭货麻辣小吃休闲零食熟食即食真空批发整箱 黑鸭腿*10包', '15', 'https://img13.360buyimg.com/jdcms/s150x150_jfs/t1/137823/12/3893/838999/5f1ff78fEc26a8acf/812a01c604fa85b1.jpg.webp', 6000, 5960, '245天历史最低价', '2022-01-12 15:02:11', '2022-01-12 15:02:15');

-- ----------------------------
-- Table structure for product_cart
-- ----------------------------
DROP TABLE IF EXISTS `product_cart`;
CREATE TABLE `product_cart`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `buy_num` int NOT NULL COMMENT '商品购买数量',
  `sale_price` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '销售单价(单位分)',
  `sale_amount` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '销售价格(单位分)',
  `real_price` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '真实单价(单位分)',
  `real_amount` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '真实价格(单位分)',
  `state` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态(0=正常,1=失效)',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_pc_product_id`(`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '购物车' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_cart
-- ----------------------------
INSERT INTO `product_cart` VALUES (1, 100, 2, 1, 0, 0, 0, 0, 0, '2022-03-03 16:48:54', '2022-03-03 16:48:56');
INSERT INTO `product_cart` VALUES (19, 1, 2, 1, 670000, 670000, 650000, 650000, 1, '2022-02-21 17:19:59', '2022-02-21 17:19:59');

SET FOREIGN_KEY_CHECKS = 1;
