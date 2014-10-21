-- MySQL dump 10.13  Distrib 5.6.19, for Win64 (x86_64)
--
-- Host: 192.168.2.46    Database: bi-crm
-- ------------------------------------------------------
-- Server version	5.5.28-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client_apply_status`
--

DROP TABLE IF EXISTS `client_apply_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_apply_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL COMMENT '客户ID,FK:client_info.member_id',
  `step1_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '个人基本信息填写状态.0未填写1已填写',
  `step2_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '企业基本信息填写状态.0未填写1已填写',
  `step3_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '展示信息填写状态.0未填写1已填写',
  `step4_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '联系信息填写状态.0未填写1已填写',
  `is_submit` tinyint(1) NOT NULL DEFAULT '0',
  `url_real` varchar(400) DEFAULT NULL COMMENT '实际地址',
  `url_encode` varchar(200) DEFAULT NULL COMMENT '客户访问的加密的地址',
  `is_valid` int(1) NOT NULL DEFAULT '1' COMMENT '是否有效.1有效0无效',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000057 DEFAULT CHARSET=utf8 COMMENT='客户填写步骤状态';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_apply_status`
--

LOCK TABLES `client_apply_status` WRITE;
/*!40000 ALTER TABLE `client_apply_status` DISABLE KEYS */;
INSERT INTO `client_apply_status` VALUES (1000015,86246,0,0,0,0,0,'/preuser/1000015','/preuser/bwwv',1,'2014-10-08 20:46:04','2014-10-08 12:46:04');
/*!40000 ALTER TABLE `client_apply_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-21 15:25:20
