-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-02-2024 a las 18:36:41
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

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
  `idAlumno` int(3) NOT NULL,
  `dniAlumno` varchar(12) NOT NULL,
  `nombreAlumno` varchar(50) DEFAULT NULL,
  `yearCurso` int(4) DEFAULT NULL,
  `segSocialAlumno` int(12) DEFAULT NULL,
  `validez` tinyint(1) DEFAULT NULL,
  `cicloAlumno` varchar(20) DEFAULT NULL,
  `CV` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos_asignaturas`
--

CREATE TABLE `alumnos_asignaturas` (
  `id_alum_asig` int(4) NOT NULL,
  `idAlumno` int(3) DEFAULT NULL,
  `idAsignatura` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `calendario` varchar(20) DEFAULT NULL,
  `anexoDosUno` longblob DEFAULT NULL,
  `anexoTres` longblob DEFAULT NULL,
  `anexoCuatro` longblob DEFAULT NULL,
  `anexoDosDos` longblob DEFAULT NULL,
  `anexoOcho` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `anexos`
--

INSERT INTO `anexos` (`idAnexo`, `tutorPracticas`, `fechaInicio`, `fechaFin`, `idNecesidad`, `dniAlumno`, `contratacion`, `calendario`, `anexoDosUno`, `anexoTres`, `anexoCuatro`, `anexoDosDos`, `anexoOcho`) VALUES
(2, '23523', '523523', '523523', '5235', '32532', 0, NULL, NULL, NULL, NULL, NULL, NULL),
(3, '', '', '', '', '', 0, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaturas`
--

CREATE TABLE `asignaturas` (
  `idAsignatura` int(3) NOT NULL,
  `nombreAsignatura` varchar(60) DEFAULT NULL,
  `abreviatura` varchar(20) DEFAULT NULL,
  `cicloFormativo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `asignaturas`
--

INSERT INTO `asignaturas` (`idAsignatura`, `nombreAsignatura`, `abreviatura`, `cicloFormativo`) VALUES
(1, 'Desarrollo de Interfaces', 'D_INT', 'DAM'),
(2, 'Empresa e Iniciativa Emprendedora', 'EIE', 'DAM'),
(3, 'Inglés Técnico para Grado Superior', 'INGLES', 'DAM'),
(4, 'Programación de Servicios y Procesos', 'PSP', 'DAM'),
(5, 'Programación Multimedia y Dispositivos Móviles', 'MOVILES', 'DAM'),
(6, 'Sistemas de Gestión Empresarial', 'SGE', 'DAM'),
(7, 'Acceso a Datos', 'A_DATOS', 'DAM'),
(8, 'Desarrollo Web en Entorno Cliente', 'ENT_CLIENTE', 'DAW'),
(9, 'Desarrollo Web en Entorno Servidor', 'ENT_SERVIDOR', 'DAW'),
(10, 'Despliegue de Aplicaciones Web', 'DESPLIEGUE', 'DAW'),
(11, 'Diseño de Interfaces Web', 'DISEÑO', 'DAW'),
(12, 'Empresa e Iniciativa Emprendedora', 'EIE', 'DAW'),
(13, 'Inglés Técnico para Grado Superior', 'INGLES', 'DAW'),
(14, 'Administración de Sistemas Gestores de Bases de Datos', 'ASGBBDD', 'ASIR'),
(15, 'Administración de Sistemas Operativos', 'ASSOO', 'ASIR'),
(16, 'Empresa e Iniciativa Emprendedora', 'EIE', 'ASIR'),
(17, 'Implantación de Aplicaciones Web', 'IAWEB', 'ASIR'),
(18, 'Inglés Técnico para Grado Superior', 'INGLES', 'ASIR'),
(19, 'Seguridad y Alta Disponibilidad', 'SEG_Y_DAD', 'ASIR'),
(20, 'Servicios de Red e Internet', 'REDES', 'ASIR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `beep`
--

CREATE TABLE `beep` (
  `idUsuario` int(4) NOT NULL,
  `contrasena` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `beep`
--

INSERT INTO `beep` (`idUsuario`, `contrasena`) VALUES
(1, 'Juan232023'),
(2, 'paco'),
(3, 'paco'),
(4, 'paco');

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
  `cantAnexos` int(3) DEFAULT NULL,
  `anexoUnoConvenio` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

CREATE TABLE `empresas` (
  `idEmpresa` int(11) NOT NULL,
  `nombreEmpresa` varchar(20) DEFAULT NULL,
  `cifEmpresa` varchar(20) NOT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `owner` varchar(20) DEFAULT NULL,
  `tutorPracticas` varchar(50) DEFAULT NULL,
  `responsableContratacion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `idUsuario` int(4) NOT NULL,
  `nombreUsuario` varchar(20) DEFAULT NULL,
  `correoUsuario` varchar(50) DEFAULT NULL,
  `rol` enum('Admin','Trabajador') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`idUsuario`, `nombreUsuario`, `correoUsuario`, `rol`) VALUES
(1, 'Pacheco', 'pacheco@gmail.com', 'Trabajador'),
(2, 'Francisco', 'leonmarcosf@gmail.com', 'Admin'),
(3, 'paco', 'paco', 'Admin'),
(4, 'Paconator', 'paconator@gmail.com', 'Trabajador');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `practicas`
--

CREATE TABLE `practicas` (
  `idPractica` int(5) NOT NULL,
  `dniAlumno` varchar(12) DEFAULT NULL,
  `tutorPracticas` varchar(50) DEFAULT NULL,
  `calendario` varchar(20) DEFAULT NULL,
  `informeSeguimiento` longblob DEFAULT NULL,
  `informeFinal` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `practicasempresas`
--

CREATE TABLE `practicasempresas` (
  `tutorPracticas_P` varchar(50) NOT NULL,
  `tutorPracticas_E` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`idAlumno`);

--
-- Indices de la tabla `alumnos_asignaturas`
--
ALTER TABLE `alumnos_asignaturas`
  ADD PRIMARY KEY (`id_alum_asig`),
  ADD KEY `idAlumno` (`idAlumno`),
  ADD KEY `idAsignatura` (`idAsignatura`);

--
-- Indices de la tabla `anexos`
--
ALTER TABLE `anexos`
  ADD PRIMARY KEY (`idAnexo`),
  ADD UNIQUE KEY `tutorPracticas` (`tutorPracticas`);

--
-- Indices de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD PRIMARY KEY (`idAsignatura`);

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
  ADD PRIMARY KEY (`idEmpresa`),
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
-- AUTO_INCREMENT de la tabla `alumnos_asignaturas`
--
ALTER TABLE `alumnos_asignaturas`
  MODIFY `id_alum_asig` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `anexos`
--
ALTER TABLE `anexos`
  MODIFY `idAnexo` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  MODIFY `idAsignatura` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `empresas`
--
ALTER TABLE `empresas`
  MODIFY `idEmpresa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `idUsuario` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `necesidad`
--
ALTER TABLE `necesidad`
  MODIFY `idNecesidad` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `practicas`
--
ALTER TABLE `practicas`
  MODIFY `idPractica` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnos_asignaturas`
--
ALTER TABLE `alumnos_asignaturas`
  ADD CONSTRAINT `alumnos_asignaturas_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumnos` (`idAlumno`),
  ADD CONSTRAINT `alumnos_asignaturas_ibfk_2` FOREIGN KEY (`idAsignatura`) REFERENCES `asignaturas` (`idAsignatura`);

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
