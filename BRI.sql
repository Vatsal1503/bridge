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
-- Dumping data for table `BRI`
--

DROP TABLE IF EXISTS `BRI`;

CREATE TABLE `BRI` (
  `bridge_name` varchar(255),
  `Bridge_Vulnerability` DOUBLE,
	`Prediction_of_acute_shock_severity` DOUBLE,
`Average_daily_traffic` DOUBLE,
`Preliminary_restoration_cost` DOUBLE,
`Restoration_time` DOUBLE,
`Disaster_management` DOUBLE,
`Area_or_region_affected` DOUBLE,
`Duration_for_Procuring_and_Tendering` DOUBLE,
`Inspection_technique` DOUBLE,
`Maturity_in_Planning_and_scheduling` DOUBLE,
`Emergency_response_management` DOUBLE,
`Arrangement_funds` DOUBLE,
`Availability_of_materials_and_equipments` DOUBLE,
`Availability_of_backup_contractor` DOUBLE,
`Detour_length` DOUBLE,
`Availability_of_fund` DOUBLE,
`Bridge_Resilience` DOUBLE,
`created_date` Timestamp NOT NULL,
  PRIMARY KEY (`created_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
