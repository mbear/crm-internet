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
-- Table structure for table `zhd_member_extend_information`
--

DROP TABLE IF EXISTS `zhd_member_extend_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zhd_member_extend_information` (
  `member_id` int(10) NOT NULL,
  `Shareproject` text,
  `freetimeactivities` varchar(200) DEFAULT NULL,
  `Understandtheinformation` varchar(200) DEFAULT NULL,
  `Shareguests` varchar(200) DEFAULT NULL,
  `secondinstance` text,
  `mms` int(10) NOT NULL,
  `decision` int(10) NOT NULL,
  `mobileClient` int(10) NOT NULL,
  `web` int(10) NOT NULL,
  `isall` int(10) NOT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  `remarkStone` text,
  `social_circle` text,
  `trun_Introduce_MemberID` int(10) DEFAULT NULL,
  `turn_Introduce_Name` varchar(100) DEFAULT NULL,
  `trade_leads` text,
  `for_information` text,
  `reterence_is_member` int(10) DEFAULT NULL COMMENT '是否会员1是0否',
  `personal_honor` text,
  `expect` text,
  `personal_experience` text,
  `reterence_is_zdtj` int(11) DEFAULT NULL COMMENT '会员是否主动推荐1是0否',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhd_member_extend_information`
--

LOCK TABLES `zhd_member_extend_information` WRITE;
/*!40000 ALTER TABLE `zhd_member_extend_information` DISABLE KEYS */;
INSERT INTO `zhd_member_extend_information` VALUES (86246,NULL,NULL,NULL,NULL,NULL,0,0,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `zhd_member_extend_information` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-21 15:31:50
