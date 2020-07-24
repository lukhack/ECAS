
use db_prosiscom;
-- MySQL dump 10.13  Distrib 5.6.40, for Win64 (x86_64)
--
-- Host: localhost    Database: db_rolaps
-- ------------------------------------------------------
-- Server version	5.6.40-log

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
-- Table structure for table `iubitacora`
--

DROP TABLE IF EXISTS `iubitacora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iubitacora` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `IUUsuarioId` int(11) NOT NULL,
  `Accion` varchar(4000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `FechaHora` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_iubitacora_uiusuario1_idx` (`IUUsuarioId`),
  CONSTRAINT `fk_iubitacora_uiusuario1` FOREIGN KEY (`IUUsuarioId`) REFERENCES `uiusuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=589 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iubitacora`
--

LOCK TABLES `iubitacora` WRITE;
/*!40000 ALTER TABLE `iubitacora` DISABLE KEYS */;
INSERT INTO `iubitacora` VALUES (1,1,'Ingreso al sistema','2018-03-30 19:46:34'),(2,1,'Ingreso al sistema','2018-03-30 19:54:39'),(3,1,'Ingreso al sistema','2018-03-30 20:29:01'),(4,1,'Ingreso al sistema','2018-03-30 20:38:57'),(5,1,'Ingreso al sistema','2018-03-30 20:58:54'),(6,1,'Ingreso al sistema','2018-03-30 21:00:15'),(7,1,'Ingreso al sistema','2018-03-30 21:15:49'),(8,1,'Ingreso al sistema','2018-03-30 21:45:58'),(9,1,'Ingreso al sistema','2018-03-30 21:46:16'),(10,1,'Ingreso al sistema','2018-03-30 21:49:10'),(11,1,'Ingreso al sistema','2018-03-30 21:49:58'),(12,1,'Ingreso al sistema','2018-03-30 21:50:12'),(13,1,'Ingreso al sistema','2018-03-30 21:50:18'),(14,1,'Ingreso al sistema','2018-03-30 21:53:55'),(15,1,'Ingreso al sistema','2018-03-30 22:07:41'),(16,1,'Ingreso al sistema','2018-03-30 22:07:45'),(17,1,'Ingreso al sistema','2018-03-30 22:08:02'),(18,1,'Ingreso al sistema','2018-03-30 22:09:20'),(19,1,'Ingreso al sistema','2018-03-30 22:09:45'),(20,1,'Ingreso al sistema','2018-03-30 22:57:51'),(21,1,'Ingreso al sistema','2018-03-30 23:00:17'),(22,1,'Ingreso al sistema','2018-04-01 12:20:41'),(23,1,'Ingreso al sistema','2018-04-01 17:16:24'),(24,1,'Usuario cerro session','2018-04-01 18:17:40'),(25,1,'Ingreso al sistema','2018-04-01 18:17:44'),(26,1,'Ingreso al sistema','2018-04-01 18:40:53'),(27,1,'Ingreso al sistema','2018-04-01 18:41:26'),(28,1,'Ingreso al sistema','2018-04-01 18:46:49'),(29,1,'Usuario cerro session','2018-04-01 18:47:06'),(30,1,'Ingreso al sistema','2018-04-01 18:47:13'),(31,1,'Ingreso al sistema','2018-04-01 19:36:50'),(32,1,'Ingreso al sistema','2018-04-01 19:43:13'),(33,1,'Ingreso al sistema','2018-04-01 19:52:52'),(34,1,'Ingreso al sistema','2018-04-01 20:33:18'),(35,1,'Ingreso al sistema','2018-04-01 21:21:31'),(36,1,'Ingreso al sistema','2018-04-01 21:25:15'),(37,1,'Ingreso al sistema','2018-04-01 22:02:38'),(38,1,'Ingreso al sistema','2018-04-03 14:40:06'),(39,1,'Ingreso al sistema','2018-04-03 15:54:18'),(40,1,'Ingreso al sistema','2018-04-03 21:16:36'),(41,1,'Ingreso al sistema','2018-04-03 21:42:30'),(42,1,'Ingreso al sistema','2018-04-03 22:09:17'),(43,1,'Ingreso al sistema','2018-04-04 07:23:22'),(44,1,'Ingreso al sistema','2018-04-04 21:54:36'),(45,1,'Ingreso al sistema','2018-04-04 21:55:11'),(46,1,'Usuario cerro session','2018-04-04 21:55:11'),(47,1,'Ingreso al sistema','2018-04-04 21:59:38'),(48,1,'Ingreso al sistema','2018-04-04 22:08:29'),(49,1,'Ingreso al sistema','2018-04-04 22:15:04'),(50,1,'Ingreso al sistema','2018-04-04 22:17:06'),(51,1,'Ingreso al sistema','2018-04-04 22:18:54'),(52,1,'Ingreso al sistema','2018-04-04 22:34:21'),(53,1,'Ingreso al sistema','2018-04-04 22:43:12'),(54,1,'Ingreso al sistema','2018-04-04 22:47:09'),(55,1,'Ingreso al sistema','2018-04-04 22:50:11'),(56,1,'Ingreso al sistema','2018-04-04 22:59:16'),(57,1,'Ingreso al sistema','2018-04-05 18:47:22'),(58,1,'Ingreso al sistema','2018-04-05 19:08:17'),(59,1,'Ingreso al sistema','2018-04-05 19:40:32'),(60,1,'Ingreso al sistema','2018-04-05 21:14:45'),(61,1,'Ingreso al sistema','2018-04-05 21:24:48'),(62,1,'Ingreso al sistema','2018-04-05 22:29:00'),(63,1,'Ingreso al sistema','2018-04-05 22:49:21'),(64,1,'Ingreso al sistema','2018-04-05 23:04:22'),(65,1,'Ingreso al sistema','2018-04-05 23:08:05'),(66,1,'Ingreso al sistema','2018-04-05 23:24:01'),(67,1,'Ingreso al sistema','2018-04-05 23:28:14'),(68,1,'Ingreso al sistema','2018-04-05 23:35:23'),(69,1,'Ingreso al sistema','2018-04-05 23:49:47'),(70,1,'Ingreso al sistema','2018-04-05 23:55:54'),(71,1,'Ingreso al sistema','2018-04-06 00:04:34'),(72,1,'Ingreso al sistema','2018-04-06 00:11:37'),(73,1,'Ingreso al sistema','2018-04-06 00:13:50'),(74,1,'Ingreso al sistema','2018-04-06 00:16:32'),(75,1,'Ingreso al sistema','2018-04-06 00:19:20'),(76,1,'Ingreso al sistema','2018-04-06 00:23:06'),(77,1,'Ingreso al sistema','2018-04-06 00:29:56'),(78,1,'Ingreso al sistema','2018-04-06 00:36:10'),(79,1,'Ingreso al sistema','2018-04-06 00:40:04'),(80,1,'Ingreso al sistema','2018-04-06 01:05:12'),(81,1,'Ingreso al sistema','2018-04-06 06:53:09'),(82,1,'Ingreso al sistema','2018-04-06 07:20:20'),(83,1,'Ingreso al sistema','2018-04-06 07:26:51'),(84,1,'Ingreso al sistema','2018-04-06 07:39:59'),(85,1,'Ingreso al sistema','2018-04-06 13:22:13'),(86,1,'Usuario cerro session','2018-04-06 16:18:31'),(87,1,'Ingreso al sistema','2018-04-06 16:18:39'),(88,1,'Ingreso al sistema','2018-04-06 16:39:49'),(89,1,'Ingreso al sistema','2018-04-06 16:48:19'),(90,1,'Ingreso al sistema','2018-04-06 16:51:01'),(91,1,'Ingreso al sistema','2018-04-06 18:55:06'),(92,1,'Ingreso al sistema','2018-04-06 20:01:59'),(93,1,'Ingreso al sistema','2018-04-08 10:04:18'),(94,1,'Ingreso al sistema','2018-04-08 10:51:35'),(95,1,'Ingreso al sistema','2018-04-08 10:57:10'),(96,1,'Ingreso al sistema','2018-04-08 11:00:58'),(97,1,'Usuario cerro session','2018-04-08 11:01:42'),(98,1,'Ingreso al sistema','2018-04-08 11:06:13'),(99,1,'Ingreso al sistema','2018-04-08 12:34:49'),(100,1,'Ingreso al sistema','2018-04-08 12:47:09'),(101,1,'Ingreso al sistema','2018-04-08 12:52:42'),(102,1,'Ingreso al sistema','2018-04-08 13:29:01'),(103,1,'Ingreso al sistema','2018-04-08 16:51:46'),(104,1,'Ingreso al sistema','2018-04-08 17:17:44'),(105,1,'Ingreso al sistema','2018-04-08 17:24:02'),(106,1,'Usuario cerro session','2018-04-08 21:12:30'),(107,1,'Ingreso al sistema','2018-04-08 21:12:35'),(108,1,'Ingreso al sistema','2018-04-08 21:18:45'),(109,1,'Ingreso al sistema','2018-04-08 21:25:11'),(110,1,'Ingreso al sistema','2018-04-08 22:08:55'),(111,1,'Ingreso al sistema','2018-04-08 22:14:19'),(112,1,'Ingreso al sistema','2018-04-08 22:17:09'),(113,1,'Ingreso al sistema','2018-04-08 22:21:51'),(114,1,'Ingreso al sistema','2018-04-08 22:27:29'),(115,1,'Ingreso al sistema','2018-04-08 22:30:11'),(116,1,'Ingreso al sistema','2018-04-09 16:13:45'),(117,1,'Ingreso al sistema','2018-04-09 17:01:09'),(118,1,'Ingreso al sistema','2018-04-09 17:06:15'),(119,1,'Ingreso al sistema','2018-04-09 17:45:47'),(120,1,'Ingreso al sistema','2018-04-09 17:48:53'),(121,1,'Ingreso al sistema','2018-04-09 18:52:29'),(122,1,'Ingreso al sistema','2018-04-09 18:57:07'),(123,1,'Ingreso al sistema','2018-04-09 19:11:56'),(124,1,'Ingreso al sistema','2018-04-09 19:17:02'),(125,1,'Ingreso al sistema','2018-04-09 19:27:57'),(126,1,'Ingreso al sistema','2018-04-09 19:31:27'),(127,1,'Ingreso al sistema','2018-04-09 19:49:18'),(128,1,'Ingreso al sistema','2018-04-09 20:41:48'),(129,1,'Ingreso al sistema','2018-04-09 20:50:36'),(130,1,'Ingreso al sistema','2018-04-09 21:09:56'),(131,1,'Ingreso al sistema','2018-04-09 21:16:11'),(132,1,'Ingreso al sistema','2018-04-09 21:24:42'),(133,1,'Ingreso al sistema','2018-04-09 21:54:49'),(134,1,'Usuario cerro session','2018-04-09 21:59:53'),(135,1,'Ingreso al sistema','2018-04-09 22:00:01'),(136,1,'Ingreso al sistema','2018-04-09 22:03:45'),(137,1,'Usuario cerro session','2018-04-09 22:13:37'),(138,1,'Ingreso al sistema','2018-04-09 22:13:44'),(139,1,'Ingreso al sistema','2018-04-09 22:17:15'),(140,1,'Ingreso al sistema','2018-04-10 16:05:07'),(141,1,'Ingreso al sistema','2018-04-20 14:52:47'),(142,1,'Ingreso al sistema','2018-04-20 17:03:47'),(143,1,'Ingreso al sistema','2018-04-22 10:43:40'),(144,1,'Ingreso al sistema','2018-04-22 10:59:55'),(145,1,'Ingreso al sistema','2018-04-22 12:38:50'),(146,1,'Ingreso al sistema','2018-04-24 08:03:28'),(147,1,'Ingreso al sistema','2018-04-24 12:02:12'),(148,1,'Ingreso al sistema','2018-04-24 16:35:05'),(149,1,'Ingreso al sistema','2018-04-24 17:59:47'),(150,1,'Ingreso al sistema','2018-04-24 18:11:56'),(151,1,'Ingreso al sistema','2018-04-24 18:23:29'),(152,1,'Ingreso al sistema','2018-04-24 18:35:13'),(153,1,'Ingreso al sistema','2018-04-24 18:42:59'),(154,1,'Ingreso al sistema','2018-04-24 18:58:12'),(155,1,'Ingreso al sistema','2018-04-24 19:09:14'),(156,1,'Ingreso al sistema','2018-04-24 19:17:19'),(157,1,'Ingreso al sistema','2018-04-24 19:36:24'),(158,1,'Ingreso al sistema','2018-04-24 19:40:09'),(159,1,'Ingreso al sistema','2018-04-24 19:42:17'),(160,1,'Ingreso al sistema','2018-04-24 19:54:28'),(161,1,'Ingreso al sistema','2018-04-24 19:58:44'),(162,1,'Ingreso al sistema','2018-04-24 20:04:51'),(163,1,'Ingreso al sistema','2018-04-24 20:10:03'),(164,1,'Ingreso al sistema','2018-04-24 20:16:53'),(165,1,'Ingreso al sistema','2018-04-24 20:19:24'),(166,1,'Ingreso al sistema','2018-04-24 20:21:12'),(167,1,'Ingreso al sistema','2018-04-24 20:25:14'),(168,1,'Ingreso al sistema','2018-04-24 21:15:53'),(169,1,'Ingreso al sistema','2018-04-24 22:50:17'),(170,1,'Ingreso al sistema','2018-04-24 22:55:09'),(171,1,'Ingreso al sistema','2018-04-24 23:05:15'),(172,1,'Ingreso al sistema','2018-04-24 23:14:49'),(173,1,'Ingreso al sistema','2018-04-24 23:23:02'),(174,1,'Ingreso al sistema','2018-04-25 20:53:29'),(175,1,'Ingreso al sistema','2018-04-25 21:08:31'),(176,1,'Ingreso al sistema','2018-04-25 21:11:26'),(177,1,'Ingreso al sistema','2018-04-25 22:25:40'),(178,1,'Ingreso al sistema','2018-04-25 22:30:30'),(179,1,'Ingreso al sistema','2018-04-25 22:36:50'),(180,1,'Ingreso al sistema','2018-04-25 22:39:54'),(181,1,'Ingreso al sistema','2018-04-25 22:45:43'),(182,1,'Ingreso al sistema','2018-04-25 23:02:26'),(183,1,'Ingreso al sistema','2018-04-25 23:23:03'),(184,1,'Ingreso al sistema','2018-04-25 23:30:42'),(185,1,'Ingreso al sistema','2018-04-26 07:40:55'),(186,1,'Ingreso al sistema','2018-04-26 07:55:44'),(187,1,'Ingreso al sistema','2018-04-26 07:59:15'),(188,1,'Ingreso al sistema','2018-04-26 08:05:34'),(189,1,'Ingreso al sistema','2018-04-26 08:07:35'),(190,1,'Ingreso al sistema','2018-04-26 13:33:21'),(191,1,'Ingreso al sistema','2018-04-26 13:36:42'),(192,1,'Ingreso al sistema','2018-04-26 13:40:49'),(193,1,'Ingreso al sistema','2018-04-26 13:47:16'),(194,1,'Ingreso al sistema','2018-04-26 15:59:24'),(195,1,'Ingreso al sistema','2018-04-26 16:03:45'),(196,1,'Ingreso al sistema','2018-04-26 17:05:13'),(197,1,'Ingreso al sistema','2018-04-26 17:58:34'),(198,1,'Ingreso al sistema','2018-04-26 18:10:39'),(199,1,'Ingreso al sistema','2018-04-26 18:15:49'),(200,1,'Ingreso al sistema','2018-04-26 18:26:47'),(201,1,'Ingreso al sistema','2018-04-26 18:41:19'),(202,1,'Ingreso al sistema','2018-04-26 18:45:43'),(203,1,'Ingreso al sistema','2018-04-26 20:27:46'),(204,1,'Ingreso al sistema','2018-04-26 20:41:57'),(205,1,'Ingreso al sistema','2018-04-26 20:46:31'),(206,1,'Ingreso al sistema','2018-04-26 20:49:28'),(207,1,'Ingreso al sistema','2018-04-26 21:11:07'),(208,1,'Ingreso al sistema','2018-04-26 21:22:33'),(209,1,'Ingreso al sistema','2018-04-26 22:38:53'),(210,1,'Ingreso al sistema','2018-04-27 10:43:57'),(211,1,'Ingreso al sistema','2018-05-07 14:43:20'),(212,1,'Usuario cerro session','2018-05-07 14:44:54'),(213,1,'Ingreso al sistema','2018-05-07 14:44:59'),(214,1,'Se actualiza los datos sin contraseña Usuario','2018-05-07 15:31:20'),(215,1,'Se actualiza los datos sin contraseña Usuario','2018-05-07 15:31:38'),(216,1,'Se actualiza los datos sin contraseña Usuario','2018-05-07 15:31:44'),(217,1,'Ingreso al sistema','2018-05-22 20:03:17'),(218,1,'Ingreso al sistema','2018-05-22 22:49:41'),(219,1,'Ingreso al sistema','2018-05-22 22:58:43'),(220,1,'Ingreso al sistema','2018-05-22 23:05:47'),(221,1,'Ingreso al sistema','2018-05-22 23:10:19'),(222,1,'Ingreso al sistema','2018-05-22 23:13:23'),(223,1,'Ingreso al sistema','2018-05-22 23:20:11'),(224,1,'Ingreso al sistema','2018-05-22 23:24:53'),(225,1,'Ingreso al sistema','2018-05-22 23:29:45'),(226,1,'Ingreso al sistema','2018-05-23 10:44:21'),(227,1,'Ingreso al sistema','2018-05-23 11:02:54'),(228,1,'Ingreso al sistema','2018-05-23 11:12:53'),(229,1,'Ingreso al sistema','2018-05-23 11:18:04'),(230,1,'Ingreso al sistema','2018-05-23 11:26:09'),(231,1,'Ingreso al sistema','2018-05-23 11:50:01'),(232,1,'Ingreso al sistema','2018-05-23 11:59:45'),(233,1,'Ingreso al sistema','2018-05-23 12:06:52'),(234,1,'Ingreso al sistema','2018-05-23 12:12:44'),(235,1,'Ingreso al sistema','2018-05-23 12:21:11'),(236,1,'Ingreso al sistema','2018-05-23 12:39:58'),(237,1,'Ingreso al sistema','2018-05-23 12:44:18'),(238,1,'Ingreso al sistema','2018-05-23 12:49:47'),(239,1,'Ingreso al sistema','2018-05-23 12:52:30'),(240,1,'Ingreso al sistema','2018-05-23 13:11:28'),(241,1,'Ingreso al sistema','2018-05-23 13:26:46'),(242,1,'Ingreso al sistema','2018-05-23 13:36:27'),(243,1,'Ingreso al sistema','2018-05-23 13:46:51'),(244,1,'Ingreso al sistema','2018-05-23 13:50:03'),(245,1,'Ingreso al sistema','2018-05-23 13:55:49'),(246,1,'Ingreso al sistema','2018-05-23 15:34:34'),(247,1,'Ingreso al sistema','2018-05-23 15:38:09'),(248,1,'Ingreso al sistema','2018-05-23 16:16:26'),(249,1,'Ingreso al sistema','2018-05-23 16:21:52'),(250,1,'Ingreso al sistema','2018-05-23 16:29:52'),(251,1,'Ingreso al sistema','2018-05-23 16:35:30'),(252,1,'Ingreso al sistema','2018-05-23 16:39:18'),(253,1,'Ingreso al sistema','2018-05-23 16:43:29'),(254,1,'Ingreso al sistema','2018-06-04 12:56:07'),(255,1,'Ingreso al sistema','2018-06-04 14:08:04'),(256,1,'Ingreso al sistema','2018-06-04 18:38:27'),(257,1,'Ingreso al sistema','2018-06-04 19:59:04'),(258,1,'Ingreso al sistema','2018-06-05 07:33:59'),(259,1,'Ingreso al sistema','2018-06-05 07:33:59'),(260,1,'Usuario cerro session','2018-06-05 07:33:59'),(261,1,'Ingreso al sistema','2018-06-05 07:34:06'),(262,1,'Ingreso al sistema','2018-06-05 08:47:08'),(263,1,'Ingreso al sistema','2018-06-05 11:11:07'),(264,1,'Ingreso al sistema','2018-06-05 11:12:40'),(265,1,'Ingreso al sistema','2018-06-05 14:00:29'),(266,1,'Ingreso al sistema','2018-06-05 14:03:36'),(267,1,'Ingreso al sistema','2018-06-05 14:05:45'),(268,1,'Ingreso al sistema','2018-06-05 18:51:44'),(269,1,'Ingreso al sistema','2018-06-05 18:53:53'),(270,1,'Ingreso al sistema','2018-06-05 18:56:03'),(271,1,'Ingreso al sistema','2018-06-05 19:37:48'),(272,1,'Usuario cerro session','2018-06-05 19:38:25'),(273,1,'Ingreso al sistema','2018-06-05 19:50:38'),(274,1,'Ingreso al sistema','2018-06-05 22:14:38'),(275,1,'Usuario cerro session','2018-06-05 22:14:46'),(276,1,'Ingreso al sistema','2018-06-05 22:14:59'),(277,1,'Se actualiza los datos sin contraseña Usuario','2018-06-05 22:24:00'),(278,1,'Usuario cerro session','2018-06-05 22:27:46'),(279,1,'Ingreso al sistema','2018-06-05 22:27:55'),(280,1,'Ingreso al sistema','2018-06-05 23:02:55'),(281,1,'Ingreso al sistema','2018-06-06 09:13:27'),(282,1,'Usuario cerro session','2018-06-06 09:13:40'),(283,1,'Ingreso al sistema','2018-06-06 09:13:47'),(284,1,'Ingreso al sistema','2018-06-06 09:32:15'),(285,1,'Ingreso al sistema','2018-06-06 09:37:32'),(286,1,'Ingreso al sistema','2018-06-06 10:02:02'),(287,1,'Ingreso al sistema','2018-06-06 10:08:13'),(288,1,'Ingreso al sistema','2018-06-06 10:11:07'),(289,1,'Ingreso al sistema','2018-06-06 11:10:11'),(290,1,'Ingreso al sistema','2018-06-06 12:01:34'),(291,1,'Ingreso al sistema','2018-06-06 12:33:42'),(292,1,'Ingreso al sistema','2018-06-06 12:38:53'),(293,1,'Ingreso al sistema','2018-06-06 14:03:32'),(294,1,'Ingreso al sistema','2018-06-06 14:13:52'),(295,1,'Ingreso al sistema','2018-06-06 14:53:23'),(296,1,'Ingreso al sistema','2018-06-06 16:36:05'),(297,1,'Ingreso al sistema','2018-06-06 22:06:37'),(298,1,'Ingreso al sistema','2018-06-06 22:12:16'),(299,1,'Ingreso al sistema','2018-06-06 22:19:04'),(300,1,'Ingreso al sistema','2018-06-06 22:23:18'),(301,1,'Ingreso al sistema','2018-06-06 22:42:32'),(302,1,'Ingreso al sistema','2018-06-06 22:46:02'),(303,1,'Ingreso al sistema','2018-06-06 22:51:03'),(304,1,'Ingreso al sistema','2018-06-06 22:57:33'),(305,1,'Ingreso al sistema','2018-06-06 23:08:00'),(306,1,'Ingreso al sistema','2018-06-06 23:10:58'),(307,1,'Ingreso al sistema','2018-06-06 23:14:57'),(308,1,'Ingreso al sistema','2018-06-06 23:21:13'),(309,1,'Ingreso al sistema','2018-06-06 23:30:18'),(310,1,'Ingreso al sistema','2018-06-07 08:52:52'),(311,1,'Ingreso al sistema','2018-06-07 09:11:09'),(312,1,'Ingreso al sistema','2018-06-07 15:48:37'),(313,1,'Ingreso al sistema','2018-06-07 16:43:01'),(314,1,'Ingreso al sistema','2018-06-07 17:45:34'),(315,1,'Ingreso al sistema','2018-06-07 17:56:12'),(316,1,'Ingreso al sistema','2018-06-07 18:00:39'),(317,1,'Ingreso al sistema','2018-06-07 19:01:20'),(318,1,'Ingreso al sistema','2018-06-07 19:04:13'),(319,1,'Ingreso al sistema','2018-06-07 19:16:06'),(320,1,'Ingreso al sistema','2018-06-07 19:22:33'),(321,1,'Ingreso al sistema','2018-06-07 19:25:00'),(322,1,'Se actualiza los datos sin contraseña Usuario','2018-06-07 19:25:21'),(323,1,'Ingreso al sistema','2018-06-07 19:45:33'),(324,1,'Ingreso al sistema','2018-06-07 19:48:30'),(325,1,'Ingreso al sistema','2018-06-07 20:49:24'),(326,1,'Ingreso al sistema','2018-06-07 21:12:25'),(327,1,'Ingreso al sistema','2018-06-07 23:39:32'),(328,1,'Ingreso al sistema','2018-06-07 23:43:20'),(329,1,'Ingreso al sistema','2018-06-07 23:51:05'),(330,1,'Ingreso al sistema','2018-06-07 23:54:44'),(331,1,'Ingreso al sistema','2018-06-08 00:01:36'),(332,1,'Ingreso al sistema','2018-06-08 00:09:26'),(333,1,'Ingreso al sistema','2018-06-08 00:13:02'),(334,1,'Ingreso al sistema','2018-06-08 00:14:35'),(335,1,'Usuario cerro session','2018-06-08 00:28:53'),(336,8,'Ingreso al sistema','2018-06-08 00:29:50'),(337,1,'Ingreso al sistema','2018-06-08 08:39:08'),(338,1,'Ingreso al sistema','2018-06-08 09:24:27'),(339,1,'Ingreso al sistema','2018-06-08 09:42:00'),(340,1,'Ingreso al sistema','2018-06-08 09:46:33'),(341,1,'Ingreso al sistema','2018-06-08 11:47:39'),(342,1,'Ingreso al sistema','2018-06-08 11:59:46'),(343,1,'Ingreso al sistema','2018-06-08 12:05:08'),(344,1,'Ingreso al sistema','2018-06-08 12:25:32'),(345,1,'Ingreso al sistema','2018-06-08 12:32:13'),(346,1,'Ingreso al sistema','2018-06-08 12:51:42'),(347,1,'Ingreso al sistema','2018-06-08 12:56:30'),(348,1,'Ingreso al sistema','2018-06-08 13:02:48'),(349,1,'Ingreso al sistema','2018-06-08 13:08:48'),(350,1,'Ingreso al sistema','2018-06-08 13:33:11'),(351,1,'Ingreso al sistema','2018-06-08 13:40:18'),(352,1,'Ingreso al sistema','2018-06-08 13:46:49'),(353,1,'Ingreso al sistema','2018-06-08 14:06:41'),(354,1,'Ingreso al sistema','2018-06-08 14:21:48'),(355,1,'Ingreso al sistema','2018-06-08 15:16:47'),(356,1,'Ingreso al sistema','2018-06-08 16:56:18'),(357,1,'Ingreso al sistema','2018-06-08 17:02:49'),(358,1,'Ingreso al sistema','2018-06-08 17:21:19'),(359,1,'Ingreso al sistema','2018-06-08 17:41:48'),(360,1,'Usuario cerro session','2018-06-08 17:44:45'),(361,1,'Ingreso al sistema','2018-06-08 17:44:51'),(362,1,'Ingreso al sistema','2018-06-08 20:39:31'),(363,1,'Ingreso al sistema','2018-06-08 20:51:02'),(364,1,'Ingreso al sistema','2018-06-08 20:53:17'),(365,1,'Ingreso al sistema','2018-06-08 20:57:39'),(366,1,'Ingreso al sistema','2018-06-08 21:00:32'),(367,1,'Ingreso al sistema','2018-06-08 21:02:48'),(368,1,'Ingreso al sistema','2018-06-08 21:05:49'),(369,1,'Ingreso al sistema','2018-06-08 21:14:00'),(370,1,'Ingreso al sistema','2018-06-08 21:19:05'),(371,1,'Ingreso al sistema','2018-06-08 21:22:34'),(372,1,'Ingreso al sistema','2018-06-08 21:30:34'),(373,1,'Ingreso al sistema','2018-06-08 21:32:51'),(374,1,'Ingreso al sistema','2018-06-08 21:52:33'),(375,1,'Ingreso al sistema','2018-06-08 22:17:48'),(376,1,'Ingreso al sistema','2018-06-08 22:23:06'),(377,1,'Ingreso al sistema','2018-06-08 22:40:09'),(378,1,'Ingreso al sistema','2018-06-08 23:29:40'),(379,1,'Ingreso al sistema','2018-06-08 23:38:05'),(380,1,'Ingreso al sistema','2018-06-08 23:46:56'),(381,1,'Ingreso al sistema','2018-06-09 06:31:56'),(382,1,'Ingreso al sistema','2018-06-09 06:43:23'),(383,1,'Ingreso al sistema','2018-06-09 06:51:53'),(384,1,'Ingreso al sistema','2018-06-09 07:54:43'),(385,1,'Ingreso al sistema','2018-06-09 08:17:12'),(386,1,'Ingreso al sistema','2018-06-09 08:19:22'),(387,1,'Ingreso al sistema','2018-06-09 08:29:00'),(388,1,'Ingreso al sistema','2018-06-09 08:33:06'),(389,1,'Ingreso al sistema','2018-06-09 08:37:21'),(390,1,'Ingreso al sistema','2018-06-09 08:43:50'),(391,1,'Ingreso al sistema','2018-06-09 11:02:10'),(392,1,'Usuario cerro session','2018-06-09 11:10:27'),(393,8,'Ingreso al sistema','2018-06-09 11:10:43'),(394,8,'Usuario cerro session','2018-06-09 11:11:10'),(395,1,'Ingreso al sistema','2018-06-09 11:12:37'),(396,1,'Usuario cerro session','2018-06-09 11:55:30'),(397,1,'Ingreso al sistema','2018-06-09 11:55:36'),(398,1,'Ingreso al sistema','2018-06-10 12:10:45'),(399,1,'Ingreso al sistema','2018-06-11 17:48:11'),(400,1,'Ingreso al sistema','2018-06-11 20:58:36'),(401,1,'Ingreso al sistema','2018-06-11 21:06:58'),(402,1,'Ingreso al sistema','2018-06-11 21:09:58'),(403,1,'Ingreso al sistema','2018-06-11 21:16:31'),(404,1,'Ingreso al sistema','2018-06-15 14:07:33'),(405,1,'Ingreso al sistema','2018-06-15 15:44:04'),(406,1,'Ingreso al sistema','2018-06-15 22:02:21'),(407,1,'Ingreso al sistema','2018-06-15 22:34:52'),(408,1,'Ingreso al sistema','2018-06-15 22:51:03'),(409,1,'Ingreso al sistema','2018-06-15 22:56:09'),(410,1,'Ingreso al sistema','2018-06-15 23:02:46'),(411,1,'Ingreso al sistema','2018-06-15 23:09:43'),(412,1,'Ingreso al sistema','2018-06-15 23:24:42'),(413,1,'Ingreso al sistema','2018-06-16 07:37:39'),(414,1,'Ingreso al sistema','2018-06-16 09:21:16'),(415,1,'Ingreso al sistema','2018-06-16 09:34:45'),(416,1,'Ingreso al sistema','2018-06-16 09:38:01'),(417,1,'Ingreso al sistema','2018-06-16 09:40:43'),(418,1,'Ingreso al sistema','2018-06-16 10:27:10'),(419,1,'Ingreso al sistema','2018-06-16 15:17:15'),(420,1,'Ingreso al sistema','2018-06-16 15:23:47'),(421,1,'Ingreso al sistema','2018-06-16 21:42:27'),(422,1,'Ingreso al sistema','2018-06-17 12:35:42'),(423,1,'Ingreso al sistema','2018-06-17 18:25:25'),(424,1,'Usuario cerro session','2018-06-17 19:24:05'),(425,1,'Ingreso al sistema','2018-06-17 19:37:02'),(426,1,'Ingreso al sistema','2018-06-17 20:22:47'),(427,1,'Ingreso al sistema','2018-06-17 20:29:08'),(428,1,'Ingreso al sistema','2018-06-17 20:57:03'),(429,1,'Ingreso al sistema','2018-06-17 22:54:29'),(430,1,'Ingreso al sistema','2018-06-17 23:03:42'),(431,1,'Ingreso al sistema','2018-06-17 23:08:49'),(432,1,'Ingreso al sistema','2018-06-17 23:13:07'),(433,1,'Ingreso al sistema','2018-06-17 23:20:26'),(434,1,'Ingreso al sistema','2018-06-17 23:27:14'),(435,1,'Ingreso al sistema','2018-06-17 23:31:32'),(436,1,'Ingreso al sistema','2018-06-17 23:35:07'),(437,1,'Ingreso al sistema','2018-06-17 23:39:14'),(438,1,'Ingreso al sistema','2018-06-17 23:43:50'),(439,1,'Ingreso al sistema','2018-06-17 23:46:29'),(440,1,'Ingreso al sistema','2018-06-17 23:55:11'),(441,1,'Ingreso al sistema','2018-06-18 00:09:54'),(442,1,'Ingreso al sistema','2018-06-18 00:30:39'),(443,1,'Usuario cerro session','2018-06-18 00:36:47'),(444,1,'Ingreso al sistema','2018-06-18 00:36:58'),(445,1,'Ingreso al sistema','2018-06-18 00:46:28'),(446,1,'Ingreso al sistema','2018-06-18 00:50:56'),(447,1,'Ingreso al sistema','2018-06-18 00:57:53'),(448,1,'Ingreso al sistema','2018-06-18 08:42:26'),(449,1,'Ingreso al sistema','2018-06-19 19:34:59'),(450,1,'Usuario cerro session','2018-06-19 19:36:34'),(451,1,'Ingreso al sistema','2018-06-19 19:36:48'),(452,1,'Ingreso al sistema','2018-06-19 21:16:32'),(453,1,'Ingreso al sistema','2018-06-19 22:08:10'),(454,1,'Ingreso al sistema','2018-06-19 22:24:55'),(455,1,'Ingreso al sistema','2018-06-19 22:30:11'),(456,1,'Ingreso al sistema','2018-06-19 22:34:03'),(457,1,'Ingreso al sistema','2018-06-19 22:38:29'),(458,1,'Ingreso al sistema','2018-06-19 22:45:18'),(459,1,'Ingreso al sistema','2018-06-19 23:03:17'),(460,1,'Ingreso al sistema','2018-06-19 23:13:48'),(461,1,'Ingreso al sistema','2018-06-19 23:58:57'),(462,1,'Ingreso al sistema','2018-06-21 13:21:51'),(463,1,'Ingreso al sistema','2018-06-27 21:04:01'),(464,1,'Ingreso al sistema','2018-06-27 22:32:31'),(465,1,'Ingreso al sistema','2018-06-27 22:36:57'),(466,1,'Ingreso al sistema','2018-06-27 22:41:36'),(467,1,'Ingreso al sistema','2018-06-27 22:59:46'),(468,1,'Ingreso al sistema','2018-06-28 22:37:12'),(469,1,'Ingreso al sistema','2018-06-28 22:43:20'),(470,1,'Ingreso al sistema','2018-06-28 23:00:15'),(471,1,'Ingreso al sistema','2018-06-28 23:05:28'),(472,1,'Ingreso al sistema','2018-06-28 23:12:56'),(473,1,'Ingreso al sistema','2018-06-28 23:22:49'),(474,1,'Ingreso al sistema','2018-07-31 06:55:02'),(475,1,'Ingreso al sistema','2018-07-31 07:26:16'),(476,1,'Ingreso al sistema','2018-07-31 07:33:14'),(477,1,'Ingreso al sistema','2018-07-31 07:37:43'),(478,1,'Ingreso al sistema','2018-07-31 07:41:51'),(479,1,'Ingreso al sistema','2018-07-31 07:53:45'),(480,1,'Ingreso al sistema','2018-07-31 07:59:54'),(481,1,'Ingreso al sistema','2018-07-31 19:23:24'),(482,1,'Ingreso al sistema','2018-07-31 19:23:29'),(483,1,'Usuario cerro session','2018-07-31 19:23:29'),(484,1,'Ingreso al sistema','2018-07-31 19:25:53'),(485,1,'Ingreso al sistema','2018-07-31 19:42:53'),(486,1,'Ingreso al sistema','2018-07-31 20:35:17'),(487,1,'Ingreso al sistema','2018-07-31 20:47:30'),(488,1,'Ingreso al sistema','2018-07-31 21:09:08'),(489,1,'Ingreso al sistema','2018-07-31 21:43:17'),(490,1,'Ingreso al sistema','2018-07-31 22:02:55'),(491,1,'Ingreso al sistema','2018-07-31 22:05:10'),(492,1,'Ingreso al sistema','2018-07-31 22:07:43'),(493,1,'Ingreso al sistema','2018-07-31 22:11:17'),(494,1,'Ingreso al sistema','2018-07-31 22:15:04'),(495,1,'Ingreso al sistema','2018-07-31 22:22:22'),(496,1,'Ingreso al sistema','2018-07-31 22:26:50'),(497,1,'Ingreso al sistema','2018-07-31 22:42:49'),(498,1,'Ingreso al sistema','2018-08-02 07:41:37'),(499,1,'Ingreso al sistema','2018-08-02 08:10:13'),(500,1,'Ingreso al sistema','2018-08-02 08:28:42'),(501,1,'Ingreso al sistema','2018-08-02 08:43:52'),(502,1,'Ingreso al sistema','2018-08-02 11:24:04'),(503,1,'Ingreso al sistema','2018-08-02 13:54:06'),(504,1,'Ingreso al sistema','2018-08-02 22:09:28'),(505,1,'Ingreso al sistema','2018-08-02 22:16:36'),(506,1,'Ingreso al sistema','2018-08-03 05:04:17'),(507,1,'Usuario cerro session','2018-08-03 05:48:30'),(508,1,'Ingreso al sistema','2018-08-03 05:51:41'),(509,1,'Ingreso al sistema','2018-08-03 17:32:58'),(510,1,'Ingreso al sistema','2018-08-04 10:05:03'),(511,1,'Usuario cerro session','2018-08-04 10:32:07'),(512,1,'Ingreso al sistema','2018-08-04 10:32:17'),(513,1,'Usuario cerro session','2018-08-04 10:32:30'),(514,1,'Ingreso al sistema','2018-08-04 10:32:43'),(515,1,'Ingreso al sistema','2018-08-04 11:10:14'),(516,1,'Ingreso al sistema','2018-08-06 16:04:08'),(517,1,'Ingreso al sistema','2018-08-08 12:29:02'),(518,1,'Ingreso al sistema','2018-08-08 15:57:16'),(519,1,'Ingreso al sistema','2018-08-09 15:44:10'),(520,1,'Ingreso al sistema','2018-08-10 10:41:23'),(521,1,'Ingreso al sistema','2018-08-13 11:01:42'),(522,1,'Ingreso al sistema','2018-08-13 16:02:00'),(523,1,'Ingreso al sistema','2018-08-14 11:22:57'),(524,1,'Ingreso al sistema','2018-08-14 12:00:30'),(525,1,'Ingreso al sistema','2018-08-14 12:08:01'),(526,1,'Ingreso al sistema','2018-08-14 13:35:23'),(527,1,'Ingreso al sistema','2018-08-14 14:51:43'),(528,1,'Ingreso al sistema','2018-08-15 15:54:07'),(529,1,'Ingreso al sistema','2018-08-15 15:59:02'),(530,1,'Ingreso al sistema','2018-08-15 16:22:27'),(531,1,'Ingreso al sistema','2018-08-15 16:35:01'),(532,1,'Ingreso al sistema','2018-08-16 09:36:07'),(533,1,'Ingreso al sistema','2018-08-16 11:38:02'),(534,1,'Ingreso al sistema','2018-08-22 11:16:21'),(535,1,'Ingreso al sistema','2018-08-22 11:54:35'),(536,1,'Ingreso al sistema','2018-08-22 13:44:19'),(537,1,'Ingreso al sistema','2018-08-23 10:25:03'),(538,1,'Ingreso al sistema','2018-08-23 10:43:47'),(539,1,'Ingreso al sistema','2018-08-24 11:13:47'),(540,1,'Ingreso al sistema','2018-08-24 14:31:28'),(541,1,'Ingreso al sistema','2018-08-27 10:09:13'),(542,1,'Ingreso al sistema','2018-08-27 12:13:13'),(543,1,'Ingreso al sistema','2018-08-27 13:02:09'),(544,1,'Ingreso al sistema','2018-08-29 09:05:00'),(545,1,'Ingreso al sistema','2018-08-29 09:05:01'),(546,1,'Usuario cerro session','2018-08-29 09:05:01'),(547,1,'Ingreso al sistema','2018-08-29 09:11:19'),(548,1,'Ingreso al sistema','2018-08-30 12:26:14'),(549,1,'Ingreso al sistema','2018-08-30 12:31:20'),(550,1,'Ingreso al sistema','2018-08-30 16:27:29'),(551,1,'Ingreso al sistema','2018-09-22 10:42:18'),(552,1,'Ingreso al sistema','2018-09-26 09:39:48'),(553,1,'Ingreso al sistema','2018-09-26 11:14:25'),(554,1,'Ingreso al sistema','2018-09-27 10:10:53'),(555,1,'Ingreso al sistema','2018-09-27 12:21:32'),(556,1,'Ingreso al sistema','2018-09-28 12:27:18'),(557,1,'Ingreso al sistema','2018-09-28 17:27:12'),(558,1,'Ingreso al sistema','2018-10-02 12:16:13'),(559,1,'Ingreso al sistema','2018-10-02 17:29:29'),(560,1,'Ingreso al sistema','2018-10-03 14:15:49'),(561,1,'Ingreso al sistema','2018-10-03 15:15:46'),(562,1,'Ingreso al sistema','2018-10-04 11:11:15'),(563,1,'Ingreso al sistema','2018-10-04 14:15:45'),(564,1,'Ingreso al sistema','2018-10-05 11:16:32'),(565,1,'Ingreso al sistema','2018-10-05 17:48:45'),(566,1,'Ingreso al sistema','2018-10-06 11:08:03'),(567,1,'Ingreso al sistema','2018-10-08 16:41:25'),(568,1,'Ingreso al sistema','2018-10-09 09:59:23'),(569,1,'Ingreso al sistema','2018-10-09 13:02:32'),(570,1,'Ingreso al sistema','2018-10-10 09:30:43'),(571,1,'Ingreso al sistema','2018-10-11 11:40:42'),(572,1,'Ingreso al sistema','2018-10-11 11:43:10'),(573,1,'Ingreso al sistema','2018-10-13 12:21:12'),(574,1,'Ingreso al sistema','2018-10-16 16:57:03'),(575,1,'Ingreso al sistema','2018-10-18 15:10:23'),(576,1,'Ingreso al sistema','2018-10-19 10:16:23'),(577,1,'Ingreso al sistema','2018-10-19 13:17:42'),(578,1,'Ingreso al sistema','2018-10-20 12:00:39'),(579,1,'Ingreso al sistema','2018-10-22 12:41:17'),(580,1,'Ingreso al sistema','2018-10-22 14:16:16'),(581,1,'Ingreso al sistema','2018-10-26 15:40:35'),(582,1,'Ingreso al sistema','2018-10-26 16:36:49'),(583,1,'Ingreso al sistema','2018-10-30 11:48:24'),(584,1,'Ingreso al sistema','2018-10-31 10:05:04'),(585,1,'Ingreso al sistema','2018-11-02 09:48:24'),(586,1,'Ingreso al sistema','2018-11-02 16:44:34'),(587,1,'Ingreso al sistema','2018-11-03 10:47:39'),(588,1,'Ingreso al sistema','2018-11-03 14:44:55');
/*!40000 ALTER TABLE `iubitacora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iucolores`
--

DROP TABLE IF EXISTS `iucolores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iucolores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Color` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iucolores`
--

LOCK TABLES `iucolores` WRITE;
/*!40000 ALTER TABLE `iucolores` DISABLE KEYS */;
INSERT INTO `iucolores` VALUES (1,'ROJO'),(2,'BLANCO'),(3,'UVA'),(4,'MOSTAZA'),(5,'KAKY'),(6,'AZULOSCURO'),(7,'NEGRO'),(8,'GRISOSCURO'),(9,'ARENA'),(10,'VINO TINTO'),(11,'PALODEROSA'),(12,'VERDEANTIO'),(13,'AMARILLO'),(14,'AZUL REY'),(15,'MOSTAZA');
/*!40000 ALTER TABLE `iucolores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iuconfig`
--

DROP TABLE IF EXISTS `iuconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iuconfig` (
  `id` int(11) NOT NULL,
  `tipo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nameform` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nametitle` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `numColum` int(11) DEFAULT NULL,
  `icon` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `activo` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iuconfig`
--

LOCK TABLES `iuconfig` WRITE;
/*!40000 ALTER TABLE `iuconfig` DISABLE KEYS */;
INSERT INTO `iuconfig` VALUES (1,'SMTP','formSmtp','SMTP',4,'email',1),(2,'WSDL','formWsdl','Configuración de WSDL',2,'adjust',0),(3,'PAGINA','formPagina','diseño página',2,'palette',1),(4,'Almacenamiento','formAlmacena','Path almacenamiento',2,'work',1),(5,'FACTURACION','formFacturacion','Facturación',2,'timelapse',1);
/*!40000 ALTER TABLE `iuconfig` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iuconfigform`
--

DROP TABLE IF EXISTS `iuconfigform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iuconfigform` (
  `id` int(11) NOT NULL,
  `labelNombre` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nameId` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `parameterValor` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `valor` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `maximoValue` int(11) DEFAULT NULL,
  `requerido` tinyint(4) DEFAULT NULL,
  `messageError` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tipo` int(11) NOT NULL,
  `tipoCampo` int(11) NOT NULL,
  `mascara` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_iuconfigform_uiconfig1_idx` (`tipo`),
  KEY `fk_iuconfigform_iuconfigtipocampo1_idx` (`tipoCampo`),
  CONSTRAINT `fk_iuconfigform_iuconfigtipocampo1` FOREIGN KEY (`tipoCampo`) REFERENCES `iuconfigtipocampo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iuconfigform_uiconfig1` FOREIGN KEY (`tipo`) REFERENCES `iuconfig` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iuconfigform`
--

LOCK TABLES `iuconfigform` WRITE;
/*!40000 ALTER TABLE `iuconfigform` DISABLE KEYS */;
INSERT INTO `iuconfigform` VALUES (0,'Titulo','idTitulo','TITULO','ALMACEN',100,0,'Ingrese un titulo de la pagina',3,1,NULL),(1,'Email Usuario','idUsuario','EMAILUSUARIO','ipialeswsdl@gmail.com',200,0,'Ingrese el valor de Usuario',1,1,NULL),(2,'Email Password','idPassword','EMAILPASSWORD','admin6210*',50,0,'Ingrese el valor en passwrod ',1,1,NULL),(3,'Host','idHost','HOST','smtp.gmail.com',200,0,'Ingrese el valor en el host',1,1,NULL),(4,'Para','idFrom','FROM','wsdl@vid.org.co',200,0,'Ingrese el valor en from',1,1,NULL),(5,'Puerto','idPuerto','PORT','25',5,0,'Ingrese el valor en port',1,2,'9?9999'),(6,'Copia a','idCopyTo','COPYTO','juligrva@hotmail.com;jaramillo71@hotmail.com',1000,1,'',1,1,NULL),(7,'destinatarios','iddestinatarios','Destinatarios','juligrva@hotmail.com',200,0,'Ingrese el valor en socket',1,1,NULL),(11,'logo','idLogo','logoLogin','images/logo.png',1000,0,'Ingrese el valor en logo',3,1,NULL),(12,'favIcon','idFavIcon','FavIcon','http://www.sanjosedelguaviare-guaviare.gov.co/favicon.ico',1000,0,'Ingrese el valor en favIcon',3,1,NULL),(13,'Fondo','idFondo','FONDO','images/login/imagen-noche-medellin.jpg',1000,0,'Ingrese un fondo de la pagina',3,1,NULL),(14,'Asunto','idAsunto','ASUNTO','Ingreso de establecimientos',1000,0,'Ingrese un valor en asunto',1,1,NULL),(15,'Ruta Almacenamiento','idPath','PATH','C:\\ROLAPS\\IMAGE',1000,0,'Ingrese un valor en el path',4,1,NULL),(18,'Copia Entidades','idCopyToEntidad','COPYENTIDAD','juligrva@hotmail.com',4000,1,'Ingrese un valor en copia a enteidades',1,1,''),(19,'logo','idLogoSlider','logoSlider','images/logo.png',1000,0,'Ingrese el valor en logo',3,1,NULL),(20,'logo','idLogoFooter','logoFooter','images/logo.png',1000,0,'Ingrese el valor en logo',3,1,NULL),(21,'Iva','idIva','IVA','19',2,0,'Ingrese el valor en Iva',5,1,NULL),(22,'Formato Número','idFormat','NUMBERFORMAT','###,###',100,1,'Ingrese un valor en el formato de número',5,1,NULL);
/*!40000 ALTER TABLE `iuconfigform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iuconfigtipocampo`
--

DROP TABLE IF EXISTS `iuconfigtipocampo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iuconfigtipocampo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipoCampo` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iuconfigtipocampo`
--

LOCK TABLES `iuconfigtipocampo` WRITE;
/*!40000 ALTER TABLE `iuconfigtipocampo` DISABLE KEYS */;
INSERT INTO `iuconfigtipocampo` VALUES (1,'String'),(2,'Integer'),(3,'Boolean');
/*!40000 ALTER TABLE `iuconfigtipocampo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iudevoluciontipo`
--

DROP TABLE IF EXISTS `iudevoluciontipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iudevoluciontipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `devolucion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iudevoluciontipo`
--

LOCK TABLES `iudevoluciontipo` WRITE;
/*!40000 ALTER TABLE `iudevoluciontipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `iudevoluciontipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iufactura`
--

DROP TABLE IF EXISTS `iufactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iufactura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fechaFactura` datetime DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `consecutivo` varchar(10) DEFAULT NULL,
  `iva` double DEFAULT NULL,
  `bruto` double DEFAULT NULL,
  `descuento` double DEFAULT NULL,
  `vaIva` double DEFAULT NULL,
  `neto` double DEFAULT NULL,
  `observacion` varchar(1000) DEFAULT NULL,
  `idfacturatipo` int(11) NOT NULL,
  `idfacturaEstado` int(11) NOT NULL,
  `iditercero` int(11) NOT NULL,
  `idresolucion` int(11) NOT NULL,
  `idformaPago` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_iufactura_iufacturatipo1_idx` (`idfacturatipo`),
  KEY `fk_iufactura_iufacturaEstado1_idx` (`idfacturaEstado`),
  KEY `fk_iufactura_uitercero1_idx` (`iditercero`),
  KEY `fk_iufactura_maresolucion1_idx` (`idresolucion`),
  KEY `fk_iufactura_uiformaPago1_idx` (`idformaPago`),
  KEY `fk_iufactura_usuario_idx` (`idUsuario`),
  CONSTRAINT `fk_iufactura_iufacturaEstado1` FOREIGN KEY (`idfacturaEstado`) REFERENCES `iufacturaestado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iufactura_iufacturatipo1` FOREIGN KEY (`idfacturatipo`) REFERENCES `iufacturatipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iufactura_maresolucion1` FOREIGN KEY (`idresolucion`) REFERENCES `mapatameter` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iufactura_uiformaPago1` FOREIGN KEY (`idformaPago`) REFERENCES `uiformapago` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iufactura_uitercero1` FOREIGN KEY (`iditercero`) REFERENCES `uitercero` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iufactura`
--

LOCK TABLES `iufactura` WRITE;
/*!40000 ALTER TABLE `iufactura` DISABLE KEYS */;
INSERT INTO `iufactura` VALUES (1,'2018-08-02 08:47:44',28,'FA-28',19,295000,0,56050,351050,NULL,1,1,1,1,2,1),(2,'2018-08-02 08:59:08',29,'FA-29',19,295000,0,56050,351050,NULL,1,2,1,1,2,1),(3,'2018-08-02 09:08:05',30,'FA-30',19,295000,0,56050,351050,NULL,1,1,1,1,2,1),(4,'2018-08-02 11:45:15',1,'FA-1',19,280000,0,53200,333200,NULL,1,1,1,1,2,1),(5,'2018-08-02 11:54:03',1,'RA-1',0,118000,11800,NULL,106200,NULL,1,2,2,2,2,1);
/*!40000 ALTER TABLE `iufactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iufacturaabono`
--

DROP TABLE IF EXISTS `iufacturaabono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iufacturaabono` (
  `id` int(11) NOT NULL,
  `abono` datetime DEFAULT NULL,
  `valAbono` int(11) DEFAULT NULL,
  `idfactura` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_table1_iufactura1_idx` (`idfactura`),
  CONSTRAINT `fk_table1_iufactura1` FOREIGN KEY (`idfactura`) REFERENCES `iufactura` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iufacturaabono`
--

LOCK TABLES `iufacturaabono` WRITE;
/*!40000 ALTER TABLE `iufacturaabono` DISABLE KEYS */;
/*!40000 ALTER TABLE `iufacturaabono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iufacturadetalle`
--

DROP TABLE IF EXISTS `iufacturadetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iufacturadetalle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `iva` int(11) DEFAULT NULL,
  `descuento` int(11) DEFAULT NULL,
  `idFactura` int(11) NOT NULL,
  `idRreferencia` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_iufacturaDetalle_iufactura1_idx` (`idFactura`),
  KEY `fk_iufacturaDetalle_uireferencia1_idx` (`idRreferencia`),
  CONSTRAINT `fk_iufacturaDetalle_iufactura1` FOREIGN KEY (`idFactura`) REFERENCES `iufactura` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iufacturaDetalle_uireferencia1` FOREIGN KEY (`idRreferencia`) REFERENCES `uireferencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iufacturadetalle`
--

LOCK TABLES `iufacturadetalle` WRITE;
/*!40000 ALTER TABLE `iufacturadetalle` DISABLE KEYS */;
INSERT INTO `iufacturadetalle` VALUES (1,5,59000,NULL,0,1,1),(2,5,59000,NULL,0,2,1),(3,5,59000,NULL,0,3,1),(4,5,56000,NULL,0,4,1),(5,2,59000,NULL,10,5,1);
/*!40000 ALTER TABLE `iufacturadetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iufacturadetalletalla`
--

DROP TABLE IF EXISTS `iufacturadetalletalla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iufacturadetalletalla` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` varchar(45) DEFAULT NULL,
  `idtalla` int(11) NOT NULL,
  `idfacturaDetalle` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_iuFacturadetalleTalla_iufacturaDetalle1_idx` (`idfacturaDetalle`),
  KEY `fk_iuFacturadetalleTalla_iutalla_idx` (`idtalla`),
  CONSTRAINT `fk_iuFacturadetalleTalla_iufacturaDetalle1` FOREIGN KEY (`idfacturaDetalle`) REFERENCES `iufacturadetalle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iuFacturadetalleTalla_iutalla` FOREIGN KEY (`idtalla`) REFERENCES `iutalla` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iufacturadetalletalla`
--

LOCK TABLES `iufacturadetalletalla` WRITE;
/*!40000 ALTER TABLE `iufacturadetalletalla` DISABLE KEYS */;
/*!40000 ALTER TABLE `iufacturadetalletalla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iufacturaestado`
--

DROP TABLE IF EXISTS `iufacturaestado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iufacturaestado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iufacturaestado`
--

LOCK TABLES `iufacturaestado` WRITE;
/*!40000 ALTER TABLE `iufacturaestado` DISABLE KEYS */;
INSERT INTO `iufacturaestado` VALUES (1,'Aprobada'),(2,'Anulada');
/*!40000 ALTER TABLE `iufacturaestado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iufacturanovedad`
--

DROP TABLE IF EXISTS `iufacturanovedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iufacturanovedad` (
  `idFactura` int(11) NOT NULL AUTO_INCREMENT,
  `fechanovedad` date DEFAULT NULL,
  `novedad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `fk_iuFacturaAnulada_table11_idx` (`idFactura`),
  CONSTRAINT `fk_iuFacturaAnulada_table11` FOREIGN KEY (`idFactura`) REFERENCES `iufactura` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iufacturanovedad`
--

LOCK TABLES `iufacturanovedad` WRITE;
/*!40000 ALTER TABLE `iufacturanovedad` DISABLE KEYS */;
/*!40000 ALTER TABLE `iufacturanovedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iufacturatipo`
--

DROP TABLE IF EXISTS `iufacturatipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iufacturatipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iufacturatipo`
--

LOCK TABLES `iufacturatipo` WRITE;
/*!40000 ALTER TABLE `iufacturatipo` DISABLE KEYS */;
INSERT INTO `iufacturatipo` VALUES (1,'Factura'),(2,'Remision'),(3,'devolucion'),(4,'NotaCompra');
/*!40000 ALTER TABLE `iufacturatipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iugrupotalla`
--

DROP TABLE IF EXISTS `iugrupotalla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iugrupotalla` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `activo` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iugrupotalla`
--

LOCK TABLES `iugrupotalla` WRITE;
/*!40000 ALTER TABLE `iugrupotalla` DISABLE KEYS */;
INSERT INTO `iugrupotalla` VALUES (1,'Dama',1),(2,'Caballero',1);
/*!40000 ALTER TABLE `iugrupotalla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iugrupotalladetalle`
--

DROP TABLE IF EXISTS `iugrupotalladetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iugrupotalladetalle` (
  `iuGrupoTalla_id` int(11) NOT NULL,
  `talla_id` int(11) NOT NULL,
  KEY `fk_iuGrupoTallaDetalle_iuGrupoTalla1_idx` (`iuGrupoTalla_id`),
  KEY `fk_iuGrupoTallaDetalle_iuTAlla_idx` (`talla_id`),
  CONSTRAINT `fk_iuGrupoTallaDetalle_iuGrupoTalla1` FOREIGN KEY (`iuGrupoTalla_id`) REFERENCES `iugrupotalla` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iuGrupoTallaDetalle_iuTAlla` FOREIGN KEY (`talla_id`) REFERENCES `iustockoperacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iugrupotalladetalle`
--

LOCK TABLES `iugrupotalladetalle` WRITE;
/*!40000 ALTER TABLE `iugrupotalladetalle` DISABLE KEYS */;
INSERT INTO `iugrupotalladetalle` VALUES (1,1),(1,2),(2,1),(2,2);
/*!40000 ALTER TABLE `iugrupotalladetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iuimagen`
--

DROP TABLE IF EXISTS `iuimagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iuimagen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(1000) DEFAULT NULL,
  `with` int(11) DEFAULT NULL,
  `heigh` int(11) DEFAULT NULL,
  `idReferenciaDetalles` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_iuImagen_uiReferenciaDetalles1_idx` (`idReferenciaDetalles`),
  CONSTRAINT `fk_iuImagen_uiReferenciaDetalles1` FOREIGN KEY (`idReferenciaDetalles`) REFERENCES `uireferenciadetalles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iuimagen`
--

LOCK TABLES `iuimagen` WRITE;
/*!40000 ALTER TABLE `iuimagen` DISABLE KEYS */;
/*!40000 ALTER TABLE `iuimagen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iumensajes`
--

DROP TABLE IF EXISTS `iumensajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iumensajes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `fechaLeido` datetime DEFAULT NULL,
  `mensaje` text,
  `UiUsuario_emisor` int(11) DEFAULT NULL,
  `UiUsuario_recep` int(11) DEFAULT NULL,
  `leido` tinyint(4) DEFAULT NULL COMMENT '1: sin leer.\n2:  leido\n',
  PRIMARY KEY (`id`),
  KEY `fk_iumensajes_uiusuario1_idx` (`UiUsuario_recep`),
  KEY `fk_iumensajes_uiusuario2_idx` (`UiUsuario_emisor`),
  CONSTRAINT `fk_iumensajes_uiusuario1` FOREIGN KEY (`UiUsuario_recep`) REFERENCES `uiusuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iumensajes_uiusuario2` FOREIGN KEY (`UiUsuario_emisor`) REFERENCES `uiusuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iumensajes`
--

LOCK TABLES `iumensajes` WRITE;
/*!40000 ALTER TABLE `iumensajes` DISABLE KEYS */;
INSERT INTO `iumensajes` VALUES (1,'2018-06-08 00:28:44',NULL,'hola mundo pedido',1,8,0);
/*!40000 ALTER TABLE `iumensajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iureferenciaxvalortercero`
--

DROP TABLE IF EXISTS `iureferenciaxvalortercero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iureferenciaxvalortercero` (
  `valor` int(11) DEFAULT NULL,
  `idtercero` int(11) NOT NULL,
  `idRererencia` int(11) NOT NULL,
  PRIMARY KEY (`idtercero`,`idRererencia`),
  KEY `pk_terceroxvalor_idx` (`idtercero`),
  KEY `pk_referenciaxtercero_idx` (`idRererencia`),
  CONSTRAINT `pk_referenciaxtercero` FOREIGN KEY (`idRererencia`) REFERENCES `uireferencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pk_terceroxvalor` FOREIGN KEY (`idtercero`) REFERENCES `uitercero` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iureferenciaxvalortercero`
--

LOCK TABLES `iureferenciaxvalortercero` WRITE;
/*!40000 ALTER TABLE `iureferenciaxvalortercero` DISABLE KEYS */;
INSERT INTO `iureferenciaxvalortercero` VALUES (59000,1,1),(59000,2,1);
/*!40000 ALTER TABLE `iureferenciaxvalortercero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iustock`
--

DROP TABLE IF EXISTS `iustock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iustock` (
  `id` int(11) NOT NULL,
  `iduireferencia` int(11) NOT NULL,
  `total` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_iuStock_uireferencia1_idx` (`iduireferencia`),
  CONSTRAINT `fk_iuStock_uireferencia1` FOREIGN KEY (`iduireferencia`) REFERENCES `uireferencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iustock`
--

LOCK TABLES `iustock` WRITE;
/*!40000 ALTER TABLE `iustock` DISABLE KEYS */;
/*!40000 ALTER TABLE `iustock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iustockdetalle`
--

DROP TABLE IF EXISTS `iustockdetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iustockdetalle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idReferenciaDetalles` int(11) NOT NULL,
  `idtalla` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_iustockdetalle_uiReferenciaDetalles1_idx` (`idReferenciaDetalles`),
  KEY `fk_iustockdetalle_iutalla_idx` (`idtalla`),
  CONSTRAINT `fk_iustockdetalle_iutalla` FOREIGN KEY (`idtalla`) REFERENCES `iutalla` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iustockdetalle_uiReferenciaDetalles1` FOREIGN KEY (`idReferenciaDetalles`) REFERENCES `uireferenciadetalles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iustockdetalle`
--

LOCK TABLES `iustockdetalle` WRITE;
/*!40000 ALTER TABLE `iustockdetalle` DISABLE KEYS */;
INSERT INTO `iustockdetalle` VALUES (7,1,1,1),(10,1,2,5),(11,2,1,4),(12,2,2,3),(13,4,1,1),(14,4,2,100);
/*!40000 ALTER TABLE `iustockdetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iustocklog`
--

DROP TABLE IF EXISTS `iustocklog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iustocklog` (
  `idiustocklog` int(11) NOT NULL AUTO_INCREMENT,
  `iustockoperacion_id` int(11) NOT NULL,
  `iustockdetalle_id` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `log` varchar(255) DEFAULT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idiustocklog`),
  KEY `fk_iustocklog_iustockoperacion1_idx` (`iustockoperacion_id`),
  KEY `fk_iustocklog_iustockdetalle1_idx` (`iustockdetalle_id`),
  CONSTRAINT `fk_iustocklog_iustockdetalle1` FOREIGN KEY (`iustockdetalle_id`) REFERENCES `iustockdetalle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iustocklog_iustockoperacion1` FOREIGN KEY (`iustockoperacion_id`) REFERENCES `iustockoperacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iustocklog`
--

LOCK TABLES `iustocklog` WRITE;
/*!40000 ALTER TABLE `iustocklog` DISABLE KEYS */;
/*!40000 ALTER TABLE `iustocklog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iustockoperacion`
--

DROP TABLE IF EXISTS `iustockoperacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iustockoperacion` (
  `id` int(11) NOT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `operacion` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iustockoperacion`
--

LOCK TABLES `iustockoperacion` WRITE;
/*!40000 ALTER TABLE `iustockoperacion` DISABLE KEYS */;
INSERT INTO `iustockoperacion` VALUES (1,'Factura','R'),(2,'Devolucion','S'),(3,'Producto Terminado','S'),(4,'Producto defectuoso',NULL);
/*!40000 ALTER TABLE `iustockoperacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iutalla`
--

DROP TABLE IF EXISTS `iutalla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iutalla` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `talla` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `idtallatipo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_talla_iutallatipo1_idx` (`idtallatipo`),
  CONSTRAINT `fk_talla_iutallatipo1` FOREIGN KEY (`idtallatipo`) REFERENCES `iutallatipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iutalla`
--

LOCK TABLES `iutalla` WRITE;
/*!40000 ALTER TABLE `iutalla` DISABLE KEYS */;
INSERT INTO `iutalla` VALUES (1,'XS','',2),(2,'S','',2);
/*!40000 ALTER TABLE `iutalla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iutallatipo`
--

DROP TABLE IF EXISTS `iutallatipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iutallatipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iutallatipo`
--

LOCK TABLES `iutallatipo` WRITE;
/*!40000 ALTER TABLE `iutallatipo` DISABLE KEYS */;
INSERT INTO `iutallatipo` VALUES (1,'Calzado'),(2,'Textil');
/*!40000 ALTER TABLE `iutallatipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iutercerousuario`
--

DROP TABLE IF EXISTS `iutercerousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iutercerousuario` (
  `idusuario` int(11) NOT NULL,
  `idtercero` int(11) NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `fk_table1_uitercero2_idx` (`idtercero`),
  KEY `fk_table1_uiusuario2_idx` (`idusuario`,`idtercero`),
  CONSTRAINT `datatercero_pk` FOREIGN KEY (`idtercero`) REFERENCES `uitercero` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `datausuario_pk` FOREIGN KEY (`idusuario`) REFERENCES `uiusuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iutercerousuario`
--

LOCK TABLES `iutercerousuario` WRITE;
/*!40000 ALTER TABLE `iutercerousuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `iutercerousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `madepartamento`
--

DROP TABLE IF EXISTS `madepartamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `madepartamento` (
  `id` int(11) NOT NULL,
  `departamento` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `madepartamento`
--

LOCK TABLES `madepartamento` WRITE;
/*!40000 ALTER TABLE `madepartamento` DISABLE KEYS */;
INSERT INTO `madepartamento` VALUES (5,'ANTIOQUIA'),(8,'ATLANTICO'),(11,'BOGOTA'),(13,'BOLIVAR'),(15,'BOYACA'),(17,'CALDAS'),(18,'CAQUETA'),(19,'CAUCA'),(20,'CESAR'),(23,'CORDOBA'),(25,'CUNDINAMARCA'),(27,'CHOCO'),(41,'HUILA'),(44,'LA GUAJIRA'),(47,'MAGDALENA'),(50,'META'),(52,'NARIÑO'),(54,'N. DE SANTANDER'),(63,'QUINDIO'),(66,'RISARALDA'),(68,'SANTANDER'),(70,'SUCRE'),(73,'TOLIMA'),(76,'VALLE DEL CAUCA'),(81,'ARAUCA'),(85,'CASANARE'),(86,'PUTUMAYO'),(88,'SAN ANDRES'),(91,'AMAZONAS'),(94,'GUAINIA'),(95,'GUAVIARE'),(97,'VAUPES'),(99,'VICHADA'),(100,'OTRO PAIS');
/*!40000 ALTER TABLE `madepartamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mamunicipio`
--

DROP TABLE IF EXISTS `mamunicipio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mamunicipio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codDane` int(11) DEFAULT NULL,
  `municipio` varchar(100) DEFAULT NULL,
  `idDepartamento` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_mamunicipio_madepartamento1_idx` (`idDepartamento`),
  CONSTRAINT `fk_mamunicipio_madepartamento1` FOREIGN KEY (`idDepartamento`) REFERENCES `madepartamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1013 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mamunicipio`
--

LOCK TABLES `mamunicipio` WRITE;
/*!40000 ALTER TABLE `mamunicipio` DISABLE KEYS */;
INSERT INTO `mamunicipio` VALUES (1,5001,'MEDELLIN',5),(2,5002,'ABEJORRAL',5),(3,5004,'ABRIAQUI',5),(4,5021,'ALEJANDRIA',5),(5,5030,'AMAGA',5),(6,5031,'AMALFI',5),(7,5034,'ANDES',5),(8,5036,'ANGELOPOLIS',5),(9,5038,'ANGOSTURA',5),(10,5040,'ANORI',5),(11,5042,'SANTAFE DE ANTIOQUIA',5),(12,5044,'ANZA',5),(13,5045,'APARTADO',5),(14,5051,'ARBOLETES',5),(15,5055,'ARGELIA',5),(16,5059,'ARMENIA',5),(17,5079,'BARBOSA',5),(18,5086,'BELMIRA',5),(19,5088,'BELLO',5),(20,5091,'BETANIA',5),(21,5093,'BETULIA',5),(22,5101,'CIUDAD BOLIVAR',5),(23,5107,'BRICE¥O',5),(24,5113,'BURITICA',5),(25,5120,'CACERES',5),(26,5125,'CAICEDO',5),(27,5129,'CALDAS',5),(28,5134,'CAMPAMENTO',5),(29,5138,'CA¥ASGORDAS',5),(30,5142,'CARACOLI',5),(31,5145,'CARAMANTA',5),(32,5147,'CAREPA',5),(33,5148,'EL CARMEN DE VIBORAL',5),(34,5150,'CAROLINA',5),(35,5154,'CAUCASIA',5),(36,5172,'CHIGORODO',5),(37,5190,'CISNEROS',5),(38,5197,'COCORNA',5),(39,5206,'CONCEPCION',5),(40,5209,'CONCORDIA',5),(41,5212,'COPACABANA',5),(42,5234,'DABEIBA',5),(43,5237,'DON MATIAS',5),(44,5240,'EBEJICO',5),(45,5250,'EL BAGRE',5),(46,5264,'ENTRERRIOS',5),(47,5266,'ENVIGADO',5),(48,5282,'FREDONIA',5),(49,5284,'FRONTINO',5),(50,5306,'GIRALDO',5),(51,5308,'GIRARDOTA',5),(52,5310,'GOMEZ PLATA',5),(53,5313,'GRANADA',5),(54,5315,'GUADALUPE',5),(55,5318,'GUARNE',5),(56,5321,'GUATAPE',5),(57,5347,'HELICONIA',5),(58,5353,'HISPANIA',5),(59,5360,'ITAGUI',5),(60,5361,'ITUANGO',5),(61,5364,'JARDIN',5),(62,5368,'JERICO',5),(63,5376,'LA CEJA',5),(64,5380,'LA ESTRELLA',5),(65,5390,'LA PINTADA',5),(66,5400,'LA UNION',5),(67,5411,'LIBORINA',5),(68,5425,'MACEO',5),(69,5440,'MARINILLA',5),(70,5467,'MONTEBELLO',5),(71,5475,'MURINDO',5),(72,5480,'MUTATA',5),(73,5483,'NARI¥O',5),(74,5490,'NECOCLI',5),(75,5495,'NECHI',5),(76,5501,'OLAYA',5),(77,5541,'PEÑOL',5),(78,5543,'PEQUE',5),(79,5576,'PUEBLORRICO',5),(80,5579,'PUERTO BERRIO',5),(81,5585,'PUERTO NARE',5),(82,5591,'PUERTO TRIUNFO',5),(83,5604,'REMEDIOS',5),(84,5607,'RETIRO',5),(85,5615,'RIONEGRO',5),(86,5628,'SABANALARGA',5),(87,5631,'SABANETA',5),(88,5642,'SALGAR',5),(89,5647,'SAN ANDRES DE CUERQUIA',5),(90,5649,'SAN CARLOS',5),(91,5652,'SAN FRANCISCO',5),(92,5656,'SAN JERONIMO',5),(93,5658,'SAN JOSE DE LA MONTA¥A',5),(94,5659,'SAN JUAN DE URABA',5),(95,5660,'SAN LUIS',5),(96,5664,'SAN PEDRO',5),(97,5665,'SAN PEDRO DE URABA',5),(98,5667,'SAN RAFAEL',5),(99,5670,'SAN ROQUE',5),(100,5674,'SAN VICENTE',5),(101,5679,'SANTA BARBARA',5),(102,5686,'SANTA ROSA DE OSOS',5),(103,5690,'SANTO DOMINGO',5),(104,5697,'EL SANTUARIO',5),(105,5736,'SEGOVIA',5),(106,5756,'SONSON',5),(107,5761,'SOPETRAN',5),(108,5789,'TAMESIS',5),(109,5790,'TARAZA',5),(110,5792,'TARSO',5),(111,5809,'TITIRIBI',5),(112,5819,'TOLEDO',5),(113,5837,'TURBO',5),(114,5842,'URAMITA',5),(115,5847,'URRAO',5),(116,5854,'VALDIVIA',5),(117,5856,'VALPARAISO',5),(118,5858,'VEGACHI',5),(119,5861,'VENECIA',5),(120,5873,'VIGIA DEL FUERTE',5),(121,5885,'YALI',5),(122,5887,'YARUMAL',5),(123,5890,'YOLOMBO',5),(124,5893,'YONDO',5),(125,5895,'ZARAGOZA',5),(126,8001,'BARRANQUILLA',8),(127,8078,'BARANOA',8),(128,8137,'CAMPO DE LA CRUZ',8),(129,8141,'CANDELARIA',8),(130,8296,'GALAPA',8),(131,8372,'JUAN DE ACOSTA',8),(132,8421,'LURUACO',8),(133,8433,'MALAMBO',8),(134,8436,'MANATI',8),(135,8520,'PALMAR DE VARELA',8),(136,8549,'PIOJO',8),(137,8558,'POLONUEVO',8),(138,8560,'PONEDERA',8),(139,8573,'PUERTO COLOMBIA',8),(140,8606,'REPELON',8),(141,8634,'SABANAGRANDE',8),(142,8638,'SABANALARGA',8),(143,8675,'SANTA LUCIA',8),(144,8685,'SANTO TOMAS',8),(145,8758,'SOLEDAD',8),(146,8770,'SUAN',8),(147,8832,'TUBARA',8),(148,8849,'USIACURI',8),(149,11001,'BOGOTA D.C.',11),(150,13001,'CARTAGENA',13),(151,13006,'ACHI',13),(152,13030,'ALTOS DEL ROSARIO',13),(153,13042,'ARENAL',13),(154,13052,'ARJONA',13),(155,13062,'ARROYOHONDO',13),(156,13074,'BARRANCO DE LOBA',13),(157,13140,'CALAMAR',13),(158,13160,'CANTAGALLO',13),(159,13188,'CICUCO',13),(160,13212,'CORDOBA',13),(161,13222,'CLEMENCIA',13),(162,13244,'EL CARMEN DE BOLIVAR',13),(163,13248,'EL GUAMO',13),(164,13268,'EL PE¥ON',13),(165,13300,'HATILLO DE LOBA',13),(166,13430,'MAGANGUE',13),(167,13433,'MAHATES',13),(168,13440,'MARGARITA',13),(169,13442,'MARIA LA BAJA',13),(170,13458,'MONTECRISTO',13),(171,13468,'MOMPOS',13),(172,13473,'MORALES',13),(173,13490,'NOROSI',13),(174,13549,'PINILLOS',13),(175,13580,'REGIDOR',13),(176,13600,'RIO VIEJO',13),(177,13620,'SAN CRISTOBAL',13),(178,13647,'SAN ESTANISLAO',13),(179,13650,'SAN FERNANDO',13),(180,13654,'SAN JACINTO',13),(181,13655,'SAN JACINTO DEL CAUCA',13),(182,13657,'SAN JUAN NEPOMUCENO',13),(183,13667,'SAN MARTIN DE LOBA',13),(184,13670,'SAN PABLO',13),(185,13673,'SANTA CATALINA',13),(186,13683,'SANTA ROSA',13),(187,13688,'SANTA ROSA DEL SUR',13),(188,13744,'SIMITI',13),(189,13760,'SOPLAVIENTO',13),(190,13780,'TALAIGUA NUEVO',13),(191,13810,'TIQUISIO',13),(192,13836,'TURBACO',13),(193,13838,'TURBANA',13),(194,13873,'VILLANUEVA',13),(195,13894,'ZAMBRANO',13),(196,15001,'TUNJA',15),(197,15022,'ALMEIDA',15),(198,15047,'AQUITANIA',15),(199,15051,'ARCABUCO',15),(200,15087,'BELEN',15),(201,15090,'BERBEO',15),(202,15092,'BETEITIVA',15),(203,15097,'BOAVITA',15),(204,15104,'BOYACA',15),(205,15106,'BRICE¥O',15),(206,15109,'BUENAVISTA',15),(207,15114,'BUSBANZA',15),(208,15131,'CALDAS',15),(209,15135,'CAMPOHERMOSO',15),(210,15162,'CERINZA',15),(211,15172,'CHINAVITA',15),(212,15176,'CHIQUINQUIRA',15),(213,15180,'CHISCAS',15),(214,15183,'CHITA',15),(215,15185,'CHITARAQUE',15),(216,15187,'CHIVATA',15),(217,15189,'CIENEGA',15),(218,15204,'COMBITA',15),(219,15212,'COPER',15),(220,15215,'CORRALES',15),(221,15218,'COVARACHIA',15),(222,15223,'CUBARA',15),(223,15224,'CUCAITA',15),(224,15226,'CUITIVA',15),(225,15232,'CHIQUIZA',15),(226,15236,'CHIVOR',15),(227,15238,'DUITAMA',15),(228,15244,'EL COCUY',15),(229,15248,'EL ESPINO',15),(230,15272,'FIRAVITOBA',15),(231,15276,'FLORESTA',15),(232,15293,'GACHANTIVA',15),(233,15296,'GAMEZA',15),(234,15299,'GARAGOA',15),(235,15317,'GUACAMAYAS',15),(236,15322,'GUATEQUE',15),(237,15325,'GUAYATA',15),(238,15332,'GsICAN',15),(239,15362,'IZA',15),(240,15367,'JENESANO',15),(241,15368,'JERICO',15),(242,15377,'LABRANZAGRANDE',15),(243,15380,'LA CAPILLA',15),(244,15401,'LA VICTORIA',15),(245,15403,'LA UVITA',15),(246,15407,'VILLA DE LEYVA',15),(247,15425,'MACANAL',15),(248,15442,'MARIPI',15),(249,15455,'MIRAFLORES',15),(250,15464,'MONGUA',15),(251,15466,'MONGUI',15),(252,15469,'MONIQUIRA',15),(253,15476,'MOTAVITA',15),(254,15480,'MUZO',15),(255,15491,'NOBSA',15),(256,15494,'NUEVO COLON',15),(257,15500,'OICATA',15),(258,15507,'OTANCHE',15),(259,15511,'PACHAVITA',15),(260,15514,'PAEZ',15),(261,15516,'PAIPA',15),(262,15518,'PAJARITO',15),(263,15522,'PANQUEBA',15),(264,15531,'PAUNA',15),(265,15533,'PAYA',15),(266,15537,'PAZ DE RIO',15),(267,15542,'PESCA',15),(268,15550,'PISBA',15),(269,15572,'PUERTO BOYACA',15),(270,15580,'QUIPAMA',15),(271,15599,'RAMIRIQUI',15),(272,15600,'RAQUIRA',15),(273,15621,'RONDON',15),(274,15632,'SABOYA',15),(275,15638,'SACHICA',15),(276,15646,'SAMACA',15),(277,15660,'SAN EDUARDO',15),(278,15664,'SAN JOSE DE PARE',15),(279,15667,'SAN LUIS DE GACENO',15),(280,15673,'SAN MATEO',15),(281,15676,'SAN MIGUEL DE SEMA',15),(282,15681,'SAN PABLO DE BORBUR',15),(283,15686,'SANTANA',15),(284,15690,'SANTA MARIA',15),(285,15693,'SANTA ROSA DE VITERBO',15),(286,15696,'SANTA SOFIA',15),(287,15720,'SATIVANORTE',15),(288,15723,'SATIVASUR',15),(289,15740,'SIACHOQUE',15),(290,15753,'SOATA',15),(291,15755,'SOCOTA',15),(292,15757,'SOCHA',15),(293,15759,'SOGAMOSO',15),(294,15761,'SOMONDOCO',15),(295,15762,'SORA',15),(296,15763,'SOTAQUIRA',15),(297,15764,'SORACA',15),(298,15774,'SUSACON',15),(299,15776,'SUTAMARCHAN',15),(300,15778,'SUTATENZA',15),(301,15790,'TASCO',15),(302,15798,'TENZA',15),(303,15804,'TIBANA',15),(304,15806,'TIBASOSA',15),(305,15808,'TINJACA',15),(306,15810,'TIPACOQUE',15),(307,15814,'TOCA',15),(308,15816,'TOGsI',15),(309,15820,'TOPAGA',15),(310,15822,'TOTA',15),(311,15832,'TUNUNGUA',15),(312,15835,'TURMEQUE',15),(313,15837,'TUTA',15),(314,15839,'TUTAZA',15),(315,15842,'UMBITA',15),(316,15861,'VENTAQUEMADA',15),(317,15879,'VIRACACHA',15),(318,15897,'ZETAQUIRA',15),(319,17001,'MANIZALES',17),(320,17013,'AGUADAS',17),(321,17042,'ANSERMA',17),(322,17050,'ARANZAZU',17),(323,17088,'BELALCAZAR',17),(324,17174,'CHINCHINA',17),(325,17272,'FILADELFIA',17),(326,17380,'LA DORADA',17),(327,17388,'LA MERCED',17),(328,17433,'MANZANARES',17),(329,17442,'MARMATO',17),(330,17444,'MARQUETALIA',17),(331,17446,'MARULANDA',17),(332,17486,'NEIRA',17),(333,17495,'NORCASIA',17),(334,17513,'PACORA',17),(335,17524,'PALESTINA',17),(336,17541,'PENSILVANIA',17),(337,17614,'RIOSUCIO',17),(338,17616,'RISARALDA',17),(339,17653,'SALAMINA',17),(340,17662,'SAMANA',17),(341,17665,'SAN JOSE',17),(342,17777,'SUPIA',17),(343,17867,'VICTORIA',17),(344,17873,'VILLAMARIA',17),(345,17877,'VITERBO',17),(346,18001,'FLORENCIA',18),(347,18029,'ALBANIA',18),(348,18094,'BELEN DE LOS ANDAQUIES',18),(349,18150,'CARTAGENA DEL CHAIRA',18),(350,18205,'CURILLO',18),(351,18247,'EL DONCELLO',18),(352,18256,'EL PAUJIL',18),(353,18410,'LA MONTA¥ITA',18),(354,18460,'MILAN',18),(355,18479,'MORELIA',18),(356,18592,'PUERTO RICO',18),(357,18610,'SAN JOSE DEL FRAGUA',18),(358,18753,'SAN VICENTE DEL CAGUAN',18),(359,18756,'SOLANO',18),(360,18785,'SOLITA',18),(361,18860,'VALPARAISO',18),(362,19001,'POPAYAN',19),(363,19022,'ALMAGUER',19),(364,19050,'ARGELIA',19),(365,19075,'BALBOA',19),(366,19100,'BOLIVAR',19),(367,19110,'BUENOS AIRES',19),(368,19130,'CAJIBIO',19),(369,19137,'CALDONO',19),(370,19142,'CALOTO',19),(371,19212,'CORINTO',19),(372,19256,'EL TAMBO',19),(373,19290,'FLORENCIA',19),(374,19300,'GUACHENE',19),(375,19318,'GUAPI',19),(376,19355,'INZA',19),(377,19364,'JAMBALO',19),(378,19392,'LA SIERRA',19),(379,19397,'LA VEGA',19),(380,19418,'LOPEZ',19),(381,19450,'MERCADERES',19),(382,19455,'MIRANDA',19),(383,19473,'MORALES',19),(384,19513,'PADILLA',19),(385,19517,'PAEZ',19),(386,19532,'PATIA',19),(387,19533,'PIAMONTE',19),(388,19548,'PIENDAMO',19),(389,19573,'PUERTO TEJADA',19),(390,19585,'PURACE',19),(391,19622,'ROSAS',19),(392,19693,'SAN SEBASTIAN',19),(393,19698,'SANTANDER DE QUILICHAO',19),(394,19701,'SANTA ROSA',19),(395,19743,'SILVIA',19),(396,19760,'SOTARA',19),(397,19780,'SUAREZ',19),(398,19785,'SUCRE',19),(399,19807,'TIMBIO',19),(400,19809,'TIMBIQUI',19),(401,19821,'TORIBIO',19),(402,19824,'TOTORO',19),(403,19845,'VILLA RICA',19),(404,20001,'VALLEDUPAR',20),(405,20011,'AGUACHICA',20),(406,20013,'AGUSTIN CODAZZI',20),(407,20032,'ASTREA',20),(408,20045,'BECERRIL',20),(409,20060,'BOSCONIA',20),(410,20175,'CHIMICHAGUA',20),(411,20178,'CHIRIGUANA',20),(412,20228,'CURUMANI',20),(413,20238,'EL COPEY',20),(414,20250,'EL PASO',20),(415,20295,'GAMARRA',20),(416,20310,'GONZALEZ',20),(417,20383,'LA GLORIA',20),(418,20400,'LA JAGUA DE IBIRICO',20),(419,20443,'MANAURE',20),(420,20517,'PAILITAS',20),(421,20550,'PELAYA',20),(422,20570,'PUEBLO BELLO',20),(423,20614,'RIO DE ORO',20),(424,20621,'LA PAZ',20),(425,20710,'SAN ALBERTO',20),(426,20750,'SAN DIEGO',20),(427,20770,'SAN MARTIN',20),(428,20787,'TAMALAMEQUE',20),(429,23001,'MONTERIA',23),(430,23068,'AYAPEL',23),(431,23079,'BUENAVISTA',23),(432,23090,'CANALETE',23),(433,23162,'CERETE',23),(434,23168,'CHIMA',23),(435,23182,'CHINU',23),(436,23189,'CIENAGA DE ORO',23),(437,23300,'COTORRA',23),(438,23350,'LA APARTADA',23),(439,23417,'LORICA',23),(440,23419,'LOS CORDOBAS',23),(441,23464,'MOMIL',23),(442,23466,'MONTELIBANO',23),(443,23500,'MO¥ITOS',23),(444,23555,'PLANETA RICA',23),(445,23570,'PUEBLO NUEVO',23),(446,23574,'PUERTO ESCONDIDO',23),(447,23580,'PUERTO LIBERTADOR',23),(448,23586,'PURISIMA',23),(449,23660,'SAHAGUN',23),(450,23670,'SAN ANDRES SOTAVENTO',23),(451,23672,'SAN ANTERO',23),(452,23675,'SAN BERNARDO DEL VIENTO',23),(453,23678,'SAN CARLOS',23),(454,23686,'SAN PELAYO',23),(455,23807,'TIERRALTA',23),(456,23855,'VALENCIA',23),(457,25001,'AGUA DE DIOS',25),(458,25019,'ALBAN',25),(459,25035,'ANAPOIMA',25),(460,25040,'ANOLAIMA',25),(461,25053,'ARBELAEZ',25),(462,25086,'BELTRAN',25),(463,25095,'BITUIMA',25),(464,25099,'BOJACA',25),(465,25120,'CABRERA',25),(466,25123,'CACHIPAY',25),(467,25126,'CAJICA',25),(468,25148,'CAPARRAPI',25),(469,25151,'CAQUEZA',25),(470,25154,'CARMEN DE CARUPA',25),(471,25168,'CHAGUANI',25),(472,25175,'CHIA',25),(473,25178,'CHIPAQUE',25),(474,25181,'CHOACHI',25),(475,25183,'CHOCONTA',25),(476,25200,'COGUA',25),(477,25214,'COTA',25),(478,25224,'CUCUNUBA',25),(479,25245,'EL COLEGIO',25),(480,25258,'EL PE¥ON',25),(481,25260,'EL ROSAL',25),(482,25269,'FACATATIVA',25),(483,25279,'FOMEQUE',25),(484,25281,'FOSCA',25),(485,25286,'FUNZA',25),(486,25288,'FUQUENE',25),(487,25290,'FUSAGASUGA',25),(488,25293,'GACHALA',25),(489,25295,'GACHANCIPA',25),(490,25297,'GACHETA',25),(491,25299,'GAMA',25),(492,25307,'GIRARDOT',25),(493,25312,'GRANADA',25),(494,25317,'GUACHETA',25),(495,25320,'GUADUAS',25),(496,25322,'GUASCA',25),(497,25324,'GUATAQUI',25),(498,25326,'GUATAVITA',25),(499,25328,'GUAYABAL DE SIQUIMA',25),(500,25335,'GUAYABETAL',25),(501,25339,'GUTIERREZ',25),(502,25368,'JERUSALEN',25),(503,25372,'JUNIN',25),(504,25377,'LA CALERA',25),(505,25386,'LA MESA',25),(506,25394,'LA PALMA',25),(507,25398,'LA PE¥A',25),(508,25402,'LA VEGA',25),(509,25407,'LENGUAZAQUE',25),(510,25426,'MACHETA',25),(511,25430,'MADRID',25),(512,25436,'MANTA',25),(513,25438,'MEDINA',25),(514,25473,'MOSQUERA',25),(515,25483,'NARI¥O',25),(516,25486,'NEMOCON',25),(517,25488,'NILO',25),(518,25489,'NIMAIMA',25),(519,25491,'NOCAIMA',25),(520,25506,'VENECIA',25),(521,25513,'PACHO',25),(522,25518,'PAIME',25),(523,25524,'PANDI',25),(524,25530,'PARATEBUENO',25),(525,25535,'PASCA',25),(526,25572,'PUERTO SALGAR',25),(527,25580,'PULI',25),(528,25592,'QUEBRADANEGRA',25),(529,25594,'QUETAME',25),(530,25596,'QUIPILE',25),(531,25599,'APULO',25),(532,25612,'RICAURTE',25),(533,25645,'SAN ANTONIO DEL TEQUENDAMA',25),(534,25649,'SAN BERNARDO',25),(535,25653,'SAN CAYETANO',25),(536,25658,'SAN FRANCISCO',25),(537,25662,'SAN JUAN DE RIO SECO',25),(538,25718,'SASAIMA',25),(539,25736,'SESQUILE',25),(540,25740,'SIBATE',25),(541,25743,'SILVANIA',25),(542,25745,'SIMIJACA',25),(543,25754,'SOACHA',25),(544,25758,'SOPO',25),(545,25769,'SUBACHOQUE',25),(546,25772,'SUESCA',25),(547,25777,'SUPATA',25),(548,25779,'SUSA',25),(549,25781,'SUTATAUSA',25),(550,25785,'TABIO',25),(551,25793,'TAUSA',25),(552,25797,'TENA',25),(553,25799,'TENJO',25),(554,25805,'TIBACUY',25),(555,25807,'TIBIRITA',25),(556,25815,'TOCAIMA',25),(557,25817,'TOCANCIPA',25),(558,25823,'TOPAIPI',25),(559,25839,'UBALA',25),(560,25841,'UBAQUE',25),(561,25843,'VILLA DE SAN DIEGO DE UBATE',25),(562,25845,'UNE',25),(563,25851,'UTICA',25),(564,25862,'VERGARA',25),(565,25867,'VIANI',25),(566,25871,'VILLAGOMEZ',25),(567,25873,'VILLAPINZON',25),(568,25875,'VILLETA',25),(569,25878,'VIOTA',25),(570,25885,'YACOPI',25),(571,25898,'ZIPACON',25),(572,25899,'ZIPAQUIRA',25),(573,27001,'QUIBDO',27),(574,27006,'ACANDI',27),(575,27025,'ALTO BAUDO',27),(576,27050,'ATRATO',27),(577,27073,'BAGADO',27),(578,27075,'BAHIA SOLANO',27),(579,27077,'BAJO BAUDO',27),(580,27099,'BOJAYA',27),(581,27135,'EL CANTON DEL SAN PABLO',27),(582,27150,'CARMEN DEL DARIEN',27),(583,27160,'CERTEGUI',27),(584,27205,'CONDOTO',27),(585,27245,'EL CARMEN DE ATRATO',27),(586,27250,'EL LITORAL DEL SAN JUAN',27),(587,27361,'ISTMINA',27),(588,27372,'JURADO',27),(589,27413,'LLORO',27),(590,27425,'MEDIO ATRATO',27),(591,27430,'MEDIO BAUDO',27),(592,27450,'MEDIO SAN JUAN',27),(593,27491,'NOVITA',27),(594,27495,'NUQUI',27),(595,27580,'RIO IRO',27),(596,27600,'RIO QUITO',27),(597,27615,'RIOSUCIO',27),(598,27660,'SAN JOSE DEL PALMAR',27),(599,27745,'SIPI',27),(600,27787,'TADO',27),(601,27800,'UNGUIA',27),(602,27810,'UNION PANAMERICANA',27),(603,41001,'NEIVA',41),(604,41006,'ACEVEDO',41),(605,41013,'AGRADO',41),(606,41016,'AIPE',41),(607,41020,'ALGECIRAS',41),(608,41026,'ALTAMIRA',41),(609,41078,'BARAYA',41),(610,41132,'CAMPOALEGRE',41),(611,41206,'COLOMBIA',41),(612,41244,'ELIAS',41),(613,41298,'GARZON',41),(614,41306,'GIGANTE',41),(615,41319,'GUADALUPE',41),(616,41349,'HOBO',41),(617,41357,'IQUIRA',41),(618,41359,'ISNOS',41),(619,41378,'LA ARGENTINA',41),(620,41396,'LA PLATA',41),(621,41483,'NATAGA',41),(622,41503,'OPORAPA',41),(623,41518,'PAICOL',41),(624,41524,'PALERMO',41),(625,41530,'PALESTINA',41),(626,41548,'PITAL',41),(627,41551,'PITALITO',41),(628,41615,'RIVERA',41),(629,41660,'SALADOBLANCO',41),(630,41668,'SAN AGUSTIN',41),(631,41676,'SANTA MARIA',41),(632,41770,'SUAZA',41),(633,41791,'TARQUI',41),(634,41797,'TESALIA',41),(635,41799,'TELLO',41),(636,41801,'TERUEL',41),(637,41807,'TIMANA',41),(638,41872,'VILLAVIEJA',41),(639,41885,'YAGUARA',41),(640,44001,'RIOHACHA',44),(641,44035,'ALBANIA',44),(642,44078,'BARRANCAS',44),(643,44090,'DIBULLA',44),(644,44098,'DISTRACCION',44),(645,44110,'EL MOLINO',44),(646,44279,'FONSECA',44),(647,44378,'HATONUEVO',44),(648,44420,'LA JAGUA DEL PILAR',44),(649,44430,'MAICAO',44),(650,44560,'MANAURE',44),(651,44650,'SAN JUAN DEL CESAR',44),(652,44847,'URIBIA',44),(653,44855,'URUMITA',44),(654,44874,'VILLANUEVA',44),(655,47001,'SANTA MARTA',47),(656,47030,'ALGARROBO',47),(657,47053,'ARACATACA',47),(658,47058,'ARIGUANI',47),(659,47161,'CERRO SAN ANTONIO',47),(660,47170,'CHIBOLO',47),(661,47189,'CIENAGA',47),(662,47205,'CONCORDIA',47),(663,47245,'EL BANCO',47),(664,47258,'EL PI¥ON',47),(665,47268,'EL RETEN',47),(666,47288,'FUNDACION',47),(667,47318,'GUAMAL',47),(668,47460,'NUEVA GRANADA',47),(669,47541,'PEDRAZA',47),(670,47545,'PIJI¥O DEL CARMEN',47),(671,47551,'PIVIJAY',47),(672,47555,'PLATO',47),(673,47570,'PUEBLOVIEJO',47),(674,47605,'REMOLINO',47),(675,47660,'SABANAS DE SAN ANGEL',47),(676,47675,'SALAMINA',47),(677,47692,'SAN SEBASTIAN DE BUENAVISTA',47),(678,47703,'SAN ZENON',47),(679,47707,'SANTA ANA',47),(680,47720,'SANTA BARBARA DE PINTO',47),(681,47745,'SITIONUEVO',47),(682,47798,'TENERIFE',47),(683,47960,'ZAPAYAN',47),(684,47980,'ZONA BANANERA',47),(685,50001,'VILLAVICENCIO',50),(686,50006,'ACACIAS',50),(687,50110,'BARRANCA DE UPIA',50),(688,50124,'CABUYARO',50),(689,50150,'CASTILLA LA NUEVA',50),(690,50223,'CUBARRAL',50),(691,50226,'CUMARAL',50),(692,50245,'EL CALVARIO',50),(693,50251,'EL CASTILLO',50),(694,50270,'EL DORADO',50),(695,50287,'FUENTE DE ORO',50),(696,50313,'GRANADA',50),(697,50318,'GUAMAL',50),(698,50325,'MAPIRIPAN',50),(699,50330,'MESETAS',50),(700,50350,'LA MACARENA',50),(701,50370,'URIBE',50),(702,50400,'LEJANIAS',50),(703,50450,'PUERTO CONCORDIA',50),(704,50568,'PUERTO GAITAN',50),(705,50573,'PUERTO LOPEZ',50),(706,50577,'PUERTO LLERAS',50),(707,50590,'PUERTO RICO',50),(708,50606,'RESTREPO',50),(709,50680,'SAN CARLOS DE GUAROA',50),(710,50683,'SAN JUAN DE ARAMA',50),(711,50686,'SAN JUANITO',50),(712,50689,'SAN MARTIN',50),(713,50711,'VISTAHERMOSA',50),(714,52001,'PASTO',52),(715,52019,'ALBAN',52),(716,52022,'ALDANA',52),(717,52036,'ANCUYA',52),(718,52051,'ARBOLEDA',52),(719,52079,'BARBACOAS',52),(720,52083,'BELEN',52),(721,52110,'BUESACO',52),(722,52203,'COLON',52),(723,52207,'CONSACA',52),(724,52210,'CONTADERO',52),(725,52215,'CORDOBA',52),(726,52224,'CUASPUD',52),(727,52227,'CUMBAL',52),(728,52233,'CUMBITARA',52),(729,52240,'CHACHAGsI',52),(730,52250,'EL CHARCO',52),(731,52254,'EL PE¥OL',52),(732,52256,'EL ROSARIO',52),(733,52258,'EL TABLON DE GOMEZ',52),(734,52260,'EL TAMBO',52),(735,52287,'FUNES',52),(736,52317,'GUACHUCAL',52),(737,52320,'GUAITARILLA',52),(738,52323,'GUALMATAN',52),(739,52352,'ILES',52),(740,52354,'IMUES',52),(741,52356,'IPIALES',52),(742,52378,'LA CRUZ',52),(743,52381,'LA FLORIDA',52),(744,52385,'LA LLANADA',52),(745,52390,'LA TOLA',52),(746,52399,'LA UNION',52),(747,52405,'LEIVA',52),(748,52411,'LINARES',52),(749,52418,'LOS ANDES',52),(750,52427,'MAGsI',52),(751,52435,'MALLAMA',52),(752,52473,'MOSQUERA',52),(753,52480,'NARI¥O',52),(754,52490,'OLAYA HERRERA',52),(755,52506,'OSPINA',52),(756,52520,'FRANCISCO PIZARRO',52),(757,52540,'POLICARPA',52),(758,52560,'POTOSI',52),(759,52565,'PROVIDENCIA',52),(760,52573,'PUERRES',52),(761,52585,'PUPIALES',52),(762,52612,'RICAURTE',52),(763,52621,'ROBERTO PAYAN',52),(764,52678,'SAMANIEGO',52),(765,52683,'SANDONA',52),(766,52685,'SAN BERNARDO',52),(767,52687,'SAN LORENZO',52),(768,52693,'SAN PABLO',52),(769,52694,'SAN PEDRO DE CARTAGO',52),(770,52696,'SANTA BARBARA',52),(771,52699,'SANTACRUZ',52),(772,52720,'SAPUYES',52),(773,52786,'TAMINANGO',52),(774,52788,'TANGUA',52),(775,52835,'SAN ANDRES DE TUMACO',52),(776,52838,'TUQUERRES',52),(777,52885,'YACUANQUER',52),(778,54001,'CUCUTA',54),(779,54003,'ABREGO',54),(780,54051,'ARBOLEDAS',54),(781,54099,'BOCHALEMA',54),(782,54109,'BUCARASICA',54),(783,54125,'CACOTA',54),(784,54128,'CACHIRA',54),(785,54172,'CHINACOTA',54),(786,54174,'CHITAGA',54),(787,54206,'CONVENCION',54),(788,54223,'CUCUTILLA',54),(789,54239,'DURANIA',54),(790,54245,'EL CARMEN',54),(791,54250,'EL TARRA',54),(792,54261,'EL ZULIA',54),(793,54313,'GRAMALOTE',54),(794,54344,'HACARI',54),(795,54347,'HERRAN',54),(796,54377,'LABATECA',54),(797,54385,'LA ESPERANZA',54),(798,54398,'LA PLAYA',54),(799,54405,'LOS PATIOS',54),(800,54418,'LOURDES',54),(801,54480,'MUTISCUA',54),(802,54498,'OCA¥A',54),(803,54518,'PAMPLONA',54),(804,54520,'PAMPLONITA',54),(805,54553,'PUERTO SANTANDER',54),(806,54599,'RAGONVALIA',54),(807,54660,'SALAZAR',54),(808,54670,'SAN CALIXTO',54),(809,54673,'SAN CAYETANO',54),(810,54680,'SANTIAGO',54),(811,54720,'SARDINATA',54),(812,54743,'SILOS',54),(813,54800,'TEORAMA',54),(814,54810,'TIBU',54),(815,54820,'TOLEDO',54),(816,54871,'VILLA CARO',54),(817,54874,'VILLA DEL ROSARIO',54),(818,63001,'ARMENIA',63),(819,63111,'BUENAVISTA',63),(820,63130,'CALARCA',63),(821,63190,'CIRCASIA',63),(822,63212,'CORDOBA',63),(823,63272,'FILANDIA',63),(824,63302,'GENOVA',63),(825,63401,'LA TEBAIDA',63),(826,63470,'MONTENEGRO',63),(827,63548,'PIJAO',63),(828,63594,'QUIMBAYA',63),(829,63690,'SALENTO',63),(830,66001,'PEREIRA',66),(831,66045,'APIA',66),(832,66075,'BALBOA',66),(833,66088,'BELEN DE UMBRIA',66),(834,66170,'DOSQUEBRADAS',66),(835,66318,'GUATICA',66),(836,66383,'LA CELIA',66),(837,66400,'LA VIRGINIA',66),(838,66440,'MARSELLA',66),(839,66456,'MISTRATO',66),(840,66572,'PUEBLO RICO',66),(841,66594,'QUINCHIA',66),(842,66682,'SANTA ROSA DE CABAL',66),(843,66687,'SANTUARIO',66),(844,68001,'BUCARAMANGA',68),(845,68013,'AGUADA',68),(846,68020,'ALBANIA',68),(847,68051,'ARATOCA',68),(848,68077,'BARBOSA',68),(849,68079,'BARICHARA',68),(850,68081,'BARRANCABERMEJA',68),(851,68092,'BETULIA',68),(852,68101,'BOLIVAR',68),(853,68121,'CABRERA',68),(854,68132,'CALIFORNIA',68),(855,68147,'CAPITANEJO',68),(856,68152,'CARCASI',68),(857,68160,'CEPITA',68),(858,68162,'CERRITO',68),(859,68167,'CHARALA',68),(860,68169,'CHARTA',68),(861,68176,'CHIMA',68),(862,68179,'CHIPATA',68),(863,68190,'CIMITARRA',68),(864,68207,'CONCEPCION',68),(865,68209,'CONFINES',68),(866,68211,'CONTRATACION',68),(867,68217,'COROMORO',68),(868,68229,'CURITI',68),(869,68235,'EL CARMEN DE CHUCURI',68),(870,68245,'EL GUACAMAYO',68),(871,68250,'EL PE¥ON',68),(872,68255,'EL PLAYON',68),(873,68264,'ENCINO',68),(874,68266,'ENCISO',68),(875,68271,'FLORIAN',68),(876,68276,'FLORIDABLANCA',68),(877,68296,'GALAN',68),(878,68298,'GAMBITA',68),(879,68307,'GIRON',68),(880,68318,'GUACA',68),(881,68320,'GUADALUPE',68),(882,68322,'GUAPOTA',68),(883,68324,'GUAVATA',68),(884,68327,'GsEPSA',68),(885,68344,'HATO',68),(886,68368,'JESUS MARIA',68),(887,68370,'JORDAN',68),(888,68377,'LA BELLEZA',68),(889,68385,'LANDAZURI',68),(890,68397,'LA PAZ',68),(891,68406,'LEBRIJA',68),(892,68418,'LOS SANTOS',68),(893,68425,'MACARAVITA',68),(894,68432,'MALAGA',68),(895,68444,'MATANZA',68),(896,68464,'MOGOTES',68),(897,68468,'MOLAGAVITA',68),(898,68498,'OCAMONTE',68),(899,68500,'OIBA',68),(900,68502,'ONZAGA',68),(901,68522,'PALMAR',68),(902,68524,'PALMAS DEL SOCORRO',68),(903,68533,'PARAMO',68),(904,68547,'PIEDECUESTA',68),(905,68549,'PINCHOTE',68),(906,68572,'PUENTE NACIONAL',68),(907,68573,'PUERTO PARRA',68),(908,68575,'PUERTO WILCHES',68),(909,68615,'RIONEGRO',68),(910,68655,'SABANA DE TORRES',68),(911,68669,'SAN ANDRES',68),(912,68673,'SAN BENITO',68),(913,68679,'SAN GIL',68),(914,68682,'SAN JOAQUIN',68),(915,68684,'SAN JOSE DE MIRANDA',68),(916,68686,'SAN MIGUEL',68),(917,68689,'SAN VICENTE DE CHUCURI',68),(918,68705,'SANTA BARBARA',68),(919,68720,'SANTA HELENA DEL OPON',68),(920,68745,'SIMACOTA',68),(921,68755,'SOCORRO',68),(922,68770,'SUAITA',68),(923,68773,'SUCRE',68),(924,68780,'SURATA',68),(925,68820,'TONA',68),(926,68855,'VALLE DE SAN JOSE',68),(927,68861,'VELEZ',68),(928,68867,'VETAS',68),(929,68872,'VILLANUEVA',68),(930,68895,'ZAPATOCA',68),(931,70001,'SINCELEJO',70),(932,70110,'BUENAVISTA',70),(933,70124,'CAIMITO',70),(934,70204,'COLOSO',70),(935,70215,'COROZAL',70),(936,70221,'COVE¥AS',70),(937,70230,'CHALAN',70),(938,70233,'EL ROBLE',70),(939,70235,'GALERAS',70),(940,70265,'GUARANDA',70),(941,70400,'LA UNION',70),(942,70418,'LOS PALMITOS',70),(943,70429,'MAJAGUAL',70),(944,70473,'MORROA',70),(945,70508,'OVEJAS',70),(946,70523,'PALMITO',70),(947,70670,'SAMPUES',70),(948,70678,'SAN BENITO ABAD',70),(949,70702,'SAN JUAN DE BETULIA',70),(950,70708,'SAN MARCOS',70),(951,70713,'SAN ONOFRE',70),(952,70717,'SAN PEDRO',70),(953,70742,'SAN LUIS DE SINCE',70),(954,70771,'SUCRE',70),(955,70820,'SANTIAGO DE TOLU',70),(956,70823,'TOLU VIEJO',70),(957,73001,'IBAGUE',73),(958,73024,'ALPUJARRA',73),(959,73026,'ALVARADO',73),(960,73030,'AMBALEMA',73),(961,73043,'ANZOATEGUI',73),(962,73055,'ARMERO',73),(963,73067,'ATACO',73),(964,73124,'CAJAMARCA',73),(965,73148,'CARMEN DE APICALA',73),(966,73152,'CASABIANCA',73),(967,73168,'CHAPARRAL',73),(968,73200,'COELLO',73),(969,73217,'COYAIMA',73),(970,73226,'CUNDAY',73),(971,73236,'DOLORES',73),(972,73268,'ESPINAL',73),(973,73270,'FALAN',73),(974,73275,'FLANDES',73),(975,73283,'FRESNO',73),(976,73319,'GUAMO',73),(977,73347,'HERVEO',73),(978,73349,'HONDA',73),(979,73352,'ICONONZO',73),(980,73408,'LERIDA',73),(981,73411,'LIBANO',73),(982,73443,'MARIQUITA',73),(983,73449,'MELGAR',73),(984,73461,'MURILLO',73),(985,73483,'NATAGAIMA',73),(986,73504,'ORTEGA',73),(987,73520,'PALOCABILDO',73),(988,73547,'PIEDRAS',73),(989,73555,'PLANADAS',73),(990,73563,'PRADO',73),(991,73585,'PURIFICACION',73),(992,73616,'RIOBLANCO',73),(993,73622,'RONCESVALLES',73),(994,73624,'ROVIRA',73),(995,73671,'SALDA¥A',73),(996,73675,'SAN ANTONIO',73),(997,73678,'SAN LUIS',73),(998,73686,'SANTA ISABEL',73),(999,73770,'SUAREZ',73),(1000,73854,'VALLE DE SAN JUAN',73),(1001,NULL,'prueba',5),(1002,NULL,'SAN PEDRO DE LOS MILAGROS',5),(1003,NULL,'tuchin',23),(1004,NULL,'ARMENIA',63),(1005,NULL,'BUENAVENTURA',76),(1006,NULL,'PUERTO ASIS',86),(1007,NULL,'CALI',76),(1008,NULL,'MOCOA',86),(1009,NULL,'LA HORMIGA',86),(1010,NULL,'ORITO',86),(1011,NULL,'MOÑITOS',23),(1012,NULL,'LA LOMA',20);
/*!40000 ALTER TABLE `mamunicipio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mapatameter`
--

DROP TABLE IF EXISTS `mapatameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mapatameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numInicial` int(11) DEFAULT NULL,
  `numFinal` int(11) DEFAULT NULL,
  `numfactura` int(11) DEFAULT NULL,
  `prefijo` varchar(45) DEFAULT NULL,
  `NResolucionDian` int(11) DEFAULT NULL,
  `fechaResolucion` date DEFAULT NULL,
  `activo` tinyint(4) DEFAULT NULL,
  `idtipo` int(11) DEFAULT NULL COMMENT '1: remisiones\n2: facutacion',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mapatameter`
--

LOCK TABLES `mapatameter` WRITE;
/*!40000 ALTER TABLE `mapatameter` DISABLE KEYS */;
INSERT INTO `mapatameter` VALUES (1,1,200,1,'FA',15456,'2015-05-16',1,1),(2,1,200,1,'RA',15645,'2015-05-16',1,2);
/*!40000 ALTER TABLE `mapatameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mapatametertipo`
--

DROP TABLE IF EXISTS `mapatametertipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mapatametertipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mapatametertipo`
--

LOCK TABLES `mapatametertipo` WRITE;
/*!40000 ALTER TABLE `mapatametertipo` DISABLE KEYS */;
INSERT INTO `mapatametertipo` VALUES (1,'Facturacion'),(2,'Remisión');
/*!40000 ALTER TABLE `mapatametertipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uidevolucion`
--

DROP TABLE IF EXISTS `uidevolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uidevolucion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `iddevoluciontipo` int(11) NOT NULL,
  `idFacturadetalleTalla` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_table1_iudevoluciontipo1_idx` (`iddevoluciontipo`),
  KEY `fk_uiDevolucion_iuFacturadetalleTalla1_idx` (`idFacturadetalleTalla`),
  CONSTRAINT `fk_table1_iudevoluciontipo1` FOREIGN KEY (`iddevoluciontipo`) REFERENCES `iudevoluciontipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uiDevolucion_iuFacturadetalleTalla1` FOREIGN KEY (`idFacturadetalleTalla`) REFERENCES `iufacturadetalletalla` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uidevolucion`
--

LOCK TABLES `uidevolucion` WRITE;
/*!40000 ALTER TABLE `uidevolucion` DISABLE KEYS */;
/*!40000 ALTER TABLE `uidevolucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uiformapago`
--

DROP TABLE IF EXISTS `uiformapago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uiformapago` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `forma` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uiformapago`
--

LOCK TABLES `uiformapago` WRITE;
/*!40000 ALTER TABLE `uiformapago` DISABLE KEYS */;
INSERT INTO `uiformapago` VALUES (1,'Credito'),(2,'Contado');
/*!40000 ALTER TABLE `uiformapago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uimaestadotarea`
--

DROP TABLE IF EXISTS `uimaestadotarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uimaestadotarea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uimaestadotarea`
--

LOCK TABLES `uimaestadotarea` WRITE;
/*!40000 ALTER TABLE `uimaestadotarea` DISABLE KEYS */;
/*!40000 ALTER TABLE `uimaestadotarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uimodulo`
--

DROP TABLE IF EXISTS `uimodulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uimodulo` (
  `id` int(11) NOT NULL,
  `nomModulo` varchar(45) DEFAULT NULL,
  `icon` varchar(250) DEFAULT NULL,
  `url` varchar(250) DEFAULT NULL,
  `item` varchar(250) DEFAULT NULL,
  `activo` tinyint(4) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  `children` tinyint(4) DEFAULT NULL COMMENT 'tiene hijos si o no',
  `actionListen` tinyint(4) DEFAULT NULL,
  `parameters` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uimodulo`
--

LOCK TABLES `uimodulo` WRITE;
/*!40000 ALTER TABLE `uimodulo` DISABLE KEYS */;
INSERT INTO `uimodulo` VALUES (1,'Dashboard','dashboard','dashboard','',1,0,0,0,NULL),(2,'Facturación','dashboard','Admon','',1,0,2,0,NULL),(4,'Consultas','dashboard','Admon','',1,0,1,0,NULL),(10,'Configuración','dashboard','Admon','',1,0,1,0,NULL),(201,'Facturar','dashboard','Admon','navegacion/Facturar/Facturar.xhtml',1,2,0,1,'{\"tipofacturacion\":\"1\",\"Titulo\":\"Factura\"}'),(202,'Remisiones','dashboard','Admon','navegacion/Facturar/Facturar.xhtml',1,2,0,1,'{\"tipofacturacion\":\"2\",\"Titulo\":\"Remisión\"}'),(305,'Terceros','dashboard','Admon','navegacion/Terceros/Proveedores.xhtml',1,3,0,1,NULL),(401,'Facturas','dashboard','Admon','navegacion/Consultar/Facturas.xhtml',1,4,0,1,'{\"tipofacturacion\":\"1\",\"Titulo\":\"Factura\",\"estado\":\"1\"}'),(402,'Remisiones','dashboard','Admon','navegacion/Consultar/Facturas.xhtml',1,4,0,1,'{\"tipofacturacion\":\"2\",\"Titulo\":\"Remisión\",\"estado\":\"1\"}'),(403,'Anulaciones','dashboard','Admon','navegacion/Consultar/Facturas.xhtml',1,4,0,1,'{\"tipofacturacion\":\"3\",\"Titulo\":\"Anulaciones\",\"estado\":\"2\"}'),(1001,'Referencia','dashboard','Admon','navegacion/referencia/referencia.xhtml',1,10,0,1,NULL),(1002,'Tallas','dashboard','Admon','navegacion/tallaje/tallaje.xhtml',1,10,0,1,NULL),(1003,'Colores','dashboard','Admon','navegacion/Color/color.xhtml',1,10,0,1,NULL),(1004,'Inventario','dashboard','Admon','navegacion/Invetario/Invetario.xhtml',1,10,0,1,NULL),(1005,'Terceros','dashboard','Admon','navegacion/Invetario/Invetario.xhtml',1,10,0,1,NULL),(1006,'Regiones','dashboard','Admon','navegacion/Municipios/Municipios.xhtml',1,10,0,1,NULL),(100501,'Proveedores','dashboard','Admon','navegacion/Terceros/Proveedores.xhtml',1,1005,0,1,NULL),(100502,'Clientes','dashboard','Admon','navegacion/Terceros/Clientes.xhtml',1,1005,0,1,NULL),(100503,'Vendedores','dashboard','Admon','navegacion/Terceros/Vendedores.xhtml',1,1005,0,1,'');
/*!40000 ALTER TABLE `uimodulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uireferencia`
--

DROP TABLE IF EXISTS `uireferencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uireferencia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codReferncia` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `activo` tinyint(4) DEFAULT NULL,
  `descuento` double DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uireferencia`
--

LOCK TABLES `uireferencia` WRITE;
/*!40000 ALTER TABLE `uireferencia` DISABLE KEYS */;
INSERT INTO `uireferencia` VALUES (1,'3129','Torero Clasico',44900,1,NULL),(2,'3213','Short',41900,1,NULL),(3,'3330','Pantalon Elegante',56900,0,NULL),(4,'3250','Pantalon Tallas Grandes',56900,0,NULL),(5,'3331','Pantalon Pesta. Pespuntada',56900,0,NULL),(6,'3332','Pantalon Ribete Sin Pespunte',56900,0,NULL),(7,'3211','Indigo Bota Campana',65900,0,NULL),(8,'1009','Indigo',65900,0,NULL),(9,'3335','Pantalon Desflecado',56900,0,NULL),(10,'3334','Torero Bolsillo Parche',44900,0,NULL),(11,'1008','Indigo',65900,0,NULL),(12,'3323','Pantalon Bota Tubo',56900,0,NULL),(13,'3336','Short Con Cinturon de Rayas',41900,0,NULL),(14,'1011','Indigo',65900,0,NULL),(15,'3175','Pantalon Bota Recta',56900,0,NULL);
/*!40000 ALTER TABLE `uireferencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uireferenciadetallefile`
--

DROP TABLE IF EXISTS `uireferenciadetallefile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uireferenciadetallefile` (
  `iduireferenciadetallefile` int(11) NOT NULL AUTO_INCREMENT,
  `nameFile` varchar(1000) DEFAULT NULL,
  `extencion` varchar(10) DEFAULT NULL,
  `idreferenciadetalle` int(11) DEFAULT NULL,
  PRIMARY KEY (`iduireferenciadetallefile`),
  KEY `idreferenciadetalle_pk_idx` (`idreferenciadetalle`),
  CONSTRAINT `idreferenciadetalle_pk` FOREIGN KEY (`idreferenciadetalle`) REFERENCES `uireferenciadetalles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uireferenciadetallefile`
--

LOCK TABLES `uireferenciadetallefile` WRITE;
/*!40000 ALTER TABLE `uireferenciadetallefile` DISABLE KEYS */;
INSERT INTO `uireferenciadetallefile` VALUES (1,'images.jpg','jpg',1),(2,'images2jpg.jpg','jpg',1),(3,'images.jpg','jpg',2),(4,'pantalon_randonnee_nature_homme_nh100_beige_quechua_8356066_752766.jpg','jpg',2),(5,'images2jpg.jpg','jpg',2);
/*!40000 ALTER TABLE `uireferenciadetallefile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uireferenciadetalles`
--

DROP TABLE IF EXISTS `uireferenciadetalles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uireferenciadetalles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `idreferencia` int(11) NOT NULL,
  `idColor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_uiReferenciaDetalles_uireferencia1_idx` (`idreferencia`),
  KEY `fk_uiReferenciaDetalles_iuColores1_idx` (`idColor`),
  CONSTRAINT `fk_uiReferenciaDetalles_iuColores1` FOREIGN KEY (`idColor`) REFERENCES `iucolores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uiReferenciaDetalles_uireferencia1` FOREIGN KEY (`idreferencia`) REFERENCES `uireferencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uireferenciadetalles`
--

LOCK TABLES `uireferenciadetalles` WRITE;
/*!40000 ALTER TABLE `uireferenciadetalles` DISABLE KEYS */;
INSERT INTO `uireferenciadetalles` VALUES (1,'',1,1),(2,'',1,2),(3,'',2,2),(4,'',3,2),(5,'BLANCO',3,2);
/*!40000 ALTER TABLE `uireferenciadetalles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uireferenciagrupotalla`
--

DROP TABLE IF EXISTS `uireferenciagrupotalla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uireferenciagrupotalla` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idreferencia` int(11) NOT NULL,
  `idGrupoTalla` int(11) NOT NULL,
  PRIMARY KEY (`id`,`idreferencia`,`idGrupoTalla`),
  KEY `fk_iuReferenciaGrupoTalla_uireferencia1_idx` (`idreferencia`),
  KEY `fk_iuReferenciaGrupoTalla_idGrupoTalla1_idx` (`idGrupoTalla`),
  CONSTRAINT `fk_iuReferenciaGrupoTalla_idGrupoTalla1` FOREIGN KEY (`idGrupoTalla`) REFERENCES `iugrupotalla` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iuReferenciaGrupoTalla_uireferencia1` FOREIGN KEY (`idreferencia`) REFERENCES `uireferencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uireferenciagrupotalla`
--

LOCK TABLES `uireferenciagrupotalla` WRITE;
/*!40000 ALTER TABLE `uireferenciagrupotalla` DISABLE KEYS */;
INSERT INTO `uireferenciagrupotalla` VALUES (1,1,2),(2,1,1),(3,2,1),(5,2,2);
/*!40000 ALTER TABLE `uireferenciagrupotalla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uireferenciavalorhitorico`
--

DROP TABLE IF EXISTS `uireferenciavalorhitorico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uireferenciavalorhitorico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `idReferencia` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_uiReferenciaValorHitorico_uireferencia1_idx` (`idReferencia`),
  CONSTRAINT `fk_uiReferenciaValorHitorico_uireferencia1` FOREIGN KEY (`idReferencia`) REFERENCES `uireferencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uireferenciavalorhitorico`
--

LOCK TABLES `uireferenciavalorhitorico` WRITE;
/*!40000 ALTER TABLE `uireferenciavalorhitorico` DISABLE KEYS */;
/*!40000 ALTER TABLE `uireferenciavalorhitorico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uirefernciacosto`
--

DROP TABLE IF EXISTS `uirefernciacosto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uirefernciacosto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(255) DEFAULT NULL,
  `cantidad` decimal(18,2) DEFAULT NULL,
  `valor` decimal(18,2) DEFAULT NULL,
  `uireferencia_id` int(11) NOT NULL,
  `uiUnidadMedida_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_uiRefernciaCosto_uireferencia1_idx` (`uireferencia_id`),
  KEY `fk_uiRefernciaCosto_uiUnidadMedida1_idx` (`uiUnidadMedida_id`),
  CONSTRAINT `fk_uiRefernciaCosto_uiUnidadMedida1` FOREIGN KEY (`uiUnidadMedida_id`) REFERENCES `uiunidadmedida` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uiRefernciaCosto_uireferencia1` FOREIGN KEY (`uireferencia_id`) REFERENCES `uireferencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uirefernciacosto`
--

LOCK TABLES `uirefernciacosto` WRITE;
/*!40000 ALTER TABLE `uirefernciacosto` DISABLE KEYS */;
INSERT INTO `uirefernciacosto` VALUES (1,'laterales lona',2.00,200.00,1,1),(2,'estampado',1.00,2000.00,1,1),(3,'tela codra',1.00,2000.00,1,2);
/*!40000 ALTER TABLE `uirefernciacosto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uirol`
--

DROP TABLE IF EXISTS `uirol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uirol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Rol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Tres roles -Admin -operario -Invitado';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uirol`
--

LOCK TABLES `uirol` WRITE;
/*!40000 ALTER TABLE `uirol` DISABLE KEYS */;
INSERT INTO `uirol` VALUES (1,'Administrador'),(2,'Admon Municipal'),(3,'Cliente');
/*!40000 ALTER TABLE `uirol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uitarea`
--

DROP TABLE IF EXISTS `uitarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uitarea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `fehaMaximo` date DEFAULT NULL,
  `Uisuario_emi` int(11) NOT NULL,
  `Uisuario_rec` int(11) NOT NULL,
  `UiEstado_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_uitarea_uiusuario2_idx` (`Uisuario_rec`),
  KEY `fk_uitarea_uimaestadotarea1_idx` (`UiEstado_id`),
  KEY `fk_uitarea_usuario3` (`Uisuario_emi`),
  CONSTRAINT `fk_uitarea_uimaestadotarea1` FOREIGN KEY (`UiEstado_id`) REFERENCES `uimaestadotarea` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uitarea_uiusuario1` FOREIGN KEY (`Uisuario_emi`) REFERENCES `uiusuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uitarea_uiusuario2` FOREIGN KEY (`Uisuario_rec`) REFERENCES `uiusuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uitarea`
--

LOCK TABLES `uitarea` WRITE;
/*!40000 ALTER TABLE `uitarea` DISABLE KEYS */;
/*!40000 ALTER TABLE `uitarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uitercero`
--

DROP TABLE IF EXISTS `uitercero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uitercero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nitocedula` varchar(15) DEFAULT NULL,
  `digito` varchar(1) DEFAULT NULL,
  `Razonsocial` varchar(45) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `ext1` varchar(45) DEFAULT NULL,
  `telefono2` varchar(10) DEFAULT NULL,
  `ext2` varchar(45) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `idmunicipio` int(11) NOT NULL,
  `idtercerotipo` int(11) NOT NULL,
  `idVendedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_uitercero_mamunicipio1_idx` (`idmunicipio`),
  KEY `fk_uitercero_uitercerotipo_idx` (`idtercerotipo`),
  KEY `fk_uitercero_uivenddor_idx` (`idVendedor`),
  CONSTRAINT `fk_uitercero_mamunicipio1` FOREIGN KEY (`idmunicipio`) REFERENCES `mamunicipio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uitercero_uitercerotipo` FOREIGN KEY (`idtercerotipo`) REFERENCES `uitercerotipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uitercero_uivenddor` FOREIGN KEY (`idVendedor`) REFERENCES `uivendedor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uitercero`
--

LOCK TABLES `uitercero` WRITE;
/*!40000 ALTER TABLE `uitercero` DISABLE KEYS */;
INSERT INTO `uitercero` VALUES (1,'8414963',NULL,'ALBEIRO GOMEZ','3146326905','','','','Calle 9 #9-71 Almacen punto clave 2do piso parque pp','',11,2,2),(2,'43064227',NULL,'LUCELLY DEL REAL ARBELAEZ','3003757058','','','','Calle 58 #49-14 el congolo','',19,2,1),(3,'50916848',NULL,'SORAIDA VELASQUEZ','3107412030','','','','Calle 98 #102-28','',36,2,2),(4,'8435796',NULL,'ALEXANDER URREGO','3146462463','','','','Calle 96 Carrera 102-08','',36,2,2),(5,'39351081',NULL,'GLORIA HOYOS HOYOS','0342890413','','','','Cr.15 #5d-23 Almacen Gloria','',51,2,2),(6,'30666242',NULL,'SUJEY GOMEZ','3127810251','','','','Cl.10 #11-16 Almacen Pague Menos','',431,2,3),(7,'900921984','9','SUPERMODA CORDOBA','0347810920','','','','Cl.35 #2-54 Almacen Intermoda','',429,2,3),(8,'64574110','8','MARIA CLARETH VARLIZA','0352825645','','','','Cl.21 #21-75 Almacen Modas Iris','',931,2,3),(9,'1005566067',NULL,'BRAYAN ZULUAGA RIEDEL','3205092201','','','','Diagonal 2 #6a-06 Almacen Mercagangas','',956,2,3),(10,'70352072','5','LUIS EVELIO FRANCO','4158516','','','','Cl.12 #9-44 Almacen la Casa del Remate','',671,2,3),(11,'70195642',NULL,'HILDA GUTEIRREZ Y/O SIMON RUIZ','3103718421','','','','Cr.50 #45a-25 Almacen tu imagen','',1002,2,2),(12,'92559714','5','CARLOS ANDRES TOVIO','2858151','','','','Cr.25 #32-21 Almacen Tendencias','',935,2,3),(13,'92188098',NULL,'EDER GONZALEZ GUERRA','3215386148','','3135629969','','Cr.13 #8-09 Centro Almacen Variedades San Pedro #1','',952,2,3),(14,'43191986','1','YESICA NASAR VIÑAS','0356878293','','3155556878','','Cl. las Flores #12-50 Almacen Jovenes','',166,2,3),(15,'45515627','2','DORIS YANETH QUINTERO ZULUAGA','0356720447','','','','Avd. Pedro de Heredia #30-01 Distribuidora Nacional','',150,2,3),(16,'21778105','0','ROSA GOMEZ','3005678820','','','','Edf. Bombay Local #2 Almacen Rochis','',150,2,3),(17,'30894878',NULL,'SHIRLY COTA MONTERO','3007406307','','','','Bruselas Trans.40 #26a-32 Almacen Variedades Yulis','',150,2,3),(18,'5222263','4','SONIA SALAZAR','3114993746','','','','Cr.19a #8-65 Lc.437 Entrada 10 Bodega el verde sanandresito san jose','',149,2,2),(19,'43777555',NULL,'JOSE FLADER NARANJO','3206125357','','','','Cr.14 #17-52','',818,2,2),(20,'29934685',NULL,'NOELMA JARAMILLO','3162288885','','','','Cl.3 #36-39','',1005,2,2),(21,'26649421',NULL,'MIRTA RIVERA QUESADA','3133622344','','','','Cl.13a #10 Este casa roja porton negro diagonal a la tienda de cabrera','',358,2,3),(22,'8520227','1','LUIS EDUARDO LOPEZ MARTINEZ Y/O WILSON PAVON','3205728818','','3135331279','','Cl.18 #18-22','',409,2,3),(23,'1035520371','7','YOLIMA AGUDELO','3046071555','','','','Cr.3 #17-33 Almacen Tendencias Fashion','',171,2,3),(24,'51857435',NULL,'LUCIA GUTIERREZ HOYOS','3116608691','','','','Cl.14 #14-58 Almacen Temporadas Calle del Comercio','',433,2,3),(25,'901155149','2','INVERSIONES TORRES S.A.S.','3046290881','','','','Cl.7-Cr.2a Esquina Almacen Multicentro Taiwan','',663,2,3),(26,'28402015','8','BLETH RODRIGUEZ MUÑOZ','4240728','','','','Cl.17 #11-104 Almacen Contraste','',409,2,3),(27,'70694795','4','CARLOS MARIO SALAZAR','0354132002','','3106307184','','Cl.6 #8-18 Almacen Metamoxfosis','',666,2,3),(28,'36380358',NULL,'ELVIA LUCIA GARCIA','3183869585','','','','Cl.5 #5-08 Almacen Koketas','',620,2,2),(29,'21872261',NULL,'AMPARO ZULUAGA','3142275386','','','','Cl.10 #20-11 Almacen Surtimodas','',1006,2,3),(30,'70901971','8','LUIS ALBERTO ARBELAEZ','8712500','','','','Cl.8 #5-27 Almacen Hilachas Medellin','',603,2,3),(31,'67011241','1','DIANA MILENA MESA REYES','3188457215','','','','Cr.40b #27-77 Almacen Fashion Desian Boutique','',1007,2,3),(32,'30507201','0','BETTY VALENCIA RINCON','3143443363','','','','Cl.7 #3-35 Almacen Facelook','',627,2,3),(33,'40076787',NULL,'MARLEY NUÑEZ','3212484762','','','','Cl.21 #1b-16 Barrio las acacias','',346,2,3),(34,'40780805',NULL,'CONSUELO NIETO','3143505528','','','','C.C. la Perdiz Local 175-176 Almacen Arsago sport','',346,2,3),(35,'69005220','8','TANIA ISABEL CORDOBA F.','3108108748','','','','Cl.8 #6-45 Almacen Tania','',1008,2,3),(36,'70698170',NULL,'CESAR RAMIREZ','4287233','','','','Cl.9 #16-73 Almacen Terremoto','',1009,2,3),(37,'41107832','1','YANETH CAMACHO','4292314','','','','Cl.8 #10-13 Almacen Jamar','',1010,2,3),(38,'98.654.276','9','DIDIER ALBERTO CARDONA NARANJO','3156264634','','','','Cl.17 #6-104 Almacen el buen precio','',442,2,3),(39,'34947079','3','DARELYS HOYOS ARRIOLA','3147867391','','','','Cl.Cordoba Almacen Daren Fashion','',430,2,3),(40,'39280583','4','YEIMIN ELENA JARANA','3226593134','','','','Cl.19 #1-06 Almacen el Pasaje','',35,2,3),(41,'39287085',NULL,'MARISELA GARCIA','3232857439','','','','Cl.11 #2-10 Almacen Love Tienda','',35,2,3),(42,'15320338','1','LEONEL FERNANDEZ ARANGO','3117298397','','','','Cl.21 #2-10 Almacen Marcas y Marcas','',35,2,3),(43,'901181807','0','MP RETAIL S.A.S.','2771151','105-106','','','Cl.22 #20-68 Barrio Centro','',931,2,3),(44,'64562639','1','SARAY MONTES PEREZ','3004299972','','','','Gran Centro el Parque Local D-6 Almacen Saray Buty','',931,2,3),(45,'13617157','4','ISMAEL PERILLA VELASQUEZ','3117350529','','','','Cl.20 #19-27 Local C-18 el Parque Almacen Gran Centro','',931,2,3),(46,'43450836','7','MARISELY GIRALDO MARIN','3126421307','','','','Cl.17 #7-44 Almacen la Feria de las Promociones','',435,2,3),(47,'70351285',NULL,'JOSE FRANCO','3103711943','','','','Cl.15 #27-27 Almacen Medellin','',950,2,3),(48,'15673498',NULL,'JORGE LUIS FABRA','3114148562','','','','Cr.7 #19-27 Almacen Variedades Erika','',444,2,3),(49,'70828353','4','ALDIVER IDARRAGA','3106453239','','','','Cl.9 #14-45 Almacen Moda Olafo','',455,2,3),(50,'51857435',NULL,'LUCIA GUTIERREZ','3116608691','','','','Cl.14 #14-58 Almacen Temporadas','',433,2,3),(51,'900226241','4','GARCIA OCAMPO S.A.','7890376','','','','Cl.35 #3-05 Almacen Centro de la Moda','',429,2,3),(52,'78023122','3','ASTOLFO MONTES','3126924452','','','','Cereabastos Local 04-05 Almacen Astolfo','',433,2,3),(53,'11039594',NULL,'DAVID FLOREZ GARCIA','3126607622','','','','Cr.7 Local 10-05 Almacen El Gordo','',452,2,3),(54,'42692878',NULL,'ORLANDO PINTO','3114211976','','','','Cr.3 #23a-26 Almacen Dos Mundos','',1011,2,3),(55,'30646298',NULL,'LUZ MARINA GIRALDO','7735563','','','','Cl.1 #20-29 Almacen La Casa Del Vestido','',439,2,3),(56,'1044921509','1','CLAUDIA ESCOBAR FERIA','3004412019','','','','Cl.2 #19-24 Almacen la Feria de la Moda','',439,2,3),(57,'45556046','9','KAROL PEREZ','3004412019','','','','Cr.20 #2a-50 Almacen el Punto de la Moda','',439,2,3),(58,'70756591','0','DIEGO FLOREZ','3004412019','','','','Cl.4 #19-30 Almacen D y C Tienda de Moda','',439,2,3),(59,'94351048','0','RAMIRO GRANADA','3004412019','','','','Cr.20 #3-25 Almacen Colombia Moda','',439,2,3),(60,'11037195','8','LUIS CANTILLO BANDA','3183306829','','','','Cl.12 #16-49','',1003,2,3),(61,'1003502436',NULL,'VIVIANA NAJERA HOYOLA','3023735895','','','','Cr.11 #13-24 Almacen Expomoda','',449,2,3),(62,'92188098','3','EDER GONZALEZ','3135629969','','3215386149','','Cr.13 #8-9 Centro Almacen Variedades San Pedro #1','',952,2,3),(63,'33200853','4','ROSMIRA AGUILAR','3016128947','','','','Cl. las Damas Trans.3b #12c-41 Almacen Centro de la Economia','',166,2,3),(64,'811045172','4','PROVEDORA LA CACHAQUERA','3146190341','','','','Cr.14a #Cl.11 Esquina Almacen la Cachaquera','',672,2,3),(65,'901155149','2','CARLOS ALONSO TORRES','3046290881','','','','Cl.7 Cr.2a Esquina Almacen Multicentro Taiwan','',663,2,3),(66,'70.694.755',NULL,'CARLOS MARIO SALAZAR','4292845','','','','Cl.7 #2a-66 Almacen Centro de la Moda','',663,2,3),(67,'901126772','8','ALMACEN MEDELLIN 2F S.A.S.','3104196336','','','','Cl.4 #6-69 Almacen Medellin','',1012,2,3),(68,'70008202','8','LUZ ADRIANA RAMIREZ','5781192','','','','Cl.18 #18-23 Almacen Gangazo Paisa','',409,2,3),(69,'1000393622','8','ESTEFANIA CIFUENTES','3106449551','','','','Cr.16 #12-35 Almacen Black White','',406,2,3),(70,'39034775','8','LEDYS CASTILLO','3184170347','','','','C.C. Aladino Almacen Moda y Color','',126,2,3),(71,'63523835',NULL,'ANDREA LIZCANO SILVA','6338766','','','','Cr.18 #33-44 Almacen Andrea Lizcano','',844,2,3),(72,'43450856',NULL,'NANCY GARCIA GOMEZ','3145970248','','','','Cr.13 #13-52 Centro Almacen Paguemenos','',129,2,3),(73,'43450433','2','SORAIDA DUQUE GOMEZ','3112865859','','3046095884','','Cl.20 #18-70 Almacen La Estrella De La Moda','',95,2,3),(74,'24728266',NULL,'OLGA LUCIA GIRALDO','2580212','','','','Cl.6 #7-76 Almacen Giraldo','',975,2,3),(75,'900634154','1','TIENDA 1A JR S.A.S.','8710181','','','','Cr.5 #7-68 Almacem Color de Verano','',603,2,3),(76,'36276906','3','AMALY ROJAS CASTRO','8361768','','','','Cl.8 #3-45 Almacen Orlan Sport','',627,2,3),(77,'30507201',NULL,'BETTY VALENCIA RINCON','3143443363','','','','Cl.7 #3-35 Almacen Facelook','',627,2,3),(78,'36173231','8','ELVIA SUPELANO','3125605376','','','','Cl.8 #3-20 Almacen Saray Jeans','',627,2,3),(79,'26598911','6','BETURIA MORA','3138588742','','3125758866','','Cl.7 #2-34 Almacen Pantys y Pantys','',627,2,3),(80,'26598910',NULL,'SOFIA MORA','3112379899','','','','Cl.9 #3-31 Almacen Modas y Accesorios Sofi','',637,2,3),(81,'26599358','7','LUZ DARY MORA','3154907586','','','','Cr.4 #8-04 Almacen Koqueta J.C.','Cr',637,2,3);
/*!40000 ALTER TABLE `uitercero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uitercerotipo`
--

DROP TABLE IF EXISTS `uitercerotipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uitercerotipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Tercero` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uitercerotipo`
--

LOCK TABLES `uitercerotipo` WRITE;
/*!40000 ALTER TABLE `uitercerotipo` DISABLE KEYS */;
INSERT INTO `uitercerotipo` VALUES (1,'Proveedor'),(2,'Cliente');
/*!40000 ALTER TABLE `uitercerotipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uiunidadmedida`
--

DROP TABLE IF EXISTS `uiunidadmedida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uiunidadmedida` (
  `id` int(11) NOT NULL,
  `Unidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uiunidadmedida`
--

LOCK TABLES `uiunidadmedida` WRITE;
/*!40000 ALTER TABLE `uiunidadmedida` DISABLE KEYS */;
INSERT INTO `uiunidadmedida` VALUES (1,'UN'),(2,'Mt'),(3,'Cm'),(4,'ML'),(5,'Par');
/*!40000 ALTER TABLE `uiunidadmedida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uiusuario`
--

DROP TABLE IF EXISTS `uiusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uiusuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `password` char(40) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `avatar` text,
  `theme` varchar(100) DEFAULT NULL,
  `verticalMenu` tinyint(1) DEFAULT NULL,
  `layout` varchar(100) DEFAULT NULL,
  `UiRol_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_UiUsuario_UiRol1_idx` (`UiRol_id`),
  CONSTRAINT `fk_UiUsuario_UiRol1` FOREIGN KEY (`UiRol_id`) REFERENCES `uirol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='tabla que almacena los datos de autenticación del usuario.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uiusuario`
--

LOCK TABLES `uiusuario` WRITE;
/*!40000 ALTER TABLE `uiusuario` DISABLE KEYS */;
INSERT INTO `uiusuario` VALUES (1,'Admon','Admin','40bd001563085fc35165329ea1ff5c5ecbdbbeef','juligrva@hotmail.com','234234',1,'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAABRFBMVEUuWHH////7YCDxyaXktpKRXyzrwJwmWHOHXjWUXyglU23oupaNWiUeT2oLSGWYZzb7VQD2zqrh5umVXyYERmT6z6ghUGv7UAD7VwD7WxTL09nCy9KKUg8WS2dEaH5ogpPn3dWcrLf19/hWa3l0i5s6YXiRo69yXEiwvMWGmqemtL7Y3uJBZn1VdIc9WWmaajpnW1IOWHWFgX+1pJP9q5LOqo36vqy4jGOoeEz6ZSj87un59fLMnXf74dh/XT3+2s+imI39y7xVWlxKWWTsaTn8kXD7cDrOZ0jKbVB2Z2z338v8gFbu1MCpZFb9o4n9t6GfaWDjckvryK+8dmPfb0r4iWT4ajL60MT8f1NoZG7mYzH8mny1YEt9XV/XYjt8aW3mo5CSZ2NtdXrdu51sXEyUjojBqpWPlZi0lXrXx7nElW6jfFhUhHEjAAAQgUlEQVR4nNWd+VsaSRrHqxFtaRpEIGhrGgMCQSMx5ELFZMYcTq5xMpOYZHeObC5nNvv//75VfUAfdXa/rfjdeeaZuFj0J+9b7/vW2UjLXO3q2nq/tdXZGDR3ugih7k5zsNHZavXX16rt7L8eZdl4e62/NeiWyrZdahiGgabCf2qUbLtc6g62+muZcmZF2F7vDTAaJkN8EdJyadBbzwozC8J2v9O1bSFbmNO2u51+FpTQhO21XrNuq8AFMO16swfusqCE7fVOSc12FFuWOrAOC0hI8NLQTU2JIeEeC4qw2jNA8HxIo1cFejIYwv6g3ADDc9UoD/ogzwZA2G7BeGdU2FtbAD0yNWG1Y5cywHNVsjupnTUlYXWjnoX5pjLqGykZUxFWN8rZ8jmM5XSMKQgzt9+EMZUdExO2e+dgvwljuZc45iQl7BvZxReaSkbS3JGM8MaOfa58RPbOjfMj3DpHB53KKG+dE+EaOl8HnaqE1s6DcKt+QXxEdXUzqhLe6EIXoGpqdFV7oyJhq3yhfETlVoaE7cH5h9C47IFSblQhXDMuIoTGZRgqAUeBsHWRISaseisLwo1Z8FBf9gY4Ybt5sTE0qkZTtjNKElZnpAtOZRiS4w05wrVZ8lBftly8kSLsz06MCaouNdyQIdyeTUCMuA1DOAN1DEtlCUQx4QwDSpVwQsIZyvM0iXO/iHB7li1IJHRUAWF/1gExoiCi8glnNE2EJUgaXMK1ywCIEbmpn0dYncVKhiabV8BxCNto1mpRlgzEKcM5hM3LAogRm0kIN2ZruMRXgz1eZBK2LksndGW3VAkvSRidihlQGYTty+SirhqMaMMgvERRxhcr2tAJexe1MpFGdk+e8MZl64SuytQJfyrhRT9qYskSdi5fmHHV6MgRrs/+iImlOmU/HIXw8oXRqQwZwq3L6qNEjfgKaozwxuX1UaJ4PI0R7lxmJ8VuuiMi7F+ugjsuOzqnESFsX24LEhltLiFsuabLCvJLSz0eYRUuzODHfnTr+sNFsR5ev/UIAVLabQ5hB8pJMd5ioVYoFObFwp+qFRYxJNB3Gx02YRWo4tZvXpdiC6pW+ArFWK8yCTdgTKjfqqnyuba8BYNobLAIoXrhYi0Bn2PHhzCI5SqDEMiEi0kM6JlxEeQJQkYMEML0Qj0FIEaEsWKwJwYIQQKp/jWpi7qqPYJADIbTKWEbpF67mcaCjiCeIpgTp4QtiHJG/5qWECaglloUQhAT6vFHNk01xEWQnliKE/ZBKtKbkV5omkt7e3umScEkP9zd21uK/l81iOdApX6McAASZx4VwhCjhWWihcO9+SAm+c+97/kiUX4UZqw9BngQZAyihDDZXr8VJDT3FpbnXC0vzy0cjojBTGLWkUOXd1XM7wURYaLpNOv7hDCzMyFC87vP51MSzRVdywVVHAUQgWq3yYyNTwhVkU4JzVEY0NNCnqJiwIpg1WmYcB1m8iJkQyognTBfBLchstdDhEADwwCheahE+N0Et2EnRAg0eREgXKIDMgjzeXAb+ikRQTppgDAaZkSE02ADRui5KYJ00kA+NPN0QCbh4YQQJltM3BRBOmkw4zNMyPTSIjih56YOIdg2bv1RzU/2yoR7sBkf+RvBHcIe1GLMlJDVDdmEfkeEqdqIGr0JYROqTfTYJ2R1Qzbhd3BC1PQJoSYRUYBwQZUw74ea2k2wp6m3PULA1Rh/9GSyANmEeXhCZ5UGAeYKFBgfsrohh9CPpWAP4+YLQtiFaxN52WJXndAvTQuA6zRdlxBmCsqV7hEykwWHcMlDBCQkE1IIrmQj0kXpkEO46/4uzDyNK1K4IcBsiMh8sEtIHxvyCffgCUlGREAzNJ70h4WUhECz3q7IbA0Cmkb0pF9PTXgdckXYJoSA676TGeE0hFCDJ0flKiYEPT3pDRDTEIIV3kS4+EbaNuTmBK/0TkEIN7QgKm1jQsCKBvmFaRpCuKINOVUNgt3wbBhXzVT50KylupUw9jxNTAjYHrI/ny0c7prJCHFNY+5+z9+7bUD6qYYAazYDnV0hU9uHCQnN+UMyGV68twlnRruN4JKF3p274kAsL4+SjC3MPX+yvwiHWK4iuGRhfJlgLI9YgBzCUWAxA2zWwV5DMOuGpK07V6YcTBNyCAOAxXtQT1VaR2DpcPMKk0qOMER7G8hPS9sIamRRusO2mzphHsqIjR7aAvrLMqT4pAmLm0DrM1sIqKQxJJ1UmhDITY0OAhodGt+ACe/A9B5jAw1AGkKNH+W6oTQhVEccIKDMIxtoZAnBQk0T7cA0NLOEOwhoshTcS8+ACLtQhMZt4EjzI1AWg5vuntFsgeAYG3KA0oRQtTeYl+JQA1mXggUazAcUS2e18sZ8cCOxM6loKmlDsJWGJlRNg7UDR1j8DBZnBlB1KVZDKmHIEBbvgM3hGgOosQWR/aMEogQhWLZHztgCanxIJIMoJoQEJONDyNVDZH/+ImIUERbztyGXGfAYfxv06LbRuP0lFeG9bzroKkNpG26uzW/ydjEF4eFn6MfpA86XutI3mRu+xITF0Sbs05D5UtAFUqId9k4TsQ2XIHe+EJWrkOsWrnT2njYRYfEQcpuCI7sNu/ZEpC+yFw9FhHuQ2xRcQa8fImc7RmIvhTpEOpGzfgi7BkwIWdv0RYTFkQm6EQN5a8Cg6/jI2XDCXD0kJ6DykQMzAcL5wldgQmcdHzxdfC2YtJS4vDyX/07Wh3dHdMrioQm71QR5ezGg04V+qxDfqOAfX5ufX3JOJO4Fj3b5hLvAm2mQt59GgyeMbhFezo+W/LN57g5EcoJtdFiMmBB4Mw3y9kSB7mtD7omEsBGXD6/6Rw1qV/H/vD+YZgiR7DaB3Uwz2dcGOrrwNg2FjLgw4ds9u3bt2tnu5IxTxISQu9gdeXsTIfeXEpFNQ8HNGMv+0bur/3gH5v656m9DnRrR2UALu11osr8U+jJdZ6+3mZ8cH/WPGZj/m5w+/p//o++Tg6TOcQtwwjb8Pm802c3um3By3Ofqf6/5OvM3vJtBH4U65TxVF36vvqNacCP0sr99GyMS1Zx/TX626xix6G3UrwEHmg78eQsiveZ1Mufk7yhyGH0p/Edz5JwKzmAXOwqctwA8M0Pk79c353exogfxI4Tz5hKW96ECMKFzAQjwuSdHj+c5ihKGBBxoJueewDPizXn27RhswsL8TVgTBs6ugRffnFt4mIRAt+8EFDh/CHaGdComIosQ9BSCq8AZUvB8QcbBjJt4GIQ16LFv5BwwdOGGyECYjkgnrEEPfVHkLHc7g7ufGfcpUQlr0ONCotB5/AzcNHAoWEgIPWhyFLlTIQM3ZSBSCAuPMwCM3ouRzeXBOiX3UwiB06CnyN0mGd0eTMn9UULwPO8pdj8N+PKFq3jujxDC53lPsTuGoGdrplqsFcyA5oN/KIBPcvuK3xMFdNcXRboe2mkTnPMubsJePxsQ5a6vDCo3T1zCrL6Ucl8bzJ17VHEIs/pK6p174AuJE10AIfXexEzqGkfnT0i/+xJ6MmOq8ydk3F8KdQdtVKUmm7CUTTnDuIM2i6zfKDU2v32ZYxDm733b1Eugh0YdMe8RBjaiYZebf5/NXQnvkgqvAReL+bO/N8s27Bcz74KG7IkNu9Hpj7WDuajiq9wvtPF6xyjDFcac+7zBrt4bdrfcV2jJEB44n7zR6w5hL9ujEkIs0ujD5qe3x16DYwnCsffZ47efmhCQkbchAr8bQR+iTz/tW9a+32Bsz0KMcMH/aA7/2ttPqS3JfzdCyvdb6MOPzzBeDstv8IWQ8NWEEAtDPvuYjlHwfosUqzS4870+dvHwk/rtjaOXfsUIfScd+79qHb9OYUjRO0oSv2dGH25i8+V8Wf5za68EhL/5HzxYnf72/rPNhIzi98wke1eQPnz+qzXly+UqBywjRgknfxUHlcDvW9avzxMxSrwrKMGMDeb7K8SXy61MCKM9MUI46YXag5VQC8kYZd73pP5eueHm2zAeseGDaXvLHMKF6cd+qEQbsd5uDlUfhoIT/5Hae9f07ptcDDBX+WHa3phDOJ5+7ChGiNt901UyY1nuvWtK784bfjyO82HCo0B7YyZhAFC7HyfEjMfPFcwo++48FT8dvqHx5XKr94PtjZephAuhL/1lldqS9UYBkQpD+6HsOyz1brwHeoS/hFt8sRAnfBX+yAmjKeutrKcqvMNS60nlfb37hPFUOesk0uL4twjhb+PIJ54y23oihxgt17iEclujh0zAnPU01uT4xdzChPBVlE/TTtmNPZFxVLV3yUq9D3j4E/OZctZLWqvjgxcvXr16cRDHwzpmNpaznkkgRutRAaHEO53152zAXG6f0S5b9EDjIT4X+qnqO50l3ss9fMYjrCgTrnBas96KjKj+Xm7xu9WHHLfCZRvVEzk64BHmcoK9REnerS6KNvomz4S5lQfshqmKF20hI/7MdVNWlBEQ8kfD+msuYbBskxKlaAuKH05ZUUZAyJ+14UVSQnif0zBNjJJmYkTeWn9kZkaekBtQ9X3uE0WLGqFYJY1PyHFTZhgVE2p9JqL+L8ET/a5IyE74rthuWo/OW6gQan3WSEr/WUBITfkcUYcowQZZ0bTMBxQRatsMxCGr5vb1TpGQ3xomfE130/K2oGERodaiIw753TA4FyWlA34oxfqL6qb1lqhlIaHWovVFfslGFJipkdEDIWEuGaAEobZNQRR1Q+WEKEiHWNafcTeti1xUjpAWUYXdMDyPIZYgHRLCP2JuKoii8oTaegyxK+qGOeuuEuHvor+xXO7fUcI6Zd4pIWFsI7goG+aoY2CePogJrQigzU30ioRa1QgVqYKi1NGxuNWAhE4a7YiGwSvV1Am1djM4mBIUpY5WVADH/LGTSxjsiI0mp9hORIjHiwFPHb4TP5BSupBIFqGOaLPHg8kJA4lRMDZ0pZQuxMmCaBpjWvJNKxBqa/6+EP2TBOGqyvjprkQ/nMzWGA25GKNOiDujuwg+/EOCMDZlypNoZOG26I6gStJdUJ1Q03qOpw6fyDyPyuiCO+czkVOalukTv0wpEmo3UEMm3xMpTCiOZZwUtzjE306duudIlVDTtur6RxmfUgmmDySSRY6MEevxFVCR1Am1NXHZ7UghmMqF0tzqnyohxlMCQk37z4oMokIwFUzSuLJWVGdGHCUi1B4cS/ylK0zVvJTJr8eqU7CukhFq2n1LPNyRr0wlym5LdXrSV1JCbXxSEQ4RZdsSTmFYlRPVVYKJEhPi5zoVdMeKbDDlz+jjDniqNiUSUgpC3B35jNLDfO4AH/Ml64CeUhFixpccRulhPnOBm/C9TMWXmhAzPmX2R+m6jVmzWZV09iNKTYj7490KC1KuAcbw16pU7qbof74ACLHuP6E6q2TdRg001sqTpPkhLBhC7Kwnq3FDSoaaeKCxKqsnqd3TExQh1tFp1FslQ00k0GDvPD2CeyxAQtyhjk5DlrQ+SP3afghv9fQocXanCZQQa/z+5N3Kqk9piX8hUNFYqyvvTt6D4mnwhEQH95/uY4e1wttMmXpfIWVnpbJ/eh8gdMaUBSHRwdHJh9WVFZlweHdlZfXDyVEWdERZETo6eH8knjQaH73PCs5RpoSO2lp77P6D5fyE/Ecb/9v5J/Pv/z+HIPWXzgdqbwAAAABJRU5ErkJggg==','bluegrey',0,'medellin',1),(2,'lukas','lukas','40bd001563085fc35165329ea1ff5c5ecbdbbeef','juligrva@hotmail.com','45355545',0,'data:image/png;base64,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','bluegrey',1,'moody',2),(3,'andres','1236','40bd001563085fc35165329ea1ff5c5ecbdbbeef','lukhack@gmail.com',NULL,NULL,NULL,NULL,1,NULL,3),(4,'andres','1235','40bd001563085fc35165329ea1ff5c5ecbdbbeef','lukhack@gmail.com',NULL,1,NULL,'bluegrey',1,'medellin',3),(5,'andres','5555','40bd001563085fc35165329ea1ff5c5ecbdbbeef','lukhack@gmail.com',NULL,1,NULL,'bluegrey',1,'medellin',3),(7,'andres','1234','40bd001563085fc35165329ea1ff5c5ecbdbbeef','lukhack@gmail.com',NULL,1,NULL,'bluegrey',1,'medellin',3),(8,'fffff','123','40bd001563085fc35165329ea1ff5c5ecbdbbeef','juligrva@hotmail.com',NULL,1,NULL,'bluegrey',1,'medellin',3),(9,'adfasdf','231asdf','140badff9be22344cb441351a4e7bf39522d7bda','lukhack@hotmail.com',NULL,1,NULL,'bluegrey',1,'medellin',3),(10,'asdfasdf','asdfasd','40bd001563085fc35165329ea1ff5c5ecbdbbeef','lukhack@gmail.com',NULL,1,NULL,'bluegrey',1,'medellin',3);
/*!40000 ALTER TABLE `uiusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uiusuariomodulo`
--

DROP TABLE IF EXISTS `uiusuariomodulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uiusuariomodulo` (
  `UiUsuario_id` int(11) NOT NULL,
  `UiModulo_id` int(11) NOT NULL,
  PRIMARY KEY (`UiUsuario_id`,`UiModulo_id`),
  KEY `fk_table1_UiUsuario1_idx` (`UiUsuario_id`),
  KEY `fk_table1_UiModulo1_idx` (`UiModulo_id`),
  CONSTRAINT `fk_table1_UiModulo1` FOREIGN KEY (`UiModulo_id`) REFERENCES `uimodulo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_UiUsuario1` FOREIGN KEY (`UiUsuario_id`) REFERENCES `uiusuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uiusuariomodulo`
--

LOCK TABLES `uiusuariomodulo` WRITE;
/*!40000 ALTER TABLE `uiusuariomodulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `uiusuariomodulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uivalorreferenciatercero`
--

DROP TABLE IF EXISTS `uivalorreferenciatercero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uivalorreferenciatercero` (
  `iditercero` int(11) NOT NULL,
  `idreferencia` int(11) NOT NULL,
  `valor` int(11) DEFAULT NULL,
  PRIMARY KEY (`iditercero`,`idreferencia`),
  KEY `fk_valorReferenciaTercero_uireferencia1_idx` (`idreferencia`),
  CONSTRAINT `fk_valorReferenciaTercero_uireferencia1` FOREIGN KEY (`idreferencia`) REFERENCES `uireferencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_valorReferenciaTercero_uitercero1` FOREIGN KEY (`iditercero`) REFERENCES `uitercero` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uivalorreferenciatercero`
--

LOCK TABLES `uivalorreferenciatercero` WRITE;
/*!40000 ALTER TABLE `uivalorreferenciatercero` DISABLE KEYS */;
/*!40000 ALTER TABLE `uivalorreferenciatercero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uivendedor`
--

DROP TABLE IF EXISTS `uivendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uivendedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` varchar(15) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `telefono2` varchar(10) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `idmunicipio` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uivendedor`
--

LOCK TABLES `uivendedor` WRITE;
/*!40000 ALTER TABLE `uivendedor` DISABLE KEYS */;
INSERT INTO `uivendedor` VALUES (1,'01','Bodega','2510157','','Carrera 45 #53-50 c.c. gran plaza piso 12 ofc.1207','rouiceconfecciones@gmail.com',1),(2,'3415310','Alejandro Pulgarin','3144578868','','','',1),(3,'8567315','Walter Gomez','3134370577','','','',1);
/*!40000 ALTER TABLE `uivendedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-02 10:38:10
