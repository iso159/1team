-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.5.32

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `book_id` int(10) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'죽은시인의사회'),(2,'82년생김지영'),(3,'멈추면 비로소 보이는것들'),(11,'사랑하기 때문에'),(12,'아프니까 청춘이다'),(15,'2018 시나공 정보처리기사 실기'),(21,'test'),(31,'무례한 사람에게 웃으며 대처하는 법'),(32,'신경 끄기의 기술'),(33,'나의 영어 사춘기'),(34,'언어의 온도'),(35,'나미야 잡화점의 기적'),(36,'비울수록 사람을 더 채우는 말 그릇'),(37,'ETS 토익 정기시험 기출문제집'),(38,'연애의 행방'),(39,'살인자의 기억법'),(40,'나는 나로 살기로 했다'),(41,'말의 품격'),(42,'자존감 수업'),(43,'보노보노처럼 살다니 다행이야'),(44,'너의 췌장을 먹고 싶어'),(45,'꽃을 보듯 너를 본다.'),(46,'하늘과 바람과 별과 시'),(47,'#너에게'),(48,'약간의 거리를 둔다'),(49,'지구만큼 슬펐다고 한다'),(50,'아직, 불행하지 않습니다'),(51,'시 읽는 밤'),(52,'난장이가 쏘아올린 작은 공'),(53,'왜 나는 너를 사랑하는가'),(54,'오베라는 남자'),(55,'비행운'),(56,'봉제인형 살인사건'),(57,'20대에 읽어야 할 한권의 책'),(58,'군생활 자기계발 비법'),(59,'몰입'),(60,'나이 서른에 책 3000권을 읽어봤더니'),(61,'잘나가는 회사는 왜 나를 선택했나?'),(62,'나를 단련하는 책 읽기'),(63,'책 세상을 탐하다'),(64,'셰익스피어 4대명작'),(65,'20대에 하지 않으면 안될 50가지'),(66,'이십대 전반전'),(67,'부동산 그대로 희망이다'),(68,'질문을 던져라 책이 답한다'),(69,'성공은 20대에 결정된다'),(70,'대학이 변하면 국민이 행복해진다'),(71,'리셋 코리아'),(72,'나는 책에서 나를 만났다'),(73,'여대생 Bible'),(74,'모나드론 외'),(75,'피터 드러커의 리더십'),(76,'빅 스위치'),(77,'지금 알고 있는 것을 그때의 내가 알았더라면'),(78,'심리학 초콜릿'),(79,'정치놈 정치님'),(80,'학문의 길'),(81,'베스트셀러에서 지성인의 길을 걷다'),(82,'연애천재가 된 홈대리'),(83,'임경빈의 도끼스윙'),(84,'부동산으로 100억 버는 비법'),(85,'지금 제대로 가고 있습니까'),(86,'연애 정경'),(87,'조선 왕 독살사건'),(88,'똑똑한 리더의 손자병법'),(89,'기업 소셜미디어 활용 전략'),(90,'마음이 예뻐지는 시'),(91,'2020 미디어 트렌드'),(92,'부모는 니 실력이 아니야'),(93,'황제 다이어트'),(94,'약속된 성공'),(95,'당신의 나이에 시작된 기적'),(96,'뉴욕의사의 백신 영어'),(97,'밸런스 독서법'),(98,'어린왕자와 깊이 만나는 즐거움'),(99,'리더십과 자기기만'),(100,'인재가 기업의 미래다'),(101,'억만장자 마인드'),(102,'성공하기 위한 멀티플레이어 전략');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-13 12:19:34
