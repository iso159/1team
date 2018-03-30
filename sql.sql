-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: iso159.cafe24.com    Database: iso159
-- ------------------------------------------------------
-- Server version	5.5.17-log

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
-- Table structure for table `t_adopt`
--

DROP TABLE IF EXISTS `t_adopt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_adopt` (
  `adopt_code` varchar(35) NOT NULL COMMENT '입양자 코드(PK)',
  `bl_code` varchar(35) NOT NULL COMMENT '보호소 통합 관리 코드(PK)',
  `animal_code` varchar(35) NOT NULL COMMENT '동물 코드(FK)',
  `adopt_request_code` varchar(35) NOT NULL COMMENT '입양 코드(FK)',
  `m_member_id` varchar(35) NOT NULL COMMENT '회원 아이디(PK)',
  `m_admin_id` varchar(35) DEFAULT NULL COMMENT '관리자 아이디(FK)',
  `adopt_date` datetime NOT NULL COMMENT '입양자 등록 날짜',
  PRIMARY KEY (`adopt_code`),
  KEY `FK_adopt_request_TO_adopt` (`adopt_request_code`),
  KEY `FK_member_TO_adopt2` (`m_member_id`),
  KEY `FK_member_TO_adopt` (`m_admin_id`),
  KEY `FK_business_license_TO_adopt` (`bl_code`),
  KEY `FK_animal_TO_adopt` (`animal_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='입양자 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_adopt`
--

LOCK TABLES `t_adopt` WRITE;
/*!40000 ALTER TABLE `t_adopt` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_adopt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_adopt_jindan`
--

DROP TABLE IF EXISTS `t_adopt_jindan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_adopt_jindan` (
  `adopt_jindan_code` varchar(35) NOT NULL COMMENT '입양자 진단서 코드(PK)',
  `bl_code` varchar(35) NOT NULL COMMENT '보호소 통합 관리 코드(FK)',
  `m_member_id` varchar(35) NOT NULL COMMENT '회원 아이디(FK)',
  `m_shelter_id` varchar(35) DEFAULT NULL COMMENT '보호소 아이디(FK)',
  `adopt_code` varchar(35) NOT NULL COMMENT '입양자 코드(FK)',
  `jindan_code` varchar(35) NOT NULL COMMENT '진단서 코드(FK)',
  `adopt_jindan_date` datetime NOT NULL COMMENT '진단서 등록 일자',
  PRIMARY KEY (`adopt_jindan_code`),
  KEY `FK_adopt_TO_adopt_jindan` (`adopt_code`),
  KEY `FK_jindan_TO_adopt_jindan` (`jindan_code`),
  KEY `FK_member_TO_adopt_jindan` (`m_member_id`),
  KEY `FK_member_TO_adopt_jindan2` (`m_shelter_id`),
  KEY `FK_business_license_TO_adopt_jindan` (`bl_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='입양자 진단서 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_adopt_jindan`
--

LOCK TABLES `t_adopt_jindan` WRITE;
/*!40000 ALTER TABLE `t_adopt_jindan` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_adopt_jindan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_adopt_request`
--

DROP TABLE IF EXISTS `t_adopt_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_adopt_request` (
  `adopt_request_code` varchar(35) NOT NULL COMMENT '입양 신청 코드(PK)',
  `animal_code` varchar(35) NOT NULL COMMENT '동물 코드(FK)',
  `bl_code` varchar(35) NOT NULL COMMENT '보호소 통합 관리 코드(FK)',
  `m_member_id` varchar(35) NOT NULL COMMENT '회원아이디(FK)',
  `m_shelter_id` varchar(35) DEFAULT NULL COMMENT '보호소 아이디(FK)',
  `os_code_adopt` varchar(35) NOT NULL COMMENT '입양 상태 코드(FK)',
  `adopt_request_reason` varchar(1000) NOT NULL COMMENT '입양 이유',
  `adopt_request_advice_contents` varchar(2000) DEFAULT NULL COMMENT '상담 내용',
  `adopt_request_date` datetime NOT NULL COMMENT '입양 신청 날짜',
  `adopt_request_advice_date` datetime DEFAULT NULL COMMENT '입양 상담 날짜',
  `adopt_decide_date` datetime DEFAULT NULL COMMENT '입양 결정 날짜',
  `adopt_refused_reason` varchar(1000) DEFAULT NULL COMMENT '거절 사유',
  `adopt_point` int(11) NOT NULL COMMENT '입양 포인트',
  PRIMARY KEY (`adopt_request_code`),
  KEY `FK_animal_TO_adopt_request` (`animal_code`),
  KEY `FK_member_TO_adopt_request` (`m_member_id`),
  KEY `FK_overall_status_TO_adopt_request` (`os_code_adopt`),
  KEY `FK_member_TO_adopt_request2` (`m_shelter_id`),
  KEY `FK_business_license_TO_adopt_request` (`bl_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='입양 신청 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_adopt_request`
--

LOCK TABLES `t_adopt_request` WRITE;
/*!40000 ALTER TABLE `t_adopt_request` DISABLE KEYS */;
INSERT INTO `t_adopt_request` VALUES ('adopt_request_code_6','animal_code_01','bl_code_01','m_04',NULL,'os_adopt_4_1_1','test',NULL,'2018-03-30 11:15:16',NULL,NULL,NULL,500),('adopt_request_code_4','animal_code_02','bl_code_01','m_04',NULL,'os_adopt_4_1_7','하늘보리맛있다','<br>1. 유기동물 입양에 대해 가족 모두가 동의하였습니까?<br>,,<br>2. 입양 보내는 동물은 모두 중성화 수술을 하여 번식할 수 없습니다. 동의하시나요? (단, 입양 보내는 동물이 중성화 수술의 시기가 안 된 어린 동물의 경우, 입양자가 입양 후 케어와 약속한 시기에 직접 또는 케어와 연계하여 중성화 수술을 진행해야 합니다. 이 경우, 케어는 반드시 확인절차를 거칠 것이며, 이에 동의하여야 합니다.<br>,,<br>3. 입양 후에도 입양한 동물의 소유권은 케어에 있으며, 이는 동물학대 발생 시 동물의 압수를 위하여 필요함을 알려 드립니다. 동의하시나요? <br>,,<br>4. 만일 기르지 못하는 사정이 발생하였을 경우, 반드시 관리자로 통보를 해주어야 하며 본인 임의대로 재 입양을 보내서는 안 됩니다. 동의하시나요?<br>,,<br>5. 기르던 중 분실사고가 발생했을 때는 반드시 그날 즉시 관리자에 알리고 관리자와 함께 찾을 수 있도록 최선을 다해야 합니다. 동의하시나요?<br>,,<br>6. 입양 후, 이 동물에 대한 주요 책임자는 누구입니까? (주요 책임자의 나이는 20세 이상이어야 함. 18세미만은 부모님의 동의가 필요합니다)<br>,,<br>7. 반려동물이 하루에 몇 시간 동안 혼자 있게 되나요?<br>,,<br>8. 며칠 동안 집을 비우는 경우 어떻게 하시겠습니까?<br>,,<br>9. 하의 환경 및 가족 사항에 변화가 생기면(이혼, 이별, 이사, 이민, 사망 등), 어떻게 하시겠습니까?<br>,,<br>10. 구조된 동물의 경우, 사람과 집 생활에 길들여지지 않은 경우가 있습니다. 이 점에 대해 이해할 수 있으신가요?<br>,,<br>11. 새로운 환경에 적응할 때까지 용변을 가리지 못할 수 있습니다. 용변훈련은 입양 후 새로 시작해야 합니다. 동의하시나요?<br>,,<br>12. 어떻게 훈련을 시킬 것인지 구체적으로 설명해 주십시오. (본인이 직접 또는 전문가를 통해서 등)<br>,,<br>13. 어떻게 운동을 시킬 것인지 구체적으로 설명해 주십시오.<br>,,<br>14. 집에서 정성껏 만든 음식을 먹이시길 추천합니다. 그렇지 못할 경우 어떤 종료의 사료를 먹일 것이며, 선호하는 브랜드가 있다면 설명해 주십시오.<br>,,<br>15. 동물에게 폭력을 행사해서는 안 되며, 쾌적한 환경과 먹이, 식수를 제공해 주어야 합니다. 또한, 임의 유기나 <br>,,<br>16. 입양한 동물이 자연사할 때까지 기를 각오가 되어 있으신가요? <br>,,<br>17. 입양이 확정되어 동물이 가정에 도착하면 가장 먼저 사진을 찍어 입양센터로 보내주시고 도착소식을 반드시 전해 주셔야합니다. 이에 동의하시나요?  <br>,,<br>18. 입양 후 3개월에 1회씩 입양한 동물의 사진과 이야기를 입양후기에 올려야하며 입양 후 케어의 가정방문이 <br>,,<br>19. 입양한 아이를 파양 할 경우 , 앞으로 저희 협회를  통한 다른 동물의 입양은 1년간 제한됩니다.<br>,','2018-03-28 10:42:09','2018-03-28 10:43:57','2018-03-28 10:43:59',NULL,500),('adopt_request_code_5','animal_code_02','bl_code_01','m_04',NULL,'os_adopt_4_1_2','인석이',NULL,'2018-03-28 10:42:51',NULL,NULL,NULL,500),('adopt_request_code_3','animal_code_02','bl_code_01','m_04',NULL,'os_adopt_4_1_5','ㅓㅓㅓㅓㅓ','<br>1. 유기동물 입양에 대해 가족 모두가 동의하였습니까?<br>,넵,<br>2. 입양 보내는 동물은 모두 중성화 수술을 하여 번식할 수 없습니다. 동의하시나요? (단, 입양 보내는 동물이 중성화 수술의 시기가 안 된 어린 동물의 경우, 입양자가 입양 후 케어와 약속한 시기에 직접 또는 케어와 연계하여 중성화 수술을 진행해야 합니다. 이 경우, 케어는 반드시 확인절차를 거칠 것이며, 이에 동의하여야 합니다.<br>,넵,<br>3. 입양 후에도 입양한 동물의 소유권은 케어에 있으며, 이는 동물학대 발생 시 동물의 압수를 위하여 필요함을 알려 드립니다. 동의하시나요? <br>,넵,<br>4. 만일 기르지 못하는 사정이 발생하였을 경우, 반드시 관리자로 통보를 해주어야 하며 본인 임의대로 재 입양을 보내서는 안 됩니다. 동의하시나요?<br>,넵,<br>5. 기르던 중 분실사고가 발생했을 때는 반드시 그날 즉시 관리자에 알리고 관리자와 함께 찾을 수 있도록 최선을 다해야 합니다. 동의하시나요?<br>,넵,<br>6. 입양 후, 이 동물에 대한 주요 책임자는 누구입니까? (주요 책임자의 나이는 20세 이상이어야 함. 18세미만은 부모님의 동의가 필요합니다)<br>,넵넵,<br>7. 반려동물이 하루에 몇 시간 동안 혼자 있게 되나요?<br>,넵,<br>8. 며칠 동안 집을 비우는 경우 어떻게 하시겠습니까?<br>,넵,<br>9. 하의 환경 및 가족 사항에 변화가 생기면(이혼, 이별, 이사, 이민, 사망 등), 어떻게 하시겠습니까?<br>,넵!넵,<br>10. 구조된 동물의 경우, 사람과 집 생활에 길들여지지 않은 경우가 있습니다. 이 점에 대해 이해할 수 있으신가요?<br>,넵,<br>11. 새로운 환경에 적응할 때까지 용변을 가리지 못할 수 있습니다. 용변훈련은 입양 후 새로 시작해야 합니다. 동의하시나요?<br>,넵,<br>12. 어떻게 훈련을 시킬 것인지 구체적으로 설명해 주십시오. (본인이 직접 또는 전문가를 통해서 등)<br>,넵,<br>13. 어떻게 운동을 시킬 것인지 구체적으로 설명해 주십시오.<br>,넵,<br>14. 집에서 정성껏 만든 음식을 먹이시길 추천합니다. 그렇지 못할 경우 어떤 종료의 사료를 먹일 것이며, 선호하는 브랜드가 있다면 설명해 주십시오.<br>,넵,<br>15. 동물에게 폭력을 행사해서는 안 되며, 쾌적한 환경과 먹이, 식수를 제공해 주어야 합니다. 또한, 임의 유기나 <br>,넵,<br>16. 입양한 동물이 자연사할 때까지 기를 각오가 되어 있으신가요? <br>,넵,<br>17. 입양이 확정되어 동물이 가정에 도착하면 가장 먼저 사진을 찍어 입양센터로 보내주시고 도착소식을 반드시 전해 주셔야합니다. 이에 동의하시나요?  <br>,넵,<br>18. 입양 후 3개월에 1회씩 입양한 동물의 사진과 이야기를 입양후기에 올려야하며 입양 후 케어의 가정방문이 <br>,넵,<br>19. 입양한 아이를 파양 할 경우 , 앞으로 저희 협회를  통한 다른 동물의 입양은 1년간 제한됩니다.<br>,넵!','2018-03-28 10:41:29','2018-03-28 10:43:40',NULL,NULL,500),('adopt_request_code_2','animal_code_02','bl_code_01','m_04',NULL,'os_adopt_4_1_2','귀여워너무',NULL,'2018-03-28 10:40:11',NULL,NULL,NULL,500),('adopt_request_code_1','animal_code_01','bl_code_01','m_04',NULL,'os_adopt_4_1_7','ㅇㅇㅇ','<br>1. 유기동물 입양에 대해 가족 모두가 동의하였습니까?<br>,ㅇ,<br>2. 입양 보내는 동물은 모두 중성화 수술을 하여 번식할 수 없습니다. 동의하시나요? (단, 입양 보내는 동물이 중성화 수술의 시기가 안 된 어린 동물의 경우, 입양자가 입양 후 케어와 약속한 시기에 직접 또는 케어와 연계하여 중성화 수술을 진행해야 합니다. 이 경우, 케어는 반드시 확인절차를 거칠 것이며, 이에 동의하여야 합니다.<br>,ㅇ,<br>3. 입양 후에도 입양한 동물의 소유권은 케어에 있으며, 이는 동물학대 발생 시 동물의 압수를 위하여 필요함을 알려 드립니다. 동의하시나요? <br>,ㅇ,<br>4. 만일 기르지 못하는 사정이 발생하였을 경우, 반드시 관리자로 통보를 해주어야 하며 본인 임의대로 재 입양을 보내서는 안 됩니다. 동의하시나요?<br>,,<br>5. 기르던 중 분실사고가 발생했을 때는 반드시 그날 즉시 관리자에 알리고 관리자와 함께 찾을 수 있도록 최선을 다해야 합니다. 동의하시나요?<br>,,<br>6. 입양 후, 이 동물에 대한 주요 책임자는 누구입니까? (주요 책임자의 나이는 20세 이상이어야 함. 18세미만은 부모님의 동의가 필요합니다)<br>,,<br>7. 반려동물이 하루에 몇 시간 동안 혼자 있게 되나요?<br>,,<br>8. 며칠 동안 집을 비우는 경우 어떻게 하시겠습니까?<br>,,<br>9. 하의 환경 및 가족 사항에 변화가 생기면(이혼, 이별, 이사, 이민, 사망 등), 어떻게 하시겠습니까?<br>,,<br>10. 구조된 동물의 경우, 사람과 집 생활에 길들여지지 않은 경우가 있습니다. 이 점에 대해 이해할 수 있으신가요?<br>,ㅇ,<br>11. 새로운 환경에 적응할 때까지 용변을 가리지 못할 수 있습니다. 용변훈련은 입양 후 새로 시작해야 합니다. 동의하시나요?<br>,,<br>12. 어떻게 훈련을 시킬 것인지 구체적으로 설명해 주십시오. (본인이 직접 또는 전문가를 통해서 등)<br>,,<br>13. 어떻게 운동을 시킬 것인지 구체적으로 설명해 주십시오.<br>,,<br>14. 집에서 정성껏 만든 음식을 먹이시길 추천합니다. 그렇지 못할 경우 어떤 종료의 사료를 먹일 것이며, 선호하는 브랜드가 있다면 설명해 주십시오.<br>,,<br>15. 동물에게 폭력을 행사해서는 안 되며, 쾌적한 환경과 먹이, 식수를 제공해 주어야 합니다. 또한, 임의 유기나 <br>,,<br>16. 입양한 동물이 자연사할 때까지 기를 각오가 되어 있으신가요? <br>,,<br>17. 입양이 확정되어 동물이 가정에 도착하면 가장 먼저 사진을 찍어 입양센터로 보내주시고 도착소식을 반드시 전해 주셔야합니다. 이에 동의하시나요?  <br>,,<br>18. 입양 후 3개월에 1회씩 입양한 동물의 사진과 이야기를 입양후기에 올려야하며 입양 후 케어의 가정방문이 <br>,,<br>19. 입양한 아이를 파양 할 경우 , 앞으로 저희 협회를  통한 다른 동물의 입양은 1년간 제한됩니다.<br>,','2018-03-28 10:07:14','2018-03-28 10:13:16','2018-03-28 10:13:20',NULL,500);
/*!40000 ALTER TABLE `t_adopt_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_animal`
--

DROP TABLE IF EXISTS `t_animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_animal` (
  `animal_code` varchar(35) NOT NULL COMMENT '동물 코드(PK)',
  `os_code_animal` varchar(35) NOT NULL COMMENT '동물 상태 코드(FK)',
  `bl_code` varchar(35) NOT NULL COMMENT '보호소 통합 관리 코드(FK)',
  `m_shelter_id` varchar(35) NOT NULL COMMENT '보호소 아이디(FK)',
  `os_code_kind` varchar(35) NOT NULL COMMENT '동물 종류 코드(FK)',
  `animal_breed` varchar(10) NOT NULL COMMENT '품종(api)',
  `animal_area` varchar(10) NOT NULL COMMENT '지역(api)',
  `animal_id_code` varchar(15) NOT NULL COMMENT '동물 식별코드(api)',
  `animal_weight` double NOT NULL COMMENT '체중(api)',
  `animal_age` int(11) NOT NULL COMMENT '나이(api)',
  `animal_enroll_date` date NOT NULL COMMENT '등록 날짜(api)',
  PRIMARY KEY (`animal_code`),
  KEY `FK_member_TO_animal` (`m_shelter_id`),
  KEY `FK_overall_status_TO_animal` (`os_code_animal`),
  KEY `FK_overall_status_TO_animal2` (`os_code_kind`),
  KEY `FK_business_license_TO_animal` (`bl_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='동물 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_animal`
--

LOCK TABLES `t_animal` WRITE;
/*!40000 ALTER TABLE `t_animal` DISABLE KEYS */;
INSERT INTO `t_animal` VALUES ('animal_code_02','os_animal_3_1_2','bl_code_01','m_02','os_animal_kinds_11_1_1','진돗개','덕진동','170103덕진2',6,1,'2018-03-16'),('animal_code_03','os_animal_3_1_3','bl_code_02','m_07','os_animal_kinds_11_1_1','닥스훈트','효자동','170104효자1',7,2,'2018-03-16'),('animal_code_04','os_animal_3_1_3','bl_code_02','m_07','os_animal_kinds_11_1_1','시츄','효자동','170102효자2',5,3,'2018-03-16'),('animal_code_05','os_animal_3_1_2','bl_code_02','m_07','os_animal_kinds_11_1_1','말티즈','효자동','170102효자3',12,2,'2018-03-16'),('animal_code_7','os_animal_3_1_1','','m_03','os_animal_kinds_11_1_1','2','2','2',2,2,'2018-03-29'),('animal_code_6','os_animal_3_1_1','','m_03','os_animal_kinds_11_1_1','말티즈','전주','1',1,1,'2018-03-29'),('animal_code_11','os_animal_3_1_1','','m_03','os_animal_kinds_11_1_1','9','9','9',9,9,'2018-03-29');
/*!40000 ALTER TABLE `t_animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_board`
--

DROP TABLE IF EXISTS `t_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_board` (
  `board_code` varchar(35) NOT NULL COMMENT '게시판 코드(PK)',
  `m_admin_id` varchar(35) NOT NULL COMMENT '관리자 아이디(FK)',
  `board_name` varchar(100) NOT NULL COMMENT '게시판 명',
  `board_date` date NOT NULL COMMENT '게시판 생성 날짜',
  PRIMARY KEY (`board_code`),
  KEY `FK_member_TO_board` (`m_admin_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='게시판 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_board`
--

LOCK TABLES `t_board` WRITE;
/*!40000 ALTER TABLE `t_board` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_board_content`
--

DROP TABLE IF EXISTS `t_board_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_board_content` (
  `board_content_code` varchar(35) NOT NULL COMMENT '게시판 본문 코드(PK)',
  `board_code` varchar(35) NOT NULL COMMENT '게시판 코드(FK)',
  `m_member_id` varchar(35) NOT NULL COMMENT '회원 아이디(FK)',
  `board_content_title` varchar(100) NOT NULL COMMENT '제목',
  `board_content_content` varchar(255) NOT NULL COMMENT '내용',
  `board_content_date` datetime NOT NULL COMMENT '게시글 등록날짜',
  PRIMARY KEY (`board_content_code`),
  KEY `FK_board_TO_board_content` (`board_code`),
  KEY `FK_member_TO_board_content` (`m_member_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='게시판 본문 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_board_content`
--

LOCK TABLES `t_board_content` WRITE;
/*!40000 ALTER TABLE `t_board_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_board_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_board_reply`
--

DROP TABLE IF EXISTS `t_board_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_board_reply` (
  `board_reply_code` varchar(35) NOT NULL COMMENT '게시판 댓글 코드(PK)',
  `board_content_code` varchar(35) NOT NULL COMMENT '게시판 본문 코드(FK)',
  `m_member_id` varchar(35) NOT NULL COMMENT '회원 아이디(FK)',
  `board_reply_content` varchar(255) NOT NULL COMMENT '댓글 내용',
  `board_reply_date` datetime NOT NULL COMMENT '게시판 댓글 생성 날짜',
  PRIMARY KEY (`board_reply_code`),
  KEY `FK_board_content_TO_board_reply` (`board_content_code`),
  KEY `FK_member_TO_board_reply` (`m_member_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='게시판 댓글 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_board_reply`
--

LOCK TABLES `t_board_reply` WRITE;
/*!40000 ALTER TABLE `t_board_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_board_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_business_license`
--

DROP TABLE IF EXISTS `t_business_license`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_business_license` (
  `bl_code` varchar(35) NOT NULL COMMENT '보호소 통합 관리 코드(PK)',
  `m_member_id` varchar(35) NOT NULL COMMENT '회원아이디(FK)',
  `os_code_license_status` varchar(35) NOT NULL COMMENT '사업자 등록 현황 코드(FK)',
  `bl_shelter_name` varchar(15) NOT NULL COMMENT '보호소 이름',
  `bl_shelter_number` varchar(15) NOT NULL COMMENT '보호소(사업자) 번호',
  `bl_shelter_postcode` varchar(15) NOT NULL COMMENT '보호소 우편번호',
  `bl_shelter_address` varchar(50) NOT NULL COMMENT '보호소 주소',
  `bl_shelter_deny_reason` varchar(1000) DEFAULT NULL,
  `bl_shelter_date` datetime NOT NULL COMMENT '사업자 등록 신청 날짜',
  PRIMARY KEY (`bl_code`),
  KEY `FK_member_TO_business_license` (`m_member_id`),
  KEY `FK_overall_status_TO_business_license` (`os_code_license_status`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='보호소 통합 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_business_license`
--

LOCK TABLES `t_business_license` WRITE;
/*!40000 ALTER TABLE `t_business_license` DISABLE KEYS */;
INSERT INTO `t_business_license` VALUES ('bl_code_01','m_02','os_business_1_1_3','참조은동물병원','123456789','55236','덕진구 덕진동',NULL,'2018-03-15 00:00:00'),('bl_code_02','m_09','os_business_1_1_3','유앤아이동물병원','2336856452','23564','완산구 효자동',NULL,'2018-03-15 00:00:00'),('bl_code_3','312','os_business_1_1_3','행보칸보호소','01011233356','52136','삼천동','ㅎㅎ','2018-03-22 00:00:00'),('bl_code_4','1','os_business_1_1_4','123','123','123','123','송인석임','2018-03-22 00:00:00'),('bl_code_16','login','os_business_1_1_2','fileTest','1234','1234','1234','난 싫음','2018-03-26 15:40:55');
/*!40000 ALTER TABLE `t_business_license` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cost_io`
--

DROP TABLE IF EXISTS `t_cost_io`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cost_io` (
  `cost_io_code` varchar(35) NOT NULL COMMENT '책임비 입출 코드(PK)',
  `exp_code` varchar(35) NOT NULL COMMENT '체험 코드(FK)',
  `os_code` varchar(35) NOT NULL COMMENT '책임비 분류 코드(FK)',
  `cost_io_cost` int(11) NOT NULL COMMENT '책임비',
  PRIMARY KEY (`cost_io_code`),
  KEY `FK_exp_TO_cost_io` (`exp_code`),
  KEY `FK_overall_status_TO_cost_io` (`os_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='책임비 입출 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cost_io`
--

LOCK TABLES `t_cost_io` WRITE;
/*!40000 ALTER TABLE `t_cost_io` DISABLE KEYS */;
INSERT INTO `t_cost_io` VALUES ('cost_io_code_01','exp_code_01','os_cost_return_13_1_1',50000),('cost_io_code_02','exp_code_01','os_cost_return_13_1_2',50000);
/*!40000 ALTER TABLE `t_cost_io` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_diagnosis_eyes`
--

DROP TABLE IF EXISTS `t_diagnosis_eyes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_diagnosis_eyes` (
  `de_code` varchar(35) NOT NULL COMMENT '진단서 눈상태코드(PK)',
  `jindan_code` varchar(35) NOT NULL COMMENT '진단서 코드(PK)',
  `os_cornea` varchar(35) NOT NULL COMMENT '각막(PK)',
  `os_conjunctiva` varchar(35) NOT NULL COMMENT '결막(PK)',
  `os_crystalline` varchar(35) NOT NULL COMMENT '수정체(PK)',
  `os_normal` varchar(35) NOT NULL COMMENT '상태이상유무(PK)',
  PRIMARY KEY (`de_code`),
  KEY `FK_overall_status_TO_diagnosis_eyes` (`os_cornea`),
  KEY `FK_overall_status_TO_diagnosis_eyes2` (`os_conjunctiva`),
  KEY `FK_jindan_TO_diagnosis_eyes` (`jindan_code`),
  KEY `FK_overall_status_TO_diagnosis_eyes3` (`os_crystalline`),
  KEY `FK_overall_status_TO_diagnosis_eyes4` (`os_normal`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='진단서 눈상태';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_diagnosis_eyes`
--

LOCK TABLES `t_diagnosis_eyes` WRITE;
/*!40000 ALTER TABLE `t_diagnosis_eyes` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_diagnosis_eyes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_exp`
--

DROP TABLE IF EXISTS `t_exp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_exp` (
  `exp_code` varchar(35) NOT NULL COMMENT '체험 코드(PK)',
  `animal_code` varchar(35) NOT NULL COMMENT '동물 코드(FK)',
  `m_exp_id` varchar(35) NOT NULL COMMENT '체험자아이디(FK)',
  `m_shelter_id_accept` varchar(35) DEFAULT NULL COMMENT '보호소아이디(FK)',
  `m_shelter_id_check` varchar(35) DEFAULT NULL,
  `bl_code` varchar(35) NOT NULL COMMENT '보호소 통합 관리 코드(FK)',
  `exp_period_code` varchar(35) NOT NULL COMMENT '동물 체험 기간 코드(FK)',
  `os_code_exp` varchar(35) NOT NULL COMMENT '체험 예약 상태(FK)',
  `os_code_cost_return` varchar(35) NOT NULL COMMENT '책임비 반환 상태(FK)',
  `exp_journal_count` int(11) NOT NULL COMMENT '일지 횟수',
  `exp_cost` int(11) NOT NULL COMMENT '체험 책임비',
  `exp_purpose` varchar(1000) NOT NULL COMMENT '체험 목적',
  `exp_reserve_request_date` datetime NOT NULL COMMENT '예약 신청 날짜',
  `exp_check_date` datetime DEFAULT NULL COMMENT '예약 확인 날짜',
  `exp_start_date` date NOT NULL COMMENT '체험 시작 날짜',
  `exp_end_date` date NOT NULL COMMENT '체험 종료 기간',
  PRIMARY KEY (`exp_code`),
  KEY `FK_animal_TO_exp` (`animal_code`),
  KEY `FK_member_TO_exp` (`m_exp_id`),
  KEY `FK_exp_period_TO_exp` (`exp_period_code`),
  KEY `FK_member_TO_exp2` (`m_shelter_id_accept`),
  KEY `FK_overall_status_TO_exp` (`os_code_exp`),
  KEY `FK_overall_status_TO_exp2` (`os_code_cost_return`),
  KEY `FK_business_license_TO_exp` (`bl_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='유기동물 체험 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_exp`
--

LOCK TABLES `t_exp` WRITE;
/*!40000 ALTER TABLE `t_exp` DISABLE KEYS */;
INSERT INTO `t_exp` VALUES ('exp_code_01','animal_code_01','m_04','m_02','m_02','bl_code_01','exp_period_2_5_1','os_exp_12_1_2','os_cost_13_1_1',1,50000,'강아지와친해지고싶다','2018-03-15 00:00:00','2018-03-16 00:00:00','2018-03-17','2018-03-18'),('exp_code_4','animal_code_01','m_03','m_02','m_02','bl_code_01','exp_period_7_11_4','os_exp_12_1_1','os_cost_13_1_1',4,110000,'이제 제껍니다 하하','2018-03-22 16:22:53','2018-03-16 00:00:00','2018-03-30','2018-04-05'),('exp_code_5','animal_code_01','m_03','m_02','m_02','bl_code_01','exp_period_4_7_2','os_exp_12_1_2','os_cost_13_1_1',2,70000,'가즈아','2018-03-23 10:32:02','2018-03-16 00:00:00','2018-03-29','2018-04-01'),('exp_code_10','animal_code_02','m_03',NULL,NULL,'bl_code_01','exp_period_6_9_3','os_exp_12_1_3','os_cost_13_1_1',2,70000,'끄아앙','2018-03-28 14:25:32',NULL,'2018-03-29','2018-04-01'),('exp_code_9','animal_code_03','m_03',NULL,NULL,'bl_code_02','exp_period_7_11_4','os_exp_12_1_3','os_cost_13_1_1',4,110000,'ㄻㅇㄴㄹ','2018-03-28 10:23:56',NULL,'2018-03-29','2018-04-04'),('exp_code_8','animal_code_01','m_03',NULL,NULL,'bl_code_01','exp_period_7_11_4','os_exp_12_1_3','os_cost_13_1_1',4,110000,'ㅁㄴㅇ','2018-03-28 10:23:49',NULL,'2018-03-29','2018-04-04'),('exp_code_11','animal_code_01','m_04',NULL,NULL,'bl_code_01','exp_period_7_11_4','os_exp_12_1_3','os_cost_13_1_1',4,110000,'키운다 이녀석','2018-03-29 14:52:21',NULL,'2018-03-30','2018-04-05'),('exp_code_12','animal_code_01','m_03',NULL,NULL,'bl_code_01','exp_period_4_7_2','os_exp_12_1_3','os_cost_13_1_1',2,70000,'끄아앙','2018-03-29 16:28:03',NULL,'2018-03-29','2018-04-01'),('exp_code_13','animal_code_01','m_02',NULL,NULL,'bl_code_01','exp_period_6_9_3','os_exp_12_1_3','os_cost_13_1_1',2,70000,'돈이많아서','2018-03-30 11:15:39',NULL,'2018-03-30','2018-04-02'),('exp_code_14','animal_code_01','m_02',NULL,NULL,'bl_code_01','exp_period_4_7_2','os_exp_12_1_3','os_cost_13_1_1',2,70000,'ㅇㅁㄴㅇ','2018-03-30 12:58:20',NULL,'2018-03-31','2018-04-03');
/*!40000 ALTER TABLE `t_exp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_exp_journal`
--

DROP TABLE IF EXISTS `t_exp_journal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_exp_journal` (
  `exp_journal_code` varchar(35) NOT NULL COMMENT '체험 일지 코드(PK)',
  `exp_code` varchar(35) NOT NULL COMMENT '체험 코드(FK)',
  `m_exp_id` varchar(35) NOT NULL COMMENT '체험자 아이디(FK)',
  `exp_journal` varchar(255) NOT NULL COMMENT '체험 일지',
  `exp_journal_point` int(11) NOT NULL COMMENT '체험일지 포인트',
  `exp_journal_animal_char` varchar(255) DEFAULT NULL COMMENT '체험 동물 특징',
  `exp_journal_date` datetime NOT NULL COMMENT '일지 등록 일자',
  PRIMARY KEY (`exp_journal_code`),
  KEY `FK_exp_TO_exp_journal` (`exp_code`),
  KEY `FK_member_TO_exp_journal` (`m_exp_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='체험 일지 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_exp_journal`
--

LOCK TABLES `t_exp_journal` WRITE;
/*!40000 ALTER TABLE `t_exp_journal` DISABLE KEYS */;
INSERT INTO `t_exp_journal` VALUES ('exp_journal_code_01','exp_code_01','m_04','간식을주니까앉았다',20,'간식을너무좋아한다','2018-03-17 00:00:00');
/*!40000 ALTER TABLE `t_exp_journal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_exp_period`
--

DROP TABLE IF EXISTS `t_exp_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_exp_period` (
  `exp_period_code` varchar(35) NOT NULL COMMENT '동물 체험 기간 코드(PK)',
  `exp_period_period` varchar(5) NOT NULL COMMENT '동물 체험 기간',
  `exp_period_level` varchar(1) NOT NULL COMMENT '동물 체험 기간 레벨',
  `exp_period_cost` int(11) NOT NULL COMMENT '동물 체험 기간별 책임비',
  `exp_period_cost_level` varchar(2) NOT NULL COMMENT '동물 체험 기간별 책임비 레벨',
  `exp_period_cost_minus` int(11) NOT NULL COMMENT '책임비 차감 금액',
  `exp_period_journal_count` int(11) NOT NULL COMMENT '일지횟수레벨',
  PRIMARY KEY (`exp_period_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='동물 체험 기간 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_exp_period`
--

LOCK TABLES `t_exp_period` WRITE;
/*!40000 ALTER TABLE `t_exp_period` DISABLE KEYS */;
INSERT INTO `t_exp_period` VALUES ('exp_period_2_5_1','1~2일','2',50000,'5',20000,1),('exp_period_4_7_2','3~4일','4',70000,'7',20000,2),('exp_period_6_9_3','5~6일','6',90000,'9',20000,3),('exp_period_7_11_4','7일','7',110000,'11',20000,4);
/*!40000 ALTER TABLE `t_exp_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_jindan`
--

DROP TABLE IF EXISTS `t_jindan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_jindan` (
  `jindan_code` varchar(35) NOT NULL COMMENT '진단서 코드(PK)',
  `animal_code` varchar(35) NOT NULL COMMENT '동물 코드(FK)',
  `bl_code` varchar(35) NOT NULL COMMENT '보호소 통합 관리 코드(FK)',
  `m_shelter_id` varchar(35) NOT NULL COMMENT '보호소 아이디(FK)',
  `os_code_medical` varchar(35) NOT NULL COMMENT '진단서 종류 코드(FK)',
  `jindan_expost_point` int(11) DEFAULT NULL COMMENT '사후관리 진단서 포인트',
  `jindan_overall_opinion` varchar(255) NOT NULL COMMENT '전체적인 소견',
  `jindan_date` date NOT NULL COMMENT '진단서 등록 날짜',
  PRIMARY KEY (`jindan_code`),
  KEY `FK_animal_TO_jindan` (`animal_code`),
  KEY `FK_member_TO_jindan` (`m_shelter_id`),
  KEY `FK_overall_status_TO_jindan` (`os_code_medical`),
  KEY `FK_business_license_TO_jindan` (`bl_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='진단서 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_jindan`
--

LOCK TABLES `t_jindan` WRITE;
/*!40000 ALTER TABLE `t_jindan` DISABLE KEYS */;
INSERT INTO `t_jindan` VALUES ('jindan_code_01','animal_code_01','bl_code_01','m_02','os_jindan_2_1_1',0,'조금비만','2018-03-17'),('jindan_code_02','animal_code_03','bl_code_02','m_07','os_jindan_2_1_2',300,'너무활발','2018-03-17');
/*!40000 ALTER TABLE `t_jindan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_jindan_ears`
--

DROP TABLE IF EXISTS `t_jindan_ears`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_jindan_ears` (
  `jindan_ears_code` varchar(35) NOT NULL COMMENT '진단서 귀상태코드(PK)',
  `jindan_code` varchar(35) NOT NULL COMMENT '진단서 코드(PK)',
  `os_hearing` varchar(35) NOT NULL COMMENT '청각(PK)',
  `os_eare_secrete` varchar(35) NOT NULL COMMENT '귀 분비물(PK)',
  `os_mite` varchar(35) NOT NULL COMMENT '진드기(PK)',
  `os_odd_yumu` varchar(35) NOT NULL COMMENT '상태이상유무(PK)',
  PRIMARY KEY (`jindan_ears_code`),
  KEY `FK_overall_status_TO_jindan_ears` (`os_hearing`),
  KEY `FK_overall_status_TO_jindan_ears2` (`os_eare_secrete`),
  KEY `FK_jindan_TO_jindan_ears` (`jindan_code`),
  KEY `FK_overall_status_TO_jindan_ears3` (`os_mite`),
  KEY `FK_overall_status_TO_jindan_ears4` (`os_odd_yumu`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='진단서 귀상태';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_jindan_ears`
--

LOCK TABLES `t_jindan_ears` WRITE;
/*!40000 ALTER TABLE `t_jindan_ears` DISABLE KEYS */;
INSERT INTO `t_jindan_ears` VALUES ('jindan_ears_code_01','jindan_code_01','os_21_1_1','os_21_2_3','os_21_3_7','os_8_1_1');
/*!40000 ALTER TABLE `t_jindan_ears` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_jindan_general`
--

DROP TABLE IF EXISTS `t_jindan_general`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_jindan_general` (
  `jindan_general_code` varchar(35) NOT NULL COMMENT '진단서 일반상태 코드(PK)',
  `jindan_code` varchar(35) NOT NULL COMMENT '진단서 코드(PK)',
  `os_body` varchar(35) NOT NULL COMMENT '신체상태(FK)',
  `os_manner` varchar(35) NOT NULL COMMENT '태도(FK)',
  `os_rheum` varchar(35) NOT NULL COMMENT '점막(FK)',
  `os_odd_yumu` varchar(35) NOT NULL COMMENT '상태 이상 유무(PK)',
  PRIMARY KEY (`jindan_general_code`),
  KEY `FK_overall_status_TO_jindan_general` (`os_body`),
  KEY `FK_overall_status_TO_jindan_general2` (`os_manner`),
  KEY `FK_overall_status_TO_jindan_general3` (`os_rheum`),
  KEY `FK_jindan_TO_jindan_general` (`jindan_code`),
  KEY `FK_overall_status_TO_jindan_general4` (`os_odd_yumu`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='진단서 일반상태';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_jindan_general`
--

LOCK TABLES `t_jindan_general` WRITE;
/*!40000 ALTER TABLE `t_jindan_general` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_jindan_general` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_jindan_nose`
--

DROP TABLE IF EXISTS `t_jindan_nose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_jindan_nose` (
  `jindan_nose_code` varchar(35) NOT NULL COMMENT '진단서 코상태코드(PK)',
  `jindan_code` varchar(35) NOT NULL COMMENT '진단서 코드(FK)',
  `os_nose_secrete` varchar(35) NOT NULL COMMENT '코 분비물(FK)',
  `os_odd_yumu` varchar(35) NOT NULL COMMENT '상태이상유무(FK)',
  PRIMARY KEY (`jindan_nose_code`),
  KEY `FK_jindan_TO_jindan_nose` (`jindan_code`),
  KEY `FK_overall_status_TO_jindan_nose` (`os_nose_secrete`),
  KEY `FK_overall_status_TO_jindan_nose2` (`os_odd_yumu`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='진단서 코상태';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_jindan_nose`
--

LOCK TABLES `t_jindan_nose` WRITE;
/*!40000 ALTER TABLE `t_jindan_nose` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_jindan_nose` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_jindan_skin`
--

DROP TABLE IF EXISTS `t_jindan_skin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_jindan_skin` (
  `jindan_skin_code` varchar(35) NOT NULL COMMENT '진단서 피부상태 코드(PK)',
  `jindan_code` varchar(35) NOT NULL COMMENT '진단서 코드(PK)',
  `os_coat` varchar(35) NOT NULL COMMENT '피모상태(FK)',
  `os_skin` varchar(35) NOT NULL COMMENT '피부상태(FK)',
  `os_odd_yumu` varchar(35) NOT NULL COMMENT '상태이상유무(PK)',
  PRIMARY KEY (`jindan_skin_code`),
  KEY `FK_overall_status_TO_jindan_skin` (`os_coat`),
  KEY `FK_overall_status_TO_jindan_skin2` (`os_skin`),
  KEY `FK_jindan_TO_jindan_skin` (`jindan_code`),
  KEY `FK_overall_status_TO_jindan_skin3` (`os_odd_yumu`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='진단서 피부상태';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_jindan_skin`
--

LOCK TABLES `t_jindan_skin` WRITE;
/*!40000 ALTER TABLE `t_jindan_skin` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_jindan_skin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member`
--

DROP TABLE IF EXISTS `t_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_member` (
  `m_id` varchar(35) NOT NULL COMMENT '회원 아이디(PK)',
  `m_info_code` varchar(35) NOT NULL COMMENT '회원 코드(FK)',
  `bl_code` varchar(35) DEFAULT NULL COMMENT '사업자 등록증 코드(FK)',
  `m_right_code` varchar(35) NOT NULL COMMENT '권한 코드(FK)',
  `m_pw` varchar(20) NOT NULL COMMENT '패스워드',
  PRIMARY KEY (`m_id`),
  KEY `FK_business_license_TO_member` (`bl_code`),
  KEY `FK_member_right_TO_member` (`m_right_code`),
  KEY `FK_member_info_TO_member` (`m_info_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='회원 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member`
--

LOCK TABLES `t_member` WRITE;
/*!40000 ALTER TABLE `t_member` DISABLE KEYS */;
INSERT INTO `t_member` VALUES ('admin','m_info_code_01',NULL,'mr_1_1','1234'),('m_02','m_info_code_02','','mr_3_1','1234'),('m_03','m_info_code_03','','mr_2_1','1234'),('m_04','m_info_code_04',NULL,'mr_3_1','1234'),('m_05','m_info_code_05',NULL,'mr_3_2','1234'),('m_06','m_info_code_06',NULL,'mr_3_3','1234'),('m_07','m_info_code_07','bl_code_02','mr_2_1','1234'),('m_08','m_info_code_08','bl_code_02','m_08','1234'),('m_09','m_09','bl_code_02','mr_2_2','1234'),('login','m_info_code_29',NULL,'mr_2_1','1234'),('exp1','m_info_code_37',NULL,'mr_3_1','1'),('ㅇㄴㅁㄹ1','m_info_code_38',NULL,'mr_3_1','1'),('1','1',NULL,'mr_2_2','1'),('a','a','a','mr_1_1','a');
/*!40000 ALTER TABLE `t_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_info`
--

DROP TABLE IF EXISTS `t_member_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_member_info` (
  `m_info_code` varchar(35) NOT NULL COMMENT '회원 코드(PK)',
  `m_info_name` varchar(20) NOT NULL COMMENT '이름',
  `m_info_nickname` varchar(15) NOT NULL COMMENT '닉네임',
  `m_info_gender` varchar(5) NOT NULL COMMENT '성별',
  `m_info_birth` varchar(8) NOT NULL COMMENT '생년월일',
  `m_info_postcode` varchar(5) NOT NULL COMMENT '우편번호',
  `m_info_address` varchar(255) NOT NULL COMMENT '주소',
  `m_info_email` varchar(20) NOT NULL COMMENT '이메일',
  `m_info_phone` varchar(15) NOT NULL COMMENT '연락처',
  `m_info_join_date` datetime NOT NULL COMMENT '가입날짜',
  PRIMARY KEY (`m_info_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='회원정보 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_info`
--

LOCK TABLES `t_member_info` WRITE;
/*!40000 ALTER TABLE `t_member_info` DISABLE KEYS */;
INSERT INTO `t_member_info` VALUES ('m_info_code_01','김장성','1','남','3','2','2','2','2','2018-03-12 00:00:00'),('m_info_code_02','김항수','1','남','3','2','2','2','2','2018-03-12 00:00:00'),('m_info_code_03','송인석','thddlstjr','남','950605','12345','중화산동','email03','01012345675','2018-03-13 00:00:00'),('m_info_code_04','진영','wlsdud','여','950826','12345','모현동','email04','01012345677','2018-03-13 00:00:00'),('m_info_code_05','차선영','cktjsdud','여','900115','12345','우아동','email05','01012345671','2018-03-14 00:00:00'),('m_info_code_06','박로진','qkrfhwls','남','920503','12345','덕진동','email06','01012345672','2018-03-14 00:00:00'),('m_info_code_11','이영현','dldudgus','남','920503','12345','삼천동','email07','01012345672','2018-03-14 00:00:00'),('m_info_code_08','박범진','qkrqjawls','남','920503','12345','효자동','email08','01012345672','2018-03-14 00:00:00'),('m_info_code_09','안준철','dkswnscjf','남','920503','12345','중화산동','email09','01012345672','2018-03-14 00:00:00'),('m_info_code_38','1','1','1','1','1','1','1','1','2018-03-28 12:29:34'),('m_info_code_37','ㅁ','ㅁ','ㅁ','940826','12345','ㅇㅇ','ㅇㅇ','12345','2018-03-28 09:23:28'),('m_info_code_34','','1','1','1','1','1','11','1','2018-03-26 10:44:30'),('m_info_code_35','1','11','1','1','1','1','1','1','2018-03-26 10:44:35'),('m_info_code_36','김항수','김항수','남','941129','10101','효자동3가','hangsu1','01010101','2018-03-26 15:22:14'),('m_info_code_30','1','2','1','1','1','1','1','1','2018-03-23 14:20:46'),('m_info_code_29','1','1','1','1','1','1','1','1','2018-03-23 14:19:51'),('m_info_code_31','1','1','1','1','1','1','1','1','2018-03-23 14:20:49'),('m_info_code_32','1','1','1','1','1','1','1','1','2018-03-23 14:20:51'),('m_info_code_33','123','123','1','2312312','312','312312312331223','123312','33','2018-03-23 16:24:09');
/*!40000 ALTER TABLE `t_member_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_point`
--

DROP TABLE IF EXISTS `t_member_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_member_point` (
  `m_point_code` varchar(35) NOT NULL COMMENT '회원 포인트 코드(PK)',
  `point_list_code` varchar(35) DEFAULT NULL COMMENT '포인트 리스트 관리 코드(FK)',
  `m_member_id` varchar(35) NOT NULL COMMENT '회원 아이디(FK)',
  `m_shelter_id` varchar(35) DEFAULT NULL COMMENT '보호소 아이디(FK)',
  `m_point_fluid_point` int(11) NOT NULL COMMENT '유동 포인트',
  `m_point_fluid_date` datetime NOT NULL COMMENT '유동 포인트 날짜',
  PRIMARY KEY (`m_point_code`),
  KEY `FK_member_TO_member_point` (`m_member_id`),
  KEY `FK_point_list_TO_member_point` (`point_list_code`),
  KEY `FK_member_TO_member_point2` (`m_shelter_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='회원 포인트 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_point`
--

LOCK TABLES `t_member_point` WRITE;
/*!40000 ALTER TABLE `t_member_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_member_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_right`
--

DROP TABLE IF EXISTS `t_member_right`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_member_right` (
  `m_right_code` varchar(35) NOT NULL COMMENT '회원 권한 코드(PK)',
  `m_right_name` varchar(5) NOT NULL COMMENT '권한명',
  `m_right_level` varchar(5) NOT NULL COMMENT '권한레벨',
  `m_right_grade_name` varchar(5) NOT NULL COMMENT '등급명',
  `m_right_grade_level` varchar(1) NOT NULL COMMENT '등급레벨',
  PRIMARY KEY (`m_right_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='회원 권한 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_right`
--

LOCK TABLES `t_member_right` WRITE;
/*!40000 ALTER TABLE `t_member_right` DISABLE KEYS */;
INSERT INTO `t_member_right` VALUES ('mr_1_1','관리자','1','관리자','1'),('mr_2_1','보호소','2','직원','1'),('mr_2_2','보호소','2','대표','2'),('mr_3_1','회원','3','체험자','1'),('mr_3_2','회원','3','입양자','2'),('mr_3_3','회원','3','탈퇴자','3');
/*!40000 ALTER TABLE `t_member_right` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_survey`
--

DROP TABLE IF EXISTS `t_member_survey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_member_survey` (
  `m_survey_code` varchar(35) NOT NULL COMMENT '회원 설문조사 관리 코드(PK)',
  `survey_list_code` varchar(35) NOT NULL COMMENT '질문 코드(FK)',
  `exp_code` varchar(35) DEFAULT NULL COMMENT '체험 코드(FK)',
  `m_exp_id` varchar(35) NOT NULL COMMENT '체험자 아이디(PK)',
  `bl_code` varchar(35) NOT NULL COMMENT '보호소 통합 관리 코드(FK)',
  `adopt_request_code` varchar(35) DEFAULT NULL COMMENT '입양 신청 코드(FK)',
  `survey_record_code` varchar(35) NOT NULL COMMENT '설문조사 점수 코드(FK)',
  PRIMARY KEY (`m_survey_code`),
  KEY `FK_survey_list_TO_member_survey` (`survey_list_code`),
  KEY `FK_exp_TO_member_survey` (`exp_code`),
  KEY `FK_survey_record_TO_member_survey` (`survey_record_code`),
  KEY `FK_adopt_request_TO_member_survey` (`adopt_request_code`),
  KEY `FK_business_license_TO_member_survey` (`bl_code`),
  KEY `FK_member_TO_member_survey` (`m_exp_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='회원 설문조사 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_survey`
--

LOCK TABLES `t_member_survey` WRITE;
/*!40000 ALTER TABLE `t_member_survey` DISABLE KEYS */;
INSERT INTO `t_member_survey` VALUES ('m_survey_code_01','survey_list_code_01','exp_code_01','m_04','bl_code_01',NULL,'survey_record_1_5'),('m_survey_code_02','survey_list_code_02','exp_code_01','m_04','bl_code_01',NULL,'survey_record_1_5'),('m_survey_code_03','survey_list_code_03','exp_code_01','m_04','bl_code_01',NULL,'survey_record_3_3'),('m_survey_code_04','survey_list_code_04','exp_code_01','m_04','bl_code_01',NULL,'survey_record_4_2'),('m_survey_code_05','survey_list_code_05','exp_code_01','m_04','bl_code_01',NULL,'survey_record_2_4');
/*!40000 ALTER TABLE `t_member_survey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_overall_file`
--

DROP TABLE IF EXISTS `t_overall_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_overall_file` (
  `of_code` varchar(35) NOT NULL COMMENT '종합 파일 코드(PK)',
  `bl_code` varchar(35) DEFAULT NULL COMMENT '사업자 등록증 코드(FK)',
  `adopt_request_code` varchar(35) DEFAULT NULL COMMENT '입양 신청 코드(FK)',
  `board_content_code` varchar(35) DEFAULT NULL COMMENT '게시판 본문 코드(FK)',
  `of_path` varchar(255) NOT NULL COMMENT '파일 경로',
  `of_origin_name` varchar(255) NOT NULL COMMENT '원본 파일명',
  `of_save_name` varchar(255) NOT NULL COMMENT '저장 파일명',
  `of_ext` varchar(5) NOT NULL COMMENT '파일 확장자',
  `of_size` int(11) NOT NULL COMMENT '파일 사이즈',
  `of_down_date` datetime NOT NULL COMMENT '파일 생성 날짜',
  PRIMARY KEY (`of_code`),
  KEY `FK_business_license_TO_overall_file` (`bl_code`),
  KEY `FK_adopt_request_TO_overall_file` (`adopt_request_code`),
  KEY `FK_board_content_TO_overall_file` (`board_content_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='종합 파일 관리 ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_overall_file`
--

LOCK TABLES `t_overall_file` WRITE;
/*!40000 ALTER TABLE `t_overall_file` DISABLE KEYS */;
INSERT INTO `t_overall_file` VALUES ('of_code_8','bl_code_16',NULL,NULL,'/home/hosting_users/iso159/tomcat/webapps/ROOT/resources/shelterUpload/','11김장성_문제풀이_하나의클래스_리턴있는메서드선언및호출','3c4c2def-b24f-4b6a-803b-cc8bc713965a','docx',27907,'2018-03-26 15:40:55'),('of_code_7','bl_code_16',NULL,NULL,'/home/hosting_users/iso159/tomcat/webapps/ROOT/resources/shelterUpload/','11_김장성_Wrapper클래스조사','e304e52a-c411-40a3-8ac7-e85a3dd0b473','txt',581,'2018-03-26 15:40:55'),('of_code_9',NULL,'adopt_request_code_1',NULL,'D:\\jjev\\workspace_1teamProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\teamProject\\resources/adoptUpload/','shutdown','93786251-0d8e-4fd8-8c00-aa78f6254e56','exe',34304,'2018-03-28 10:07:14'),('of_code_10',NULL,'adopt_request_code_2',NULL,'D:\\jjev\\workspace_1teamProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\teamProject\\resources/adoptUpload/','TTA정보통신용어_신규목록ver20171231','4a63d487-ceb7-4982-9110-0a6814a0720a','xlsx',98594,'2018-03-28 10:40:11'),('of_code_11',NULL,'adopt_request_code_3',NULL,'D:\\jjev\\workspace_1teamProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\teamProject\\resources/adoptUpload/','spring프로젝트 만들기','86503536-fd8a-4b18-a3db-b455d93bb48a','txt',1706,'2018-03-28 10:41:30'),('of_code_12',NULL,'adopt_request_code_3',NULL,'D:\\jjev\\workspace_1teamProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\teamProject\\resources/adoptUpload/','sql구조랑데이터','b481f907-72f0-49e1-8d69-3b64737689e2','sql',62691,'2018-03-28 10:41:30'),('of_code_13',NULL,'adopt_request_code_4',NULL,'D:\\jjev\\workspace_1teamProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\teamProject\\resources/adoptUpload/','Hwp','8917a696-85d2-4284-9aca-14410f31b741','exe',4334760,'2018-03-28 10:42:09'),('of_code_14',NULL,'adopt_request_code_5',NULL,'D:\\jjev\\workspace_1teamProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\teamProject\\resources/adoptUpload/','spring프로젝트 만들기','b942b5e5-0d73-49c4-965d-b139985439e8','txt',1706,'2018-03-28 10:42:51');
/*!40000 ALTER TABLE `t_overall_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_overall_status`
--

DROP TABLE IF EXISTS `t_overall_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_overall_status` (
  `os_code` varchar(35) NOT NULL COMMENT '종합 상태 코드(PK)',
  `os_large` varchar(10) NOT NULL COMMENT '그룹 대분류',
  `os_large_level` varchar(5) NOT NULL COMMENT '그룸 대분류 레벨',
  `os_small` varchar(5) NOT NULL COMMENT '그룹 소분류',
  `os_small_level` varchar(5) NOT NULL COMMENT '그룹 소분류 레벨',
  `os_name` varchar(10) NOT NULL COMMENT '종합 상태 코드명',
  `os_name_level` varchar(255) NOT NULL COMMENT '종합 상태 레벨',
  PRIMARY KEY (`os_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='종합상태코드관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_overall_status`
--

LOCK TABLES `t_overall_status` WRITE;
/*!40000 ALTER TABLE `t_overall_status` DISABLE KEYS */;
INSERT INTO `t_overall_status` VALUES ('os_business_1_1_1','사업자 신청상태','1','','1','신청중','1'),('os_business_1_1_2','사업자 신청상태','1','','1','신청확인','2'),('os_business_1_1_3','사업자 신청상태','1','','1','결정완료','3'),('os_jindan_2_1_1','진단서종류','2','','1','등록 진단서','1'),('os_jindan_2_1_2','진단서종류','2','','1','사후관리진단서','2'),('os_jindan_2_1_3','진단서종류','2','','1','질병 진단서','3'),('os_animal_3_1_1','동물상태','3','','1','등록동물','1'),('os_animal_3_1_2','동물상태','3','','1','체험동물','2'),('os_animal_3_1_4','동물상태','3','','1','입양동물','4'),('os_adopt_4_1_1','입양상태','4','','1','입양신청','1'),('os_adopt_4_1_2','입양상태','4','','1','입양신청완료','2'),('os_shelter_23_1_4','보호소 직원요청상태','23','','1','요청거부','4'),('os_adopt_4_1_4','입양상태','4','','1','입양 상담 신청확인','4'),('os_adopt_4_1_5','입양상태','4','','1','상담진행중','5'),('os_adopt_4_1_6','입양상태','4','','1','입양 상담확인','6'),('os_adopt_4_1_7','입양상태','4','','1','입양 완료','7'),('os_adopt_4_1_8','입양상태','4','','1','입양 거절','8'),('os_apply_5_1_1','신청서','5','','1','체험 신청서','1'),('os_apply_5_1_2','신청서','5','','1','입양 신청서','2'),('os_jinlyo_yeyag_kinds_6_1_1','진료예약종류','6','','1','사후관리','1'),('os_jinlyo_yeyag_kinds_6_1_2','진료예약종류','6','','1','질병','2'),('os_jinlyo_yeyag_status_7_1_1','진료예약상태','7','','1','진료 신청중','1'),('os_jinlyo_yeyag_status_7_1_2','진료예약상태','7','','1','진료 신청확인','2'),('os_jinlyo_yeyag_status_7_1_3','진료예약상태','7','','1','진료 거절','3'),('os_jinlyo_yeyag_status_7_1_4','진료예약상태','7','','1','진료결정','4'),('os_status_isang_8_1_1','상태 이상 유무','8','','1','정상','1'),('os_status_isang_8_1_2','상태 이상유무','8','','1','이상','2'),('os_order_9_1_1 ','주문상태','9','','1','주문요청','1'),('os_order_9_1_2','주문상태','9','','1','주문완료','2'),('os_order_9_1_3','주문상태','9','','1','주문취소','3'),('os_delivery_10_1_1','배송상태','10','','1','배송준비중','1'),('os_delivery_10_1_2','배송상태','10','','1','배송 중','2'),('os_delivery_10_1_3','배송상태','10','','1','배송완료','3'),('os_delivery_10_1_4','배송상태','10','','1','배송취소','4'),('os_animal_kinds_11_1_1','동물종류','11','','1','개','1'),('os_animal_kinds__11_1_2','동물종류','11','','1','고양이','2'),('os_exp_12_1_3','체험 상태','12','','1','예약 신청','3'),('os_exp_12_1_4','체험 상태','12','','1','예약 확인','4'),('os_exp_12_1_5','체험 상태','12','','1','예약완료','5'),('os_cost_13_1_1','책임비','13','보유','1','책임비 보유중','1'),('os_cost_13_1_2','책임비','13','반환','2','책임비 반환','2'),('os_cost_return_13_1_3','책임비','13','차감','3','책임비 차감','3'),('os_pay_status_14_1_1','결제 상태','14','','1','결제 진행중','1'),('os_pay_status_14_1_2','결제 상태','14','','1','결제 완료','2'),('os_goods_io_15_1_1','상품 입출관리','15','','1','입고','1'),('os_goods_io_15_1_2','상품 입출관리','15','','1','출고','2'),('os_dog_pre_16_1_1','개 예방접종','16','','1','종합예방접종','1'),('os_dog_pre_16_1_2','개 예방접종','16','','1','코로나장염 접종','2'),('os_dog_pre_16_1_3','개 예방접종','16','','1','켄넬코프 접종','3'),('os_dog_pre_16_1_4','개 예방접종','16','','1','관견병 접종','4'),('os_dog_pre_16_1_5','개 예방접종','16','','1','인플루엔자 접종','5'),('os_dog_pre_16_1_6','개 예방접종','16','','1','종합 구충 예방','6'),('os_cat_pre_17_1_1','고양이 예방접종','17','','1','4종 백신','1'),('os_cat_pre_17_1_2','고양이 예방접종','17','','1','광견병 접종','2'),('os_cat_pre_17_1_3','고양이 예방접종','17','','1','종합 구충 예방','3'),('os_normal_18_1_1','일반상태','18','신체상태','1','비만','1'),('os_normal_18_1_2','일반상태','18','신체상태','1','야윔','2'),('os_normal_18_1_3','일반상태','18','신체상태','1','정상','3'),('os_normal_18_2_4','일반상태','18','태도','2','민첨','4'),('os_normal_18_2_5','일반상태','18','태도','2','무반응','5'),('os_normal_18_2_6','일반상태','18','태도','2','침울','6'),('os_normal_18_3_7','일반상태','18','점막','3','핑크','7'),('os_normal_18_3_8','일반상태','18','점막','3','창백','8'),('os_normal_18_3_9','일반상태','18','점막','3','청색','9'),('os_normal_18_3_10','일반상태','18','점막','3','황달','10'),('os_normal_18_3_11','일반상태','18','점막','3','충혈','11'),('os_skin_19_1_1','피부상태','19','피모','1','탈모유','1'),('os_skin_19_1_2','피부상태','19','피모','1','탈모유','2'),('os_skin_19_2_3','피부상태','19','피부','2','종양','3'),('os_skin_19_2_4','피부상태','19','피부','2','외부기생충','4'),('os_skin_19_2_5','피부상태','19','피부','2','탄력성','5'),('os_skin_19_2_6','피부상태','19','피부','2','변색','6'),('os_eye_20_1_1','눈','20','각막','1','궤양','1'),('os_eye_20_1_2','눈','20','각막','1','열상','2'),('os_eye_20_1_3','눈','20','각막','1','각막염','3'),('os_eye_20_1_4','눈','20','각막','1','혼탁','4'),('os_eye_20_2_5','눈','20','결막','2','출혈','5'),('os_eye_20_2_6','눈','20','결막','2','황달','6'),('os_eye_20_2_7','눈','20','결막','2','충혈','7'),('os_eye_20_2_8','눈','20','결막','2','창백','8'),('os_eye_20_3_9','눈','20','수정체','3','혼탁유','9'),('os_eye_20_3_10','눈','20','수정체','3','혼탁유','10'),('os_ear_21_1_1','귀','21','청각','1','청각유','1'),('os_ear_21_1_2','귀','21','청각','1','청각무','2'),('os_ear_21_2_3','귀','21','분비물','2','wax','3'),('os_ear_21_2_4','귀','21','분비물','2','수양성','4'),('os_ear_21_2_5','귀','21','분비물','2','화농성','5'),('os_ear_21_3_6','귀','21','진드기','3','진드기유','6'),('os_ear_21_3_7','귀','21','진드기','3','진드기무','7'),('os_nose_22_1_1','코','22','분비물','1','수양성','1'),('os_nose_22_1_2','코','22','분비물','1','혈액성','2'),('os_nose_22_1_3','코','22','분비물','1','화농성','3'),('os_nose_22_1_4','코','22','분비물','1','건조','4'),('os_shelter_23_1_1','보호소 직원요청상태','23','','1','요청중','1'),('os_shelter_23_1_2','보호소 직원요청상태','23','','1','요청확인','2'),('os_shelter_23_1_3','보호소 직원요청상태','23','','1','결정완료','3'),('os_cost_return_24_1_1','책임비 반환상태','24','','1','Y','1'),('os_cost_return_24_1_2','책임비 반환상태','24','','1','N','2'),('os_animal_3_1_3','동물상태','3','','1','체험중인동물','3'),('os_business_1_1_4','사업자 신청상태','1','','1','등록 거부','4'),('os_exp_12_1_1','체험 상태','12','','1','체험 진행중','1'),('os_exp_12_1_2','체험 상태','12','','1','체험 완료','2');
/*!40000 ALTER TABLE `t_overall_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_point_goods`
--

DROP TABLE IF EXISTS `t_point_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_point_goods` (
  `point_goods_code` varchar(35) NOT NULL COMMENT '포인트 상품 코드(PK)',
  `m_admin_id` varchar(35) NOT NULL COMMENT '관리자아이디(FK)',
  `point_goods_name` varchar(50) NOT NULL COMMENT '포인트 상품명',
  `point_goods_point` int(11) NOT NULL COMMENT '상품 포인트',
  `point_goods_desc` varchar(255) NOT NULL COMMENT '상품 등록 날짜',
  `point_goods_date` date NOT NULL,
  PRIMARY KEY (`point_goods_code`),
  KEY `FK_member_TO_point_goods` (`m_admin_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='포인트 상품 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_point_goods`
--

LOCK TABLES `t_point_goods` WRITE;
/*!40000 ALTER TABLE `t_point_goods` DISABLE KEYS */;
INSERT INTO `t_point_goods` VALUES ('point_goods_code1','m_02','1',1,'1','2018-03-30');
/*!40000 ALTER TABLE `t_point_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_point_goods_cart`
--

DROP TABLE IF EXISTS `t_point_goods_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_point_goods_cart` (
  `point_goods_cart_code` varchar(35) NOT NULL COMMENT '포인트 상품 장바구니 코드(PK)',
  `point_goods_order_code` varchar(35) NOT NULL COMMENT '포인트 상품 주문 코드(FK)',
  `os_code_order` varchar(35) NOT NULL COMMENT '주문 상태 코드(FK)',
  `point_goods_code` varchar(35) NOT NULL COMMENT '포인트 상품 코드(FK)',
  `cart_count` int(11) NOT NULL COMMENT '주문 개수',
  `cart_point_sum` int(11) NOT NULL COMMENT '주문 상품 포인트 합계',
  `point_goods_cart_date` datetime NOT NULL COMMENT '장바구니 등록 날짜',
  PRIMARY KEY (`point_goods_cart_code`),
  KEY `FK_point_goods_TO_point_goods_cart` (`point_goods_code`),
  KEY `FK_point_goods_order_TO_point_goods_cart` (`point_goods_order_code`),
  KEY `FK_overall_status_TO_point_goods_cart` (`os_code_order`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='포인트 상품 장바구니 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_point_goods_cart`
--

LOCK TABLES `t_point_goods_cart` WRITE;
/*!40000 ALTER TABLE `t_point_goods_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_point_goods_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_point_goods_delivery`
--

DROP TABLE IF EXISTS `t_point_goods_delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_point_goods_delivery` (
  `point_goods_delivery_code` varchar(35) NOT NULL COMMENT '포인트 상품 배송 코드(PK)',
  `point_goods_order_code` varchar(35) NOT NULL COMMENT '포인트 상품 주문 코드(FK)',
  `os_code_delivery` varchar(35) NOT NULL COMMENT '배송 상태 코드(FK)',
  `point_goods_delivery_name` varchar(10) NOT NULL COMMENT '수령인',
  `point_goods_delivery_address` varchar(255) NOT NULL COMMENT '배송지 주소',
  `point_goods_delivery_phone` varchar(15) NOT NULL COMMENT '배송지 연락처',
  `point_goods_delivery_order_date` datetime NOT NULL COMMENT '주문 등록 날짜',
  `point_goods_delivery_start_date` datetime NOT NULL COMMENT '배송 시작 날짜',
  PRIMARY KEY (`point_goods_delivery_code`),
  KEY `FK_point_goods_order_TO_point_goods_delivery` (`point_goods_order_code`),
  KEY `FK_overall_status_TO_point_goods_delivery` (`os_code_delivery`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='포인트 상품 배송 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_point_goods_delivery`
--

LOCK TABLES `t_point_goods_delivery` WRITE;
/*!40000 ALTER TABLE `t_point_goods_delivery` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_point_goods_delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_point_goods_io`
--

DROP TABLE IF EXISTS `t_point_goods_io`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_point_goods_io` (
  `point_goods_io_code` varchar(35) NOT NULL COMMENT '포인트 상품 입출 관리 코드(PK)',
  `point_goods_code` varchar(35) NOT NULL COMMENT '포인트 상품 코드(FK)',
  `os_code_goods_io` varchar(35) NOT NULL COMMENT '상품 입출 코드(FK)',
  `m_admin_id` varchar(35) DEFAULT NULL COMMENT '관리자 아이디(FK)',
  `m_member_id` varchar(35) DEFAULT NULL COMMENT '회원 아이디(FK)',
  `point_goods_io_desc` varchar(255) NOT NULL COMMENT '상세 입출 내용',
  `point_goods_io_count` int(11) NOT NULL COMMENT '상품 입출 수량',
  `point_goods_io_date` datetime NOT NULL COMMENT '입출 날짜',
  PRIMARY KEY (`point_goods_io_code`),
  KEY `FK_overall_status_TO_point_goods_io` (`os_code_goods_io`),
  KEY `FK_point_goods_TO_point_goods_io` (`point_goods_code`),
  KEY `FK_member_TO_point_goods_io` (`m_admin_id`),
  KEY `FK_member_TO_point_goods_io2` (`m_member_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='포인트 상품 입출 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_point_goods_io`
--

LOCK TABLES `t_point_goods_io` WRITE;
/*!40000 ALTER TABLE `t_point_goods_io` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_point_goods_io` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_point_goods_order`
--

DROP TABLE IF EXISTS `t_point_goods_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_point_goods_order` (
  `point_goods_order_code` varchar(35) NOT NULL COMMENT '포인트 상품 주문 코드(PK)',
  `m_member_id` varchar(35) NOT NULL COMMENT '회원 아이디(FK)',
  `point_goods_order_date` datetime NOT NULL COMMENT '주문 날짜',
  PRIMARY KEY (`point_goods_order_code`),
  KEY `FK_member_TO_point_goods_order` (`m_member_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='포인트 상품 주문 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_point_goods_order`
--

LOCK TABLES `t_point_goods_order` WRITE;
/*!40000 ALTER TABLE `t_point_goods_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_point_goods_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_point_list`
--

DROP TABLE IF EXISTS `t_point_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_point_list` (
  `point_list_code` varchar(35) NOT NULL COMMENT '포인트 리스트 관리 코드(PK)',
  `point_name` varchar(20) NOT NULL COMMENT '포인트 명',
  `point_name_level` varchar(1) NOT NULL COMMENT '포인트 명 레벨',
  `point_plus_minus` varchar(2) NOT NULL COMMENT '포인트 증감',
  `point_plumin_level` varchar(1) NOT NULL COMMENT '포인트 증감 레밸',
  PRIMARY KEY (`point_list_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='포인트 리스트';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_point_list`
--

LOCK TABLES `t_point_list` WRITE;
/*!40000 ALTER TABLE `t_point_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_point_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_shelter_clinic`
--

DROP TABLE IF EXISTS `t_shelter_clinic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_shelter_clinic` (
  `sc_code` varchar(35) NOT NULL COMMENT '보호소 진료 코드(PK)',
  `bl_code` varchar(35) NOT NULL COMMENT '보호소 통합 관리 코드(PK)',
  `m_shelter_id` varchar(35) DEFAULT NULL COMMENT '보호소 아이디(FK)',
  `adopt_code` varchar(35) NOT NULL COMMENT '입양자 코드(FK)',
  `m_adopt_id` varchar(35) NOT NULL COMMENT '입양자 아이디(FK)',
  `os_code_clinic_kind` varchar(35) NOT NULL COMMENT '진료 예약 종류 코드(FK)',
  `os_code_clinic_status` varchar(35) NOT NULL COMMENT '진료 예약 상태 코드(FK)',
  `sc_date` datetime NOT NULL COMMENT '진료 날짜',
  `sc_reserve_date` datetime NOT NULL COMMENT '진료 예약 등록 날짜',
  PRIMARY KEY (`sc_code`),
  KEY `FK_adopt_TO_shelter_clinic` (`adopt_code`),
  KEY `FK_member_TO_shelter_clinic` (`m_shelter_id`),
  KEY `FK_overall_status_TO_shelter_clinic` (`os_code_clinic_status`),
  KEY `FK_member_TO_shelter_clinic2` (`m_adopt_id`),
  KEY `FK_business_license_TO_shelter_clinic` (`bl_code`),
  KEY `FK_overall_status_TO_shelter_clinic2` (`os_code_clinic_kind`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='보호소 진료 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_shelter_clinic`
--

LOCK TABLES `t_shelter_clinic` WRITE;
/*!40000 ALTER TABLE `t_shelter_clinic` DISABLE KEYS */;
INSERT INTO `t_shelter_clinic` VALUES ('sc_code_01','bl_code_01','m_02','052','m_05','gg','gg','0000-00-00 00:00:00','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `t_shelter_clinic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_shelter_staff_request`
--

DROP TABLE IF EXISTS `t_shelter_staff_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_shelter_staff_request` (
  `ssr_code` varchar(35) NOT NULL COMMENT '보호소직원요청코드(PK)',
  `m_id` varchar(35) NOT NULL COMMENT '회원 아이디(FK)',
  `bl_code` varchar(35) NOT NULL COMMENT '보호소 통합 관리 코드(FK)',
  `os_code_staff_request` varchar(35) NOT NULL COMMENT '보호소직원요청상태(FK)',
  `ssr_request_date` datetime NOT NULL COMMENT '요청날짜',
  `ssr_clear_date` datetime DEFAULT NULL COMMENT '완료날짜',
  PRIMARY KEY (`ssr_code`),
  KEY `FK_member_TO_shelter_staff_request` (`m_id`),
  KEY `FK_overall_status_TO_shelter_staff_request` (`os_code_staff_request`),
  KEY `FK_business_license_TO_shelter_staff_request` (`bl_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='보호소 직원 요청 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_shelter_staff_request`
--

LOCK TABLES `t_shelter_staff_request` WRITE;
/*!40000 ALTER TABLE `t_shelter_staff_request` DISABLE KEYS */;
INSERT INTO `t_shelter_staff_request` VALUES ('ssr_code_1','login','bl_code_01','os_shelter_23_1_3','2018-03-27 15:21:42','2018-03-29 10:11:52'),('ssr_code_2','m_03','bl_code_01','os_shelter_23_1_4','2018-03-29 10:28:43',NULL),('ssr_code_3','m_02','bl_code_3','os_shelter_23_1_1','2018-03-30 11:16:14',NULL);
/*!40000 ALTER TABLE `t_shelter_staff_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_survey`
--

DROP TABLE IF EXISTS `t_survey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_survey` (
  `survey_code` varchar(35) NOT NULL COMMENT '설문지 코드 (PK)',
  `m_admin_id` varchar(35) NOT NULL COMMENT '관리자 아이디(FK)',
  `survey_enroll_date` date NOT NULL COMMENT '설문지등록일자',
  `survey_name` varchar(10) NOT NULL COMMENT '설문지명',
  `survey_point` int(11) NOT NULL COMMENT '설문지 포인트',
  PRIMARY KEY (`survey_code`),
  KEY `FK_member_TO_survey` (`m_admin_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='설문지 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_survey`
--

LOCK TABLES `t_survey` WRITE;
/*!40000 ALTER TABLE `t_survey` DISABLE KEYS */;
INSERT INTO `t_survey` VALUES ('survey_code_1','m_01','2018-03-15','입양상담설문조사',50),('survey_code_2','login','2018-03-28','체험만족도',50),('survey_code_3','login','2018-03-28','입양만족도',50),('survey_code_4','login','2018-03-29','d',20),('survey_code_5','login','2018-03-29','ddd',2),('survey_code_6','login','2018-03-29','진영',500),('survey_code_7','login','2018-03-29','김장성',30),('survey_code_8','1','2018-03-29','송인석',1),('survey_code_9','login','2018-03-29','김항수',20);
/*!40000 ALTER TABLE `t_survey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_survey_list`
--

DROP TABLE IF EXISTS `t_survey_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_survey_list` (
  `survey_list_code` varchar(35) NOT NULL COMMENT '질문 코드(PK)',
  `survey_code` varchar(35) NOT NULL COMMENT '설문지 코드 (FK)',
  `m_admin_id` varchar(35) NOT NULL COMMENT '관리자 아이디(FK)',
  `survey_list_question` varchar(200) NOT NULL COMMENT '질문',
  `survey_list_date` datetime NOT NULL COMMENT '질문 등록 일자',
  PRIMARY KEY (`survey_list_code`),
  KEY `FK_survey_TO_survey_list` (`survey_code`),
  KEY `FK_member_TO_survey_list` (`m_admin_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='설문조사 질문 리스트';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_survey_list`
--

LOCK TABLES `t_survey_list` WRITE;
/*!40000 ALTER TABLE `t_survey_list` DISABLE KEYS */;
INSERT INTO `t_survey_list` VALUES ('survey_list_code_1','survey_code_1','m_01','1. 유기동물 입양에 대해 가족 모두가 동의하였습니까?','2018-03-15 00:00:00'),('survey_list_code_2','survey_code_1','m_01','2. 입양 보내는 동물은 모두 중성화 수술을 하여 번식할 수 없습니다. 동의하시나요? (단, 입양 보내는 동물이 중성화 수술의 시기가 안 된 어린 동물의 경우, 입양자가 입양 후 케어와 약속한 시기에 직접 또는 케어와 연계하여 중성화 수술을 진행해야 합니다. 이 경우, 케어는 반드시 확인절차를 거칠 것이며, 이에 동의하여야 합니다.','2018-03-15 00:00:00'),('survey_list_code_3','survey_code_1','m_01','3. 입양 후에도 입양한 동물의 소유권은 케어에 있으며, 이는 동물학대 발생 시 동물의 압수를 위하여 필요함을 알려 드립니다. 동의하시나요? ','2018-03-15 00:00:00'),('survey_list_code_4','survey_code_1','m_01','4. 만일 기르지 못하는 사정이 발생하였을 경우, 반드시 관리자로 통보를 해주어야 하며 본인 임의대로 재 입양을 보내서는 안 됩니다. 동의하시나요?','2018-03-15 00:00:00'),('survey_list_code_5','survey_code_1','m_01','5. 기르던 중 분실사고가 발생했을 때는 반드시 그날 즉시 관리자에 알리고 관리자와 함께 찾을 수 있도록 최선을 다해야 합니다. 동의하시나요?','2018-03-15 00:00:00'),('survey_list_code_6','survey_code_1','m_01','6. 입양 후, 이 동물에 대한 주요 책임자는 누구입니까? (주요 책임자의 나이는 20세 이상이어야 함. 18세미만은 부모님의 동의가 필요합니다)','2018-03-23 00:00:00'),('survey_list_code_7','survey_code_1','m_01','7. 반려동물이 하루에 몇 시간 동안 혼자 있게 되나요?','2018-03-23 00:00:00'),('survey_list_code_8','survey_code_1','m_01','8. 며칠 동안 집을 비우는 경우 어떻게 하시겠습니까?','2018-03-23 00:00:00'),('survey_list_code_9','survey_code_1','m_01','9. 하의 환경 및 가족 사항에 변화가 생기면(이혼, 이별, 이사, 이민, 사망 등), 어떻게 하시겠습니까?','2018-03-23 00:00:00'),('survey_list_code_11','survey_code_1','m_01','10. 구조된 동물의 경우, 사람과 집 생활에 길들여지지 않은 경우가 있습니다. 이 점에 대해 이해할 수 있으신가요?','2018-03-23 00:00:00'),('survey_list_code_12','survey_code_1','m_01','11. 새로운 환경에 적응할 때까지 용변을 가리지 못할 수 있습니다. 용변훈련은 입양 후 새로 시작해야 합니다. 동의하시나요?','2018-03-23 00:00:00'),('survey_list_code_13','survey_code_1','m_01','12. 어떻게 훈련을 시킬 것인지 구체적으로 설명해 주십시오. (본인이 직접 또는 전문가를 통해서 등)','2018-03-23 00:00:00'),('survey_list_code_14','survey_code_1','m_01','13. 어떻게 운동을 시킬 것인지 구체적으로 설명해 주십시오.','2018-03-23 00:00:00'),('survey_list_code_15','survey_code_1','m_01','14. 집에서 정성껏 만든 음식을 먹이시길 추천합니다. 그렇지 못할 경우 어떤 종료의 사료를 먹일 것이며, 선호하는 브랜드가 있다면 설명해 주십시오.','2018-03-23 00:00:00'),('survey_list_code_16','survey_code_1','m_01','15. 동물에게 폭력을 행사해서는 안 되며, 쾌적한 환경과 먹이, 식수를 제공해 주어야 합니다. 또한, 임의 유기나 ','2018-03-23 00:00:00'),('survey_list_code_17','survey_code_1','m_01','16. 입양한 동물이 자연사할 때까지 기를 각오가 되어 있으신가요? ','2018-03-23 00:00:00'),('survey_list_code_18','survey_code_1','m_01','17. 입양이 확정되어 동물이 가정에 도착하면 가장 먼저 사진을 찍어 입양센터로 보내주시고 도착소식을 반드시 전해 주셔야합니다. 이에 동의하시나요?  ','2018-03-23 00:00:00'),('survey_list_code_19','survey_code_1','m_01','18. 입양 후 3개월에 1회씩 입양한 동물의 사진과 이야기를 입양후기에 올려야하며 입양 후 케어의 가정방문이 ','2018-03-23 00:00:00'),('survey_list_code_20','survey_code_1','m_01','19. 입양한 아이를 파양 할 경우 , 앞으로 저희 협회를  통한 다른 동물의 입양은 1년간 제한됩니다.','2018-03-23 00:00:00'),('survey_list_code_44','survey_code_8','admin','','2018-03-30 12:23:41'),('survey_list_code_34','survey_code_8','login','인석아!','2018-03-29 13:53:35'),('survey_list_code_33','survey_code_8','login','인석아안녕?','2018-03-29 13:51:34'),('survey_list_code_31','survey_code_8','login','인석이는 뭘까?','2018-03-29 13:47:18'),('survey_list_code_27','survey_code_8','1','인석이바보','2018-03-29 11:57:37'),('survey_list_code_28','survey_code_8','login','인석이는 돼지일까?','2018-03-29 12:06:43'),('survey_list_code_39','survey_code_7','login','김장성바보?','2018-03-29 14:25:33'),('survey_list_code_30','survey_code_8','login','인석이는 돌일까?','2018-03-29 12:08:27'),('survey_list_code_43','survey_code_8','admin','배고프다','2018-03-30 12:23:28'),('survey_list_code_42','survey_code_9','login','항수야?','2018-03-29 14:35:23'),('survey_list_code_41','survey_code_8','login','ㅇㅇ','2018-03-29 14:33:17'),('survey_list_code_40','survey_code_8','login','항수바보','2018-03-29 14:32:43');
/*!40000 ALTER TABLE `t_survey_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_survey_record`
--

DROP TABLE IF EXISTS `t_survey_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_survey_record` (
  `survey_record_code` varchar(35) NOT NULL COMMENT '설문조사 점수 코드(PK)',
  `survey_record_grade` varchar(10) NOT NULL COMMENT '점수분류',
  `survey_record_grade_level` varchar(1) NOT NULL COMMENT '점수 분류 레벨',
  `survey_record` int(11) NOT NULL COMMENT '점수',
  PRIMARY KEY (`survey_record_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='설문조사 점수 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_survey_record`
--

LOCK TABLES `t_survey_record` WRITE;
/*!40000 ALTER TABLE `t_survey_record` DISABLE KEYS */;
INSERT INTO `t_survey_record` VALUES ('survey_record_1_5','매우그렇다','1',5),('survey_record_2_4','그렇다','2',4),('survey_record_3_3','보통이다','3',3),('survey_record_4_2','그렇지않다','4',2),('survey_record_5_1','매우그렇지않다','5',1);
/*!40000 ALTER TABLE `t_survey_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_yebang`
--

DROP TABLE IF EXISTS `t_yebang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_yebang` (
  `yebang_code` varchar(35) NOT NULL COMMENT '예방접종 관리 코드(PK)',
  `bl_code` varchar(35) NOT NULL COMMENT '보호소 통합 관리 코드(FK)',
  `m_shelter_id` varchar(35) NOT NULL COMMENT '보호소아이디(FK)',
  `animal_code` varchar(35) NOT NULL COMMENT '동물 코드(FK)',
  `os_code_yebang` varchar(35) NOT NULL COMMENT '예방접종 종류 코드(FK)',
  `yebang_whether` varchar(5) NOT NULL COMMENT '예방 접종 유무',
  `yebang_whether_date` datetime NOT NULL COMMENT '예방접종일',
  PRIMARY KEY (`yebang_code`),
  KEY `FK_animal_TO_yebang` (`animal_code`),
  KEY `FK_overall_status_TO_yebang` (`os_code_yebang`),
  KEY `FK_member_TO_yebang` (`m_shelter_id`),
  KEY `FK_business_license_TO_yebang` (`bl_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='예방 접종 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_yebang`
--

LOCK TABLES `t_yebang` WRITE;
/*!40000 ALTER TABLE `t_yebang` DISABLE KEYS */;
INSERT INTO `t_yebang` VALUES ('yebang_code_01','bl_code_01','m_03','animal_code_01','os_16_1_6','Y','2018-03-17 00:00:00'),('yebang_code_02','bl_code_01','m_02','animal_code_02','os_16_1_6','Y','2018-03-17 00:00:00'),('yebang_code_03','bl_code_02','m_07','animal_code_04','os_16_1_6','Y','2018-03-17 00:00:00'),('yebang_code_04','bl_code_02','m_08','animal_code_05','os_16_1_6','Y','2018-03-17 00:00:00');
/*!40000 ALTER TABLE `t_yebang` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-30 13:12:21
