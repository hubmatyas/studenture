# ************************************************************
# Sequel Ace SQL dump
# Version 20039
#
# https://sequel-ace.com/
# https://github.com/Sequel-Ace/Sequel-Ace
#
# Host: localhost (MySQL 8.0.31)
# Database: studenture
# Generation Time: 2022-11-11 11:31:29 AM +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE='NO_AUTO_VALUE_ON_ZERO', SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table milestone
# ------------------------------------------------------------

DROP TABLE IF EXISTS milestone_result;

CREATE TABLE `milestone` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(55) NOT NULL,
  `displeyName` varchar(55) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



# Dump of table recordCard
# ------------------------------------------------------------

DROP TABLE IF EXISTS `recordCard`;

CREATE TABLE `recordCard` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `userId` bigint NOT NULL,
  `academicYear` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `semester` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `subjectId` bigint NOT NULL,
  `subjectTermId` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



# Dump of table role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(55) NOT NULL,
  `displeyName` varchar(55) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO `role` (`id`, `name`, `displeyName`)
VALUES
	(1,'ADMIN_ROLE','Admin'),
	(2,'PROFESSOR_ROLE','Professor'),
	(3,'STUDENT_ROLE','Student');

/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table subject
# ------------------------------------------------------------

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(55) DEFAULT NULL,
  `displeyName` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `guarantorId` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



# Dump of table subject_subjectTerm
# ------------------------------------------------------------

DROP TABLE IF EXISTS `subject_subjectTerm`;

CREATE TABLE `subject_subjectTerm` (
  `subjectId` bigint NOT NULL,
  `subjectTermId` bigint NOT NULL,
  PRIMARY KEY (`subjectId`,`subjectTermId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



# Dump of table subjectTerm
# ------------------------------------------------------------

DROP TABLE IF EXISTS subject_term;

CREATE TABLE `subjectTerm` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `subjectId` bigint NOT NULL,
  `professorId` bigint NOT NULL,
  `milestoneId` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



# Dump of table user_recordCard
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_recordCard`;

CREATE TABLE `user_recordCard` (
  `userId` bigint NOT NULL,
  `recordCardId` bigint NOT NULL,
  PRIMARY KEY (`userId`,`recordCardId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



# Dump of table user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `userId` bigint NOT NULL,
  `roleId` bigint NOT NULL,
  PRIMARY KEY (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



# Dump of table user_subjectTerm
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_subjectTerm`;

CREATE TABLE `user_subjectTerm` (
  `userId` bigint NOT NULL,
  `subjectTermId` bigint NOT NULL,
  PRIMARY KEY (`userId`,`subjectTermId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
