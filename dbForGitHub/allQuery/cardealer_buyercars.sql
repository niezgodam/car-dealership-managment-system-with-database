-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cardealer
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `buyercars`
--

DROP TABLE IF EXISTS `buyercars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buyercars` (
  `id_buyercars` int NOT NULL AUTO_INCREMENT,
  `mark` varchar(70) NOT NULL,
  `model` varchar(70) NOT NULL,
  `year` int NOT NULL,
  `horsepower` int NOT NULL,
  `color` varchar(70) NOT NULL,
  `price` varchar(70) NOT NULL,
  PRIMARY KEY (`id_buyercars`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyercars`
--

LOCK TABLES `buyercars` WRITE;
/*!40000 ALTER TABLE `buyercars` DISABLE KEYS */;
INSERT INTO `buyercars` VALUES (1,'Volkswagen','Atlas',2020,235,'red','32000'),(2,'Volkswagen','Atlas',2020,235,'red','32000'),(3,'Chevrolet','Equinox',2023,170,'red','35000'),(4,'Subaru','Outback',2021,260,'blue','34000'),(5,'Ferrari','SF90 Stradale',2022,986,'red','700000'),(6,'Opel','Corsa',2023,100,'black','20000'),(7,'Lada','Granta',2022,88,'green','15000'),(8,'Dacia','Sandero',2023,100,'silver','15000'),(9,'Honda','Pilot',2020,280,'silver','36000'),(10,'Bentley','Flying Spur',2020,626,'Red','200000');
/*!40000 ALTER TABLE `buyercars` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-05 21:28:46
