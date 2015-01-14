-- MySQL dump 10.13  Distrib 5.5.29, for osx10.6 (i386)
--
-- Host: barnesbrothers.homeserver.com    Database: caewebspring
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.1

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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  `vendor_id` int(11) NOT NULL,
  `email_threshold` int(11) NOT NULL,
  `item_url` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `on_order_quantity` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `updated_at` datetime NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Paper White 8.5 X 11','paper',35,1,5,'http://officedepot.com',0,1,'2015-01-13 23:24:17','2014-12-09 22:58:57'),(2,'Pens','Pens to write with',25,1,5,'http://www.officedepot.com',0,1,'2015-01-13 23:24:07','2014-12-09 22:58:57'),(3,'Staples','Staples for the automatic stapler',20,1,5,'http://www.officedepot.com',0,1,'2015-01-13 23:22:51','2014-12-09 22:58:57'),(4,'Black Toner','Black toner for CAE X and Y',20,2,5,'http://www.konica-minolta.com',0,1,'2015-01-13 22:33:46','2014-12-09 22:58:57'),(5,'Magenta Toner','Magenta toner for CAE X and Y',10,2,5,'http://www.konica-minolta.com',0,1,'2015-01-13 22:33:46','2014-12-09 22:58:57'),(6,'Yellow Toner','Yellow toner for CAE X and Y',10,2,5,'http://www.konica-minolta.com',0,1,'2015-01-13 23:24:29','2014-12-09 22:58:57'),(7,'Cyan Toner','Cyan toner for CAE X and Y',10,2,5,'http://www.konica-minolta.com',0,1,'2015-01-13 23:24:29','2014-12-09 22:58:57');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `order_qty` int(11) NOT NULL,
  `updated_at` datetime NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (1,1,1,12,'2014-12-09 22:58:57','2014-12-09 22:58:57'),(2,1,2,5,'2014-12-09 22:58:57','2014-12-09 22:58:57'),(3,2,3,20,'2014-12-09 22:58:57','2014-12-09 22:58:57'),(4,3,4,5,'2014-12-09 22:58:57','2014-12-09 22:58:57'),(5,4,5,2,'2014-12-09 22:58:57','2014-12-09 22:58:57'),(6,4,6,2,'2014-12-09 22:58:57','2014-12-09 22:58:57'),(7,4,7,2,'2014-12-09 22:58:57','2014-12-09 22:58:57'),(8,5,4,2,'2014-12-09 22:58:57','2014-12-09 22:58:57'),(38,41,1,5,'2015-01-13 22:58:21','2015-01-13 22:58:21'),(39,41,2,5,'2015-01-13 22:58:21','2015-01-13 22:58:21'),(40,42,1,5,'2015-01-13 23:23:44','2015-01-13 23:23:44'),(41,42,2,5,'2015-01-13 23:23:44','2015-01-13 23:23:44'),(42,43,6,5,'2015-01-13 23:23:44','2015-01-13 23:23:44'),(43,43,7,5,'2015-01-13 23:23:44','2015-01-13 23:23:44');
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `status` tinyint(1) NOT NULL,
  `updated_at` datetime NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,0,'2014-12-09 22:58:57','2014-12-09 22:58:57'),(2,0,'2014-12-09 22:58:57','2014-12-09 22:58:57'),(3,0,'2014-12-09 22:58:57','2014-12-09 22:58:57'),(4,0,'2014-12-09 22:58:57','2014-12-09 22:58:57'),(5,0,'2014-12-09 22:58:57','2014-12-09 22:58:57'),(41,0,'2015-01-13 22:58:21','2015-01-13 22:58:21'),(42,0,'2015-01-13 23:23:44','2015-01-13 23:23:44'),(43,0,'2015-01-13 23:23:44','2015-01-13 23:23:44');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trans_log`
--

DROP TABLE IF EXISTS `trans_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trans_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `itemname` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `action` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `updated_at` datetime NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trans_log`
--

LOCK TABLES `trans_log` WRITE;
/*!40000 ALTER TABLE `trans_log` DISABLE KEYS */;
INSERT INTO `trans_log` VALUES (19,'caeUser','Paper White 8.5 X 11','Quantity Adjusted by -15','2015-01-13 23:23:03','2015-01-13 23:23:03'),(20,'caeUser','Paper White 8.5 X 11','Quantity of 5 On Order From Placed Order','2015-01-13 23:23:44','2015-01-13 23:23:44'),(21,'caeUser','Yellow Toner','Quantity of 5 On Order From Placed Order','2015-01-13 23:23:44','2015-01-13 23:23:44'),(22,'caeUser','Pens','Quantity of 5 On Order From Placed Order','2015-01-13 23:23:44','2015-01-13 23:23:44'),(23,'caeUser','Cyan Toner','Quantity of 5 On Order From Placed Order','2015-01-13 23:23:44','2015-01-13 23:23:44'),(24,'caeUser','Paper White 8.5 X 11','Quantity of 5 Added From Received Order','2015-01-13 23:24:07','2015-01-13 23:24:07'),(25,'caeUser','Pens','Quantity of 5 Added From Received Order','2015-01-13 23:24:07','2015-01-13 23:24:07'),(26,'caeUser','Paper White 8.5 X 11','Quantity Adjusted by 1','2015-01-13 23:24:19','2015-01-13 23:24:19'),(27,'caeUser','Yellow Toner','Quantity of 5 Added From Received Order','2015-01-13 23:24:29','2015-01-13 23:24:29'),(28,'caeUser','Cyan Toner','Quantity of 5 Added From Received Order','2015-01-13 23:24:29','2015-01-13 23:24:29');
/*!40000 ALTER TABLE `trans_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `url` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `updated_at` datetime NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES (1,'Office Depot','http://www.officedepot.com','2014-12-09 22:58:57','2014-12-09 22:58:57'),(2,'Konica Minolta','http://www.konica-minolta.com','2014-12-09 22:58:57','2014-12-09 22:58:57');
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-14  0:06:19
