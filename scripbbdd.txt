CREATE DATABASE [IF NOT EXISTS] curso;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: curso
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `alumno_id` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  PRIMARY KEY (`alumno_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'brandon','caldarella'),(2,'ander','Pérez '),(3,'Sara ','del Pinar'),(4,'Julieta',' Casas'),(5,'Jorge','de la Cruz'),(6,'Sara','del Mar'),(7,'Julieta ','Ponce'),(8,'Manuela','del Pino'),(9,'Ana ','de la Torre'),(10,'Gabriela ','Posada');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `curso_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `horas` int NOT NULL,
  PRIMARY KEY (`curso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (10,'java',300),(12,'html',150),(14,'python',250),(16,'c++',300),(18,'javascript ',500);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imparticion`
--

DROP TABLE IF EXISTS `imparticion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imparticion` (
  `curso_codigo` int NOT NULL AUTO_INCREMENT,
  `curso_id` int NOT NULL,
  `profesor_id` int NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`curso_codigo`),
  KEY `fk_imparticion_curso_idx` (`curso_id`),
  KEY `fk_imparticion_profesor1_idx` (`profesor_id`),
  CONSTRAINT `fk_imparticion_curso` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`curso_id`),
  CONSTRAINT `fk_imparticion_profesor1` FOREIGN KEY (`profesor_id`) REFERENCES `profesor` (`profesor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2191 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imparticion`
--

LOCK TABLES `imparticion` WRITE;
/*!40000 ALTER TABLE `imparticion` DISABLE KEYS */;
INSERT INTO `imparticion` VALUES (2177,10,25,'2020-03-04'),(2189,10,29,'2021-05-17'),(2190,12,27,'2022-01-20');
/*!40000 ALTER TABLE `imparticion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participantes`
--

DROP TABLE IF EXISTS `participantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participantes` (
  `alumno_id` int NOT NULL,
  `curso_codigo` int NOT NULL,
  `resenia` longtext COMMENT 'comentario sobre tu valoracion',
  `valoracion` int NOT NULL COMMENT 'siendo la valoracion del 1 al 5 \n\n1 como muy malo\n5 como bueno',
  KEY `fk_participantes_alumno1_idx` (`alumno_id`),
  KEY `fk_participantes_imparticion1_idx` (`curso_codigo`),
  CONSTRAINT `fk_participantes_alumno1` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`alumno_id`),
  CONSTRAINT `fk_participantes_imparticion1` FOREIGN KEY (`curso_codigo`) REFERENCES `imparticion` (`curso_codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participantes`
--

LOCK TABLES `participantes` WRITE;
/*!40000 ALTER TABLE `participantes` DISABLE KEYS */;
INSERT INTO `participantes` VALUES (1,2177,'hola',5),(1,2177,'hola',5),(1,2189,'bien',4),(1,2190,'puede mejorar',3),(2,2177,'exelente',5),(2,2190,'bien',4),(2,2189,'malo',1),(7,2177,'bien',4),(1,2177,'hola',5),(1,2189,'bien',4),(1,2190,'puede mejorar',3),(2,2177,'exelente',5),(2,2190,'bien',4),(2,2189,'malo',1),(7,2177,'bien',4),(3,2177,'malo',1),(4,2177,'podria mejorar',3),(10,2190,'exelente',5);
/*!40000 ALTER TABLE `participantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `profesor_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  PRIMARY KEY (`profesor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (25,'armando esteban','quito'),(27,'susana','torio'),(29,'alba','sura');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'curso'
--

--
-- Dumping routines for database 'curso'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-06 12:39:37
