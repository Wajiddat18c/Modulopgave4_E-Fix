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
-- Table `efix`.`kategori`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efix`.`kategori` (
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
    REFERENCES `efix`.`kategori` (`idKategori`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
