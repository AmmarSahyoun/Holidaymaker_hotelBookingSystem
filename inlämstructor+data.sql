-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: holidaymaker
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Temporary view structure for view `allbooking_view`
--

DROP TABLE IF EXISTS `allbooking_view`;
/*!50001 DROP VIEW IF EXISTS `allbooking_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `allbooking_view` AS SELECT 
 1 AS `bookingid`,
 1 AS `checkin`,
 1 AS `checkout`,
 1 AS `companion`,
 1 AS `extrabed`,
 1 AS `meals`,
 1 AS `roomid`,
 1 AS `guestid`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `allrooms_view`
--

DROP TABLE IF EXISTS `allrooms_view`;
/*!50001 DROP VIEW IF EXISTS `allrooms_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `allrooms_view` AS SELECT 
 1 AS `RoomID`,
 1 AS `roomnr`,
 1 AS `RoomTypeID`,
 1 AS `roomType`,
 1 AS `roomprice`,
 1 AS `hotelid`,
 1 AS `hotelname`,
 1 AS `hotelcity`,
 1 AS `distance`,
 1 AS `halfboardprice`,
 1 AS `fullboardprice`,
 1 AS `extrabedprice`,
 1 AS `facilityid`,
 1 AS `pool`,
 1 AS `restaurant`,
 1 AS `childrenactivities`,
 1 AS `entertainment`,
 1 AS `reviewid`,
 1 AS `reviewStars`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `availablerooms`
--

DROP TABLE IF EXISTS `availablerooms`;
/*!50001 DROP VIEW IF EXISTS `availablerooms`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `availablerooms` AS SELECT 
 1 AS `RoomID`,
 1 AS `roomnr`,
 1 AS `RoomTypeID`,
 1 AS `roomType`,
 1 AS `roomprice`,
 1 AS `hotelid`,
 1 AS `hotelname`,
 1 AS `hotelcity`,
 1 AS `distance`,
 1 AS `halfboardprice`,
 1 AS `fullboardprice`,
 1 AS `extrabedprice`,
 1 AS `facilityid`,
 1 AS `pool`,
 1 AS `restaurant`,
 1 AS `childrenactivities`,
 1 AS `entertainment`,
 1 AS `reviewid`,
 1 AS `reviewStars`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `checkIn` date NOT NULL,
  `checkOut` date NOT NULL,
  `companion` int NOT NULL,
  `guest_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `guestID_idx` (`guest_id`),
  CONSTRAINT `guestID` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,'2020-06-01','2020-06-08',3,57),(2,'2020-06-01','2020-06-08',1,12),(3,'2020-06-08','2020-06-10',3,94),(4,'2020-06-01','2020-06-08',1,90),(5,'2020-06-01','2020-06-08',1,30),(6,'2020-06-01','2020-06-08',1,20),(7,'2020-06-01','2020-06-08',1,28),(8,'2020-06-08','2020-06-12',0,48),(9,'2020-06-08','2020-06-15',0,71),(10,'2020-06-01','2020-06-08',5,7),(11,'2020-06-01','2020-06-08',2,9),(12,'2020-07-01','2020-07-08',2,10),(13,'2020-07-08','2020-07-12',2,15),(14,'2020-07-08','2020-07-10',2,26),(15,'2020-07-01','2020-07-08',2,77),(16,'2020-06-24','2020-06-25',1,15),(17,'2020-06-26','2020-06-28',0,41),(18,'2020-06-24','2020-06-26',0,91),(19,'2020-06-26','2020-06-28',2,10),(20,'2020-06-25','2020-06-28',0,100),(21,'2020-05-31','2020-06-09',5,106),(22,'2020-05-31','2020-06-09',5,106),(23,'2020-05-31','2020-06-09',15,106),(24,'2020-05-31','2020-06-09',15,106),(25,'2020-05-31','2020-06-09',15,106),(26,'2020-06-09','2020-06-14',25,106),(27,'2020-06-09','2020-06-12',1,101);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_x_rooms`
--

DROP TABLE IF EXISTS `booking_x_rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_x_rooms` (
  `meals` enum('halfBoard','fullBoard') CHARACTER SET binary COLLATE binary NOT NULL,
  `extraBed` tinyint(1) NOT NULL,
  `rooms_id` int NOT NULL,
  `booking_id` int NOT NULL,
  KEY `roomsID_idx` (`rooms_id`),
  KEY `bookingID_idx` (`booking_id`),
  CONSTRAINT `bookingID` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`),
  CONSTRAINT `roomsID` FOREIGN KEY (`rooms_id`) REFERENCES `rooms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_x_rooms`
--

LOCK TABLES `booking_x_rooms` WRITE;
/*!40000 ALTER TABLE `booking_x_rooms` DISABLE KEYS */;
INSERT INTO `booking_x_rooms` VALUES (_binary 'fullBoard',0,65,1),(_binary 'halfBoard',0,44,2),(_binary 'fullBoard',0,65,3),(_binary 'halfBoard',1,16,4),(_binary 'halfBoard',0,30,5),(_binary 'fullBoard',0,4,6),(_binary 'fullBoard',0,67,7),(_binary 'halfBoard',0,44,8),(_binary 'halfBoard',0,44,9),(_binary 'halfBoard',0,23,10),(_binary 'halfBoard',1,4,11),(_binary 'halfBoard',1,16,12),(_binary 'halfBoard',1,16,13),(_binary 'halfBoard',1,44,14),(_binary 'halfBoard',1,30,15),(_binary 'halfBoard',0,94,10),(_binary 'halfBoard',0,98,16),(_binary 'fullBoard',1,76,17),(_binary 'fullBoard',0,96,18),(_binary 'halfBoard',1,89,19),(_binary 'halfBoard',0,69,20),(_binary 'halfBoard',0,84,26),(_binary 'halfBoard',0,75,27);
/*!40000 ALTER TABLE `booking_x_rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility`
--

DROP TABLE IF EXISTS `facility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facility` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pool` tinyint(1) NOT NULL,
  `restaurant` tinyint(1) NOT NULL,
  `childrenActivities` tinyint(1) NOT NULL,
  `entertainment` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` VALUES (1,1,0,1,0),(2,1,1,1,0),(3,0,1,0,0),(4,1,1,1,0),(5,1,1,1,1);
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guest`
--

DROP TABLE IF EXISTS `guest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guest` (
  `id` int NOT NULL AUTO_INCREMENT,
  `guestName` varchar(255) NOT NULL,
  `guestAddress` varchar(255) NOT NULL,
  `guestEmail` varchar(255) NOT NULL,
  `guestMobile` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guest`
--

LOCK TABLES `guest` WRITE;
/*!40000 ALTER TABLE `guest` DISABLE KEYS */;
INSERT INTO `guest` VALUES (1,'Minny Willoughey','8 Weeping Birch Trail','mwilloughey0@miitbeian.gov.cn','126-395-7902'),(2,'Dorelia Minocchi','6 Independence Trail','dminocchi1@cnn.com','569-905-7274'),(3,'Ervin Wyleman','34 Stang Court','ewyleman2@weibo.com','791-338-7211'),(4,'Druci Leipoldt','64 Briar Crest Lane','dleipoldt3@storify.com','777-685-9502'),(5,'Elijah Lichtfoth','5003 Pennsylvania Road','elichtfoth4@topsy.com','208-792-6864'),(6,'Gibb Rawsthorne','84484 Maple Wood Plaza','grawsthorne5@bloglines.com','481-482-3660'),(7,'Jessica Tipens','36 Vernon Plaza','jtipens6@soup.io','107-548-9892'),(8,'Averill Bennion','43 Cherokee Junction','abennion7@hhs.gov','867-937-0438'),(9,'Agace Sayward','000 Holmberg Drive','asayward8@about.com','709-572-1946'),(10,'Carlita Temple','51943 Merrick Hill','ctemple9@miitbeian.gov.cn','114-871-2008'),(11,'Reginald Dawkins','2 Roxbury Pass','rdawkinsa@loc.gov','394-990-1816'),(12,'Danica Greenhowe','034 Jay Alley','dgreenhoweb@mail.ru','495-555-5615'),(13,'Desmond Wilgar','17 Harper Court','dwilgarc@smh.com.au','489-994-2307'),(14,'Tybalt Hubber','82845 Mariners Cove Parkway','thubberd@bloglovin.com','962-305-6991'),(15,'Corty Martinolli','7734 Eagle Crest Way','cmartinollie@diigo.com','101-801-6164'),(16,'Decca Braisher','12057 Victoria Street','dbraisherf@apache.org','174-473-8276'),(17,'Garey Buyers','56 Oak Valley Street','gbuyersg@microsoft.com','494-606-8172'),(18,'Emelia Banton','9970 Tony Crossing','ebantonh@google.co.jp','388-112-7205'),(19,'Shaina Ivushkin','4 Harbort Terrace','sivushkini@typepad.com','556-595-7340'),(20,'Jourdan Yeowell','927 Esch Terrace','jyeowellj@acquirethisname.com','251-691-5277'),(21,'Lay Harmer','813 Pierstorff Hill','lharmerk@usatoday.com','522-679-8448'),(22,'Franciska Rookes','4 Declaration Crossing','frookesl@dmoz.org','817-788-6424'),(23,'Ileane Simunek','6 Dakota Pass','isimunekm@kickstarter.com','871-702-4736'),(24,'Stevana Osgodby','310 Grasskamp Crossing','sosgodbyn@yandex.ru','104-842-7890'),(25,'Freeland Saltsberger','1854 Hermina Drive','fsaltsbergero@ifeng.com','881-909-2275'),(26,'Gnni Edmons','43857 Lunder Way','gedmonsp@cocolog-nifty.com','143-506-2263'),(27,'Dulci Corney','417 Blue Bill Park Crossing','dcorneyq@topsy.com','223-122-9703'),(28,'Vanny Dunkerton','31128 Continental Lane','vdunkertonr@newsvine.com','934-556-2546'),(29,'Bel Sleford','48 Fuller Alley','bslefords@timesonline.co.uk','316-549-2329'),(30,'Eloisa Barrabeale','50 Kipling Court','ebarrabealet@sina.com.cn','200-709-9386'),(31,'Roddy Pickthorne','87 Mifflin Place','rpickthorneu@mediafire.com','467-693-4539'),(32,'Tadio Puzey','768 Union Terrace','tpuzeyv@unblog.fr','918-779-1831'),(33,'Ade Hastler','08 Cherokee Place','ahastlerw@examiner.com','799-646-2857'),(34,'Darrin Downgate','34 Kim Park','ddowngatex@wired.com','527-692-8440'),(35,'Kenna Lawty','7 Gerald Pass','klawtyy@go.com','652-560-4376'),(36,'Cullie Ridett','14 Pepper Wood Court','cridettz@xrea.com','274-788-8408'),(37,'Queenie Holsall','0249 Vernon Court','qholsall10@ted.com','910-860-9279'),(38,'Donni Crab','17212 Spohn Crossing','dcrab11@blogs.com','787-638-4429'),(39,'Ursa Merriton','8 La Follette Junction','umerriton12@google.cn','371-233-5660'),(40,'Rodge Aubray','1 Main Crossing','raubray13@apple.com','929-956-6996'),(41,'Cass Conelly','68128 Hallows Plaza','cconelly14@myspace.com','903-227-8461'),(42,'Paton Backson','7 Scoville Place','pbackson15@myspace.com','290-510-3859'),(43,'Gibb Beahan','9 Anhalt Parkway','gbeahan16@dropbox.com','478-583-8356'),(44,'Juditha Slowgrave','6 Mitchell Court','jslowgrave17@adobe.com','538-893-8366'),(45,'Lennard Fownes','21230 Heath Place','lfownes18@stanford.edu','508-111-1163'),(46,'Jacquelynn Darragon','438 Mccormick Trail','jdarragon19@studiopress.com','929-599-5700'),(47,'Orsola Hugh','1827 Sachtjen Junction','ohugh1a@trellian.com','317-783-3140'),(48,'Wandie Tramel','914 Emmet Center','wtramel1b@123-reg.co.uk','506-340-9490'),(49,'Tucker MacEntee','0 Pleasure Park','tmacentee1c@army.mil','760-818-3702'),(50,'Mella Dallicott','80945 Carey Road','mdallicott1d@icio.us','920-296-2864'),(51,'Corry Kempton','667 Green Ridge Road','ckempton1e@amazon.com','415-144-3491'),(52,'Richmound Martinho','849 Bluejay Plaza','rmartinho1f@latimes.com','124-886-1236'),(53,'Ivar Petrushkevich','264 Dryden Pass','ipetrushkevich1g@blogspot.com','269-722-6268'),(54,'Merell Boxhall','0023 Warrior Hill','mboxhall1h@tinyurl.com','780-567-1701'),(55,'Wallie Garvan','612 Fulton Avenue','wgarvan1i@t.co','649-534-3455'),(56,'Nickola Penniell','8760 Del Sol Court','npenniell1j@pcworld.com','154-768-7215'),(57,'Laura MacKibbon','55 Waubesa Drive','lmackibbon1k@si.edu','274-364-8595'),(58,'Thorsten MacCumiskey','9904 Fulton Way','tmaccumiskey1l@home.pl','624-157-3609'),(59,'Kylie Spollen','23 Mifflin Road','kspollen1m@i2i.jp','813-765-3089'),(60,'Heall McGready','0 Buhler Drive','hmcgready1n@disqus.com','791-188-7775'),(61,'Raynor Goley','03 Pennsylvania Parkway','rgoley1o@washington.edu','891-545-1784'),(62,'Janeen Van De Cappelle','0520 Burrows Circle','jvan1p@posterous.com','429-205-2499'),(63,'Cob Luttgert','04 Autumn Leaf Road','cluttgert1q@census.gov','570-681-3778'),(64,'Joan Skeermer','4902 Golf Course Parkway','jskeermer1r@zdnet.com','401-153-4341'),(65,'Miner Sainz','0 Union Park','msainz1s@ask.com','728-785-8634'),(66,'Prudy Goody','261 La Follette Center','pgoody1t@netvibes.com','938-709-5366'),(67,'Augustine Brolan','01 Ridgeway Trail','abrolan1u@sogou.com','767-588-0732'),(68,'Marlie Coom','5314 Golf Course Alley','mcoom1v@mozilla.org','932-431-1875'),(69,'Jamey Rogeon','3709 Meadow Valley Avenue','jrogeon1w@taobao.com','459-450-0301'),(70,'Reyna Pedican','09011 Badeau Place','rpedican1x@uol.com.br','795-487-9247'),(71,'Chlo Insko','4 Sutteridge Pass','cinsko1y@taobao.com','220-904-7623'),(72,'Muffin Cornish','6 Parkside Terrace','mcornish1z@rediff.com','513-742-2408'),(73,'Moina O\' Donohue','6974 Heath Pass','mo20@youku.com','712-291-9485'),(74,'Wolfy Grunguer','27810 Doe Crossing Alley','wgrunguer21@dell.com','503-380-9892'),(75,'Bennett Castellaccio','3491 Esker Way','bcastellaccio22@reference.com','155-137-5187'),(76,'Victoir Durnan','407 Annamark Pass','vdurnan23@ow.ly','299-510-7707'),(77,'Ranee MacCarrane','2230 Gale Point','rmaccarrane24@etsy.com','563-196-3058'),(78,'Grenville Ferriman','4859 Surrey Junction','gferriman25@cnet.com','706-662-0098'),(79,'Eddy Paunsford','4092 Armistice Parkway','epaunsford26@fastcompany.com','993-763-6204'),(80,'Viole Corradeschi','08438 Mendota Circle','vcorradeschi27@reverbnation.com','202-229-9936'),(81,'Erasmus Culy','645 Tony Avenue','eculy28@aboutads.info','415-179-5588'),(82,'Laurette McCaughey','38 Summerview Parkway','lmccaughey29@goo.ne.jp','893-450-6225'),(83,'Nels Lamborn','26 High Crossing Place','nlamborn2a@hud.gov','442-793-1448'),(84,'Auroora Sworne','41 Linden Drive','asworne2b@youtu.be','346-931-9825'),(85,'Lancelot Bullerwell','2 Kropf Terrace','lbullerwell2c@pen.io','850-828-6220'),(86,'Valry Landrick','451 Summer Ridge Center','vlandrick2d@statcounter.com','646-416-8514'),(87,'Joellyn Gresswell','9 Pennsylvania Lane','jgresswell2e@sciencedaily.com','676-474-6013'),(88,'Clarisse Noke','07280 Summit Street','cnoke2f@shop-pro.jp','563-732-0680'),(89,'Arnaldo Chalker','91 International Point','achalker2g@godaddy.com','551-950-5193'),(90,'Nolan Knutton','5 Oak Valley Park','nknutton2h@sfgate.com','797-562-1066'),(91,'Claudian Yon','5 Lindbergh Hill','cyon2i@blogger.com','547-588-4593'),(92,'Teddi Damrell','37247 Anniversary Trail','tdamrell2j@salon.com','132-270-9685'),(93,'Olly Merrell','140 Bashford Alley','omerrell2k@reverbnation.com','878-784-0434'),(94,'Maud Prantl','80189 Vernon Park','mprantl2l@usda.gov','796-576-4889'),(95,'Ingeborg Lemmanbie','4 Main Road','ilemmanbie2m@delicious.com','851-955-2364'),(96,'Edwin Baxill','8361 Mesta Junction','ebaxill2n@state.gov','223-165-7839'),(97,'Risa Franken','53 Loomis Place','rfranken2o@tumblr.com','307-541-4656'),(98,'Manda Bowdler','076 Kropf Center','mbowdler2p@smugmug.com','502-810-9091'),(99,'Dulce Howard','9356 Manufacturers Trail','dhoward2q@4shared.com','290-600-4026'),(100,'Dode Cayette','6 Meadow Vale Hill','dcayette2r@tiny.cc','781-402-8942'),(101,'Ammar Sahyoun','Norra Järnvägs 19','ammarzgr@hotmail.com','0739714925'),(102,'Johan Grön','ärnvägs 1','johangr@yahool.com','0739765925'),(103,'Faris Ali','PotatisVägen 5','farisaliii@yahoo.com','0739710054'),(104,'Anna preli','PotatisVägen 8','perliAnna@yahoo.com','0739321500'),(105,'Johan Ali','TomatoVägen 3','JohanAlii@yahoo.com','0739777477'),(106,'Mohammad','Jesser','mdasfari@hotmail.com','55872949'),(107,'Zaher','Alepo','zouher@hotmail.com','44557788'),(108,'Kemo','Abu Remaneh','kemo@hotmail.com','123456789');
/*!40000 ALTER TABLE `guest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hotelName` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `distance` varchar(45) NOT NULL,
  `halfBoardPrice` double DEFAULT NULL,
  `fullBoardPrice` double DEFAULT NULL,
  `extraBedPrice` varchar(45) DEFAULT NULL,
  `facility_id` int NOT NULL,
  `review_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `facilityID_idx` (`facility_id`),
  KEY `reviewID_idx` (`review_id`),
  CONSTRAINT `facilityID` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`id`),
  CONSTRAINT `reviewID` FOREIGN KEY (`review_id`) REFERENCES `review` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'MilanoHotel','Milano','1km from Central',10,16,'11',4,3),(2,'VeniceHotel','Venice','0km from Beach',10.99,19.99,'12',2,4),(3,'RomeHotel','Rome','2km from Central',9.99,15.99,'10.99',3,3),(4,'CataniaHotel','Catania','1km from Central',12.99,20.99,'12.99',5,4),(5,'BariHotel','Bari','0km from Beach',11,18,'12',1,4);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reviewStars` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,1),(2,2),(3,3),(4,4),(5,5);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_type`
--

DROP TABLE IF EXISTS `room_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roomType` enum('SINGLE','DOUBLE','SUITE') NOT NULL,
  `roomPrice` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `roomType_UNIQUE` (`roomType`),
  UNIQUE KEY `roomPrice_UNIQUE` (`roomPrice`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_type`
--

LOCK TABLES `room_type` WRITE;
/*!40000 ALTER TABLE `room_type` DISABLE KEYS */;
INSERT INTO `room_type` VALUES (1,'SINGLE',50),(2,'DOUBLE',65),(3,'SUITE',90);
/*!40000 ALTER TABLE `room_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roomNr` varchar(45) NOT NULL,
  `roomTypeID` int NOT NULL,
  `hotelID` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `hotelID_idx` (`hotelID`),
  KEY `fk_roomTypeIF_idx` (`roomTypeID`),
  CONSTRAINT `fk_hotelID` FOREIGN KEY (`hotelID`) REFERENCES `hotel` (`id`),
  CONSTRAINT `fk_roomTypeIF` FOREIGN KEY (`roomTypeID`) REFERENCES `room_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (4,'37',2,5),(16,'28',2,4),(23,'32',3,4),(30,'20',2,3),(44,'12',2,2),(65,'1',3,1),(67,'2',2,1),(68,'3',1,1),(69,'10',1,2),(70,'16',3,2),(71,'24',3,3),(72,'19',1,3),(73,'25',1,4),(74,'33',1,5),(75,'40',3,5),(76,'4',1,1),(77,'5',1,1),(78,'6',2,1),(79,'7',2,1),(80,'8',2,1),(81,'9',1,2),(82,'11',1,2),(83,'13',2,2),(84,'14',2,2),(85,'15',2,2),(86,'17',1,3),(87,'18',1,3),(88,'21',2,3),(89,'22',2,3),(90,'23',2,3),(91,'26',1,4),(92,'27',1,4),(93,'29',2,4),(94,'30',2,4),(95,'31',2,4),(96,'34',1,5),(97,'35',1,5),(98,'36',2,5),(99,'38',2,5),(100,'39',2,5);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `allbooking_view`
--

/*!50001 DROP VIEW IF EXISTS `allbooking_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `allbooking_view` AS select `booking`.`id` AS `bookingid`,`booking`.`checkIn` AS `checkin`,`booking`.`checkOut` AS `checkout`,`booking`.`companion` AS `companion`,`booking_x_rooms`.`extraBed` AS `extrabed`,`booking_x_rooms`.`meals` AS `meals`,`booking_x_rooms`.`rooms_id` AS `roomid`,`booking`.`guest_id` AS `guestid` from (`booking_x_rooms` join `booking` on((`booking_x_rooms`.`booking_id` = `booking`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `allrooms_view`
--

/*!50001 DROP VIEW IF EXISTS `allrooms_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `allrooms_view` AS select `rooms`.`id` AS `RoomID`,`rooms`.`roomNr` AS `roomnr`,`room_type`.`id` AS `RoomTypeID`,`room_type`.`roomType` AS `roomType`,`room_type`.`roomPrice` AS `roomprice`,`hotel`.`id` AS `hotelid`,`hotel`.`hotelName` AS `hotelname`,`hotel`.`city` AS `hotelcity`,`hotel`.`distance` AS `distance`,`hotel`.`halfBoardPrice` AS `halfboardprice`,`hotel`.`fullBoardPrice` AS `fullboardprice`,`hotel`.`extraBedPrice` AS `extrabedprice`,`facility`.`id` AS `facilityid`,`facility`.`pool` AS `pool`,`facility`.`restaurant` AS `restaurant`,`facility`.`childrenActivities` AS `childrenactivities`,`facility`.`entertainment` AS `entertainment`,`review`.`id` AS `reviewid`,`review`.`reviewStars` AS `reviewStars` from ((((`rooms` join `room_type` on((`room_type`.`id` = `rooms`.`roomTypeID`))) join `hotel` on((`hotel`.`id` = `rooms`.`hotelID`))) join `facility` on((`facility`.`id` = `hotel`.`facility_id`))) join `review` on((`review`.`id` = `hotel`.`review_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `availablerooms`
--

/*!50001 DROP VIEW IF EXISTS `availablerooms`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `availablerooms` AS select `rooms`.`id` AS `RoomID`,`rooms`.`roomNr` AS `roomnr`,`room_type`.`id` AS `RoomTypeID`,`room_type`.`roomType` AS `roomType`,`room_type`.`roomPrice` AS `roomprice`,`hotel`.`id` AS `hotelid`,`hotel`.`hotelName` AS `hotelname`,`hotel`.`city` AS `hotelcity`,`hotel`.`distance` AS `distance`,`hotel`.`halfBoardPrice` AS `halfboardprice`,`hotel`.`fullBoardPrice` AS `fullboardprice`,`hotel`.`extraBedPrice` AS `extrabedprice`,`facility`.`id` AS `facilityid`,`facility`.`pool` AS `pool`,`facility`.`restaurant` AS `restaurant`,`facility`.`childrenActivities` AS `childrenactivities`,`facility`.`entertainment` AS `entertainment`,`review`.`id` AS `reviewid`,`review`.`reviewStars` AS `reviewStars` from ((((`rooms` join `room_type` on((`room_type`.`id` = `rooms`.`roomTypeID`))) join `hotel` on((`hotel`.`id` = `rooms`.`hotelID`))) join `facility` on((`facility`.`id` = `hotel`.`facility_id`))) join `review` on((`review`.`id` = `hotel`.`review_id`))) where exists(select 'x' from (`booking_x_rooms` join `booking` on((`booking_x_rooms`.`booking_id` = `booking`.`id`))) where ((`booking_x_rooms`.`rooms_id` = `rooms`.`id`) and (now() between `booking`.`checkIn` and `booking`.`checkOut`))) is false */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-23 23:44:07
