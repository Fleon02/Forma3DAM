-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-02-2024 a las 17:42:27
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `dniAlumno` varchar(12) NOT NULL,
  `nombreAlumno` varchar(50) DEFAULT NULL,
  `yearCurso` varchar(4) DEFAULT NULL,
  `segSocialAlumno` varchar(20) DEFAULT NULL,
  `validez` tinyint(1) DEFAULT NULL,
  `cicloAlumno` varchar(20) DEFAULT NULL,
  `CV` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anexos`
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `convenio`
--

CREATE TABLE `convenio` (
  `numConvenio` int(20) NOT NULL,
  `idAnexo` varchar(15) DEFAULT NULL,
  `nombreEmpresa` varchar(20) DEFAULT NULL,
  `cifEmpresa` varchar(20) DEFAULT NULL,
  `responsableFirma` varchar(50) DEFAULT NULL,
  `cantAnexos` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especial`
--

CREATE TABLE `especial` (
  `correoUsuario` varchar(20) NOT NULL,
  `hashUsuario` varchar(50) DEFAULT NULL,
  `saltUsuario` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `idUsuario` int(4) NOT NULL,
  `nombreUsuario` varchar(20) DEFAULT NULL,
  `correoUsuario` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `necesidad`
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `practicas`
--

CREATE TABLE `practicas` (
  `idPractica` int(5) NOT NULL,
  `dniAlumno` varchar(12) DEFAULT NULL,
  `calendario` varchar(20) DEFAULT NULL,
  `informeSeguimiento` varchar(50) DEFAULT NULL,
  `informeFinal` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`dniAlumno`);

--
-- Indices de la tabla `anexos`
--
ALTER TABLE `anexos`
  ADD PRIMARY KEY (`idAnexo`);

--
-- Indices de la tabla `convenio`
--
ALTER TABLE `convenio`
  ADD PRIMARY KEY (`numConvenio`);

--
-- Indices de la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD PRIMARY KEY (`cifEmpresa`);

--
-- Indices de la tabla `especial`
--
ALTER TABLE `especial`
  ADD PRIMARY KEY (`correoUsuario`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indices de la tabla `necesidad`
--
ALTER TABLE `necesidad`
  ADD PRIMARY KEY (`idNecesidad`);

--
-- Indices de la tabla `practicas`
--
ALTER TABLE `practicas`
  ADD PRIMARY KEY (`idPractica`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `anexos`
--
ALTER TABLE `anexos`
  MODIFY `idAnexo` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `idUsuario` int(4) NOT NULL AUTO_INCREMENT;

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
