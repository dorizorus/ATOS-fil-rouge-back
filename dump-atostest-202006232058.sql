-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: atostest
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `agence`
--

DROP TABLE IF EXISTS `agence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agence` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agence`
--

LOCK TABLES `agence` WRITE;
/*!40000 ALTER TABLE `agence` DISABLE KEYS */;
INSERT INTO `agence` VALUES (1,'ATOS METZ'),(2,'ATOS STRASBOURG'),(3,'Proin LLP'),(4,'Tellus Lorem Eu Institute'),(5,'Gravida Mauris Ut Incorporated'),(6,'Torquent Industries'),(7,'Class Aptent Taciti Corporation'),(8,'Ultrices Posuere Cubilia LLC'),(9,'Senectus Limited'),(10,'Neque Corporation'),(11,'Semper Industries'),(12,'Nibh LLP');
/*!40000 ALTER TABLE `agence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `besoin`
--

DROP TABLE IF EXISTS `besoin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `besoin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_echeance` date DEFAULT NULL,
  `date_emission` date DEFAULT NULL,
  `est_ouvert` bit(1) NOT NULL,
  `est_recurrent` bit(1) NOT NULL,
  `est_satisfait` bit(1) NOT NULL,
  `id_agence` bigint DEFAULT NULL,
  `id_client` int DEFAULT NULL,
  `id_contact` int DEFAULT NULL,
  `id_site` int DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKthscbc6n6s2gaen8r79n1oqnj` (`id_agence`),
  KEY `FK8u6vxlddl4x8q54mqqrmx8gc5` (`id_client`),
  KEY `FKl3oc5rfw9eysjipcdxveliwpg` (`id_contact`),
  KEY `FKexj3dx7564itsuu11jjy3ffya` (`id_site`),
  CONSTRAINT `FK8u6vxlddl4x8q54mqqrmx8gc5` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`),
  CONSTRAINT `FKexj3dx7564itsuu11jjy3ffya` FOREIGN KEY (`id_site`) REFERENCES `site_client` (`id`),
  CONSTRAINT `FKl3oc5rfw9eysjipcdxveliwpg` FOREIGN KEY (`id_contact`) REFERENCES `contact_client` (`id`),
  CONSTRAINT `FKthscbc6n6s2gaen8r79n1oqnj` FOREIGN KEY (`id_agence`) REFERENCES `agence` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `besoin`
--

LOCK TABLES `besoin` WRITE;
/*!40000 ALTER TABLE `besoin` DISABLE KEYS */;
INSERT INTO `besoin` VALUES (1,'2020-03-26','2020-03-20','','\0','',NULL,NULL,NULL,NULL,NULL),(2,'2020-06-17','2020-05-17','','\0','\0',NULL,NULL,NULL,NULL,NULL),(3,'2020-06-20','2020-05-20','','\0','\0',NULL,NULL,NULL,NULL,NULL),(4,'2020-11-17','2020-02-25','','\0','\0',3,6,5,6,'Morbi quis urna. Nunc quis arcu vel quam'),(5,'2019-11-13','2020-02-09','','','\0',2,4,9,10,'auctor ullamcorper, nisl'),(6,'2020-08-29','2020-07-06','','\0','\0',3,7,10,8,'nibh. Donec est mauris, rhoncus'),(7,'2020-11-14','2019-05-31','\0','\0','\0',5,2,1,2,'in faucibus orci luctus'),(8,'2019-11-20','2021-02-03','\0','','\0',7,1,4,9,'Suspendisse ac metus'),(9,'2020-01-19','2020-09-25','\0','','\0',2,7,7,5,'consectetuer adipiscing elit.'),(10,'2021-01-22','2019-09-07','\0','','',4,6,8,6,'tempus mauris erat'),(11,'2019-10-23','2020-11-22','','','',10,4,6,8,'mauris sapien, cursus in, hendrerit'),(12,'2020-07-29','2020-01-12','','\0','\0',7,3,2,1,'sem eget massa. Suspendisse eleifend.'),(13,'2021-05-03','2021-01-15','\0','','',5,1,3,7,'Maecenas libero est,'),(17,'2020-07-17','2020-03-26','','\0','\0',3,6,11,6,'id, ante. Nunc mauris sapien, cursus');
/*!40000 ALTER TABLE `besoin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `besoins_competences`
--

