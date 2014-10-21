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
-- Table structure for table `enterprise_info`
--

DROP TABLE IF EXISTS `enterprise_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enterprise_info` (
  `enterpirse_id` int(10) NOT NULL AUTO_INCREMENT,
  `member_id` int(10) NOT NULL,
  `enterprice_cn_name` varchar(200) DEFAULT NULL,
  `enterprise_industry` varchar(100) DEFAULT NULL,
  `enterprise_main_industry` int(10) DEFAULT NULL,
  `enterprise_business_capabilities` text,
  `enterprise_newturnover` int(10) DEFAULT NULL,
  `enterprise_turnover` varchar(100) DEFAULT NULL,
  `enterprise_province` text,
  `enterprise_city` text,
  `enterprise_en_name` text,
  `is_public_company` varchar(50) DEFAULT NULL,
  `enterprise_url` varchar(200) DEFAULT NULL,
  `enterprise_staff_num` varchar(100) DEFAULT NULL,
  `stock_code` varchar(20) DEFAULT NULL,
  `stock_description` varchar(50) DEFAULT NULL,
  `gopublic_address` varchar(50) DEFAULT NULL,
  `board_secretary` varchar(50) DEFAULT NULL,
  `enterprise_email` varchar(200) DEFAULT NULL,
  `enterprise_register_datetime` datetime DEFAULT NULL,
  `register_address` varchar(200) DEFAULT NULL,
  `license_code` varchar(100) DEFAULT NULL,
  `current_register_address` varchar(200) DEFAULT NULL,
  `current_office_address` varchar(200) DEFAULT NULL,
  `legal_representative` varchar(50) DEFAULT NULL,
  `Annualsalesvolume` varchar(200) DEFAULT NULL,
  `enterprise_divide` int(10) DEFAULT NULL,
  `enterprise_county` text,
  `enterprise_type` int(10) DEFAULT NULL,
  `enterprise_nature` int(10) DEFAULT NULL,
  `enterprise_brand` text,
  `business_scope` text COMMENT '经营范围',
  `core_business` text COMMENT '主营业务/产品',
  `registered_capital` decimal(19,4) DEFAULT NULL,
  `announced_date` varchar(50) DEFAULT NULL,
  `enterprise_profile` text,
  `managerial_implications` text,
  `core_value` text,
  `announced_date_two` varchar(50) DEFAULT NULL,
  `announced_date_three` varchar(50) DEFAULT NULL,
  `gopublic_address_two` varchar(200) DEFAULT NULL,
  `gopublic_address_three` varchar(200) DEFAULT NULL,
  `stock_code_two` varchar(100) DEFAULT NULL,
  `stock_code_three` varchar(100) DEFAULT NULL,
  `enterprise_honor` text,
  `industry` text,
  `attention_industry` text,
  PRIMARY KEY (`enterpirse_id`),
  KEY `member_id` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70163 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enterprise_info`
--

LOCK TABLES `enterprise_info` WRITE;
/*!40000 ALTER TABLE `enterprise_info` DISABLE KEYS */;
INSERT INTO `enterprise_info` VALUES (69291,86246,'啪啪啪有限公司','',266,NULL,229,NULL,'北京',NULL,'','否',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `enterprise_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-21 15:26:56
