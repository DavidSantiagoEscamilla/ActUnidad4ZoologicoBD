CREATE DATABASE  IF NOT EXISTS `bd_tmp_david_escamilla_v2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bd_tmp_david_escamilla_v2`;
-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_tmp_david_escamilla_v2
-- ------------------------------------------------------
-- Server version	5.5.16

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
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal` (
  `id_animal` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `sexo` enum('M','F') DEFAULT NULL,
  `id_especie` int(11) DEFAULT NULL,
  `id_habitat` int(11) DEFAULT NULL,
  `id_personal` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_animal`),
  KEY `idx_animal_id_habitad` (`id_habitat`),
  KEY `idx_animal_id_especie` (`id_especie`),
  KEY `idx_animal_id_cuidador` (`id_personal`),
  CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`id_especie`) REFERENCES `especie` (`id_especie`) ON UPDATE CASCADE,
  CONSTRAINT `animal_ibfk_2` FOREIGN KEY (`id_habitat`) REFERENCES `habitat` (`id_habitat`) ON UPDATE CASCADE,
  CONSTRAINT `fk_animal_cuidador` FOREIGN KEY (`id_personal`) REFERENCES `cuidador` (`id_personal`) ON UPDATE CASCADE,
  CONSTRAINT `fk_animal_especie` FOREIGN KEY (`id_especie`) REFERENCES `especie` (`id_especie`) ON UPDATE CASCADE,
  CONSTRAINT `fk_animal_habitat` FOREIGN KEY (`id_habitat`) REFERENCES `habitat` (`id_habitat`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,'RangoAZ46','2020-06-15','M',1,1,NULL),(4,'RangoAZ46','2021-05-12','M',1,1,1),(11,'RangoAZ46','2022-01-15','M',1,1,1),(12,'RangoAZ46','2021-06-12','M',1,1,2),(13,'RangoAZ46','2020-09-20','M',1,1,3),(14,'RangoAZ46','2023-02-28','M',1,1,4),(99,'RangoAZ46','2022-12-05','M',1,1,5),(100,'RangoAZ46','2010-12-23','M',1,1,1),(104,'RangoAZ46','2023-12-30','M',1,1,1),(106,'RangoAZ46','2023-06-21','M',1,1,1);
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuidado`
--

DROP TABLE IF EXISTS `cuidado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuidado` (
  `id_personal` int(11) NOT NULL DEFAULT '0',
  `id_animal` int(11) NOT NULL DEFAULT '0',
  `fecha` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id_personal`,`id_animal`,`fecha`),
  KEY `id_animal` (`id_animal`),
  CONSTRAINT `cuidado_ibfk_1` FOREIGN KEY (`id_personal`) REFERENCES `cuidador` (`id_personal`) ON UPDATE CASCADE,
  CONSTRAINT `cuidado_ibfk_2` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id_animal`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuidado`
--

