-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (arm64)
--
-- Host: localhost    Database: dbtest
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` datetime(6) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mid_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'2024-11-16 23:12:08.243000','tnd','2024-12-24 22:07:35.173000','tnd','Ha noi','2000-01-05 00:00:00.000000','Nguyen','Tuan','Dac ','0987456345',0),(3,'2024-11-17 00:10:11.158000','tnd',NULL,NULL,'Ha noi',NULL,'Nguyen','tu','dac','098456456',0),(4,'2024-11-17 23:00:05.553000','tnd',NULL,NULL,'Vinh Phuc',NULL,'nguyen','a','van','098456456',0),(5,'2024-11-17 23:05:17.295000','tnd',NULL,NULL,'test',NULL,'test','test','','123456343',0),(6,'2024-11-17 23:08:32.177000','tnd','2024-12-24 22:07:45.889000','tnd','trt','1970-01-01 08:00:00.000000','Trt','Trt',' ','trt',1),(7,'2024-11-17 23:09:33.502000','tnd','2025-01-31 14:47:28.055000','tnd','rer','1970-01-01 08:00:00.000000','Re','Re',' ','err',1),(8,'2024-11-17 23:10:20.663000','tnd',NULL,NULL,'ew',NULL,'ewe','ewe','','ewe',0),(9,'2024-11-22 23:41:35.566000','tnd',NULL,NULL,'re',NULL,'tr','tr','','e',0),(10,'2024-11-22 23:45:24.470000','tnd',NULL,NULL,'Ha Noi',NULL,'nguyen','tuan1','dac','098456456',0),(11,'2024-11-22 23:49:30.070000','tnd',NULL,NULL,'trt',NULL,'trtrtrt','trtrtrt','','tr',0),(12,'2024-11-22 23:50:23.311000','tnd',NULL,NULL,'tr',NULL,'trt','trt','','rtr',0),(13,'2024-11-22 23:51:06.670000','tnd',NULL,NULL,'bbb',NULL,'bbb','bbb','','bb',0),(14,'2024-11-30 09:58:54.332000','tnd',NULL,NULL,'ha noi',NULL,'nguyen','an','van','098456456',0),(15,'2024-11-30 13:44:39.776000','tnd',NULL,NULL,'Vinh Phuc',NULL,'nguyen','b','van','098654456',0),(16,'2024-11-30 13:50:05.640000','tnd',NULL,NULL,'Sơn tây',NULL,'nguyen','test','van','567567456',0),(17,'2024-12-10 22:49:48.191000','tnd',NULL,NULL,'hn',NULL,'test','test','','0985655568',0),(18,'2024-12-10 23:01:52.909000','tnd',NULL,NULL,'vp','2024-12-10 00:00:00.000000','an','an','','0984567896',0),(19,'2024-12-10 23:09:03.688000','tnd',NULL,NULL,'hn','2024-12-02 00:00:00.000000','test','test','','0981234568',0),(20,'2024-12-27 22:58:43.932000','tnd',NULL,NULL,'hà nội','2010-12-01 00:00:00.000000','nguyễn','tuấn','đắc ','0984563456',0),(21,'2024-12-31 14:37:37.069000','tnd',NULL,NULL,'Hà Nam','2010-12-03 00:00:00.000000','nguyễn','tuấn','','0985678456',0),(22,'2024-12-31 15:37:27.145000','tnd',NULL,NULL,'Bắc Ninh','2009-12-22 00:00:00.000000','nguyễn','thảo','phương ','0921234568',0),(23,'2024-12-31 16:02:44.218000','tnd',NULL,NULL,'test','2024-12-31 00:00:00.000000','test','test','','0912345643',0),(24,'2024-12-31 17:03:44.506000','tnd',NULL,NULL,'hn','2024-12-22 00:00:00.000000','t','t','','6666555445',0),(25,'2025-01-11 16:02:52.001000','tnd',NULL,NULL,'hà nội','2015-01-10 00:00:00.000000','test','test','','0981234565',0),(26,'2025-01-12 22:29:35.197000','tnd',NULL,NULL,'hà nội','2012-01-06 00:00:00.000000','test','test','','0981234345',0),(27,'2025-01-31 14:22:32.573000','tnd',NULL,NULL,'vĩnh phúc','2016-01-30 00:00:00.000000','nguyễn','trang','huyền ','0984561234',0),(28,'2025-01-31 14:35:22.742000','tnd',NULL,NULL,'vĩnh tường','2025-01-12 00:00:00.000000','đào','khánh','đức ','0964569856',0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `pazzword` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (1,'2025-01-04 00:00:00.000000','tnd',NULL,NULL,'123456','ADMIN',_binary '','admin');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_data`
--

