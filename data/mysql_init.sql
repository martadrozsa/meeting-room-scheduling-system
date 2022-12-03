-- -----------------------------------------------------
-- Schema employee
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `employee` DEFAULT CHARACTER SET utf8 ;
USE `employee` ;

-- -----------------------------------------------------
-- Table `employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `admission_date` date DEFAULT NULL,
    `birth_date` date DEFAULT NULL,
    `name` varchar(255) NOT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Schema room
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `room` DEFAULT CHARACTER SET utf8 ;
USE `room` ;

-- -----------------------------------------------------
-- Table `room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `room` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `numbers_of_places` int DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Schema scheduler
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `scheduler` DEFAULT CHARACTER SET utf8 ;
USE `scheduler` ;

-- -----------------------------------------------------
-- Table `scheduler`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scheduler` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `reservation_period` datetime(6) DEFAULT NULL,
    `responsible` bigint NOT NULL,
    `room` bigint NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
