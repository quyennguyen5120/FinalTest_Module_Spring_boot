-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: springboot_test
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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier_by` varchar(255) DEFAULT NULL,
  `modifier_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (11,'CreateBy','2022-05-05 09:03:20',NULL,NULL,'Áo sơ mi'),(8,'CreateBy','2022-05-05 09:02:51','Modifier','2022-05-05 09:03:34','Áo jacket'),(7,'CreateBy','2022-05-05 09:02:44',NULL,NULL,'Áo sweater'),(10,'CreateBy','2022-05-05 09:03:05',NULL,NULL,'Quần jacket'),(12,'CreateBy','2022-05-05 09:03:27',NULL,NULL,'Quần kaki'),(13,'CreateBy','2022-05-05 09:03:46',NULL,NULL,'Áo khoác');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier_by` varchar(255) DEFAULT NULL,
  `modifier_date` datetime DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  `parent_id` int DEFAULT NULL,
  `total_like` int DEFAULT NULL,
  `review_entity_id` bigint DEFAULT NULL,
  `user_entity_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6w5mmwvixa37cvy8u7u60bik8` (`review_entity_id`),
  KEY `FKulelxhnjl2sf2030105dbc1i` (`user_entity_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'unknowUser','2022-05-05 22:12:32',NULL,NULL,'Sản phẩm quá hịn, hết nước chấm. Sản phẩm quá hịn, hết nước chấm. Sản phẩm quá hịn, hết nước chấm. Sản phẩm quá hịn, hết nước chấm. Sản phẩm quá hịn, hết nước chấm. Sản phẩm quá hịn, hết nước chấm. Sản phẩm quá hịn, hết nước chấm. Sản phẩm quá hịn, hết nước chấm. Sản phẩm quá hịn, hết nước chấm. Sản phẩm quá hịn, hết nước chấm. Sản phẩm quá hịn, hết nước chấm. Sản phẩm quá hịn, hết nước chấm. ',NULL,NULL,1,19),(2,'vietdz2k','2022-05-05 22:13:03',NULL,NULL,'Sản phẩm đểu quá, ko dùng nổi, đánh giá 0 sao Sản phẩm đểu quá, ko dùng nổi, đánh giá 0 saoSản phẩm đểu quá, ko dùng nổi, đánh giá 0 saoSản phẩm đểu quá, ko dùng nổi, đánh giá 0 saoSản phẩm đểu quá, ko dùng nổi, đánh giá 0 saoSản phẩm đểu quá, ko dùng nổi, đánh giá 0 saoSản phẩm đểu quá, ko dùng nổi, đánh giá 0 saoSản phẩm đểu quá, ko dùng nổi, đánh giá 0 saoSản phẩm đểu quá, ko dùng nổi, đánh giá 0 sao',NULL,NULL,10,13),(3,'tk2k','2022-05-06 14:18:00',NULL,NULL,'Sản phẩm quá xịn, sẽ ủng hộ thêm <3',NULL,NULL,10,20),(4,'tk2k','2022-05-06 14:18:18',NULL,NULL,'Sản phẩm xịn quá aaaaaaaaaaaaaaaaaaaa',NULL,NULL,10,20);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier_by` varchar(255) DEFAULT NULL,
  `modifier_date` datetime DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category_entity_id` bigint DEFAULT NULL,
  `review_id` bigint DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm3owfv4y4429l2xo043ym447m` (`category_entity_id`),
  KEY `FK63qfnwyiuhg8m8ywe84ehhj9` (`review_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (5,'CreateBy','2022-05-05 09:04:44','Modifier','2022-05-05 10:47:47','5_2022165171628325ff6c18bde79b4cccf153c1bd029c2f.jpg','Áo sweater hình gấu trúc',99000,7,4,NULL),(6,'CreateBy','2022-05-05 09:05:56','Modifier','2022-05-05 10:46:55','5_20221651716356b0bb8c5a336dd66d05d10db51355f602.jpg_360x360q75.jpg_.webp','Áo sweater hình con bò',199000,7,3,NULL),(7,'CreateBy','2022-05-05 09:06:50','Modifier','2022-05-05 10:47:47','5_20221651716409download.jpg','Áo sweater hình lợn',199000,7,6,NULL),(8,'CreateBy','2022-05-05 09:07:23','Modifier','2022-05-05 10:47:47','5_2022165171644358c467932bdf8ab4e316a779edd6e66a.jpg','Áo sweater hình mèo ',199000,7,5,NULL),(9,'CreateBy','2022-05-05 09:08:06','Modifier','2022-05-05 10:44:52','5_20221651716486c5e8785879ad094396d1381eabf7d918.jpg','Áo sweater hình siêu nhân',299000,7,2,NULL),(11,'CreateBy','2022-05-05 09:09:20','Modifier','2022-05-05 10:44:52','5_20221651716560download(1).jpg','Áo sweater hình con voi',399000,7,1,NULL),(13,'CreateBy','2022-05-05 15:14:21','Modifier','2022-05-05 15:14:21','5_202216517384615_20221651716356b0bb8c5a336dd66d05d10db51355f602.jpg_360x360q75.jpg_.webp','Áo sweater',390000,7,7,NULL),(14,'admin','2022-05-05 21:40:25','admin','2022-05-05 21:40:25','5_20221651761624download(3).jpg','Quần kaki xám',390000,12,8,NULL),(15,'admin','2022-05-05 21:40:47','admin','2022-05-05 21:40:47','5_202216517616475_20221651761624download(3).jpg','Quần kaki màu tro',390000,12,9,NULL),(16,'admin','2022-05-05 21:41:17','admin','2022-05-05 21:41:17','5_202216517616760a83c82b74cc2602025e3f240891d82b.jpg','Áo khoác da bò',390000,13,10,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_history`
--

DROP TABLE IF EXISTS `product_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier_by` varchar(255) DEFAULT NULL,
  `modifier_date` datetime DEFAULT NULL,
  `total` int DEFAULT NULL,
  `product_entity_id` bigint DEFAULT NULL,
  `user_entity_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr4v528xnlt4illcls8hxy6c65` (`product_entity_id`),
  KEY `FKhn5ep66syj26xx3ft8gfmce9p` (`user_entity_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_history`
--

LOCK TABLES `product_history` WRITE;
/*!40000 ALTER TABLE `product_history` DISABLE KEYS */;
INSERT INTO `product_history` VALUES (1,'CreateBy','2022-05-05 15:14:43',NULL,NULL,1,11,6),(2,'CreateBy','2022-05-05 15:15:22',NULL,NULL,1,13,6),(3,'CreateBy','2022-05-05 21:06:01',NULL,NULL,3,7,13),(4,'CreateBy','2022-05-05 21:06:01',NULL,NULL,1,8,13),(5,'CreateBy','2022-05-05 21:06:01',NULL,NULL,1,11,13),(6,'longtv','2022-05-05 21:44:43',NULL,NULL,1,11,15),(7,'longtv','2022-05-05 21:44:43',NULL,NULL,1,14,15),(8,'longtv','2022-05-05 21:44:43',NULL,NULL,1,16,15),(9,'tk2k','2022-05-06 14:16:04',NULL,NULL,1,11,20),(10,'tk2k','2022-05-06 14:16:04',NULL,NULL,1,13,20),(11,'tk2k','2022-05-06 14:16:04',NULL,NULL,1,14,20);
/*!40000 ALTER TABLE `product_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier_by` varchar(255) DEFAULT NULL,
  `modifier_date` datetime DEFAULT NULL,
  `rating` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'CreateBy','2022-05-05 10:44:52','Modifier','2022-05-05 11:24:30',2),(2,'CreateBy','2022-05-05 10:44:52','Modifier','2022-05-05 10:47:47',1),(3,'CreateBy','2022-05-05 10:46:55','Modifier','2022-05-05 11:24:30',2),(4,'CreateBy','2022-05-05 10:47:47',NULL,NULL,3),(5,'CreateBy','2022-05-05 10:47:47','Modifier','2022-05-05 21:06:04',2),(6,'CreateBy','2022-05-05 10:47:47','Modifier','2022-05-05 21:06:04',2),(7,'CreateBy','2022-05-05 15:14:21','tk2k','2022-05-06 14:17:27',2),(8,'admin','2022-05-05 21:40:25','longtv','2022-05-05 21:44:46',2),(9,'admin','2022-05-05 21:40:47',NULL,NULL,5),(10,'admin','2022-05-05 21:41:17','longtv','2022-05-05 21:44:46',2);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier_by` varchar(255) DEFAULT NULL,
  `modifier_date` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,NULL,NULL,'user','user','quyenproxxxxx@gmail.com','Nguyễn Hữu Quyền'),(16,'unknowUser','2022-05-05 21:55:04',NULL,NULL,'$2a$10$bN4jZHd7DAEKbaTmH5sTmujzxzaEyfduWqR1UFepYsxUZg59w8XZq','dangdh','haidang@gmail.com','Nguyễn Hải Đăng'),(6,'CreateBy','2022-05-05 14:56:12',NULL,NULL,'$2a$10$VZrbioeWd1qE46opeI5r8u9sy85k6Mh83Jm3mH0.ZOjV0m9n/yl3y','admin','quyenproxxxxx@gmail.com','Nguyễn Hữu Quyền'),(7,'CreateBy','2022-05-05 14:58:24','Modifier','2022-05-05 14:58:24',NULL,'quyenproxxxxx@gmail.com',NULL,NULL),(15,'unknowUser','2022-05-05 21:44:04',NULL,NULL,'$2a$10$YqcF64La2yr15diNNTnSZu6gLhUnVgKYrQhKxZp6J4JyyDeG7ZLrm','longtv','longtv@gmail.com','Trần Việt Long'),(10,'CreateBy','2022-05-05 18:49:54',NULL,NULL,'$2a$10$BrT3hFCElldENjxuCO8XouF4mn7hkbfjzEH.Vef8VRT/ICuFdVtc6','quyenprozxc','quanggamo@gmail.com',NULL),(11,'CreateBy','2022-05-05 18:51:29',NULL,NULL,'$2a$10$ElTbtmFjebkRxZEQneO3..YSAwP4tY4.Cp2TE4DFGBQvQdTwvKCo2','QUyennguyen','quanggamo@gmail.com','Nguyễn Hữu Quyền'),(12,'CreateBy','2022-05-05 19:02:24',NULL,NULL,'$2a$10$fvDikIPpYfwmEKdagnlagOPk53BTx0kqqo4/7tWoFLX2AgR862V3m','adminzzzz','quanggamo@gmail.com','Nguyễn Hữu Quyền'),(13,'CreateBy','2022-05-05 20:40:22','Modifier','2022-05-05 21:14:33','$2a$10$.TyQwZdFdEyctTGMfLwy5e1inb7H3O4xyeXRenY/0BXkH5QXcH452','vietdz2k','vietdz2k@gmail.com','Đặng Hồng Việtzzzzzzzzzzz'),(17,'unknowUser','2022-05-05 22:00:52',NULL,NULL,'$2a$10$Ne7UuzzH69JF/WzAMwuV/OpxrAnEMohtqJo8HI/HDD6KPgHKCYDvK','minhanh2k','minhanh2k@gmail.com','Trần Anh Minh'),(18,'unknowUser','2022-05-05 22:04:41',NULL,NULL,'$2a$10$wnBcNJ920bnpRHC6fHuZfeNBIJqPkvoGGhsdbH0po7.CMQxvQRhJC','ducanh','qweqwe@gmail.com','Trần Cao Đức'),(19,'unknowUser','2022-05-05 22:12:32',NULL,NULL,NULL,NULL,'nguoila@gmail.com','Người lạ'),(20,'unknowUser','2022-05-06 14:15:43',NULL,NULL,'$2a$10$9sGO7636ohUhKx4CejL/p.bRa359ZML.fFHUIK2G27ejc0F5KP05u','tk2k','nguyenquyen5120@gmail.com','Tài khoản mới'),(21,'unknowUser','2022-05-06 14:20:39',NULL,NULL,'$2a$10$1iQLjGHSMq7Br1T.xhUkKOwh1Oh/UmXO.nt9.WtLcFOwIPXOQluAq','','','');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_entity_id` bigint NOT NULL,
  `roles_id` bigint NOT NULL,
  PRIMARY KEY (`user_entity_id`,`roles_id`),
  KEY `FKj9553ass9uctjrmh0gkqsmv0d` (`roles_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,2),(6,1),(7,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(20,2),(21,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-06 16:55:41
