-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema efix
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema efix
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `efix` DEFAULT CHARACTER SET utf8 ;
USE `efix` ;

-- -----------------------------------------------------
-- Table `efix`.`butik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efix`.`butik` (
  `idButik` INT(11) NOT NULL AUTO_INCREMENT,
  `navn` VARCHAR(45) NOT NULL,
  `adresse` VARCHAR(150) NOT NULL,
  `mobilNummer` INT(11) NOT NULL,
  `beskrivelse` VARCHAR(400) NOT NULL,
  `aabningstider` VARCHAR(100) NOT NULL,
  `email` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`idButik`),
  UNIQUE INDEX `Adresse_UNIQUE` (`adresse` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `efix`.`kategorier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efix`.`kategorier` (
  `idKategori` INT(11) NOT NULL AUTO_INCREMENT,
  `navn` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idKategori`),
  UNIQUE INDEX `navn_UNIQUE` (`navn` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `efix`.`nyhedsbrev`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efix`.`nyhedsbrev` (
  `idNyhedsbrev` INT(11) NOT NULL AUTO_INCREMENT,
  `eMail` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idNyhedsbrev`),
  UNIQUE INDEX `eMail_UNIQUE` (`eMail` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `efix`.`produkter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efix`.`produkter` (
  `idProdukter` INT(11) NOT NULL AUTO_INCREMENT,
  `navn` VARCHAR(150) NOT NULL,
  `pris` INT(11) NOT NULL,
  `beskrivelse` VARCHAR(400) NOT NULL,
  `Kategori_idKategori` INT(11) NOT NULL,
  PRIMARY KEY (`idProdukter`),
  UNIQUE INDEX `navn_UNIQUE` (`navn` ASC) VISIBLE,
  INDEX `fk_Produkter_Kategori_idx` (`Kategori_idKategori` ASC) VISIBLE,
  CONSTRAINT `fk_Produkter_Kategori`
    FOREIGN KEY (`Kategori_idKategori`)
    REFERENCES `efix`.`kategorier` (`idKategori`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 27
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `efix`.`repair`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efix`.`repair` (
  `idRepair` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(500) NOT NULL,
  `model` VARCHAR(100) NOT NULL,
  `serial_number` VARCHAR(100) NOT NULL,
  `system_version` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NULL DEFAULT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone` INT(11) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idRepair`),
  UNIQUE INDEX `serial_number_UNIQUE` (`serial_number` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `efix`.`reparationspriser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efix`.`reparationspriser` (
  `idReparationspriser` INT(11) NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(100) NOT NULL,
  `model` VARCHAR(100) NOT NULL,
  `tid` VARCHAR(65) NOT NULL,
  `beskrivelse` VARCHAR(500) NOT NULL,
  `pris` INT(11) NOT NULL,
  PRIMARY KEY (`idReparationspriser`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `efix`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efix`.`users` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `efix`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efix`.`user_roles` (
  `user_role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE INDEX `uni_username_role` (`role` ASC, `username` ASC) VISIBLE,
  INDEX `fk_username_idx` (`username` ASC) VISIBLE,
  CONSTRAINT `fk_username`
    FOREIGN KEY (`username`)
    REFERENCES `efix`.`users` (`username`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