LOCK TABLES `cuidado` WRITE;
/*!40000 ALTER TABLE `cuidado` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuidado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuidador`
--

DROP TABLE IF EXISTS `cuidador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuidador` (
  `id_personal` int(11) NOT NULL,
  `especialidad` varchar(100) DEFAULT NULL,
  `id_cuidador` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_personal`),
  CONSTRAINT `cuidador_ibfk_1` FOREIGN KEY (`id_personal`) REFERENCES `personal` (`id_personal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuidador`
--

LOCK TABLES `cuidador` WRITE;
/*!40000 ALTER TABLE `cuidador` DISABLE KEYS */;
INSERT INTO `cuidador` VALUES (1,'Mamíferos',NULL),(2,NULL,NULL),(3,NULL,NULL),(4,NULL,NULL),(5,NULL,NULL);
/*!40000 ALTER TABLE `cuidador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especie`
--

DROP TABLE IF EXISTS `especie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especie` (
  `id_especie` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cientifico` varchar(100) NOT NULL,
  `nombre_comun` varchar(100) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_especie`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especie`
--

LOCK TABLES `especie` WRITE;
/*!40000 ALTER TABLE `especie` DISABLE KEYS */;
INSERT INTO `especie` VALUES (1,'Panthera leo','Le¢n','Mam¡fero'),(2,'Elephas maximus','Elefante','Mamífero'),(3,'Ara macao','Guacamaya','Ave'),(4,'Crocodylus acutus','Cocodrilo','Reptil'),(5,'Chelonia mydas','Tortuga verde','Reptil'),(6,'Canis lupus','Lobo','Mamífero'),(7,'Panthera onca','Jaguar','Mamífero'),(8,'Phoenicopterus ruber','Flamenco','Ave'),(9,'Boa constrictor','Boa','Reptil'),(10,'Delphinus delphis','Delfín','Mamífero'),(11,'Struthio camelus','Avestruz','Ave');
/*!40000 ALTER TABLE `especie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especie_habitat`
--

DROP TABLE IF EXISTS `especie_habitat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especie_habitat` (
  `id_especie` int(11) NOT NULL DEFAULT '0',
  `id_habitat` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_especie`,`id_habitat`),
  KEY `id_habitat` (`id_habitat`),
  CONSTRAINT `especie_habitat_ibfk_1` FOREIGN KEY (`id_especie`) REFERENCES `especie` (`id_especie`) ON UPDATE CASCADE,
  CONSTRAINT `especie_habitat_ibfk_2` FOREIGN KEY (`id_habitat`) REFERENCES `habitat` (`id_habitat`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especie_habitat`
--

LOCK TABLES `especie_habitat` WRITE;
/*!40000 ALTER TABLE `especie_habitat` DISABLE KEYS */;
/*!40000 ALTER TABLE `especie_habitat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examenmedico`
--

DROP TABLE IF EXISTS `examenmedico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examenmedico` (
  `id_examen` int(11) NOT NULL AUTO_INCREMENT,
  `id_animal` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  `tipo_examen` varchar(100) DEFAULT NULL,
  `resultado` text,
  PRIMARY KEY (`id_examen`),
  KEY `idx_examen_id_animal` (`id_animal`),
  CONSTRAINT `examenmedico_ibfk_1` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id_animal`) ON UPDATE CASCADE,
  CONSTRAINT `fk_examenanimal` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id_animal`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examenmedico`
--

LOCK TABLES `examenmedico` WRITE;
/*!40000 ALTER TABLE `examenmedico` DISABLE KEYS */;
INSERT INTO `examenmedico` VALUES (1,1,'2025-04-20',NULL,'Saludable');
/*!40000 ALTER TABLE `examenmedico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guia`
--

DROP TABLE IF EXISTS `guia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guia` (
  `id_personal` int(11) NOT NULL,
  `idioma` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_personal`),
  CONSTRAINT `guia_ibfk_1` FOREIGN KEY (`id_personal`) REFERENCES `personal` (`id_personal`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guia`
--

LOCK TABLES `guia` WRITE;
/*!40000 ALTER TABLE `guia` DISABLE KEYS */;
/*!40000 ALTER TABLE `guia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitat`
--

DROP TABLE IF EXISTS `habitat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habitat` (
  `id_habitat` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `clima` varchar(100) DEFAULT NULL,
  `id_zona` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_habitat`),
  KEY `idx_habitad_id_zona` (`id_zona`),
  CONSTRAINT `fk_habitat_zona` FOREIGN KEY (`id_zona`) REFERENCES `zona` (`id_zona`) ON UPDATE CASCADE,
  CONSTRAINT `habitat_ibfk_1` FOREIGN KEY (`id_zona`) REFERENCES `zona` (`id_zona`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitat`
--

LOCK TABLES `habitat` WRITE;
/*!40000 ALTER TABLE `habitat` DISABLE KEYS */;
INSERT INTO `habitat` VALUES (1,'Sabana','Terrestre',1),(2,'Sabana Africana','Cálido seco',1);
/*!40000 ALTER TABLE `habitat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itinerario`
--

DROP TABLE IF EXISTS `itinerario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itinerario` (
  `id_itinerario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text,
  `duracion_minutos` int(11) DEFAULT NULL,
  `id_guia` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_itinerario`),
  KEY `id_guia` (`id_guia`),
  CONSTRAINT `itinerario_ibfk_1` FOREIGN KEY (`id_guia`) REFERENCES `guia` (`id_personal`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itinerario`
--

LOCK TABLES `itinerario` WRITE;
/*!40000 ALTER TABLE `itinerario` DISABLE KEYS */;
/*!40000 ALTER TABLE `itinerario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itinerario_habitat`
--

DROP TABLE IF EXISTS `itinerario_habitat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itinerario_habitat` (
  `id_itinerario` int(11) NOT NULL DEFAULT '0',
  `id_habitat` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_itinerario`,`id_habitat`),
  KEY `id_habitat` (`id_habitat`),
  CONSTRAINT `itinerario_habitat_ibfk_1` FOREIGN KEY (`id_itinerario`) REFERENCES `itinerario` (`id_itinerario`) ON UPDATE CASCADE,
  CONSTRAINT `itinerario_habitat_ibfk_2` FOREIGN KEY (`id_habitat`) REFERENCES `habitat` (`id_habitat`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itinerario_habitat`
--

LOCK TABLES `itinerario_habitat` WRITE;
/*!40000 ALTER TABLE `itinerario_habitat` DISABLE KEYS */;
/*!40000 ALTER TABLE `itinerario_habitat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal` (
  `id_personal` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_personal`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` VALUES (1,'Laura Rodríguez','3041234567','Calle 35 #02-4'),(2,'James Rodríguez','3001234567','Calle 45 #12-34'),(3,'Carlitos Pérez','3019876543','Carrera 12 #45-67'),(4,'Mariana Torres','3023456789','Avenida 3 #10-20'),(5,'Andrés Gómez','3031122334','Diagonal 45 #67-89'),(6,'Paula Martínez','3045566778','Transversal 8 #23-45'),(7,'Carlos Ríos','3110000001','Calle 1'),(8,'Ana Torres','3110000002','Calle 2'),(9,'Luis Gómez','3110000003','Calle 3'),(10,'Marta Díaz','3110000004','Calle 4'),(11,'Andrés Ruiz','3110000005','Calle 5'),(12,'Sara Pérez','3110000006','Calle 6'),(13,'Daniel Castro','3110000007','Calle 7'),(14,'Camila Navarro','3110000008','Calle 8'),(15,'Esteban Vera','3110000009','Calle 9'),(16,'Laura Restrepo','3110000010','Calle 10'),(17,'Mario Giraldo','3110000011','Calle 11'),(18,'Valentina Jara','3110000012','Calle 12'),(19,'Sebastián Lara','3110000013','Calle 13'),(20,'Juana Paredes','3110000014','Calle 14'),(21,'Pedro Mejía','3110000015','Calle 15'),(22,'Olga Mendoza','3110000016',NULL);
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tablax`
--

DROP TABLE IF EXISTS `tablax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tablax` (
  `id_animal` int(11) NOT NULL DEFAULT '0',
  `nombre` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `sexo` enum('M','F') DEFAULT NULL,
  `id_especie` int(11) DEFAULT NULL,
  `id_habitat` int(11) DEFAULT NULL,
  `id_personal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tablax`
--

LOCK TABLES `tablax` WRITE;
/*!40000 ALTER TABLE `tablax` DISABLE KEYS */;
INSERT INTO `tablax` VALUES (1,'RangoAZ46','2020-06-15','M',1,1,NULL),(4,'RangoAZ46','2021-05-12','M',1,1,1),(11,'RangoAZ46','2022-01-15','M',1,1,1),(12,'RangoAZ46','2021-06-12','M',1,1,2),(13,'RangoAZ46','2020-09-20','M',1,1,3),(14,'RangoAZ46','2023-02-28','M',1,1,4),(99,'RangoAZ46','2022-12-05','M',1,1,5),(100,'RangoAZ46','2010-12-23','M',1,1,1),(104,'RangoAZ46','2023-12-30','M',1,1,1),(106,'RangoAZ46','2023-06-21','M',1,1,1);
/*!40000 ALTER TABLE `tablax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tablay`
--

DROP TABLE IF EXISTS `tablay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tablay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `asignatura` varchar(100) DEFAULT NULL,
  `nota1` decimal(3,2) DEFAULT NULL,
  `nota2` decimal(3,2) DEFAULT NULL,
  `nota3` decimal(3,2) DEFAULT NULL,
  `nota_definitiva` decimal(3,2) DEFAULT NULL,
  `promedio` decimal(3,2) DEFAULT NULL,
  `mensaje` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tablay`
--

LOCK TABLES `tablay` WRITE;
/*!40000 ALTER TABLE `tablay` DISABLE KEYS */;
INSERT INTO `tablay` VALUES (1,'2023-05-20 00:00:00','PERSONA 1','DE TAL','ESTRUCTURAS DE DATOS',1.00,NULL,NULL,NULL,NULL,'PRÁCTICAMENTE NO HIZO NADA'),(2,'2023-06-20 00:00:00','PERSONA 1','DE TAL','ESTRUCTURAS DE DATOS',1.00,1.00,NULL,NULL,NULL,'LA ACTIVIDAD ES UNA COPIA DE FRAGMENTOS DISPONIBLES EN INTERNET'),(3,'2023-07-20 00:00:00','PERSONA 1','DE TAL','ESTRUCTURAS DE DATOS',1.00,1.00,1.00,NULL,NULL,'LA ACTIVIDAD ESTA COMPLETA PERO NO PUDO SUSTENTAR, EXPLICARLA Y NO DOMINA EL DESARROLLO DE NINGUNO DE LOS EJERCICIOS'),(4,'2023-05-20 00:00:00','PERSONA 3','DE TAL','ESTRUCTURAS DE DATOS',4.00,NULL,NULL,NULL,NULL,'ACTIVIDAD AL 80%, PERO FUE DESARROLLADA PROGRESIVAMENTE Y SOCIALIZADA AL DOCENTE EN CADA TUTORIA'),(5,'2023-06-20 00:00:00','PERSONA 3','DE TAL','ESTRUCTURAS DE DATOS',4.00,4.50,NULL,NULL,NULL,'ACTIVIDAD COMPLETA Y ENTREGADA UNA SEMANA ANTES DEL CIERRE, CON VIDEO Y SIN DOCUMENTO'),(6,'2023-07-20 00:00:00','PERSONA 3','DE TAL','ESTRUCTURAS DE DATOS',4.00,4.50,5.00,NULL,NULL,'ACTIVIDAD ENTREGADA MUCHO ANTES DEL CIERRE, 100% COMPLETA, CON DOCUMENTO, VIDEO Y SUSTENTACIÓN');
/*!40000 ALTER TABLE `tablay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zona`
--

DROP TABLE IF EXISTS `zona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zona` (
  `id_zona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_zona`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zona`
--

LOCK TABLES `zona` WRITE;
/*!40000 ALTER TABLE `zona` DISABLE KEYS */;
INSERT INTO `zona` VALUES (1,'Zona A'),(2,'Zona Tropical');
/*!40000 ALTER TABLE `zona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_tmp_david_escamilla_v2'
--

--
-- Dumping routines for database 'bd_tmp_david_escamilla_v2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-15 21:45:08
