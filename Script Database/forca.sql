-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 16-Set-2018 às 16:25
-- Versão do servidor: 10.1.35-MariaDB
-- versão do PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `forca`
--

CREATE SCHEMA `forca` ;


--
-- Estrutura da tabela `jogador`
--

CREATE TABLE `jogador` (
  `idjogador` int(11) NOT NULL,
  `nome` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dificuldade` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `situacao` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `palavraJogo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `numVidas` int(11) DEFAULT NULL,
  `inicioJogo` datetime DEFAULT NULL,
  `fimJogo` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



--
-- Indexes for dumped tables
--

--
-- Indexes for table `jogador`
--
ALTER TABLE `jogador`
  ADD PRIMARY KEY (`idjogador`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jogador`
--
ALTER TABLE `jogador`
  MODIFY `idjogador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
