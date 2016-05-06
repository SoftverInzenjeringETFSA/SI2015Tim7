-- MySQL dump 10.13  Distrib 5.5.49, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: tim7
-- ------------------------------------------------------
-- Server version	5.5.49-0ubuntu0.14.04.1

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
-- Table structure for table `Osobe`
--

DROP TABLE IF EXISTS `Osobe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Osobe` (
  `id` int(11) NOT NULL,
  `Ime` varchar(255) NOT NULL,
  `Prezime` varchar(255) NOT NULL,
  `Adresa` varchar(255) NOT NULL,
  `BrojTelefona` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Osobe`
--

LOCK TABLES `Osobe` WRITE;
/*!40000 ALTER TABLE `Osobe` DISABLE KEYS */;
INSERT INTO `Osobe` VALUES (1,'Sef','Sefic','Sefovska 5','225883','sef','a'),(2,'Ajdin','Mujezinovic','Nike Kolumbica','660279','am','am'),(3,'Irma','Karasoftic','Ne Znam','101001','ik','');
/*!40000 ALTER TABLE `Osobe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sef`
--

DROP TABLE IF EXISTS `Sef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sef` (
  `id` int(11) NOT NULL,
  `osoba_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `osoba_id_UNIQUE` (`osoba_id`),
  KEY `fk_Sef_1_idx` (`osoba_id`),
  CONSTRAINT `fk_Sef_1` FOREIGN KEY (`osoba_id`) REFERENCES `Osobe` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sef`
--

LOCK TABLES `Sef` WRITE;
/*!40000 ALTER TABLE `Sef` DISABLE KEYS */;
INSERT INTO `Sef` VALUES (1,1);
/*!40000 ALTER TABLE `Sef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Servisi`
--

DROP TABLE IF EXISTS `Servisi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Servisi` (
  `id` int(10) NOT NULL,
  `DatumOdlaska` datetime NOT NULL,
  `DatumVracanja` datetime DEFAULT NULL,
  `Cijena` decimal(10,0) DEFAULT NULL,
  `Opis` varchar(255) DEFAULT NULL,
  `Vozilo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Servisi_1_idx` (`Vozilo_id`),
  CONSTRAINT `fk_Servisi_1` FOREIGN KEY (`Vozilo_id`) REFERENCES `Vozila` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Servisi`
--

LOCK TABLES `Servisi` WRITE;
/*!40000 ALTER TABLE `Servisi` DISABLE KEYS */;
/*!40000 ALTER TABLE `Servisi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TocenjeGoriva`
--

DROP TABLE IF EXISTS `TocenjeGoriva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TocenjeGoriva` (
  `id` int(11) NOT NULL,
  `Vozilo_id` int(11) NOT NULL,
  `Voznja_id` int(11) DEFAULT NULL,
  `Kolicina` decimal(10,0) DEFAULT NULL,
  `Cijena` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_TocenjeGoriva_1_idx` (`Vozilo_id`),
  KEY `fk_TocenjeGoriva_2_idx` (`Voznja_id`),
  CONSTRAINT `fk_TocenjeGoriva_1` FOREIGN KEY (`Vozilo_id`) REFERENCES `Vozila` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TocenjeGoriva_2` FOREIGN KEY (`Voznja_id`) REFERENCES `Voznje` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TocenjeGoriva`
--

LOCK TABLES `TocenjeGoriva` WRITE;
/*!40000 ALTER TABLE `TocenjeGoriva` DISABLE KEYS */;
/*!40000 ALTER TABLE `TocenjeGoriva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vozaci`
--

DROP TABLE IF EXISTS `Vozaci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Vozaci` (
  `id` int(11) NOT NULL,
  `BrojVozacke` varchar(255) DEFAULT NULL,
  `Osoba_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Osoba_id_UNIQUE` (`Osoba_id`),
  CONSTRAINT `fk_Vozaci_1` FOREIGN KEY (`Osoba_id`) REFERENCES `Osobe` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vozaci`
--

LOCK TABLES `Vozaci` WRITE;
/*!40000 ALTER TABLE `Vozaci` DISABLE KEYS */;
INSERT INTO `Vozaci` VALUES (1,NULL,2),(2,NULL,3);
/*!40000 ALTER TABLE `Vozaci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vozila`
--

DROP TABLE IF EXISTS `Vozila`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Vozila` (
  `id` int(11) NOT NULL,
  `BrojVlasnickeDozvole` varchar(50) NOT NULL,
  `BrojSaobracajneDozvole` varchar(50) NOT NULL,
  `Registracija` varchar(50) NOT NULL,
  `Naziv` varchar(255) NOT NULL,
  `OsnovneKarakteristike` varchar(500) NOT NULL,
  `ZadnjiServisKilometri` decimal(10,0) NOT NULL,
  `DatumZadnjegServisa` datetime NOT NULL,
  `PredjenjiKilometri` decimal(10,0) NOT NULL,
  `Proizvodjac` varchar(255) NOT NULL,
  `GodinaProizvodnje` datetime NOT NULL,
  `Status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vozila`
--

LOCK TABLES `Vozila` WRITE;
/*!40000 ALTER TABLE `Vozila` DISABLE KEYS */;
INSERT INTO `Vozila` VALUES (1,'AA0205915','AA0205915','A34-K-200','Passat','AA-Limuzina, 2007. godiste, crni',0,'0000-00-00 00:00:00',0,'','0000-00-00 00:00:00','\0');
/*!40000 ALTER TABLE `Vozila` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Voznje`
--

DROP TABLE IF EXISTS `Voznje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Voznje` (
  `id` int(11) NOT NULL,
  `DatumPreuzimanja` datetime NOT NULL,
  `PredjeniKilometri` decimal(10,0) DEFAULT NULL,
  `DatumVracanja` datetime DEFAULT NULL,
  `OpisUpotrebe` varchar(255) DEFAULT NULL,
  `Vozilo_id` int(11) NOT NULL,
  `Vozac_Id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Voznje_1_idx` (`Vozilo_id`),
  KEY `fk_Voznje_2_idx` (`Vozac_Id`),
  CONSTRAINT `fk_Voznje_1` FOREIGN KEY (`Vozilo_id`) REFERENCES `Vozila` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Voznje_2` FOREIGN KEY (`Vozac_Id`) REFERENCES `Vozaci` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Voznje`
--

LOCK TABLES `Voznje` WRITE;
/*!40000 ALTER TABLE `Voznje` DISABLE KEYS */;
INSERT INTO `Voznje` VALUES (1,'2016-05-01 00:00:00',NULL,NULL,'Malo se vozali :)',1,2);
/*!40000 ALTER TABLE `Voznje` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-06 17:49:07
