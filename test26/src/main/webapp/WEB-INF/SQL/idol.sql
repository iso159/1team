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
-- Table structure for table `idol`
--

DROP TABLE IF EXISTS `idol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idol` (
  `idol_id` int(11) NOT NULL AUTO_INCREMENT,
  `idol_name` varchar(45) NOT NULL,
  PRIMARY KEY (`idol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idol`
--

LOCK TABLES `idol` WRITE;
/*!40000 ALTER TABLE `idol` DISABLE KEYS */;
INSERT INTO `idol` VALUES (1,'소녀시대'),(2,'트와이스'),(3,'레드벨벳'),(5,'걸스데이'),(8,'마마무'),(15,'비'),(17,'빅스'),(18,'방탄소년단'),(19,'비투비'),(20,'엑소'),(21,'소년공화국'),(22,'인피니트'),(23,'여자친구'),(24,'러블리즈'),(25,'블랙핑크'),(26,'에이핑크'),(27,'오마이걸'),(28,'우주소녀'),(29,'갓세븐'),(30,'비스트'),(31,'샤이니'),(32,'다이아'),(33,'동방신기'),(34,'슈퍼주니어'),(35,'빅뱅'),(36,'2pm'),(37,'2am'),(38,'백퍼센트'),(39,'보이프렌드'),(40,'틴탑'),(41,'빅스'),(42,'뉴이스트'),(43,'ft아일랜드'),(44,'탑독'),(45,'제국의 아이들'),(46,'유키스'),(47,'블락비'),(48,'원더걸스'),(49,'미쓰에이'),(50,'fx'),(51,'씨스타'),(52,'달샤벳'),(53,'브라운 아이드 걸스'),(54,'애프터스쿨'),(55,'오렌지카라멜'),(56,'레인보우'),(57,'카라'),(58,'크레용팝'),(59,'다비치'),(60,'투개월'),(61,'에픽하이'),(62,'10cm'),(63,'손담비'),(64,'아이유'),(65,'홍대광'),(66,'박효신'),(67,'리쌍'),(68,'박정현'),(69,'백지영'),(70,'부활'),(71,'선미'),(72,'성시경'),(73,'악동뮤지션'),(74,'이승기'),(75,'이적'),(76,'이하이'),(77,'이효리'),(78,'자우림'),(79,'장나라'),(80,'장미여관'),(81,'장재인'),(82,'정인'),(83,'지누션'),(84,'휘성'),(85,' ns윤지'),(86,'에일리'),(87,'빈지노'),(88,'보아'),(89,'범키'),(90,'지나'),(91,'거미'),(92,'아이비'),(93,'aoa'),(94,'주니엘'),(95,'케이윌'),(96,'매드클라운'),(97,'싸이'),(98,'산이'),(99,'윤하');
/*!40000 ALTER TABLE `idol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-12  9:52:18
