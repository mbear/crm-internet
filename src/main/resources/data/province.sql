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
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `province` (
  `id` int(11) unsigned NOT NULL,
  `name` varchar(64) NOT NULL DEFAULT '',
  `sort_id` int(11) NOT NULL DEFAULT '0',
  `default_user` int(11) DEFAULT NULL,
  `belong_user` varchar(220) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (1,'安徽',0,107,'107');
INSERT INTO `province` VALUES (5,'福建',0,29,'29');
INSERT INTO `province` VALUES (7,'甘肃',0,12,'12');
INSERT INTO `province` VALUES (8,'广东',0,1455,'1455,22,56,1481,1466,1467');
INSERT INTO `province` VALUES (9,'广西 ',0,97,'97');
INSERT INTO `province` VALUES (12,'贵州',0,1263,'1263,36');
INSERT INTO `province` VALUES (15,'河北',0,84,'84');
INSERT INTO `province` VALUES (17,'黑龙江',0,84,'84');
INSERT INTO `province` VALUES (18,'河南',0,1267,'1267,32');
INSERT INTO `province` VALUES (19,'湖北',0,27,'27');
INSERT INTO `province` VALUES (21,'湖南',0,28,'28');
INSERT INTO `province` VALUES (22,'江苏',0,41,'41,20,39,90,40,99,34,108');
INSERT INTO `province` VALUES (23,'江西',0,31,'31');
INSERT INTO `province` VALUES (24,'吉林',0,81,'81');
INSERT INTO `province` VALUES (29,'辽宁',0,81,'81');
INSERT INTO `province` VALUES (33,'内蒙古',0,1321,'1321,12');
INSERT INTO `province` VALUES (34,'宁夏',0,12,'12');
INSERT INTO `province` VALUES (35,'青海',0,11,'11');
INSERT INTO `province` VALUES (36,'陕西 ',0,11,'11');
INSERT INTO `province` VALUES (37,'山东',0,9,'9,94,93');
INSERT INTO `province` VALUES (38,'山西 ',0,11,'11');
INSERT INTO `province` VALUES (41,'四川',0,1465,'1465,8');
INSERT INTO `province` VALUES (48,'新疆',0,1302,'1302,32');
INSERT INTO `province` VALUES (50,'西藏',0,97,'97');
INSERT INTO `province` VALUES (52,'云南',0,97,'97');
INSERT INTO `province` VALUES (53,'浙江',0,1358,'1358,17,1482,87,85,88,25');
INSERT INTO `province` VALUES (55,'北京',0,13,'13,6,14,74,103,30,1457');
INSERT INTO `province` VALUES (56,'重庆',0,1259,'1259,36');
INSERT INTO `province` VALUES (57,'海南',0,97,'97');
INSERT INTO `province` VALUES (58,'上海',0,1282,'1282,73,71,89,110,1479,37,100');
INSERT INTO `province` VALUES (59,'天津',0,1456,'1456');
INSERT INTO `province` VALUES (60,'香港',0,1455,'1455,22,56,1481,1466,1467');
INSERT INTO `province` VALUES (61,'澳门',0,1455,'1455,22,56,1481,1466,1467');
INSERT INTO `province` VALUES (62,'台湾',0,74,'74');
INSERT INTO `province` VALUES (63,'其它',0,13,'13,6,14,74,103,30,1457');
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-21 15:24:13
