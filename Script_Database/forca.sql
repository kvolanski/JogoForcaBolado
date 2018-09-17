-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 17-Set-2018 às 04:26
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

-- --------------------------------------------------------

--
-- Estrutura da tabela `jogador`
--

CREATE TABLE `jogador` (
  `idjogador` int(11) NOT NULL,
  `nome` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dificuldade` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `situacao` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `palavraJogo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `numVidas` int(11) DEFAULT NULL,
  `inicioJogo` datetime DEFAULT NULL,
  `fimJogo` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `jogador`
--

INSERT INTO `jogador` (`idjogador`, `nome`, `dificuldade`, `situacao`, `palavraJogo`, `numVidas`, `inicioJogo`, `fimJogo`) VALUES
(3, 'Kevin', '', 'MESTRE', '', 5, '2018-09-12 00:00:00', '2018-09-21 00:00:00'),
(4, 'Tiago', '', 'VITORIA', '', 7, '2018-09-15 00:00:00', '2018-09-15 00:00:00'),
(5, 'Tiago', '', 'VITORIA', '', 7, '2018-09-15 00:00:00', '2018-09-15 00:00:00'),
(6, 'Tiago', '', 'VITORIA', '', 7, '2018-09-15 20:13:55', '2018-09-15 20:14:02'),
(7, 'Diego', '', 'ABANDONO', '', 1, '2018-09-15 20:19:24', '2018-09-15 20:19:40'),
(8, 'Rosson', '', 'VITORIA', 'SAPATO', 2, '2018-09-15 20:54:45', '2018-09-15 20:54:58'),
(9, 'Kevin', '', 'DERROTA', 'BANANA', 0, '2018-09-15 20:56:26', '2018-09-15 20:56:36'),
(10, 'Tiago', '', 'ABANDONO', 'BANANA', 3, '2018-09-15 21:48:35', '2018-09-15 21:51:27'),
(11, 'Tiago', 'DIFICIL', 'VITORIA', 'BANANA', 3, '2018-09-16 00:44:43', '2018-09-16 00:44:59'),
(12, 'Tiago', 'MEDIO', 'VITORIA', 'ARCO-IRIS', 5, '2018-09-16 00:58:03', '2018-09-16 00:58:20'),
(13, 'Tiago', 'DIFICIL', 'VITORIA', 'BANANA', 3, '2018-09-16 12:02:30', '2018-09-16 12:02:34'),
(14, 'Tiago', 'DIFICIL', NULL, NULL, 3, '2018-09-16 21:37:04', NULL),
(15, 'Tiago', 'DIFICIL', NULL, NULL, 3, '2018-09-16 21:55:13', NULL),
(16, 'Tiago', 'DIFICIL', NULL, NULL, 3, '2018-09-16 21:59:54', NULL),
(17, 'Tiago', 'DIFICIL', NULL, NULL, 3, '2018-09-16 22:01:05', NULL),
(18, 'Tiago', 'DIFICIL', NULL, NULL, 3, '2018-09-16 22:03:18', NULL),
(19, 'Tiago', 'DIFICIL', NULL, NULL, 3, '2018-09-16 22:07:02', NULL),
(20, 'Tiago', 'DIFICIL', NULL, NULL, 3, '2018-09-16 22:07:59', NULL),
(21, 'Tiago', 'DIFICIL', NULL, NULL, 3, '2018-09-16 22:15:31', NULL),
(22, 'Tiago', 'DIFICIL', NULL, 'BANANA', 3, '2018-09-16 22:16:50', NULL),
(23, 'Tiago', 'DIFICIL', 'VITORIA', 'TELHA', 3, '2018-09-16 22:22:44', '2018-09-16 22:22:59'),
(24, 'Tiago', 'DIFICIL', NULL, NULL, 3, '2018-09-16 22:22:44', NULL),
(25, 'Tiago', 'DIFICIL', 'VITORIA', 'TELHA', 3, '2018-09-16 22:25:26', '2018-09-16 22:25:48'),
(26, 'Tiago', 'DIFICIL', NULL, 'TELHA', 3, '2018-09-16 22:30:26', NULL),
(27, 'Tiagp', 'DIFICIL', 'VITORIA', 'TELHA', 3, '2018-09-16 22:31:10', '2018-09-16 22:33:09'),
(28, 'Tiago', 'MEDIO', 'VITORIA', 'TELHA', 5, '2018-09-16 22:33:40', '2018-09-16 22:34:11'),
(29, 'Tiago', 'MEDIO', 'VITORIA', 'TELHA', 5, '2018-09-16 22:36:39', '2018-09-16 22:37:03');

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
  MODIFY `idjogador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
