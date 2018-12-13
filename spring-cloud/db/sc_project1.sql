/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : sc_project1

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-12-13 15:38:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `f_id` varchar(32) NOT NULL,
  `f_order_user_id` varchar(32) NOT NULL COMMENT '订单人id',
  `f_concat_user` varchar(50) NOT NULL COMMENT '联系人',
  `f_phone` datetime NOT NULL COMMENT '电话',
  `f_address` varchar(32) NOT NULL COMMENT '地址',
  `f_create_time` varchar(32) NOT NULL COMMENT '创建时间',
  `f_sum_price` double NOT NULL DEFAULT '0' COMMENT '总价格',
  `f_is_delete` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否删除',
  `f_state` int(11) NOT NULL DEFAULT '1' COMMENT '订单状态',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `f_id` varchar(32) NOT NULL COMMENT '详情id',
  `f_order_id` varchar(32) NOT NULL COMMENT '订单id',
  `f_goods_id` varchar(32) NOT NULL COMMENT '商品id',
  `f_buy_count` int(11) NOT NULL COMMENT '购买数量',
  `f_buy_price` double NOT NULL COMMENT '购买价格',
  `f_sum_price` double NOT NULL COMMENT '总价',
  `f_create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `f_id` varchar(32) NOT NULL COMMENT '用户id',
  `f_dept_id` varchar(32) NOT NULL COMMENT '部门id',
  `f_account` varchar(64) NOT NULL COMMENT '登录账号',
  `f_password` varchar(64) NOT NULL COMMENT '密码',
  `f_user_name` varchar(50) NOT NULL COMMENT '用户姓名',
  `f_phone` varchar(100) DEFAULT NULL COMMENT '联系电话',
  `f_state` int(11) NOT NULL COMMENT '0:删除 1.可用 2.不可用（冻结）',
  `f_create_time` datetime NOT NULL COMMENT '创建时间',
  `f_last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `f_last_login_ip` varchar(32) NOT NULL COMMENT '上次登录ip',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='(用户表)';