DROP TABLE IF EXISTS `master_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_data` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `key_data` varchar(255) DEFAULT NULL,
  `value_data` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_data`
--

LOCK TABLES `master_data` WRITE;
/*!40000 ALTER TABLE `master_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `master_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_examination`
--

DROP TABLE IF EXISTS `medical_examination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_examination` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `sympton` varchar(255) DEFAULT NULL,
  `treatment` varchar(255) DEFAULT NULL,
  `type_of_medicine` varchar(255) DEFAULT NULL,
  `schedule_medical_id` int DEFAULT NULL,
  `day_of_examination` varchar(255) DEFAULT NULL,
  `money` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `total_money` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK478rfy65olpiaodwdm3jwetyn` (`schedule_medical_id`),
  CONSTRAINT `FKndygc9y30bsuhpfedtepwb0yl` FOREIGN KEY (`schedule_medical_id`) REFERENCES `schedule_medical` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_examination`
--

LOCK TABLES `medical_examination` WRITE;
/*!40000 ALTER TABLE `medical_examination` DISABLE KEYS */;
INSERT INTO `medical_examination` VALUES (3,NULL,NULL,NULL,NULL,'test',NULL,'test',20,'2024-12-28','120000',1,NULL),(4,NULL,NULL,NULL,NULL,'test1, test2',NULL,'test1, test2',21,'2024-12-28','120000',1,NULL),(5,NULL,NULL,NULL,NULL,'test',NULL,'3456',22,'2024-12-28','120000',1,NULL),(6,NULL,NULL,NULL,NULL,'ho, mũi',NULL,'siro, nhỏ mũi, kladcid',23,'2024-12-28','120000',1,NULL),(7,NULL,NULL,NULL,NULL,'ho, sốt ',NULL,'hút mũi, kladcis',27,'2024-12-28','120000',1,NULL),(8,NULL,NULL,NULL,NULL,'đau họng , ho ',NULL,'amoxilin, siro',28,'2024-12-31','150000',1,NULL),(9,NULL,NULL,NULL,NULL,'ho, sốt ',NULL,'amox, klacid',29,'2024-12-31','123232',1,NULL),(10,NULL,NULL,NULL,NULL,'ể',NULL,'ể',30,'2024-12-31','3343434343434',1,NULL),(11,NULL,NULL,NULL,NULL,'ho,sốt,mũi',NULL,'klacid,amox ,hút mũi',34,'2025-01-31','135000,26000,20000',1,'181000');
/*!40000 ALTER TABLE `medical_examination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `id_parent` int DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `router_link` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,NULL,'tnd',NULL,NULL,'pi pi-plus-circle',NULL,'Register','/register'),(2,NULL,'tnd',NULL,NULL,'pi pi-list',NULL,'List Register','/listregister'),(3,NULL,'admin',NULL,NULL,'pi pi-history',NULL,'History','/historycustomer'),(4,NULL,'admin',NULL,NULL,'pi pi-database',NULL,'Customer List','/listcustomer'),(5,NULL,NULL,NULL,NULL,'pi pi-money-bill',NULL,'Total Money','/money'),(6,NULL,'tnd',NULL,'tnd','pi pi-download',NULL,'Database','/db'),(7,NULL,'tnd',NULL,'tnd','pi pi-desktop',NULL,'Test','/test');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_medical`
--

DROP TABLE IF EXISTS `schedule_medical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule_medical` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `date_register` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `time_register` varchar(255) DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKocptenta905cx7uckgmg213tc` (`customer_id`),
  CONSTRAINT `FKocptenta905cx7uckgmg213tc` FOREIGN KEY (`customer_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_medical`
--

LOCK TABLES `schedule_medical` WRITE;
/*!40000 ALTER TABLE `schedule_medical` DISABLE KEYS */;
INSERT INTO `schedule_medical` VALUES (1,'2024-11-09 23:20:56.552000','tnd',NULL,NULL,'09-11-2024','nguyen dac tuan',0,'08:10',NULL),(2,'2024-11-09 23:31:15.500000','tnd',NULL,NULL,'09-11-2024','nguyen dac tuan',1,'08:10',NULL),(4,'2024-11-17 00:10:11.197000','tnd',NULL,NULL,'2024-11-17','Nguyen dac tuan',0,'00:09',3),(5,'2024-11-17 23:00:05.601000','tnd',NULL,NULL,'2024-11-17','nguyen van a',0,'22:59',4),(6,'2024-11-17 23:05:25.071000','tnd',NULL,NULL,'2024-11-17','test',0,'23:05',5),(7,'2024-11-17 23:08:36.241000','tnd',NULL,NULL,'2024-11-17','trt',0,'23:08',6),(8,'2024-11-17 23:09:36.002000','tnd',NULL,NULL,'2024-11-17','re',2,'23:09',7),(9,'2024-11-17 23:10:23.128000','tnd',NULL,NULL,'2024-11-17','ewe',2,'23:10',8),(11,'2024-11-22 23:45:24.485000','tnd',NULL,NULL,'2024-11-22','nguyen dac tuan1',2,'23:45',10),(17,'2024-11-22 23:49:30.092000','tnd',NULL,NULL,'2024-11-22','trtrtrt',2,'23:49',11),(18,'2024-11-22 23:50:23.327000','tnd',NULL,NULL,'2024-11-22','trt',2,'23:50',12),(19,'2024-11-22 23:51:06.704000','tnd',NULL,NULL,'2024-11-22','bbb',0,'23:51',13),(20,'2024-11-30 09:58:54.362000','tnd',NULL,NULL,'2024-11-30','nguyen van an',1,'10:58',14),(21,'2024-11-30 13:44:39.815000','tnd',NULL,NULL,'2024-11-30','nguyen van b',1,'13:45',15),(22,'2024-11-30 13:50:05.656000','tnd',NULL,NULL,'2024-11-30','nguyen van test',1,'14:50',16),(23,'2024-12-07 14:58:35.717000','tnd',NULL,NULL,'2024-12-07','nguyen dac tuan',1,'14:54',10),(24,'2024-12-10 22:49:48.363000','tnd',NULL,NULL,'2024-12-10','test',0,'22:48',17),(25,'2024-12-10 23:01:53.154000','tnd',NULL,NULL,'2024-12-10','an',0,'22:59',18),(26,'2024-12-10 23:09:03.766000','tnd',NULL,NULL,'2024-12-10','test',0,'23:08',19),(27,'2024-12-27 22:58:43.971000','tnd',NULL,NULL,'2024-12-27','nguyễn đắc tuấn',1,'22:58',20),(28,'2024-12-31 14:37:37.117000','tnd',NULL,NULL,'2024-12-31','nguyễn tuấn',1,'15:40',21),(29,'2024-12-31 15:37:27.179000','tnd',NULL,NULL,'2024-12-31','nguyễn phương thảo',1,'16:40',22),(30,'2024-12-31 16:02:44.245000','tnd',NULL,NULL,'2024-12-31','test',1,'16:01',23),(31,'2024-12-31 17:03:44.535000','tnd',NULL,NULL,'2024-12-31','t',0,'17:03',24),(32,'2025-01-11 16:02:52.047000','tnd',NULL,NULL,'2025-01-11','test',0,'17:10',25),(33,'2025-01-12 22:29:35.240000','tnd',NULL,NULL,'2025-01-12','test',0,'22:30',26),(34,'2025-01-31 14:22:32.622000','tnd',NULL,NULL,'2025-01-31','nguyễn huyền trang',1,'15:50',27),(35,'2025-01-31 14:35:22.770000','tnd',NULL,NULL,'2025-01-31','đào đức khánh',0,'14:40',28);
/*!40000 ALTER TABLE `schedule_medical` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-04 17:16:03
