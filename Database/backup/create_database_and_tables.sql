CREATE DATABASE `efix` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE efix;
CREATE TABLE `butik` (
  `idButik` int(11) NOT NULL AUTO_INCREMENT,
  `navn` varchar(45) NOT NULL,
  `adresse` varchar(150) NOT NULL,
  `mobilNummer` int(11) NOT NULL,
  `beskrivelse` varchar(400) NOT NULL,
  `aabningstider` varchar(100) NOT NULL,
  `email` varchar(75) NOT NULL,
  PRIMARY KEY (`idButik`),
  UNIQUE KEY `Adresse_UNIQUE` (`adresse`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `kategorier` (
  `idKategori` int(11) NOT NULL AUTO_INCREMENT,
  `navn` varchar(100) NOT NULL,
  PRIMARY KEY (`idKategori`),
  UNIQUE KEY `navn_UNIQUE` (`navn`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `nyhedsbrev` (
  `idNyhedsbrev` int(11) NOT NULL AUTO_INCREMENT,
  `eMail` varchar(255) NOT NULL,
  PRIMARY KEY (`idNyhedsbrev`),
  UNIQUE KEY `eMail_UNIQUE` (`eMail`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

CREATE TABLE `produkter` (
  `idProdukter` int(11) NOT NULL AUTO_INCREMENT,
  `navn` varchar(150) NOT NULL,
  `pris` int(11) NOT NULL,
  `beskrivelse` varchar(400) NOT NULL,
  `Kategori_idKategori` int(11) NOT NULL,
  PRIMARY KEY (`idProdukter`),
  UNIQUE KEY `navn_UNIQUE` (`navn`),
  KEY `fk_Produkter_Kategori_idx` (`Kategori_idKategori`),
  CONSTRAINT `fk_Produkter_Kategori` FOREIGN KEY (`Kategori_idKategori`) REFERENCES `kategorier` (`idKategori`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

CREATE TABLE `repair` (
  `idRepair` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL,
  `model` varchar(100) NOT NULL,
  `serial_number` varchar(100) NOT NULL,
  `system_version` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `phone` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`idRepair`),
  UNIQUE KEY `serial_number_UNIQUE` (`serial_number`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `reparationspriser` (
  `idReparationspriser` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  `tid` varchar(65) NOT NULL,
  `beskrivelse` varchar(500) NOT NULL,
  `pris` int(11) NOT NULL,
  PRIMARY KEY (`idReparationspriser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  KEY `fk_username_idx` (`username`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
