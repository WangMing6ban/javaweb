/*
Navicat MySQL Data Transfer

Source Server         : shangcheng
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : bookshop

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2017-12-22 16:58:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(20) NOT NULL,
  `address` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dd` (`user_id`),
  CONSTRAINT `dd` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('22', '保定', '66', '5');
INSERT INTO `address` VALUES ('23', '我矮', '66', '5');
INSERT INTO `address` VALUES ('24', '爸爸', '66', '5');
INSERT INTO `address` VALUES ('25', '贝贝', '66', '5');
INSERT INTO `address` VALUES ('26', '爱你', '66', '6');
INSERT INTO `address` VALUES ('27', '密码', '88', '6');
INSERT INTO `address` VALUES ('30', '我的家', '12', '23');

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `admin_username` varchar(20) NOT NULL,
  `admin_passwd` varchar(20) NOT NULL,
  `admin_realname` varchar(20) DEFAULT NULL,
  `admin_email` varchar(30) DEFAULT NULL,
  `admin_imgurl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('4', 'vv', '1111111', null, '1111111111@qq.com', 'F:\\apache-tomcat-9.0.0.M26\\webapps\\ming\\uploading/86.jpg');
INSERT INTO `admin` VALUES ('5', '33', '1111111', null, '8888888888@qq.com', 'F:\\apache-tomcat-9.0.0.M26\\webapps\\ming\\uploading/85.jpg');
INSERT INTO `admin` VALUES ('7', 'vv', '33333333', null, '2908673444@qq.com', 'F:\\apache-tomcat-9.0.0.M26\\webapps\\ming\\uploading/85.jpg');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `book_name` varchar(50) DEFAULT NULL,
  `book_price` double(100,0) DEFAULT NULL,
  `book_description` varchar(200) DEFAULT NULL,
  `book_imgurl` varchar(100) DEFAULT NULL,
  `book_state` varchar(100) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `waijian` (`type_id`),
  CONSTRAINT `waijian` FOREIGN KEY (`type_id`) REFERENCES `book_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('3', 'english', '13', 'yignu', 'images/templatemo_image_01.jpg', 'newproduct', '4');
INSERT INTO `book` VALUES ('7', '马斯', '12', '思想', 'images/templatemo_image_01.jpg', 'hotproduct', '3');
INSERT INTO `book` VALUES ('8', 'spring', '14', 'spring', 'images/templatemo_image_01.jpg', 'hotproduct', '8');
INSERT INTO `book` VALUES ('9', '图书', '33', '思想', 'images/templatemo_image_02.jpg', 'newproduct', '6');
INSERT INTO `book` VALUES ('10', '美国饰', '22', '美国的历史', 'images/templatemo_image_02.jpg', 'hotproduct', '6');

-- ----------------------------
-- Table structure for `book_type`
-- ----------------------------
DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type` (
  `id` int(11) NOT NULL,
  `type_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`,`type_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_type
-- ----------------------------
INSERT INTO `book_type` VALUES ('3', '英语');
INSERT INTO `book_type` VALUES ('4', '百变');
INSERT INTO `book_type` VALUES ('5', '嗯嗯');
INSERT INTO `book_type` VALUES ('6', '软件');
INSERT INTO `book_type` VALUES ('7', '累了');
INSERT INTO `book_type` VALUES ('8', '数学');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `order_state` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`user_id`),
  CONSTRAINT `userid` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('2', '23', '已取消');
INSERT INTO `orders` VALUES ('3', '23', '已确认');
INSERT INTO `orders` VALUES ('4', '23', '已确认');
INSERT INTO `orders` VALUES ('6', '7', '已发货');
INSERT INTO `orders` VALUES ('7', '7', '已确认');
INSERT INTO `orders` VALUES ('8', '23', '已确认');
INSERT INTO `orders` VALUES ('9', '23', '已确认');
INSERT INTO `orders` VALUES ('10', '23', '已确认');

-- ----------------------------
-- Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `count` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `waijian2` (`order_id`),
  KEY `waijian1` (`book_id`),
  CONSTRAINT `waijian1` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `waijian2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('3', '3', '2', '1');
INSERT INTO `order_detail` VALUES ('4', '3', '3', '1');
INSERT INTO `order_detail` VALUES ('5', '7', '4', '1');
INSERT INTO `order_detail` VALUES ('6', '3', '4', '1');
INSERT INTO `order_detail` VALUES ('10', '8', '6', '1');
INSERT INTO `order_detail` VALUES ('11', '3', '6', '1');
INSERT INTO `order_detail` VALUES ('12', '7', '7', '1');
INSERT INTO `order_detail` VALUES ('13', '3', '8', '1');
INSERT INTO `order_detail` VALUES ('14', '10', '8', '2');
INSERT INTO `order_detail` VALUES ('15', '7', '9', '1');
INSERT INTO `order_detail` VALUES ('16', '3', '9', '1');
INSERT INTO `order_detail` VALUES ('17', '8', '10', '1');
INSERT INTO `order_detail` VALUES ('18', '7', '10', '1');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `user_username` varchar(50) NOT NULL,
  `user_passwd` varchar(50) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_imgurl` varchar(100) DEFAULT NULL,
  `user_detail` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('4', '梅梅', '4444', '4444444444@qq.com', 'images/templatemo_image_01.jpg', null);
INSERT INTO `users` VALUES ('5', '丽丽', '55555', '5555555555@qq.com', 'images/templatemo_image_01.jpg', null);
INSERT INTO `users` VALUES ('6', 'lili', '6666', '6666666666@qq.com', 'images/templatemo_image_01.jpg', null);
INSERT INTO `users` VALUES ('7', 'vv', '33333333', '2908673444@qq.com', 'uploading/85.jpg', null);
INSERT INTO `users` VALUES ('21', '11', '22222222', '1111111111@qq.com', 'uploading/86.jpg', null);
INSERT INTO `users` VALUES ('22', '22', '55555555', '9999999999@qq.com', 'uploading/85.jpg', null);
INSERT INTO `users` VALUES ('23', 'ming', '11111111', '2908673445@qq.com', 'uploading/85.jpg', '						我的家\r\n					\r\n						');
INSERT INTO `users` VALUES ('24', 'dd', 'ddddddd', 'ddddddd@qq.com', 'uploading/86.jpg', null);
