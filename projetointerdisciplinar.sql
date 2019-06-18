-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 18-Jun-2019 às 15:10
-- Versão do servidor: 10.1.39-MariaDB
-- versão do PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetointerdisciplinar`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `adotantes`
--

CREATE TABLE `adotantes` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `animais_id` int(11) NOT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `animais`
--

CREATE TABLE `animais` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `responsavel_id` int(11) NOT NULL,
  `raça_id` int(11) NOT NULL,
  `genero` varchar(40) NOT NULL,
  `especie_id` int(11) NOT NULL,
  `idade` varchar(3) NOT NULL,
  `observation` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `especie`
--

CREATE TABLE `especie` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `protetores`
--

CREATE TABLE `protetores` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `protetores`
--

INSERT INTO `protetores` (`id`, `nome`, `cpf`, `celular`, `email`, `endereco`, `bairro`, `estado`, `tipo`, `senha`) VALUES
(5, 'fellipe', '126.293.136-38', '(34)99979-1270', 'fellipeluann12@gmail.com', 'Rua Osvaldo Cruz', 'Centro', 'AL', 'Administrador', '333');

-- --------------------------------------------------------

--
-- Estrutura da tabela `raça`
--

CREATE TABLE `raça` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adotantes`
--
ALTER TABLE `adotantes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_adotantes-animais_id_idx` (`animais_id`) USING BTREE;

--
-- Indexes for table `animais`
--
ALTER TABLE `animais`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_especie_id_idx` (`especie_id`) USING BTREE,
  ADD KEY `fk_raça_p_idx` (`raça_id`) USING BTREE,
  ADD KEY `fk_responsavel_id_idx` (`responsavel_id`) USING BTREE;

--
-- Indexes for table `especie`
--
ALTER TABLE `especie`
  ADD KEY `id` (`id`) USING BTREE;

--
-- Indexes for table `protetores`
--
ALTER TABLE `protetores`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `raça`
--
ALTER TABLE `raça`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adotantes`
--
ALTER TABLE `adotantes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `animais`
--
ALTER TABLE `animais`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `especie`
--
ALTER TABLE `especie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `protetores`
--
ALTER TABLE `protetores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `raça`
--
ALTER TABLE `raça`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `adotantes`
--
ALTER TABLE `adotantes`
  ADD CONSTRAINT `fk_adotantes-animais_id` FOREIGN KEY (`animais_id`) REFERENCES `animais` (`id`);

--
-- Limitadores para a tabela `animais`
--
ALTER TABLE `animais`
  ADD CONSTRAINT `fk_especie_p` FOREIGN KEY (`especie_id`) REFERENCES `especie` (`id`),
  ADD CONSTRAINT `fk_raça_p` FOREIGN KEY (`raça_id`) REFERENCES `raça` (`id`),
  ADD CONSTRAINT `fk_responsavel_p` FOREIGN KEY (`responsavel_id`) REFERENCES `protetores` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
