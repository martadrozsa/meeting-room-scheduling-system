CREATE DATABASE IF NOT EXISTS employee;
CREATE DATABASE IF NOT EXISTS room;
CREATE DATABASE IF NOT EXISTS scheduler;


-- -----------------------------------------------------
-- Table `employee`
-- -----------------------------------------------------
CREATE TABLE NOT EXISTS `employee` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `admission_date` date DEFAULT NULL,
    `birth_date` date DEFAULT NULL,
    `name` varchar(255) NOT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `room`
-- -----------------------------------------------------
CREATE TABLE `room` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `numbers_of_places` int DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `scheduler`
-- -----------------------------------------------------
CREATE TABLE `scheduler` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `reservation_date_and_time` datetime(6) DEFAULT NULL,
    `responsible` bigint NOT NULL,
    `room` bigint NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
