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
-- Table structure for table `carforbuyer`
--

DROP TABLE IF EXISTS `carforbuyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carforbuyer` (
  `id_carforbuyer` int NOT NULL AUTO_INCREMENT,
  `mark` varchar(70) NOT NULL,
  `model` varchar(70) NOT NULL,
  `year` int NOT NULL,
  `horsepower` int NOT NULL,
  `color` varchar(70) NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`id_carforbuyer`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carforbuyer`
--

LOCK TABLES `carforbuyer` WRITE;
/*!40000 ALTER TABLE `carforbuyer` DISABLE KEYS */;
INSERT INTO `carforbuyer` VALUES (1,'Audi','Q7',2017,329,'gray',40000),(2,'BMW','X5',2019,335,'black',50000),(3,'Mercedes-Benz','GLE',2020,362,'blue',60000),(4,'Lexus','RX',2018,295,'white',45000),(5,'Toyota','Highlander',2021,295,'red',47000),(6,'Volvo','XC60',2019,316,'silver',48000),(7,'Ford','Explorer',2020,300,'black',45000),(8,'Chevrolet','Tahoe',2020,355,'blue',55000),(9,'Jeep','Grand Cherokee',2021,293,'green',48000),(10,'GMC','Acadia',2020,230,'gray',40000),(11,'Acura','RDX',2021,272,'white',46000),(12,'Infiniti','QX60',2020,295,'red',48000),(13,'Cadillac','XT5',2020,310,'black',50000),(14,'Lincoln','Aviator',2021,400,'blue',65000),(15,'Buick','Envision',2020,228,'silver',38000),(16,'Mazda','CX-9',2019,250,'black',35000),(17,'Hyundai','Santa Fe',2021,191,'green',30000),(18,'Kia','Sorento',2020,281,'gray',35000),(19,'Nissan','Pathfinder',2021,284,'white',37000),(20,'Volkswagen','Atlas',2020,235,'red',32000),(21,'Subaru','Outback',2021,260,'blue',34000),(22,'Honda','Pilot',2020,280,'silver',36000),(23,'Tesla','Model X',2021,670,'black',90000),(24,'Ferrari','SF90 Stradale',2022,986,'red',700000),(25,'Lamborghini','Aventador',2023,730,'yellow',550000),(26,'Porsche','Taycan',2022,616,'blue',180000),(27,'McLaren','Artura',2023,680,'orange',300000),(28,'Bugatti','Veyron',2022,1001,'black',1500000),(29,'Rolls-Royce','Cullinan',2023,563,'white',400000),(30,'Bentley','Bentayga',2023,626,'gray',350000),(31,'Aston Martin','Valkyrie',2023,1160,'black',2000000),(32,'Jaguar','I-PACE',2022,394,'green',80000),(33,'Land Rover','Defender',2022,395,'blue',90000),(34,'Jeep','Cherokee',2022,271,'gray',40000),(35,'GMC','Terrain',2023,170,'black',32000),(36,'Cadillac','XT6',2022,310,'white',55000),(37,'Buick','Encore',2023,155,'silver',25000),(38,'Chrysler','300',2023,292,'blue',35000),(39,'Lincoln','Corsair',2023,250,'red',40000),(40,'Volvo','XC40',2023,187,'black',32000),(41,'Maserati','Ghibli',2023,345,'white',60000),(42,'Alfa Romeo','Giulia',2022,280,'gray',50000),(43,'Genesis','G70',2023,252,'blue',45000),(44,'Infiniti','Q50',2022,300,'black',55000),(45,'Mini','Countryman',2023,189,'green',35000),(46,'Smart','EQ ForTwo',2023,80,'yellow',30000),(47,'Scion','xB',2022,158,'red',20000),(48,'Acura','TLX',2023,272,'silver',45000),(49,'Hummer','EV',2023,1000,'black',90000),(50,'Haval','F7',2023,268,'white',35000),(51,'Geely','Xingyue L',2022,218,'blue',30000),(52,'BYD','Han',2023,605,'black',40000),(53,'Lada','Granta',2022,88,'green',15000),(54,'Renault','Arkana',2023,138,'gray',20000),(55,'Peugeot','2008',2022,155,'white',25000),(56,'Citroen','C3',2023,155,'red',27000),(57,'Dacia','Sandero',2023,100,'silver',15000),(58,'Skoda','Scala',2022,150,'blue',25000),(59,'Fiat','Tipo',2023,130,'yellow',22000),(60,'Opel','Corsa',2023,100,'black',20000),(61,'Seat','Ibiza',2022,110,'white',21000),(62,'Dodge','Durango',2023,475,'red',55000),(63,'Ram','2500',2023,410,'blue',60000),(64,'Tesla','Model Y',2023,450,'black',70000),(65,'Ford','Ranger',2023,270,'gray',45000),(66,'Chevrolet','Blazer',2023,305,'white',50000),(67,'GMC','Canyon',2023,200,'black',40000),(68,'Toyota','4Runner',2023,270,'red',48000),(69,'Nissan','Xterra',2023,310,'blue',52000),(70,'Honda','Passport',2023,280,'gray',47000),(71,'Jeep','Compass',2023,180,'white',38000),(72,'Ford','Escape',2023,250,'black',40000),(73,'Chevrolet','Equinox',2023,170,'red',35000),(74,'Tesla','Roadster',2023,1000,'silver',250000),(75,'Mercedes-Benz','GLS',2023,483,'silver',70000),(76,'Toyota','Corolla',2022,150,'Red',25000),(77,'Honda','Civic',2021,140,'Blue',23000),(78,'Ford','Mustang',2023,300,'Yellow',40000),(79,'Chevrolet','Camaro',2020,320,'Black',45000),(80,'Tesla','Model 3',2022,250,'White',50000),(81,'BMW','3 Series',2023,220,'Silver',55000),(82,'Audi','A4',2021,190,'Gray',60000),(83,'Mercedes-Benz','C-Class',2020,200,'Black',65000),(84,'Volkswagen','Golf',2022,120,'Blue',30000),(85,'Subaru','Impreza',2021,150,'Green',27000),(86,'Nissan','Altima',2023,160,'Silver',32000),(87,'Hyundai','Elantra',2022,130,'Red',26000),(88,'Kia','Optima',2021,140,'White',28000),(89,'Mazda','Mazda3',2020,155,'Black',29000),(90,'Lexus','IS',2023,220,'Blue',60000),(91,'Infiniti','Q50',2021,250,'Gray',62000),(92,'Genesis','G70',2020,270,'Black',65000),(93,'Chevrolet','Tahoe',2022,355,'Black',60000),(94,'Dodge','Charger',2021,292,'Gray',35000),(95,'Jeep','Wrangler',2023,285,'Green',45000),(96,'Ram','1500',2020,395,'Blue',40000),(97,'GMC','Sierra',2022,420,'White',55000),(98,'Cadillac','Escalade',2021,420,'Silver',70000),(99,'Lincoln','Navigator',2023,450,'Black',80000),(100,'Buick','Enclave',2020,310,'Red',40000),(101,'Chrysler','300',2022,292,'Blue',35000),(102,'Fiat','500',2021,135,'Yellow',25000),(103,'Jaguar','F-Pace',2023,246,'Silver',55000),(104,'Land Rover','Discovery',2020,296,'Green',60000),(105,'Mercedes-Benz','GLE',2022,255,'White',65000),(106,'Porsche','Cayenne',2021,335,'Black',75000),(107,'Volvo','XC90',2023,250,'Blue',70000),(108,'Acura','MDX',2020,290,'Red',50000),(109,'Alfa Romeo','Stelvio',2022,280,'Gray',60000),(110,'Bentley','Bentayga',2021,542,'White',200000),(111,'Bugatti','Veyron',2023,1001,'Black',1500000),(112,'Ferrari','F8 Tributo',2020,710,'Red',300000),(113,'Lamborghini','Urus',2022,650,'Yellow',250000),(114,'Maserati','Levante',2021,345,'Blue',120000),(115,'McLaren','720S',2023,710,'Orange',300000),(116,'Rolls-Royce','Cullinan',2020,563,'Silver',350000),(117,'Tesla','Model X',2022,670,'Gray',80000),(118,'Fiat','Panda',2021,85,'White',15000),(119,'Dacia','Duster',2023,130,'Red',20000),(120,'Mini','Cooper',2020,134,'Blue',30000),(121,'Smart','Fortwo',2022,89,'Black',18000),(122,'Subaru','Forester',2021,182,'Green',32000),(123,'Suzuki','Swift',2023,82,'Yellow',15000),(124,'Renault','Captur',2020,90,'Silver',25000),(125,'Peugeot','3008',2022,130,'Gray',35000),(126,'Opel','Corsa',2021,100,'Black',22000),(127,'Citroen','C3',2023,110,'Red',24000),(128,'Audi','Q7',2020,248,'Blue',50000),(129,'BMW','X5',2022,335,'White',60000),(130,'Ford','Explorer',2021,300,'Black',45000),(131,'Honda','Pilot',2023,280,'Gray',55000),(132,'Hyundai','Tucson',2020,181,'Green',30000),(133,'Kia','Sorento',2022,281,'Blue',35000),(134,'Lexus','RX',2021,295,'Red',40000),(135,'Mazda','CX-5',2023,187,'Silver',32000),(136,'Nissan','Rogue',2020,181,'Black',30000),(137,'Toyota','RAV4',2022,203,'Gray',35000),(138,'Volkswagen','Tiguan',2021,184,'White',38000),(139,'Chevrolet','Equinox',2023,170,'Blue',32000),(140,'Dodge','Durango',2020,293,'Red',45000),(141,'Jeep','Grand Cherokee',2022,295,'Black',55000),(142,'Ram','2500',2021,410,'Gray',65000),(143,'GMC','Terrain',2023,170,'Green',32000),(144,'Cadillac','XT5',2020,237,'White',40000),(145,'Lincoln','Aviator',2022,400,'Blue',60000),(146,'Buick','Encore',2021,138,'Red',30000),(147,'Chrysler','Pacifica',2023,287,'Silver',50000),(148,'Fiat','Tipo',2020,94,'Black',18000),(149,'Jaguar','XE',2022,247,'Gray',35000),(150,'Land Rover','Range Rover Sport',2021,355,'Green',45000),(151,'Mercedes-Benz','GLC',2023,255,'Blue',55000),(152,'Porsche','Macan',2020,248,'Red',60000),(153,'Volvo','XC60',2022,250,'White',70000),(154,'Acura','RDX',2021,272,'Silver',80000),(155,'Alfa Romeo','Giulia',2023,280,'Black',40000),(157,'Bugatti','Chiron Sport',2022,1500,'Gray',1500000);
/*!40000 ALTER TABLE `carforbuyer` ENABLE KEYS */;
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
