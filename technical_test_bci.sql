-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.30 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para technical_test_bci
CREATE DATABASE IF NOT EXISTS `technical_test_bci` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `technical_test_bci`;

-- Volcando estructura para tabla technical_test_bci.phone
CREATE TABLE IF NOT EXISTS `phone` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `citycode` varchar(255) DEFAULT NULL,
  `countrycode` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb0niws2cd0doybhib6srpb5hh` (`user_id`),
  CONSTRAINT `FKb0niws2cd0doybhib6srpb5hh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla technical_test_bci.phone: ~3 rows (aproximadamente)
INSERT INTO `phone` (`id`, `citycode`, `countrycode`, `number`, `user_id`) VALUES
	(1, '1', '57', '935280674', 1),
	(2, '1', '57', '935280674', 2),
	(3, '2', '58', '935280673', 2),
	(4, '1', '57', '935280674', 3),
	(5, '2', '58', '935280673', 3),
	(6, '1', '57', '935280674', 4),
	(7, '2', '58', '935280673', 4);

-- Volcando estructura para tabla technical_test_bci.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime(6) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `modified` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `token` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla technical_test_bci.user: ~3 rows (aproximadamente)
INSERT INTO `user` (`id`, `created`, `email`, `is_active`, `last_login`, `modified`, `name`, `password`, `token`) VALUES
	(1, '2024-01-18 16:38:05.957000', 'calderon200396@gmail.com', b'0', '2024-01-18 16:38:05.957000', NULL, 'kevin', 'Kevin12', NULL),
	(2, '2024-01-18 16:41:36.719000', 'calderon200397@gmail.com', b'0', '2024-01-18 16:41:36.719000', NULL, 'kevin2', 'Kevin12', NULL),
	(3, '2024-01-18 16:43:12.537000', 'calderon200399@gmail.com', b'1', '2024-01-18 16:43:12.537000', NULL, 'kevin2', 'Kevin12', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJjYWxkZXJvbjIwMDM5OUBnbWFpbC5jb20iLCJpc3MiOiJJbmcuS2V2aW5DYWxkZXJvbiIsImlhdCI6MTcwNTYxNDE5MiwiZXhwIjoxNzA2OTEwMTkyfQ.vnk7Q_pmgYTfwJ2bCb664rrQVmg0Ur7yWSEz8fiNbZI'),
	(4, '2024-01-18 16:58:39.983000', 'calderon200388@gmail.com', b'1', '2024-01-18 16:58:39.983000', NULL, 'kevin2', 'Jose12', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJjYWxkZXJvbjIwMDM4OEBnbWFpbC5jb20iLCJpc3MiOiJJbmcuS2V2aW5DYWxkZXJvbiIsImlhdCI6MTcwNTYxNTExOSwiZXhwIjoxNzA2OTExMTE5fQ.xGR7Kpj9ZLPRmt9Cnt7_X0Il6CERo4dzaNYPfAUDVY0');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
