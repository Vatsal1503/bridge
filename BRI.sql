CREATE DATABASE  IF NOT EXISTS `BRI`;
USE `BRI`;
--
-- Table structure for table ``
--
DROP TABLE IF EXISTS `pdftable`;

CREATE TABLE `pdftable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(128) NOT NULL,
  `pdffile` mediumblob NOT NULL,
  PRIMARY KEY (`id`,`file_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table ``
--

INSERT INTO `pdftable` VALUES (1,'Savijibhai Korat Bridge','C:/Users/atu/Desktop/Savijibhai_Korat_Bridge.pdf');