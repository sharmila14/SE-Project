-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dpa
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `courses` (
  `courseName` varchar(60) NOT NULL,
  PRIMARY KEY (`courseName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES ('CSCE 5050 Applications of Cryptography'),('CSCE 5170 Graph Theory'),('CSCE 5200 Information Retrieval and Web Search'),('CSCE 5220 Computer Graphics'),('CSCE 5370 Distributed and Parallel Database Systems'),('CSCE 5380 Data Mining'),('CSCE 5510 Wireless Communications'),('CSCE 5520 Wireless Networks and Protocols'),('CSCE 5530 Computer Network Design'),('CSCE 5540 Introduction to Sensor Networks'),('CSCE 5550 Introduction to Computer Security'),('CSCE 5580 Computer Networks '),('CSCE 5615 (5933) Networks-on-Chip'),('CSCE 5932 Internship'),('CSCE 5933 LTE Physical Layer'),('CSCE 5933/5390 Topics in CSCE, Topic: Multimedia Computing'),('DSCI 5350 BigData Analytics');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses_dp`
--

DROP TABLE IF EXISTS `courses_dp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `courses_dp` (
  `userName` varchar(50) NOT NULL,
  `courseCatergory` varchar(20) DEFAULT NULL,
  `courseName` varchar(80) NOT NULL,
  `semesterTaken` varchar(30) DEFAULT NULL,
  `cHrs` int(11) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userName`,`courseName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses_dp`
--

LOCK TABLES `courses_dp` WRITE;
/*!40000 ALTER TABLE `courses_dp` DISABLE KEYS */;
INSERT INTO `courses_dp` VALUES ('sharanya','optional','CSCE 5050 Applications of Cryptography','spring',3,'A'),('sharanya','courseC','CSCE 5170 Graph Theory','spring',3,'A'),('sharanya','optional','CSCE 5200 Information Retrieval and Web Search','Fall',3,'A'),('sharanya','optional','CSCE 5230 Methods of Numerical Computations','Fall',3,'A'),('sharanya','courseD','CSCE 5350 Fundamentals of Database Systems','spring',3,'A'),('sharanya','optional','CSCE 5370 Distributed and Parallel Database Systems','Fall',3,'A'),('sharanya','optional','CSCE 5380 Data Mining','spring',3,'A'),('sharanya','courseA','CSCE 5450 Programming Languages','Fall',3,'A'),('sharanya','optional','CSCE 5530 Computer Network Design','summer',3,'A'),('sharanya','courseB','CSCE 5580 Computer Networks','spring',3,'A'),('sharanya','optional','CSCE 5615 (5933) Networks-on-Chip','spring',3,'A'),('sharanya','optional','CSCE 5933/5390 Topics in CSCE, Topic: Multimedia Computing','spring',3,'A');
/*!40000 ALTER TABLE `courses_dp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `degreeplan`
--

DROP TABLE IF EXISTS `degreeplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `degreeplan` (
  `name` varchar(50) DEFAULT NULL,
  `studentId` int(11) NOT NULL,
  `localAddress` varchar(200) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `degree` varchar(20) DEFAULT NULL,
  `major` varchar(40) DEFAULT NULL,
  `minor` varchar(40) DEFAULT NULL,
  `interestArea` varchar(40) DEFAULT NULL,
  `majorProfessor` varchar(40) DEFAULT NULL,
  `coMajorProfessor` varchar(40) DEFAULT NULL,
  `totalCreditHours` int(11) DEFAULT NULL,
  `degreePlanStatus` varchar(80) DEFAULT NULL,
  `professorSignature` varchar(256) DEFAULT NULL,
  `associateChairSignature` varchar(256) DEFAULT NULL,
  `chairSignature` varchar(256) DEFAULT NULL,
  `rejectComments` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `degreeplan`
--

LOCK TABLES `degreeplan` WRITE;
/*!40000 ALTER TABLE `degreeplan` DISABLE KEYS */;
INSERT INTO `degreeplan` VALUES ('sharanya',11256784,'2415 charlotte street','sharanyagottimukkula@my.unt.edu','M.S','computerScience','computer engineering','software engineering','Dr. Armin Mikler','Dr. Armin Mikler',36,'Degree Plan approved in the CSCE Department','nanditha','hasrhini','aravnd','Please change optional course 3');
/*!40000 ALTER TABLE `degreeplan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dpi`
--

DROP TABLE IF EXISTS `dpi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dpi` (
  `information` varchar(6000) DEFAULT NULL,
  `sNo` int(10) NOT NULL,
  PRIMARY KEY (`sNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dpi`
--

LOCK TABLES `dpi` WRITE;
/*!40000 ALTER TABLE `dpi` DISABLE KEYS */;
INSERT INTO `dpi` VALUES ('All the Computer science and Engineering Masters\'s students need to submit a degree plan (A list of courses studied or planning to study towars their Mater\'s degree). It is recommended that every student have their degree plan approved once they complete 18 credit hours. Students need to choose a major professor submit major professor, get the degree plan approved by the major professor and then submit it to the adminspecialist. All the Interest Areas, Required Courses and optional course information can be found on this page.',1);
/*!40000 ALTER TABLE `dpi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gre`
--

DROP TABLE IF EXISTS `gre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gre` (
  `userName` varchar(50) NOT NULL,
  `verbal` int(11) DEFAULT NULL,
  `quantitative` int(11) DEFAULT NULL,
  `analytical` int(11) DEFAULT NULL,
  `dateTaken` date DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gre`
--

LOCK TABLES `gre` WRITE;
/*!40000 ALTER TABLE `gre` DISABLE KEYS */;
INSERT INTO `gre` VALUES ('sharanya',130,130,2,'2018-10-12');
/*!40000 ALTER TABLE `gre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interestareas`
--

DROP TABLE IF EXISTS `interestareas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `interestareas` (
  `interestArea` varchar(500) NOT NULL,
  `major` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`interestArea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interestareas`
--

LOCK TABLES `interestareas` WRITE;
/*!40000 ALTER TABLE `interestareas` DISABLE KEYS */;
INSERT INTO `interestareas` VALUES ('Algorithms and Theory ','CS'),('Communications and Networks','CE'),('Computational Science','CS'),('Computer Networking and Security','CS'),('Computer Systems','CSCE'),('Database Management and Data Mining','CS'),('Embedded and Real-Time Systems','CE'),('Game Programming','CS'),('Intelligent Systems','CS'),('Software Engineering','CS'),('VLSI','CE');
/*!40000 ALTER TABLE `interestareas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `login` (
  `userName` varchar(40) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(30) DEFAULT NULL,
  `approvalStatus` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('aravind','347b7d2417ca30d906dc5edda4056d7b','student','approved'),('bryant','f925916e2754e5e03f75dd58a5733251','chair','approved'),('CSCEUNT_DPA','a39d362c8364f35fe6ce612d1e5dbee3','admin','approved'),('dolly','f925916e2754e5e03f75dd58a5733251','student','approved'),('george','4bc9a9caad572fd65efdea49f8297fc3','student','approved'),('harshini','e6d304912bdaaad6e67c2f6fdf8015cb','student','approved'),('melanie','f925916e2754e5e03f75dd58a5733251','adminspecialist','approved'),('mikler','e63eea102da9e561d9e1281a9e2dd6b6','professor','approved'),('nanditha','8e86ec7899c66248e6bf5d24503bd3f9','student','approved'),('pushpa','df6e3cce545e954073a7fa82beb3ac8d','professor','approved'),('robert','f925916e2754e5e03f75dd58a5733251','associatechair','approved'),('sahithya','f925916e2754e5e03f75dd58a5733251','student','approved'),('sharanya','d232704062b0fea5c8d5b869cddef2a5','student','approved'),('sharmila','f925916e2754e5e03f75dd58a5733251','student','approved');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `majorprofessor`
--

DROP TABLE IF EXISTS `majorprofessor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `majorprofessor` (
  `studentName` varchar(50) NOT NULL,
  `studentMajor` varchar(20) DEFAULT NULL,
  `professorName` varchar(50) DEFAULT NULL,
  `professorEmail` varchar(60) DEFAULT NULL,
  `degreePlanStatus` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`studentName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `majorprofessor`
--

LOCK TABLES `majorprofessor` WRITE;
/*!40000 ALTER TABLE `majorprofessor` DISABLE KEYS */;
INSERT INTO `majorprofessor` VALUES ('aravind','CS','Bryant Barett','BryantBarett@unt.edu',NULL),('dolly','CE','Dr. Armin Mikler','arminmikler@unt.edu',NULL),('harshini','CS','Bryant Barett','BryantBarett@unt.edu',NULL),('nanditha','CS','Bryant Barett','BryantBarett@unt.edu',NULL),('sharanya','CS','Dr. Armin Mikler','arminmikler@unt.edu','yes'),('sharmila','CE','Robert Akl','roberakl@unt.edu',NULL);
/*!40000 ALTER TABLE `majorprofessor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mandatorycourses`
--

DROP TABLE IF EXISTS `mandatorycourses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mandatorycourses` (
  `CourseName` varchar(80) NOT NULL,
  `groupId` varchar(20) DEFAULT NULL,
  `major` varchar(20) DEFAULT NULL,
  `seqNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`CourseName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mandatorycourses`
--

LOCK TABLES `mandatorycourses` WRITE;
/*!40000 ALTER TABLE `mandatorycourses` DISABLE KEYS */;
INSERT INTO `mandatorycourses` VALUES ('CSCE 5150 Analysis of Algorithms','C','CS',1),('CSCE 5160 Parallel Processing and Algorithms','B','CE',1),('CSCE 5170 Graph Theory','C','CS',2),('CSCE 5210 Artificial Intelligence','D','CS',1),('CSCE 5350 Fundamentals of Database Systems','D','CS',2),('CSCE 5400 Automata Theory','C','CS',3),('CSCE 5430 Software Engineering','A','CS',1),('CSCE 5440 Real-Time Software Development','C','CE',1),('CSCE 5450 Programming Languages','A','CS',2),('CSCE 5510 Wireless Communications','A','CE',1),('CSCE 5520 Wireless Networks and Protocols','A','CE',2),('CSCE 5550 Computer Security','D','CS',3),('CSCE 5580 Computer Networks','B','CS',1),('CSCE 5580 ComputerNetworks','A','CE',3),('CSCE 5610 Computer System Architecture','B','CSCE',2),('CSCE 5612 (5933) Embedded Hardware & Software Design','C','CE',2),('CSCE 5620 Real-time Operating Systems','C','CE',3),('CSCE 5640 Operating System Design','B','CSCE',3),('CSCE 5650 Compiler Design','A','CS',3),('CSCE 5730 Digital CMOS VLSI Design','D','CE',1),('CSCE 5740 Topics in Modern Electronic System Design','D','CE',2),('CSCE 5760 Design for Fault Tolerance','D','CE',3);
/*!40000 ALTER TABLE `mandatorycourses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `register` (
  `name` varchar(30) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `role` varchar(30) DEFAULT NULL,
  `userName` varchar(30) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `approvalStatus` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES ('Aravind Thotempudi','aravindthottempudi@my.unt.edu','student','aravind','347b7d2417ca30d906dc5edda4056d7b','approved'),('Dr. Armin Mikler','arminmikler@unt.edu','professor','mikler','e63eea102da9e561d9e1281a9e2dd6b6','approved'),('Bryant Barett','BryantBarett@unt.edu','chair','Bryant','f925916e2754e5e03f75dd58a5733251','approved'),('dolly','dolly@gmail.com','student','dolly','f925916e2754e5e03f75dd58a5733251','approved'),('George Joseph','georgejoseph@my.unt.edu','student','george','4bc9a9caad572fd65efdea49f8297fc3','approved'),('Melanie Dewey','melaniedewey@my.unt.edu','adminspecialist','melanie','f925916e2754e5e03f75dd58a5733251','approved'),('Nanditha Bodanapu','nandithabodanapu@my.unt.edu','student','nanditha','8e86ec7899c66248e6bf5d24503bd3f9','approved'),('pushpa','pushpa@gmail.com','professor','pushpa','df6e3cce545e954073a7fa82beb3ac8d','approved'),('Robert Akl','roberakl@unt.edu','associatechair','robert','f925916e2754e5e03f75dd58a5733251','approved'),('sahithya','sahithya@my.unt.edu','student','sahithya','f925916e2754e5e03f75dd58a5733251','approved'),('Sharanya Gottimukkula','sharanyagottimukkua@my.unt.edu','student','Sharanya','d232704062b0fea5c8d5b869cddef2a5','approved'),('sharmila','sharmila1@my.unt.edu','student','sharmila','f925916e2754e5e03f75dd58a5733251','approved'),('Sri Harshini','sriharshinivallabhaneni@my.unt.edu','student','harshini','e6d304912bdaaad6e67c2f6fdf8015cb','approved');
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requests`
--

DROP TABLE IF EXISTS `requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `requests` (
  `userName` varchar(50) NOT NULL,
  `professorName` varchar(50) DEFAULT NULL,
  `professorEmail` varchar(80) NOT NULL,
  `department` varchar(30) DEFAULT NULL,
  `admissionSemester` varchar(30) DEFAULT NULL,
  `admissionYear` int(11) DEFAULT NULL,
  `message` varchar(4000) DEFAULT NULL,
  `requestStatus` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`userName`,`professorEmail`),
  CONSTRAINT `requests_ibfk_1` FOREIGN KEY (`userName`) REFERENCES `login` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
INSERT INTO `requests` VALUES ('aravind','Bryant Barett','BryantBarett@unt.edu','CS','fall',2017,'please accept my request','Request Accepted'),('dolly','Dr. Armin Mikler','arminmikler@unt.edu','CE','spring',2017,'please accept my request','Request Accepted'),('george','Bryant Barett','BryantBarett@unt.edu','CS','fall',2017,'please accept','Request Sent'),('harshini','Bryant Barett','BryantBarett@unt.edu','CS','fall',2017,'Please accept','Request Accepted'),('nanditha','Bryant Barett','BryantBarett@unt.edu','CS','fall',2017,'Hello Sir,\r\n\r\nIt would be great if you can accept my request.\r\n\r\nThanks\r\nSharanya','Request Accepted'),('sharanya','Dr. Armin Mikler','arminmikler@unt.edu','CS','fall',2017,'Hello Sir\r\n\r\nIt would be great if you can accept my request and be my major professor.\r\n\r\nThanks\r\nSharanya','Request Accepted'),('sharanya','Bryant Barett','BryantBarett@unt.edu','CS','fall',2017,'mmmmm','Request Sent'),('sharmila','Robert Akl','roberakl@unt.edu','CE','fall',2017,'Please be my major professor','Request Accepted');
/*!40000 ALTER TABLE `requests` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-25 17:54:02
