-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema efix
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema efix
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `efix` DEFAULT CHARACTER SET utf8 ;
USE `efix` ;

-- -----------------------------------------------------
-- Table `efix`.`Kategori`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efix`.`Kategori` (
  `idKategori` INT NOT NULL AUTO_INCREMENT,
  `navn` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idKategori`),
  UNIQUE INDEX `navn_UNIQUE` (`navn` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `efix`.`Produkter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efix`.`Produkter` (
  `idProdukter` INT NOT NULL AUTO_INCREMENT,
  `navn` VARCHAR(150) NOT NULL,
  `pris` INT NOT NULL,
  `beskrivelse` VARCHAR(400) NOT NULL,
  `Kategori_idKategori` INT NOT NULL,
  PRIMARY KEY (`idProdukter`),
  UNIQUE INDEX `navn_UNIQUE` (`navn` ASC),
  INDEX `fk_Produkter_Kategori_idx` (`Kategori_idKategori` ASC),
  CONSTRAINT `fk_Produkter_Kategori`
    FOREIGN KEY (`Kategori_idKategori`)
    REFERENCES `efix`.`Kategori` (`idKategori`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `efix`.`Butik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efix`.`Butik` (
  `idButik` INT NOT NULL AUTO_INCREMENT,
  `navn` VARCHAR(45) NOT NULL,
  `adresse` VARCHAR(150) NOT NULL,
  `mobilNummer` INT NOT NULL,
  `beskrivelse` VARCHAR(400) NOT NULL,
  `aabningstider` VARCHAR(100) NOT NULL,
  `email` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`idButik`),
  UNIQUE INDEX `Adresse_UNIQUE` (`adresse` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `efix`.`Brugere`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efix`.`Brugere` (
  `idBrugere` INT NOT NULL AUTO_INCREMENT,
  `brugernavn` VARCHAR(150) NOT NULL,
  `Adgangskode` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`idBrugere`),
  UNIQUE INDEX `brugernavn_UNIQUE` (`brugernavn` ASC),
  UNIQUE INDEX `Adgangskode_UNIQUE` (`Adgangskode` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
