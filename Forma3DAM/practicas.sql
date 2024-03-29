-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-02-2024 a las 19:30:06
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `practicas`
--
CREATE DATABASE IF NOT EXISTS `practicas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `practicas`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--
-- Creación: 17-02-2024 a las 17:20:20
-- Última actualización: 17-02-2024 a las 17:20:20
--

CREATE TABLE `alumnos` (
  `idAlumno` int(3) NOT NULL,
  `dniAlumno` varchar(12) NOT NULL,
  `nombreAlumno` varchar(50) DEFAULT NULL,
  `yearCurso` varchar(4) DEFAULT NULL,
  `segSocialAlumno` varchar(20) DEFAULT NULL,
  `validez` tinyint(1) DEFAULT NULL,
  `cicloAlumno` varchar(20) DEFAULT NULL,
  `CV` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `alumnos`:
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anexos`
--
-- Creación: 17-02-2024 a las 17:44:30
--

CREATE TABLE `anexos` (
  `idAnexo` int(5) NOT NULL,
  `tutorPracticas` varchar(50) DEFAULT NULL,
  `fechaInicio` varchar(15) DEFAULT NULL,
  `fechaFin` varchar(15) DEFAULT NULL,
  `idNecesidad` varchar(10) DEFAULT NULL,
  `dniAlumno` varchar(12) DEFAULT NULL,
  `contratacion` tinyint(1) DEFAULT NULL,
  `anexoDosUno` longblob DEFAULT NULL,
  `anexoTres` longblob DEFAULT NULL,
  `anexoCuatro` longblob DEFAULT NULL,
  `anexoDosDos` longblob DEFAULT NULL,
  `anexoOcho` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `anexos`:
--

--
-- Volcado de datos para la tabla `anexos`
--

INSERT INTO `anexos` (`idAnexo`, `tutorPracticas`, `fechaInicio`, `fechaFin`, `idNecesidad`, `dniAlumno`, `contratacion`, `anexoDosUno`, `anexoTres`, `anexoCuatro`, `anexoDosDos`, `anexoOcho`) VALUES
(2, '23523', '523523', '523523', '5235', '32532', 0, NULL, NULL, NULL, NULL, NULL),
(3, '', '', '', '', '', 0, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `beep`
--
-- Creación: 17-02-2024 a las 17:11:52
--

CREATE TABLE `beep` (
  `idUsuario` int(4) NOT NULL,
  `contrasena` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `beep`:
--   `idUsuario`
--       `login` -> `idUsuario`
--

--
-- Volcado de datos para la tabla `beep`
--

INSERT INTO `beep` (`idUsuario`, `contrasena`) VALUES
(1, 'Juan232023'),
(2, 'paco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `convenio`
--
-- Creación: 17-02-2024 a las 18:10:57
--

CREATE TABLE `convenio` (
  `numConvenio` int(20) NOT NULL,
  `idAnexo` varchar(15) DEFAULT NULL,
  `nombreEmpresa` varchar(20) DEFAULT NULL,
  `cifEmpresa` varchar(20) DEFAULT NULL,
  `responsableFirma` varchar(50) DEFAULT NULL,
  `cantAnexos` int(3) DEFAULT NULL,
  `anexoUnoConvenio` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `convenio`:
--   `cifEmpresa`
--       `empresas` -> `cifEmpresa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--
-- Creación: 17-02-2024 a las 17:36:15
--

CREATE TABLE `empresas` (
  `nombreEmpresa` varchar(20) DEFAULT NULL,
  `cifEmpresa` varchar(20) NOT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `owner` varchar(20) DEFAULT NULL,
  `tutorPracticas` varchar(50) DEFAULT NULL,
  `responsableContratacion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `empresas`:
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--
-- Creación: 17-02-2024 a las 17:11:52
--

CREATE TABLE `login` (
  `idUsuario` int(4) NOT NULL,
  `nombreUsuario` varchar(20) DEFAULT NULL,
  `correoUsuario` varchar(50) DEFAULT NULL,
  `rol` enum('Admin','Trabajador') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `login`:
--

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`idUsuario`, `nombreUsuario`, `correoUsuario`, `rol`) VALUES
(1, 'Pacheco', 'pacheco@gmail.com', 'Trabajador'),
(2, 'Francisco', 'leonmarcosf@gmail.com', 'Admin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `necesidad`
--
-- Creación: 17-02-2024 a las 17:36:33
--

CREATE TABLE `necesidad` (
  `idNecesidad` int(4) NOT NULL,
  `cifEmpresa` varchar(20) DEFAULT NULL,
  `cicloNecesidad` varchar(10) DEFAULT NULL,
  `dam` int(2) DEFAULT NULL,
  `daw` int(2) DEFAULT NULL,
  `asir` int(2) DEFAULT NULL,
  `mark` int(2) DEFAULT NULL,
  `fin` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `necesidad`:
--   `cifEmpresa`
--       `empresas` -> `cifEmpresa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `practicas`
--
-- Creación: 17-02-2024 a las 17:31:30
--

CREATE TABLE `practicas` (
  `idPractica` int(5) NOT NULL,
  `dniAlumno` varchar(12) DEFAULT NULL,
  `tutorPracticas` varchar(50) DEFAULT NULL,
  `calendario` varchar(20) DEFAULT NULL,
  `informeSeguimiento` varchar(50) DEFAULT NULL,
  `informeFinal` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `practicas`:
--   `tutorPracticas`
--       `empresas` -> `tutorPracticas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `practicasempresas`
--
-- Creación: 17-02-2024 a las 18:24:49
--

CREATE TABLE `practicasempresas` (
  `tutorPracticas_P` varchar(50) NOT NULL,
  `tutorPracticas_E` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `practicasempresas`:
--   `tutorPracticas_P`
--       `practicas` -> `tutorPracticas`
--   `tutorPracticas_E`
--       `empresas` -> `tutorPracticas`
--

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`idAlumno`);

--
-- Indices de la tabla `anexos`
--
ALTER TABLE `anexos`
  ADD PRIMARY KEY (`idAnexo`),
  ADD UNIQUE KEY `tutorPracticas` (`tutorPracticas`);

--
-- Indices de la tabla `beep`
--
ALTER TABLE `beep`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indices de la tabla `convenio`
--
ALTER TABLE `convenio`
  ADD PRIMARY KEY (`numConvenio`),
  ADD UNIQUE KEY `cifEmpresa` (`cifEmpresa`);

--
-- Indices de la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD PRIMARY KEY (`cifEmpresa`),
  ADD UNIQUE KEY `cifEmpresa` (`cifEmpresa`),
  ADD UNIQUE KEY `tutorPracticas` (`tutorPracticas`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indices de la tabla `necesidad`
--
ALTER TABLE `necesidad`
  ADD PRIMARY KEY (`idNecesidad`),
  ADD UNIQUE KEY `cifEmpresa` (`cifEmpresa`);

--
-- Indices de la tabla `practicas`
--
ALTER TABLE `practicas`
  ADD PRIMARY KEY (`idPractica`),
  ADD UNIQUE KEY `tutorPracticas` (`tutorPracticas`);

--
-- Indices de la tabla `practicasempresas`
--
ALTER TABLE `practicasempresas`
  ADD PRIMARY KEY (`tutorPracticas_P`,`tutorPracticas_E`),
  ADD KEY `tutorPracticas_E` (`tutorPracticas_E`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `idAlumno` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `anexos`
--
ALTER TABLE `anexos`
  MODIFY `idAnexo` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `idUsuario` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `necesidad`
--
ALTER TABLE `necesidad`
  MODIFY `idNecesidad` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `practicas`
--
ALTER TABLE `practicas`
  MODIFY `idPractica` int(5) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `beep`
--
ALTER TABLE `beep`
  ADD CONSTRAINT `beep_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `login` (`idUsuario`);

--
-- Filtros para la tabla `convenio`
--
ALTER TABLE `convenio`
  ADD CONSTRAINT `convenio_ibfk_1` FOREIGN KEY (`cifEmpresa`) REFERENCES `empresas` (`cifEmpresa`);

--
-- Filtros para la tabla `necesidad`
--
ALTER TABLE `necesidad`
  ADD CONSTRAINT `necesidad_ibfk_1` FOREIGN KEY (`cifEmpresa`) REFERENCES `empresas` (`cifEmpresa`);

--
-- Filtros para la tabla `practicas`
--
ALTER TABLE `practicas`
  ADD CONSTRAINT `practicas_ibfk_1` FOREIGN KEY (`tutorPracticas`) REFERENCES `empresas` (`tutorPracticas`);

--
-- Filtros para la tabla `practicasempresas`
--
ALTER TABLE `practicasempresas`
  ADD CONSTRAINT `practicasempresas_ibfk_1` FOREIGN KEY (`tutorPracticas_P`) REFERENCES `practicas` (`tutorPracticas`),
  ADD CONSTRAINT `practicasempresas_ibfk_2` FOREIGN KEY (`tutorPracticas_E`) REFERENCES `empresas` (`tutorPracticas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