DROP TABLE IF EXISTS `besoins_competences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `besoins_competences` (
  `id_competence` int NOT NULL,
  `id_besoin` bigint NOT NULL,
  `experience` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_besoin`,`id_competence`),
  KEY `FKntpytonmydc4kqib3vdei9k8i` (`id_competence`),
  CONSTRAINT `FKjjbrm039ushcm2n41r4d02cud` FOREIGN KEY (`id_besoin`) REFERENCES `besoin` (`id`),
  CONSTRAINT `FKntpytonmydc4kqib3vdei9k8i` FOREIGN KEY (`id_competence`) REFERENCES `competence` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `besoins_competences`
--

LOCK TABLES `besoins_competences` WRITE;
/*!40000 ALTER TABLE `besoins_competences` DISABLE KEYS */;
INSERT INTO `besoins_competences` VALUES (4,2,'Expert'),(5,3,'Junior'),(9,4,'Junior'),(9,5,'Expérimenté'),(5,7,'Expérimenté'),(7,7,'Junior'),(5,8,'Expert'),(2,9,'Expert'),(6,9,'Junior'),(5,10,'Expérimenté'),(9,17,NULL);
/*!40000 ALTER TABLE `besoins_competences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Ac Mattis Velit LLC'),(2,'Tortor Nibh Limited'),(3,'Libero Lacus Foundation'),(4,'Magna Ltd'),(5,'Tincidunt Foundation'),(6,'Tellus Phasellus Ltd'),(7,'Magna Duis Dignissim Limited'),(8,'Egestas A Dui Ltd'),(9,'Euismod Industries'),(10,'Ullamcorper Viverra Maecenas Industries'),(44,'TestAjoutBloc');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collaborateur`
--

DROP TABLE IF EXISTS `collaborateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collaborateur` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bench` int NOT NULL,
  `cv_url` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `id_agence` bigint DEFAULT NULL,
  `identifiant` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg9l6oo9jtya88mt1nf2muyra9` (`id_agence`),
  CONSTRAINT `FKg9l6oo9jtya88mt1nf2muyra9` FOREIGN KEY (`id_agence`) REFERENCES `agence` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collaborateur`
--

LOCK TABLES `collaborateur` WRITE;
/*!40000 ALTER TABLE `collaborateur` DISABLE KEYS */;
INSERT INTO `collaborateur` VALUES (1,31,'odio. Nam interdum enim non','Kerry','Zephania',1,NULL,NULL),(2,38,'sodales elit erat vitae risus.','Karen','Marsden',7,NULL,NULL),(3,94,'Donec non justo.','Camilla','Elvis',2,NULL,NULL),(4,4,'vulputate','Colleen','Wade',2,NULL,NULL),(5,58,'ac ipsum. Phasellus','Ulla','Simon',3,NULL,NULL),(6,76,'lobortis quam','Shaine','Derek',3,NULL,NULL),(7,64,'lobortis mauris.','Reagan','Curran',6,NULL,NULL),(8,27,'amet orci. Ut sagittis lobortis','Tanya','Holmes',4,NULL,NULL),(9,28,'condimentum.','Ayanna','Coby',10,NULL,NULL),(10,68,'risus.','Lesley','Norman',5,NULL,NULL),(11,0,'','Tardy','Julien',1,'MA478','Développeur Java'),(12,0,'','Test','Adrien',1,'MA478','Développeur C--'),(13,0,'myfake.url','Sujet107','Justine',3,'M4A7','Développeuse DotNet'),(15,0,'myfake.url','Sujet109','Dupont',8,'AK47','Développeur RienDuTout');
/*!40000 ALTER TABLE `collaborateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collaborateurs_competences`
--

DROP TABLE IF EXISTS `collaborateurs_competences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collaborateurs_competences` (
  `id_competence` int NOT NULL,
  `id_collaborateur` bigint NOT NULL,
  `annees_experience` int NOT NULL,
  `experience` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_collaborateur`,`id_competence`),
  KEY `FKto8g01wfubmvyvdyehopoklt` (`id_competence`),
  CONSTRAINT `FKh503t5htxkdt1bpddsn6rw6pv` FOREIGN KEY (`id_collaborateur`) REFERENCES `collaborateur` (`id`),
  CONSTRAINT `FKto8g01wfubmvyvdyehopoklt` FOREIGN KEY (`id_competence`) REFERENCES `competence` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collaborateurs_competences`
--

LOCK TABLES `collaborateurs_competences` WRITE;
/*!40000 ALTER TABLE `collaborateurs_competences` DISABLE KEYS */;
INSERT INTO `collaborateurs_competences` VALUES (6,1,5,'Expérimenté'),(6,3,12,'Junior'),(1,4,10,'Expérimenté'),(4,4,14,'Expérimenté'),(2,6,11,'Expérimenté'),(3,7,18,'Expert'),(7,7,25,'Expert'),(4,8,15,'Expert'),(8,8,22,'Junior'),(9,8,19,'Expert'),(7,11,25,'Expert'),(1,13,25,'Expert'),(5,13,25,'Expert'),(1,15,25,'Expert'),(5,15,25,'Expert');
/*!40000 ALTER TABLE `collaborateurs_competences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commentaire` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `commentaire` varchar(255) DEFAULT NULL,
  `date_emission` datetime DEFAULT NULL,
  `id_besoin` bigint DEFAULT NULL,
  `id_demarche` bigint DEFAULT NULL,
  `id_proposition` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt8gybgr4ee4bi35yhxan5qn67` (`id_besoin`),
  KEY `FKne2pygg0mwovuxqu13sg4y1h8` (`id_demarche`),
  KEY `FK1xujal7dl3me0u25pocqvlpve` (`id_proposition`),
  CONSTRAINT `FK1xujal7dl3me0u25pocqvlpve` FOREIGN KEY (`id_proposition`) REFERENCES `proposition` (`id`),
  CONSTRAINT `FKne2pygg0mwovuxqu13sg4y1h8` FOREIGN KEY (`id_demarche`) REFERENCES `demarche` (`id`),
  CONSTRAINT `FKt8gybgr4ee4bi35yhxan5qn67` FOREIGN KEY (`id_besoin`) REFERENCES `besoin` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentaire`
--

LOCK TABLES `commentaire` WRITE;
/*!40000 ALTER TABLE `commentaire` DISABLE KEYS */;
INSERT INTO `commentaire` VALUES (1,'vitae semper egestas, urna','2020-07-04 00:00:00',6,NULL,NULL),(2,'tristique aliquet.','2019-11-06 00:00:00',3,NULL,NULL),(3,'arcu. Vestibulum ut eros non enim commodo hendrerit.','2020-12-04 00:00:00',1,NULL,NULL),(4,'conubia nostra, per inceptos','2020-04-26 00:00:00',8,NULL,NULL),(13,'ante, iaculis nec, eleifend non, dapibus rutrum, justo.','2020-10-02 00:00:00',NULL,NULL,5),(14,'Nulla dignissim. Maecenas ornare egestas ligula.','2019-06-09 00:00:00',NULL,NULL,8),(15,'nibh. Phasellus nulla. Integer vulputate,','2019-07-26 00:00:00',NULL,NULL,6),(16,'sed dolor.','2021-05-11 00:00:00',NULL,NULL,7),(17,'dis parturient montes, nascetur','2019-07-08 00:00:00',NULL,2,NULL),(18,'parturient montes, nascetur ridiculus mus.','2020-10-18 00:00:00',NULL,8,NULL),(19,'Aliquam ornare, libero','2019-06-05 00:00:00',NULL,5,NULL),(20,'blandit congue. In scelerisque scelerisque dui. Suspendisse ac','2020-12-20 00:00:00',NULL,7,NULL);
/*!40000 ALTER TABLE `commentaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competence`
--

DROP TABLE IF EXISTS `competence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `competence` (
  `id` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competence`
--

LOCK TABLES `competence` WRITE;
/*!40000 ALTER TABLE `competence` DISABLE KEYS */;
INSERT INTO `competence` VALUES (1,'Développeur','Metier'),(2,'Architecte','Metier'),(3,'Autre','Metier'),(4,'Java','Technologie'),(5,'DotNet','Technologie'),(6,'Merise','Méthode'),(7,'UML','Méthode'),(8,'Linux','Technologie'),(9,'Windows','Technologie'),(10,NULL,'Outil'),(12,'MDA','Méthode');
/*!40000 ALTER TABLE `competence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_client`
--

DROP TABLE IF EXISTS `contact_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `num_fax` varchar(255) DEFAULT NULL,
  `num_tel_perso` varchar(255) DEFAULT NULL,
  `num_tel_pro` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `id_client` int DEFAULT NULL,
  `id_site` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKol164w7gkod9ipc079xm6mbg6` (`id_client`),
  KEY `FKst10g2uj6d2qwth7tdx234gbc` (`id_site`),
  CONSTRAINT `FKol164w7gkod9ipc079xm6mbg6` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`),
  CONSTRAINT `FKst10g2uj6d2qwth7tdx234gbc` FOREIGN KEY (`id_site`) REFERENCES `site_client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_client`
--

LOCK TABLES `contact_client` WRITE;
/*!40000 ALTER TABLE `contact_client` DISABLE KEYS */;
INSERT INTO `contact_client` VALUES (1,'diam.luctus.lobortis@consectetuerrhoncus.com','Kaseem','03 65 01 70 47','05 96 32 39 92','04 02 09 99 91','et,','Quon',2,2),(2,'Mauris.magna@nonegestasa.org','Gannon','07 64 99 59 32','09 24 61 35 56','01 80 68 28 39','metus.','Tatyana',3,1),(3,'purus.sapien@iaculis.edu','Hunter','02 03 93 74 08','06 82 32 96 86','03 65 19 74 79','quam,','Rama',1,7),(4,'Cras.eu.tellus@Aliquamornarelibero.com','Driscoll','07 70 91 54 59','09 08 24 87 41','02 79 56 83 61','congue.','Serena',1,9),(5,'Ut.tincidunt@diam.co.uk','James','04 60 07 14 13','01 35 26 15 59','07 34 40 89 01','Vestibulum','Nerea',6,6),(6,'dignissim.Maecenas.ornare@eget.edu','Randall','02 06 89 18 30','09 21 44 92 18','03 38 74 14 32','orci','Ifeoma',4,8),(7,'placerat.velit@felisNullatempor.edu','Steel','07 08 40 27 26','05 40 99 71 28','03 19 64 38 60','risus.','Scarlett',7,5),(8,'ac.orci.Ut@dolor.org','Mufutau','07 09 22 90 65','08 66 79 38 49','08 95 03 22 81','quis','Vanna',6,6),(9,'velit@sapien.net','Timothy','05 60 82 25 66','05 67 45 76 21','09 82 48 04 84','ultrices.','Charlotte',4,10),(10,'gravida.nunc@Integer.edu','John','04 31 57 19 59','07 80 36 60 30','02 75 91 93 54','varius','Grace',7,8),(11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(52,'son mail à lui','Julien',NULL,NULL,NULL,'couché','Julien',44,50),(53,'mon mail','Adrien',NULL,NULL,NULL,'assis','Adrien',44,49),(54,'son mail','Justine',NULL,NULL,NULL,'debout','Justine',44,50);
/*!40000 ALTER TABLE `contact_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_soustraitant`
--

DROP TABLE IF EXISTS `contact_soustraitant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_soustraitant` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `num_tel_perso` varchar(255) DEFAULT NULL,
  `num_tel_pro` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `id_agence` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtlmo3g3gec9i538f90gh1edve` (`id_agence`),
  CONSTRAINT `FKtlmo3g3gec9i538f90gh1edve` FOREIGN KEY (`id_agence`) REFERENCES `agence` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_soustraitant`
--

LOCK TABLES `contact_soustraitant` WRITE;
/*!40000 ALTER TABLE `contact_soustraitant` DISABLE KEYS */;
INSERT INTO `contact_soustraitant` VALUES (1,'consequat.enim.diam@posuerecubilia.co.uk','Wing','03 05 57 39 04','06 51 73 83 74','Ursa',10),(2,'nulla.ante.iaculis@elitNullafacilisi.com','Orson','08 13 30 12 05','06 85 60 40 80','Karleigh',2),(3,'risus.Donec.nibh@non.edu','Colt','07 87 71 61 46','05 52 32 36 50','Fatima',6),(4,'nonummy.ipsum@vitaealiquameros.edu','Coby','03 47 22 86 23','05 51 08 08 52','Clementine',7),(5,'massa.non.ante@egestas.net','Jordan','08 28 26 45 34','03 97 86 66 14','Serena',1),(6,'nascetur.ridiculus@iaculisodio.edu','Oscar','09 32 76 32 49','08 17 42 98 30','Ava',6),(7,'Praesent.eu@volutpatNulla.co.uk','Tucker','09 03 76 14 19','03 65 23 14 07','Brooke',10),(8,'ornare.elit@lacusCras.net','Akeem','07 61 67 95 94','01 15 36 82 87','Riley',3),(9,'metus.sit@iaculis.com','Ferdinand','06 09 07 77 13','08 99 73 49 63','Lee',9),(10,'inceptos.hymenaeos.Mauris@arcu.edu','Alan','02 29 49 59 80','02 72 73 95 98','Nita',9);
/*!40000 ALTER TABLE `contact_soustraitant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `demarche`
--

DROP TABLE IF EXISTS `demarche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `demarche` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_demarche` datetime DEFAULT NULL,
  `date_planification` datetime DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `id_site_client` int DEFAULT NULL,
  `id_utilisateur` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo68eu1k468h2i1m85db1jo682` (`id_site_client`),
  KEY `FKkvd2m300vi6rbp2h62lllyufl` (`id_utilisateur`),
  CONSTRAINT `FKkvd2m300vi6rbp2h62lllyufl` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  CONSTRAINT `FKo68eu1k468h2i1m85db1jo682` FOREIGN KEY (`id_site_client`) REFERENCES `site_client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demarche`
--

LOCK TABLES `demarche` WRITE;
/*!40000 ALTER TABLE `demarche` DISABLE KEYS */;
INSERT INTO `demarche` VALUES (1,'2019-11-09 00:00:00','2019-11-22 00:00:00','at risus. Nunc ac sem',6,2),(2,'2021-01-25 00:00:00','2021-01-08 00:00:00','purus gravida sagittis.',9,1),(3,'2020-09-19 00:00:00','2019-07-12 00:00:00','Nulla interdum. Curabitur',7,1),(4,'2020-01-30 00:00:00','2019-10-22 00:00:00','arcu. Vestibulum ante',1,3),(5,'2021-05-06 00:00:00','2020-12-12 00:00:00','mollis',1,4),(6,'2020-06-02 00:00:00','2020-10-24 00:00:00','Cum sociis natoque',1,1),(7,'2021-04-18 00:00:00','2020-12-02 00:00:00','Nulla aliquet. Proin velit.',6,1),(8,'2020-08-10 00:00:00','2020-01-11 00:00:00','Proin dolor. Nulla semper',1,4),(9,'2021-01-05 00:00:00','2020-03-18 00:00:00','euismod enim.',3,4),(10,'2020-10-11 00:00:00','2020-06-26 00:00:00','cursus a, enim. Suspendisse',5,3);
/*!40000 ALTER TABLE `demarche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proposition`
--

DROP TABLE IF EXISTS `proposition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proposition` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_proposition` date DEFAULT NULL,
  `date_relance` date DEFAULT NULL,
  `prix_achat` bigint NOT NULL,
  `prix_vente` bigint NOT NULL,
  `id_besoin` bigint DEFAULT NULL,
  `id_collaborateur` bigint DEFAULT NULL,
  `id_statut` int DEFAULT NULL,
  `id_utilisateur` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi6djkbgchmbagn7vtjwuieg9f` (`id_besoin`),
  KEY `FK6sttdaq0f1k8tqua4erft4vdd` (`id_collaborateur`),
  KEY `FK8k73m0rqfufrnntw5npw8kl8b` (`id_statut`),
  KEY `FK9d9kv3jux6eh3on04cf9yagrb` (`id_utilisateur`),
  CONSTRAINT `FK6sttdaq0f1k8tqua4erft4vdd` FOREIGN KEY (`id_collaborateur`) REFERENCES `collaborateur` (`id`),
  CONSTRAINT `FK8k73m0rqfufrnntw5npw8kl8b` FOREIGN KEY (`id_statut`) REFERENCES `statut` (`id`),
  CONSTRAINT `FK9d9kv3jux6eh3on04cf9yagrb` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  CONSTRAINT `FKi6djkbgchmbagn7vtjwuieg9f` FOREIGN KEY (`id_besoin`) REFERENCES `besoin` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proposition`
--

LOCK TABLES `proposition` WRITE;
/*!40000 ALTER TABLE `proposition` DISABLE KEYS */;
INSERT INTO `proposition` VALUES (1,'2021-05-11','2019-11-03',113,201,5,1,1,4),(2,'2019-11-13','2020-10-31',59,236,9,4,2,3),(3,'2020-04-19','2020-05-18',57,164,4,5,2,3),(4,'2020-10-29','2020-11-10',165,159,6,6,4,1),(5,'2020-08-02','2020-04-21',23,197,11,8,4,2),(6,'2020-10-04','2020-11-12',80,123,9,9,1,2),(7,'2019-06-17','2020-01-01',45,158,9,1,4,4),(8,'2019-12-05','2019-11-02',186,61,8,9,4,2),(9,'2020-05-31','2019-05-23',7,65,6,7,1,1),(10,'2020-12-30','2019-11-01',170,150,10,10,3,4);
/*!40000 ALTER TABLE `proposition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_MANAGER'),(3,'ROLE_COMMERCIAL'),(4,'ROLE_CONSULTANT');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_client`
--

DROP TABLE IF EXISTS `site_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site_client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `est_actif` bit(1) NOT NULL,
  `nom_ville` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id_client` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg9hiknuvjvjp8008vsagrr7rg` (`id_client`),
  CONSTRAINT `FKg9hiknuvjvjp8008vsagrr7rg` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_client`
--

LOCK TABLES `site_client` WRITE;
/*!40000 ALTER TABLE `site_client` DISABLE KEYS */;
INSERT INTO `site_client` VALUES (1,'9739 Pellentesque St.','','Borlänge',3),(2,'336-1519 Facilisis. St.','\0','Dawson Creek',2),(3,'4895 Etiam Avenue','','Travo',10),(4,'601-8396 Lacinia Rd.','\0','Qutubullapur',3),(5,'Ap #298-3322 Magna. St.','','Dolgellau',7),(6,'Ap #804-815 Nullam Avenue','','Scorrano',6),(7,'7004 Sed Rd.','\0','Traiskirchen',1),(8,'P.O. Box 397, 541 Tempor Road','\0','Montefalcone nel Sannio',4),(9,'3416 Dui. Rd.','','Grimbergen',1),(10,'P.O. Box 418, 6686 Fringilla Ave','\0','Lourdes',4),(49,'15, rue des peupliers','\0','TestAjoutBlocSarreguemines',44),(50,'69, rue de la Gare','\0','TestAjoutBlocThionville',44);
/*!40000 ALTER TABLE `site_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statut`
--

DROP TABLE IF EXISTS `statut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statut` (
  `id` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statut`
--

LOCK TABLES `statut` WRITE;
/*!40000 ALTER TABLE `statut` DISABLE KEYS */;
INSERT INTO `statut` VALUES (1,'OK ATOS'),(2,'KO ATOS'),(3,'OK Collaborateur'),(4,'KO Collaborateur');
/*!40000 ALTER TABLE `statut` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilisateur` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `est_actif` bit(1) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `id_role` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr6x7g9mw0va8oe9drohepvywu` (`id_role`),
  CONSTRAINT `FKr6x7g9mw0va8oe9drohepvywu` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (1,'','admin','Test','admin','Admin',1),(2,'','manager','Test','manager','Manager',2),(3,'','commercial','Test','commercial','Commercial',3),(4,'','consultant','Test','consultant','Consultant',4);
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'atostest'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-23 20:58:34
