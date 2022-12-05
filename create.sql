-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sport
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `account` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_player`
--

DROP TABLE IF EXISTS `event_player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_player` (
  `id_player` varchar(10) NOT NULL,
  `id_item` varchar(10) NOT NULL,
  `grade` double DEFAULT NULL,
  `join` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_player`,`id_item`),
  KEY `id_item` (`id_item`),
  CONSTRAINT `event_player_ibfk_1` FOREIGN KEY (`id_player`) REFERENCES `player` (`account`),
  CONSTRAINT `event_player_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_player`
--

LOCK TABLES `event_player` WRITE;
/*!40000 ALTER TABLE `event_player` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_referee`
--

DROP TABLE IF EXISTS `event_referee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_referee` (
  `id_referee` varchar(10) NOT NULL,
  `id_item` varchar(10) NOT NULL,
  PRIMARY KEY (`id_referee`,`id_item`),
  KEY `id_item` (`id_item`),
  CONSTRAINT `event_referee_ibfk_1` FOREIGN KEY (`id_referee`) REFERENCES `referee` (`account`),
  CONSTRAINT `event_referee_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_referee`
--

LOCK TABLES `event_referee` WRITE;
/*!40000 ALTER TABLE `event_referee` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_referee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_volunteer`
--

DROP TABLE IF EXISTS `event_volunteer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_volunteer` (
  `id_item` varchar(10) NOT NULL,
  `id_volunteer` varchar(10) NOT NULL,
  PRIMARY KEY (`id_item`,`id_volunteer`),
  KEY `id_volunteer` (`id_volunteer`),
  CONSTRAINT `event_volunteer_ibfk_1` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`),
  CONSTRAINT `event_volunteer_ibfk_2` FOREIGN KEY (`id_volunteer`) REFERENCES `volunteer` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_volunteer`
--

LOCK TABLES `event_volunteer` WRITE;
/*!40000 ALTER TABLE `event_volunteer` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_volunteer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` varchar(10) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `rule` text,
  `place` varchar(20) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `is_over` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log` (
  `id_volunteer` varchar(10) DEFAULT NULL,
  `id_item` varchar(10) DEFAULT NULL,
  `id_player` varchar(10) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `message` text,
  KEY `id_volunteer` (`id_volunteer`),
  KEY `id_item` (`id_item`),
  KEY `id_player` (`id_player`),
  CONSTRAINT `log_ibfk_1` FOREIGN KEY (`id_volunteer`) REFERENCES `volunteer` (`account`),
  CONSTRAINT `log_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`),
  CONSTRAINT `log_ibfk_3` FOREIGN KEY (`id_player`) REFERENCES `player` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marking`
--

DROP TABLE IF EXISTS `marking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marking` (
  `id_referee` varchar(10) NOT NULL,
  `id_item` varchar(10) NOT NULL,
  `id_player` varchar(10) NOT NULL,
  `grade` double DEFAULT NULL,
  PRIMARY KEY (`id_referee`,`id_item`,`id_player`),
  KEY `id_event` (`id_item`),
  KEY `id_sport` (`id_player`),
  CONSTRAINT `marking_ibfk_1` FOREIGN KEY (`id_referee`) REFERENCES `referee` (`account`),
  CONSTRAINT `marking_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`),
  CONSTRAINT `marking_ibfk_3` FOREIGN KEY (`id_player`) REFERENCES `player` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marking`
--

LOCK TABLES `marking` WRITE;
/*!40000 ALTER TABLE `marking` DISABLE KEYS */;
/*!40000 ALTER TABLE `marking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player` (
  `account` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referee`
--

DROP TABLE IF EXISTS `referee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `referee` (
  `account` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referee`
--

LOCK TABLES `referee` WRITE;
/*!40000 ALTER TABLE `referee` DISABLE KEYS */;
/*!40000 ALTER TABLE `referee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `score` (
  `id_item` varchar(10) NOT NULL,
  `id_player` varchar(10) NOT NULL,
  `score` double DEFAULT NULL,
  `rank` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_item`,`id_player`),
  KEY `id_player` (`id_player`),
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`id_item`) REFERENCES `event_player` (`id_item`),
  CONSTRAINT `score_ibfk_2` FOREIGN KEY (`id_player`) REFERENCES `event_player` (`id_player`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer`
--

DROP TABLE IF EXISTS `volunteer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volunteer` (
  `account` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer`
--

LOCK TABLES `volunteer` WRITE;
/*!40000 ALTER TABLE `volunteer` DISABLE KEYS */;
/*!40000 ALTER TABLE `volunteer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-05 17:12:56
