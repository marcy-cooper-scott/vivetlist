-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: vivetlist_db
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_time` datetime DEFAULT NULL,
  `doctor_name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK886ced1atxgvnf1o3oxtj5m4s` (`user_id`),
  CONSTRAINT `FK886ced1atxgvnf1o3oxtj5m4s` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (1,'2018-05-21 15:00:00','Hawkeye','Mobile Clinic',1),(2,'2018-06-01 09:30:00','Howser','Memorial',2),(3,'2018-05-18 11:45:00','Welby','Baptist',3),(5,'2018-08-13 16:15:00','Shepherd','Mercy Clinic',5),(6,'2018-10-01 15:15:00','Hunnicutt','Military Dr',6),(7,'2018-05-12 09:30:00','Gonzales','Military Dr',1),(9,'2018-05-12 10:00:00','Dr. Smith','San Antonio',5),(10,'2018-05-12 10:14:00','Dr. Jones','San Antonio',5),(11,'2018-05-12 12:45:00','Dr. Harris','San Antonio',5),(12,'2018-05-12 11:30:00','Gonzales','Military Dr',1),(13,'2018-05-12 11:45:00','Dr. Jones','San Antonio',1),(22,'2018-05-25 13:30:00','Dr. Detroit','San Antonio',5),(23,'2018-05-23 14:30:00','Dr. No','San Antonio',5),(24,'2018-05-11 15:00:00','Dr. Smith','San Antonio',5),(30,'2018-06-07 16:00:00','Dr. Roberts','San Antonio',4),(31,'2018-06-11 08:00:00','Dr. Smith','San Antonio',4),(32,'2018-05-10 13:30:00','Dr. Smith','San Antonio',4),(33,'2018-05-29 09:30:00','Dr. Jones','San Antonio',4),(34,'2018-05-19 15:52:00','Dr. Smith','San Antonio',4),(35,'2018-05-24 16:01:00','Dr. Detroit','San Antonio',4),(36,'2018-05-17 12:00:00','Gonzales','Medical Dr Clinic',1),(37,'2018-05-30 08:48:00','Dr Smith','San Antonio',4),(38,'2018-05-28 08:54:00','Dr Smith','San Antonio',4),(39,'2018-05-28 09:05:00','Dr. Jones','San Antonio',4);
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `body` varchar(500) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh4c7lvsc298whoyd4w9ta25cr` (`post_id`),
  KEY `FK8omq0tc18jd43bu5tjh6jvraq` (`user_id`),
  CONSTRAINT `FK8omq0tc18jd43bu5tjh6jvraq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKh4c7lvsc298whoyd4w9ta25cr` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'What kind of glucose meter do you have?',2,6),(2,'I would love to join an in-person support group!!',3,2),(3,'Wow, I didn\'t know that either!!',5,4),(4,'Try any of the Annie\'s brand snacks or the Fiber One snacks.  If you\'re in the mood for ice cream, Ben & Jerry\'s Cherry Garcia is good, too!!',6,2),(5,'Since my last trip to Iraq years ago, I have had trouble sleeping, but instead of a machine, I have to sleep in total silence or I become so unnerved that I cannot sleep and toss and turn. I might have to try the machine and see if that helps! Thanks for your post!',7,4),(6,'How old is your son? I had that fear with my daughter at 1.5 years after her second OHS. It was never really an issue. I think she kind of regulated herself. Regardless of age, you can use pillows on either side to make a kind of trough to help limit rolling.',8,6),(7,'Keep an eye on how the scar closes itself, how it heals. A good idea is taking a photograph every day to ensure it doesn\'t get red (infections). As @Biggetybird says, use pillows as barriers. My son was also 14 months when he had his second surgery and he didn\'t roll over. They are going to break the rib cage, I think he is not going to move at all (because of the pain). Good luck!',8,2),(8,'Maybe the pillow trick could help with rolling around. However, that could backfire I think because they might roll away to get away from the pillows. :(',8,4),(9,'My son had his big surgery at four months old. The day after coming home from the hospital (9 days post op) he rolled from back to belly for the first time! We were told he will “self limit” it’s more a worry for adults picking them up, to scoop and not grab under the armpits. I wouldn’t worry too much, they are seriously so resilient. Sending good thoughts for a successful surgery!',8,4),(11,'Basically the reason you must take prophylactic antibiotics is because your oral flora (aka mouth bacteria) are able to enter your blood and eventually your heart during dental work. This is simply due to tissue damage that your dentist causes during cleaning. Certain bacteria such as streptococcus Viridans are able to colonize damaged heart valves or in your case a congenital heart defects. This can lead to a myriad of dangerous consequences.',10,4),(12,'How old is your son? I had that fear with my daughter at 1.5 years after her second OHS. It was never really an issue. I think she kind of regulated herself. Regardless of age, you can use pillows on either side to make a kind of trough to help limit rolling.',8,5),(13,'You\'re welcome! I hope it helps you!!',7,1);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'Diabetes is a number of diseases that involve problems with the hormone insulin. This group is intended to help those suffering with diabetes to communicate and help each other.','Diabetes'),(2,'Cancer is when abnormal cells divide in an uncontrolled way. Users can use this group to discuss treatment options and outreach to help patients and their families.','Cancer'),(3,'This group is for those suffering from Post Traumatic Stress Disorder (PTSD), a psychiatric disorder that can occur in people who have experienced or witnessed a traumatic event.','PTSD'),(4,'MS remains a mystery, but there\'s also a wealth of information available. This group will help those with MS to communicate and help each other with new treatments and their results.','Multiple Sclerosis'),(5,'With congenital heart defects, some part of the heart doesn\'t form properly before birth. This group is for adults with CHD or parents of children with CHD.','Congenital Heart Disease'),(6,'This group is for those with Attention Deficit Hyperactivity Disorder (ADHD), a highly genetic, brain-based syndrome that has to do with the regulation of a particular set of brain functions and related behaviors.','ADHD');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups_users`
--

DROP TABLE IF EXISTS `groups_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups_users` (
  `group_id` bigint(20) NOT NULL,
  `users_id` bigint(20) NOT NULL,
  KEY `FKtqn1wd1nl4s87rm85wtcsi763` (`users_id`),
  KEY `FKakkv3ihrlmgfjf50vj62a0jr6` (`group_id`),
  CONSTRAINT `FKakkv3ihrlmgfjf50vj62a0jr6` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `FKtqn1wd1nl4s87rm85wtcsi763` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups_users`
