-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: studentuure
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `milestone_result`
--

DROP TABLE IF EXISTS `milestone_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `milestone_result` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `milestone` enum('TEST','WORKSHOP','EXAM') DEFAULT 'TEST',
  `maximum` int NOT NULL DEFAULT '100',
  `result` int DEFAULT NULL,
  `term_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `milestone_id_uindex` (`id`),
  KEY `term_id` (`term_id`),
  CONSTRAINT `term_id` FOREIGN KEY (`term_id`) REFERENCES `subject_term` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `milestone_result`
--

LOCK TABLES `milestone_result` WRITE;
/*!40000 ALTER TABLE `milestone_result` DISABLE KEYS */;
INSERT INTO `milestone_result` VALUES (1,'TEST',100,20,1),(7,'WORKSHOP',20,25,1),(8,'TEST',20,15,1),(14,'TEST',20,0,NULL);
/*!40000 ALTER TABLE `milestone_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recordcard`
--

DROP TABLE IF EXISTS `recordcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recordcard` (
  `recordCard_id` bigint NOT NULL,
  `student_id` int DEFAULT NULL,
  `subjectterm_id` int DEFAULT NULL,
  PRIMARY KEY (`recordCard_id`),
  CONSTRAINT `subjectterm` FOREIGN KEY (`recordCard_id`) REFERENCES `subject_term` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recordcard`
--

LOCK TABLES `recordcard` WRITE;
/*!40000 ALTER TABLE `recordcard` DISABLE KEYS */;
/*!40000 ALTER TABLE `recordcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `guarant` varchar(20) DEFAULT NULL,
  `credits` int NOT NULL DEFAULT '100',
  `goal` varchar(100) DEFAULT NULL,
  `degree` enum('BC','MGR') DEFAULT NULL,
  `language` enum('CZ','EN') DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subject_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (2,'Algoritmizace','Phd.Jozef Novak',100,'vedieť algoritmy','BC','CZ','zakladne algoritmy as Sort,Searche'),(5,'Matematika','Phd.Jozef Novak',20,'','BC','CZ',''),(6,'Základy frontendu','Phd.Jozef Novak',20,'React','BC','CZ','React'),(7,'Angličtina','Phd.Jozef Novak',10,'B2','BC','CZ','B2');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_term`
--

DROP TABLE IF EXISTS `subject_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_term` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `subject_id` int NOT NULL,
  `academic_year` varchar(10) DEFAULT NULL,
  `semester` enum('ZS','LS') DEFAULT NULL,
  `result` int DEFAULT '0',
  `term_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subjectTerm_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_term`
--

LOCK TABLES `subject_term` WRITE;
/*!40000 ALTER TABLE `subject_term` DISABLE KEYS */;
INSERT INTO `subject_term` VALUES (1,5,'2021/2022','LS',0,NULL);
/*!40000 ALTER TABLE `subject_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjectterm_milestones`
--

DROP TABLE IF EXISTS `subjectterm_milestones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjectterm_milestones` (
  `subjectterm_milestones_id` bigint NOT NULL,
  `subjectterm_id` int DEFAULT NULL,
  `milestone_id` int DEFAULT NULL,
  PRIMARY KEY (`subjectterm_milestones_id`),
  CONSTRAINT `milestones_id` FOREIGN KEY (`subjectterm_milestones_id`) REFERENCES `milestone_result` (`id`),
  CONSTRAINT `subjectterm_id` FOREIGN KEY (`subjectterm_milestones_id`) REFERENCES `subject_term` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjectterm_milestones`
--

LOCK TABLES `subjectterm_milestones` WRITE;
/*!40000 ALTER TABLE `subjectterm_milestones` DISABLE KEYS */;
/*!40000 ALTER TABLE `subjectterm_milestones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(10) DEFAULT NULL,
  `id_int` bigint DEFAULT NULL,
  `session_id` varchar(10) DEFAULT NULL,
  `session_expire` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('101832492192105240247','Anna Borets','anitaborets@gmail.com',NULL,'USER',NULL),('115250436403609299919','Anna Borets','ekoveda2012@gmail.com',NULL,'USER',NULL),('123265','user','user@gmail.com','user','USER',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-14 12:14:07
