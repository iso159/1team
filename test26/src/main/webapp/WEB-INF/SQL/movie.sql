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
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(45) NOT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'블랙팬서'),(2,'코코'),(3,'염력'),(4,'어벤져스'),(5,'가디언즈오브갤럭시'),(6,'데드풀'),(7,'염력'),(11,'어벤저스3'),(68,'게스트하우스 (Guest House)'),(69,'게이트 (Gate)'),(70,'겨울왕국의 무민 (Moomins and the Winter Wonderland)'),(71,'골든슬럼버 (Golden Slumber)'),(72,'궁합 (The Princess and the Matchmaker)'),(73,'금의위: 혈지도 (Blade of Enforcer)'),(74,'나미야 잡화점의 기적'),(75,'원더'),(76,'쇼생크 탈출'),(77,'위대한 쇼맨'),(78,'터미네이터 2'),(79,'인생은 아름다워'),(80,'레옹'),(81,'매트릭스'),(82,'나 홀로 집에'),(83,'죽은 시인의 사회'),(84,'빽 투 더 퓨쳐'),(85,'포레스트 검프'),(86,'월-E'),(87,'라이언 일병 구하기'),(88,'토이 스토리 3'),(89,'살인의 추억'),(90,'사운드 오브 뮤직'),(91,'센과 치히로의 행방불명'),(92,'반지의 제왕: 왕의 귀환'),(93,'헬프'),(94,'글래디에이터'),(95,'패왕별희'),(96,'미세스 다웃파이어'),(97,'동주'),(98,'굿바이 마이 프랜드'),(99,'클래식'),(100,'여인의 향기'),(101,'아이 캔 스피크'),(102,'울지마 톤즈'),(103,'주토피아'),(104,'반지의 제왕: 두 개의 탑'),(105,'세 얼간이'),(106,'에이리언 2'),(107,'서유기 2 - 선리기연'),(108,'캐스트 어웨이'),(109,'아마데우스'),(110,'그대를 사랑합니다'),(111,'쉰들러 리스트'),(112,'언터처블: 1%의 우정'),(113,'알라딘'),(114,'빌리 엘리어트 뮤지컬 라이브'),(115,'뷰티풀 투모로우'),(116,'드래곤 길들이기'),(117,'굿 윌 헌팅'),(118,'히든 피겨스'),(119,'지금, 만나러 갑니다'),(120,'모노노케 히메'),(121,'아이언 자이언트'),(122,'다크 나이트'),(123,'오페라의 유령 : 25주년 특별 공연'),(124,'집으로...');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-12  9:57:29