--

LOCK TABLES `groups_users` WRITE;
/*!40000 ALTER TABLE `groups_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicines`
--

DROP TABLE IF EXISTS `medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicines` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `medicine_name` varchar(255) NOT NULL,
  `notes` varchar(500) NOT NULL,
  `refill_date` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3nje7c71dsgmn88656kyithyw` (`user_id`),
  CONSTRAINT `FK3nje7c71dsgmn88656kyithyw` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicines`
--

LOCK TABLES `medicines` WRITE;
/*!40000 ALTER TABLE `medicines` DISABLE KEYS */;
INSERT INTO `medicines` VALUES (1,'insulin','Take 2','2018-06-02 10:00:00',1),(2,'insulin','Take 2','2018-08-01 12:00:00',2),(3,'codeine','Take 2','2018-07-10 09:00:00',3),(4,'avonex','Take 2','2018-05-25 15:00:00',4),(5,'atenolol','Take 2','2018-06-30 10:00:00',5),(6,'adderall','Take 2','2018-11-18 17:00:00',6),(9,'coumadin','take 2 a day','2018-05-12 10:00:00',5),(19,'Advil','asdasd','2018-05-12 16:22:00',5),(22,'Viagra','Take all the time!!','2018-05-21 17:30:00',2),(25,'metoprolol','take 2 a day','2018-07-05 12:00:00',5),(32,'Haldol','Take daily','2018-05-14 12:23:00',1),(33,'Aceon','Take daily','2018-05-14 12:25:00',1),(34,'metoprolol','take with food','2018-05-14 16:00:00',4),(35,'coumadin','take 2 a day','2018-08-16 16:00:00',4),(36,'Prozac','take 2 a day','2018-07-26 15:20:00',5),(39,'Xanax','Take daily','2018-05-17 00:07:00',1),(43,'advil','Take daily','2018-05-16 09:10:00',4),(44,'Actos','Take daily','2018-05-16 11:00:00',4);
/*!40000 ALTER TABLE `medicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification_type`
--

DROP TABLE IF EXISTS `notification_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification_type`
--

LOCK TABLES `notification_type` WRITE;
/*!40000 ALTER TABLE `notification_type` DISABLE KEYS */;
INSERT INTO `notification_type` VALUES (1,'TEXT'),(2,'EMAIL'),(3,'BOTH');
/*!40000 ALTER TABLE `notification_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `body` varchar(500) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm9ev48bvdgo25ypcy44mu5t8k` (`group_id`),
  KEY `FK5lidm6cqbc7u4xhqpxm898qme` (`user_id`),
  CONSTRAINT `FK5lidm6cqbc7u4xhqpxm898qme` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKm9ev48bvdgo25ypcy44mu5t8k` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'Hi, I was diagnosed 5 years ago. It\'s nice to be able to connect with others who have the disease.','Diabetic for 5 years',1,1),(2,'Has anyone had trouble with their glucose meter malfunctioning?','Glucose Meter',1,2),(3,'Hi, I would like to start an in-person support group for PTSD. Is anyone interested?','Meetup Group',3,3),(5,'I had no idea that ADHD is harder to diagnose in women!','Statistics',6,5),(6,'Hi everybody, this is my first post here.  It\'s been hard for me to stick to my diet so I\'m trying to find some sugar-free snacks that taste like I\'m really eating the good stuff. Does anybody have any tips?','Diet',1,1),(7,'I have a suggestion for anyone who\'s having sleep problems. Invest in a good white noise machine for some soothing background noise. I personally like the water sounds but most of the machines I\'ve seen have lots of different choices. Just something to try if you\'re having trouble sleeping.','Sleep Suggestions',3,1),(8,'My son is about to have open heart surgery and we are hoping for some help when it comes to the recovery. Just some basic advice and we are seriously wondering how to keep him from rolling on his stomach at night','Looking For Advice',5,5),(9,'I have been noodling a topic for quite a while and I would love to have everyone\'s perspective. Now,  I want to know what keeps you going through the dark times? For me, the answer changes on a day-to-day basis: Faith, my children, my parents, and friends are usually tops on the list. But somedays it\'s Nala the family husky/Sheppard and resident crazy dog.','What Keeps You Going?',5,4),(10,'I have a congenital heart defect and have to take antibiotics anytime I get work done on my teeth. Also my cardiologist stresses that I see a dentist at least every 6 months. Just curious about the correlation between the two areas of the body.','How and why are dental work and heart health related.',5,5),(11,'I have my (first) annual MRIs on Monday and the neurologist appointment in 3 weeks. I’m nervous about the results but don’t want my concern to dominate my life. Anyone have fun ideas/traditions/anything to help make this time easier?\r\n\r\nI know logically there’s nothing to be afraid of unless I have new lesions, but it’s still more nerve wracking than I imagined leading up to the event, especially since I’ve been having more symptoms recently than normal.\r\n\r\nThanks for your support.','Fun ideas or traditions?',4,4);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminders`
--

DROP TABLE IF EXISTS `reminders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reminders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `scheduled_time` datetime NOT NULL,
  `appt_id` bigint(20) DEFAULT NULL,
  `med_id` bigint(20) DEFAULT NULL,
  `unit_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbc7yq5aiyx51j5raw8jlt5xi7` (`appt_id`),
  KEY `FK1v36qfhrlsjsa869ws7vw3xiq` (`med_id`),
  KEY `FKewfgjyhhp1gxn78bx1hajcygh` (`unit_id`),
  KEY `FKgibc0ij0e4s7bkldn4xybaanb` (`user_id`),
  CONSTRAINT `FK1v36qfhrlsjsa869ws7vw3xiq` FOREIGN KEY (`med_id`) REFERENCES `medicines` (`id`),
  CONSTRAINT `FKbc7yq5aiyx51j5raw8jlt5xi7` FOREIGN KEY (`appt_id`) REFERENCES `appointments` (`id`),
  CONSTRAINT `FKewfgjyhhp1gxn78bx1hajcygh` FOREIGN KEY (`unit_id`) REFERENCES `notification_type` (`id`),
  CONSTRAINT `FKgibc0ij0e4s7bkldn4xybaanb` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminders`
--

LOCK TABLES `reminders` WRITE;
/*!40000 ALTER TABLE `reminders` DISABLE KEYS */;
INSERT INTO `reminders` VALUES (33,'2018-05-16 17:00:00',36,NULL,3,1);
/*!40000 ALTER TABLE `reminders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `is_admin` int(11) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(100) DEFAULT NULL,
  `time_zone` bigint(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'mdm911@yahoo.com',0,'$2a$10$0S7Z7CpTT.7/JUOCpSgMmeYQ1nwK4JrXSZryUz.zd2O7vd2nDdBSS','2103163917',-5,'DianeM'),(2,'holycrackers@gmail.com',0,'$2a$10$0ah0vK39XvEPNyDL3UwbKujFCX2j0kFcl/87Uo6IbYd3UgZlibM8u','8973456789',-5,'HolyCrackers'),(3,'rockstarcoop@gmail.com',0,'$2a$10$qjMu/QDRRCgQ50jsbd0df.0M2cx110ibaaWXHp6tWW4tc75pc1ZYa','123-123-1234',-5,'RockstarCoop'),(4,'hanke31314@gmail.com',0,'$2a$10$W7ch47Xq7LKG.qPztdwg5OtTs10t/97kMpQiYDCIcSLGg1TBWGpNy','2107532770',-5,'EdwardG'),(5,'ssaegert@gmail.com',0,'$2a$10$7d/aEeKp0PCX.ZfRlZN4uOxlBddAt8tXGwFZLyaGOPysRwsPbYOs.','210-386-4388',-5,'FiveBy'),(6,'scott1995@gmail.com',0,'$2a$10$t8PqZeV2IRuPdGPT9BD19.njmGASqcBAFEPsphYR73yvWsqT1R7iy','512–123-1234',-5,'scott1995'),(7,'Tracelub@gmail.com',0,'$2a$10$fScQ3bkeHnjj1GctBv5HgeXoUr1O3YdKyK2D9qxV7pfggOCfK7hsW','2104045327',-6,'Tsutton');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_groups`
--

DROP TABLE IF EXISTS `users_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_groups` (
  `user_id` bigint(20) NOT NULL,
  `groups_id` bigint(20) NOT NULL,
  KEY `FKjex8no6gj9undclnlyn9l52wm` (`groups_id`),
  KEY `FKg6fu0mfuj9eqfd9aro1nc40nn` (`user_id`),
  CONSTRAINT `FKg6fu0mfuj9eqfd9aro1nc40nn` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKjex8no6gj9undclnlyn9l52wm` FOREIGN KEY (`groups_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_groups`
--

LOCK TABLES `users_groups` WRITE;
/*!40000 ALTER TABLE `users_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_groups` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-15 21:12:44
