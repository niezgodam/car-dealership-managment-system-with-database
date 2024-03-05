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
-- Table structure for table `unemployed`
--

DROP TABLE IF EXISTS `unemployed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unemployed` (
  `id_unemployed` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `age` int NOT NULL,
  `experience` int NOT NULL,
  `position` varchar(50) NOT NULL,
  PRIMARY KEY (`id_unemployed`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unemployed`
--

LOCK TABLES `unemployed` WRITE;
/*!40000 ALTER TABLE `unemployed` DISABLE KEYS */;
INSERT INTO `unemployed` VALUES (2,'Judith','Alexander',25,1,'Recruiter'),(3,'Lucie','Kennedy',28,2,'Recruiter'),(4,'Sadie','Gonzales',42,13,'Recruiter'),(6,'Edgar','Parrish',26,3,'Recruiter'),(7,'Nora','Ramirez',30,8,'Recruiter'),(8,'Gavin','Barnes',35,10,'Recruiter'),(9,'Hannah','Wells',31,6,'Recruiter'),(10,'Victor','Fisher',40,12,'Recruiter'),(11,'Zoe','Harrison',27,4,'Recruiter'),(12,'Dean','Mendoza',34,9,'Recruiter'),(13,'Savannah','Schmidt',29,7,'Recruiter'),(14,'Landon','Ferguson',33,11,'Recruiter'),(15,'Riley','Lowe',26,3,'Recruiter'),(17,'Oscar','Bishop',38,14,'Recruiter'),(18,'Miranda','Huerta',32,9,'Recruiter'),(19,'Evan','McCarthy',37,11,'Recruiter'),(20,'Hailey','Stephenson',28,5,'Recruiter'),(21,'Simon','Hodges',41,15,'Recruiter'),(22,'Ivy','Schroeder',29,7,'Recruiter'),(23,'Tristan','Powers',30,8,'Recruiter'),(24,'Brianna','Saunders',31,9,'Recruiter'),(25,'Jasper','Yu',25,2,'Recruiter'),(26,'Phoebe','Wilkinson',26,3,'Recruiter'),(27,'Cole','Morton',36,12,'Recruiter'),(28,'Aria','Becker',34,11,'Recruiter'),(29,'Max','Sharp',39,14,'Recruiter'),(30,'Luna','Howell',27,6,'Recruiter'),(31,'Axel','Ramos',33,10,'Recruiter'),(32,'Julia','Mccormick',37,13,'Recruiter'),(33,'Carter','Morris',38,14,'Recruiter'),(34,'Nova','Hardy',29,7,'Recruiter'),(35,'Will','Chaney',39,5,'Recruiter'),(36,'James','Smith',50,25,'recruiter'),(38,'Serena','Lane',45,15,'recruiter');
/*!40000 ALTER TABLE `unemployed` ENABLE KEYS */;
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
