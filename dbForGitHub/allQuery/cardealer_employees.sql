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
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id_employees` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `age` int NOT NULL,
  `experience` int NOT NULL,
  `position` varchar(50) NOT NULL,
  PRIMARY KEY (`id_employees`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Mohamed','Miranda',45,15,'Team leader'),(2,'Alicia','Middleton',25,3,'Receptionist'),(3,'Kane','Prince',62,40,'Parts Specialist'),(4,'Laila','Joseph',50,21,'Service Technician'),(5,'Lily','Shepherd',39,9,'Marketing Coordinator'),(6,'Rayhan','Huff',18,0,'Intern'),(7,'Whitney','Bloggs',19,1,'Intern'),(8,'Alex','Johnson',32,5,'Sales Manager'),(9,'Emily','Garcia',28,3,'Sales Representative'),(10,'Nathan','Lee',25,1,'Sales Representative'),(11,'Sophia','Chen',45,15,'Senior Sales Consultant'),(12,'Mason','Martinez',22,0,'Trainee Sales Associate'),(13,'Gabriel','Choudhury',28,3,'Inventory Coordinator'),(14,'Charlotte','Ali',34,6,'Inventory Specialist'),(15,'Benjamin','Kumar',37,8,'Inventory Manager'),(16,'Evelyn','Raj',21,1,'Receptionist'),(17,'Liam','Gupta',30,5,'Administrative Assistant'),(18,'Mia','Fernandez',36,7,'Office Manager'),(19,'Harper','Tran',42,15,'Senior Marketing Manager'),(20,'Logan','Wu',23,2,'Marketing Assistant'),(21,'Avery','Chan',27,4,'Marketing Specialist'),(22,'Noah','Rodriguez',33,9,'Marketing Director'),(23,'Ella','Ng',24,1,'Finance Assistant'),(24,'James','Smith',50,25,'Senior Finance Consultant'),(25,'Madison','Wong',31,6,'Financial Analyst'),(26,'William','Lopez',38,8,'Finance Manager'),(27,'Isabella','Patel',26,2,'Junior Technician'),(28,'Daniel','Kim',48,20,'Senior Technician'),(29,'Ava','Gonzalez',29,4,'Service Advisor'),(30,'Ethan','Nguyen',35,7,'Service Advisor'),(31,'Olivia','Brown',40,10,'Service Manager'),(32,'Mason','Martinez',22,0,'Trainee Sales Associate'),(33,'Sophia','Chen',45,15,'Senior Sales Consultant'),(34,'Nathan','Lee',25,1,'Sales Representative'),(35,'Emily','Garcia',28,3,'Sales Representative'),(36,'Serena','Lane',45,15,'Recruiter'),(37,'Judith','Alexander',25,1,'Recruiter'),(38,'Judith','Alexander',25,1,'Recruiter'),(39,'Serena','Lane',45,15,'Recruiter'),(40,'Lucie','Kennedy',28,2,'Recruiter'),(41,'Will','Chaney',39,5,'Recruiter'),(42,'Leah','Wagner',36,13,'Recruiter'),(43,'Serena','Lane',45,15,'recruiter');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-05 21:28:45
