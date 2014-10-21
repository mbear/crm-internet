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
-- Table structure for table `client_info`
--

DROP TABLE IF EXISTS `client_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_info` (
  `member_id` int(10) NOT NULL AUTO_INCREMENT,
  `member_code` varchar(20) DEFAULT NULL,
  `zhdaddress` varchar(100) DEFAULT NULL,
  `uid` int(10) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT '',
  `client_password` char(50) DEFAULT NULL,
  `client_introduction` varchar(512) DEFAULT '',
  `client_detail` text,
  `client_land` int(10) NOT NULL DEFAULT '0',
  `client_name` varchar(100) NOT NULL,
  `client_position` text,
  `client_gender` varchar(50) DEFAULT '',
  `client_birthday` datetime DEFAULT NULL,
  `client_email` varchar(200) DEFAULT NULL,
  `client_phone` varchar(200) DEFAULT NULL,
  `client_mobile` varchar(200) DEFAULT NULL,
  `client_mobileTwo` varchar(200) DEFAULT NULL,
  `client_nation` varchar(50) DEFAULT NULL,
  `client_animalzodiac` varchar(10) DEFAULT NULL,
  `client_birthplace` varchar(200) DEFAULT NULL,
  `client_nationality` varchar(200) DEFAULT NULL,
  `client_nativeplace` varchar(200) DEFAULT NULL,
  `client_home` varchar(200) DEFAULT NULL,
  `secritrice_name` varchar(100) DEFAULT NULL,
  `secritrice_gender` varchar(2) DEFAULT NULL,
  `secritrice_title` varchar(100) DEFAULT NULL,
  `secritrice_email` varchar(200) DEFAULT NULL,
  `secritrice_phone` varchar(50) DEFAULT NULL,
  `secritrice_mobile` varchar(20) DEFAULT NULL,
  `reterence_name` varchar(100) DEFAULT NULL,
  `reterence_enterprise` varchar(200) DEFAULT NULL,
  `reterence_job` varchar(50) DEFAULT NULL,
  `reterence_email` varchar(200) DEFAULT NULL,
  `reterence_phone` varchar(20) DEFAULT NULL,
  `reterence_mobile` varchar(20) DEFAULT NULL,
  `reterence_gender` varchar(50) DEFAULT NULL,
  `reterence_memberid` int(10) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `follow_status` int(10) DEFAULT NULL,
  `datasource` int(10) NOT NULL,
  `datastatus` int(10) DEFAULT NULL,
  `Decisionref_Remark` text,
  `approve_status` int(10) NOT NULL DEFAULT '0',
  `remark` text,
  `org_id` int(10) NOT NULL DEFAULT '0',
  `file1` varchar(200) DEFAULT NULL,
  `file2` varchar(200) DEFAULT NULL,
  `file3` varchar(200) DEFAULT NULL,
  `approve_time` datetime DEFAULT NULL,
  `apply_remark` varchar(200) DEFAULT NULL,
  `cardtype` varchar(200) DEFAULT NULL,
  `cardnumber` varchar(200) DEFAULT NULL,
  `socialposition` text,
  `submit_time` datetime DEFAULT NULL,
  `pay_status` int(10) NOT NULL DEFAULT '0',
  `submitcontact_status` int(10) NOT NULL DEFAULT '0',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `client_mailingaddress` text,
  `client_postalcode` varchar(100) DEFAULT NULL,
  `client_politics_status` varchar(50) DEFAULT NULL,
  `client_stature` decimal(10,2) DEFAULT NULL,
  `client_weight` decimal(10,2) DEFAULT NULL,
  `client_fax` varchar(50) DEFAULT NULL,
  `client_im` varchar(100) DEFAULT NULL,
  `client_education_background` text,
  `client_field` text,
  `client_research_directions` text,
  `client_twitter` varchar(100) DEFAULT NULL,
  `client_specific_character` text,
  `client_friends_circle` text,
  `client_tags` varchar(200) DEFAULT NULL,
  `client_blog_url` varchar(200) DEFAULT NULL,
  `client_role` int(10) NOT NULL DEFAULT '0',
  `client_status` int(10) NOT NULL DEFAULT '0',
  `zhisland` char(2) DEFAULT NULL,
  `client_province` text,
  `client_city` text,
  `client_department` varchar(100) DEFAULT NULL,
  `data_type` int(10) NOT NULL DEFAULT '0',
  `data_status` int(10) NOT NULL DEFAULT '1',
  `client_age` varchar(100) DEFAULT NULL,
  `decisionref_type` int(10) NOT NULL DEFAULT '0',
  `decisionref_status` int(10) NOT NULL DEFAULT '0',
  `companyname` varchar(100) DEFAULT NULL,
  `sendfrom` varchar(10) DEFAULT NULL,
  `personnm` varchar(50) DEFAULT NULL,
  `vip` char(20) DEFAULT NULL,
  `Institutions_attribute` varchar(200) DEFAULT NULL,
  `Rating_report` varchar(50) DEFAULT NULL,
  `market_type` int(10) NOT NULL DEFAULT '0',
  `client_type` varchar(20) DEFAULT NULL,
  `vvip` char(20) DEFAULT NULL,
  `isfans` bit(1) DEFAULT NULL,
  `social_title` varchar(50) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  `isShareholder` int(10) DEFAULT NULL,
  `client_source` varchar(100) DEFAULT NULL,
  `shareholderReterence_name` varchar(100) DEFAULT NULL,
  `webClose_time` datetime DEFAULT NULL,
  `webOpen_time` datetime DEFAULT NULL,
  `secondApprove_time` datetime DEFAULT NULL,
  `web_status` int(10) NOT NULL DEFAULT '0',
  `enterpriser_1` varchar(20) DEFAULT NULL,
  `enterpriser_1_contact` varchar(50) DEFAULT NULL,
  `enterpriser_2` varchar(20) DEFAULT NULL,
  `enterpriser_2_contact` varchar(50) DEFAULT NULL,
  `enterpriser_3` varchar(20) DEFAULT NULL,
  `enterpriser_3_contact` varchar(50) DEFAULT NULL,
  `enterpriser_4` varchar(20) DEFAULT NULL,
  `enterpriser_4_contact` varchar(50) DEFAULT NULL,
  `enterpriser_5` varchar(20) DEFAULT NULL,
  `enterpriser_5_contact` varchar(50) DEFAULT NULL,
  `related_person1` varchar(50) DEFAULT NULL,
  `related_person2` varchar(50) DEFAULT NULL,
  `related_person3` varchar(50) DEFAULT NULL,
  `related_person4` varchar(50) DEFAULT NULL,
  `related_person5` varchar(50) DEFAULT NULL,
  `datasourceID` text,
  `datasourceRemark` text,
  `ispioneer` int(10) NOT NULL DEFAULT '0',
  `Client_will` int(10) NOT NULL DEFAULT '1',
  `is_hight_quality` int(10) NOT NULL DEFAULT '0',
  `reterence_desc` text,
  `school_name` text,
  `education_type` int(10) DEFAULT NULL,
  `education_major` text,
  `school_name_two` text,
  `education_type_two` int(10) DEFAULT NULL,
  `education_major_two` text,
  `business_college` text,
  `college_type` int(10) DEFAULT NULL,
  `college_major` text,
  `commuting_province` text,
  `renew_approve_status` int(10) NOT NULL DEFAULT '0',
  `renew_begin_time` datetime DEFAULT NULL,
  `renew_end_time` datetime DEFAULT NULL,
  `renew_status` int(10) NOT NULL DEFAULT '0',
  `secondsubmit_status` varchar(128) DEFAULT NULL,
  `kik_id` varchar(200) DEFAULT NULL,
  `service_name` varchar(20) DEFAULT NULL,
  `member_address` varchar(50) DEFAULT NULL,
  `qq_id` varchar(200) DEFAULT NULL,
  `member_assets` varchar(50) DEFAULT NULL,
  `tribe_position` text,
  `zhisland_position` text,
  `sina_id` varchar(200) DEFAULT NULL,
  `is_freeze` tinyint(4) DEFAULT NULL,
  `freeze_time` datetime DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  KEY `datastatus` (`datastatus`),
  KEY `pay_status` (`pay_status`),
  KEY `approve_status` (`approve_status`),
  KEY `username` (`username`),
  KEY `service_name` (`service_name`)
) ENGINE=InnoDB AUTO_INCREMENT=86345 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_info`
--

LOCK TABLES `client_info` WRITE;
/*!40000 ALTER TABLE `client_info` DISABLE KEYS */;
INSERT INTO `client_info` VALUES (86246,NULL,NULL,NULL,'',NULL,'','',0,'牟宗彦','首席执行官','',NULL,'test@test.com','010-11111111','15855555555','15811111111',NULL,NULL,NULL,NULL,NULL,NULL,'','',NULL,'test2@test.com','010-88888888','15822222222',NULL,NULL,NULL,NULL,'010-55555555','15833333333',NULL,NULL,'liqian',NULL,92,1,NULL,0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,'765287652876536419',NULL,NULL,1,1,'2014-08-26 00:42:12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,0,NULL,0,0,NULL,NULL,NULL,NULL,NULL,NULL,0,'2',NULL,NULL,NULL,NULL,0,NULL,'',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0,NULL,NULL,'liqian',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `client_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-21 15:25:48
