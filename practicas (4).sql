-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-02-2024 a las 19:43:20
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`idAlumno`, `dniAlumno`, `nombreAlumno`, `yearCurso`, `segSocialAlumno`, `validez`, `cicloAlumno`, `CV`) VALUES
(-5, '09141745G', 'Francisco', 2002, 850805024, 1, 'DAM', NULL);
INSERT INTO `alumnos` (`idAlumno`, `dniAlumno`, `nombreAlumno`, `yearCurso`, `segSocialAlumno`, `validez`, `cicloAlumno`, `CV`) VALUES
(-3, '45678901C', 'Carlos García', 2023, 2147483647, 1, 'ASIR', NULL),
(1, '12345678A', 'Juan Pérez', 2023, 2147483647, 1, 'DAM', NULL),
(2, '87654321B', 'María López', 2022, 2147483647, 1, 'DAW', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos_asignaturas`
--

CREATE TABLE `alumnos_asignaturas` (
  `id_alum_asig` int(4) NOT NULL,
  `idAlumno` int(3) DEFAULT NULL,
  `idAsignatura` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anexos`
--

CREATE TABLE `anexos` (
  `idAnexo` int(5) NOT NULL,
  `fechaInicio` varchar(15) DEFAULT NULL,
  `fechaFin` varchar(15) DEFAULT NULL,
  `idNecesidad` int(10) DEFAULT NULL,
  `idEmpresa` int(3) NOT NULL,
  `contratacion` tinyint(1) DEFAULT NULL,
  `calendario` varchar(20) DEFAULT NULL,
  `anexoDosUno` longblob DEFAULT NULL,
  `anexoTres` longblob DEFAULT NULL,
  `anexoCuatro` longblob DEFAULT NULL,
  `anexoDosDos` longblob DEFAULT NULL,
  `anexoOcho` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `anexos`
--

INSERT INTO `anexos` (`idAnexo`, `fechaInicio`, `fechaFin`, `idNecesidad`, `idEmpresa`, `contratacion`, `calendario`, `anexoDosUno`, `anexoTres`, `anexoCuatro`, `anexoDosDos`, `anexoOcho`) VALUES
(6, '28 marzo 2024', '31 marzo 2024', 1, 1, 1, 'marzo', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `anexos` (`idAnexo`, `fechaInicio`, `fechaFin`, `idNecesidad`, `idEmpresa`, `contratacion`, `calendario`, `anexoDosUno`, `anexoTres`, `anexoCuatro`, `anexoDosDos`, `anexoOcho`) VALUES
(7, '14 febrero 2024', '07 febrero 2024', 2, 1, 1, 'febrero', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `anexos` (`idAnexo`, `fechaInicio`, `fechaFin`, `idNecesidad`, `idEmpresa`, `contratacion`, `calendario`, `anexoDosUno`, `anexoTres`, `anexoCuatro`, `anexoDosDos`, `anexoOcho`) VALUES
(8, '15 febrero 2024', '28 febrero 2024', 1, 3, 1, 'febrero', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaturas`
--

CREATE TABLE `asignaturas` (
  `idAsignatura` int(3) NOT NULL,
  `nombreAsignatura` varchar(60) DEFAULT NULL,
  `abreviatura` varchar(20) DEFAULT NULL,
  `cicloFormativo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `hash_contrasena` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `beep`
--

INSERT INTO `beep` (`idUsuario`, `hash_contrasena`, `salt`) VALUES
(1, '+N5M0YcxC3v2Hp7iTGew+kyub9OMlEn+kI0Ev68vvEU=', 'bXmpqver87ynDp59ozE/og=='),
(2, 'eA4GUSssef5GbIZBDE2x+zUDdHepf1ZC/5juahfHYHg=', 'z35a8MtG917T6LN2/2Nsmg==');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bolsa`
--

CREATE TABLE `bolsa` (
  `idBolsa` int(5) NOT NULL,
  `idEmpresa` int(5) DEFAULT NULL,
  `idAlumno` int(3) DEFAULT NULL,
  `beca` tinyint(1) DEFAULT NULL,
  `bolsa` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `convenio`
--

CREATE TABLE `convenio` (
  `idConvenio` int(11) NOT NULL,
  `idEmpresa` int(11) NOT NULL,
  `numConvenio` int(11) NOT NULL,
  `nombreEmpresa` varchar(20) DEFAULT NULL,
  `responsableFirma` varchar(50) DEFAULT NULL,
  `cantAnexos` int(11) DEFAULT NULL,
  `anexoUnoConvenio` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `convenio`
--

INSERT INTO `convenio` (`idConvenio`, `idEmpresa`, `numConvenio`, `nombreEmpresa`, `responsableFirma`, `cantAnexos`, `anexoUnoConvenio`) VALUES
(-6, 3, 5646, 'Empresa 3', 'Paco', 4, NULL);
INSERT INTO `convenio` (`idConvenio`, `idEmpresa`, `numConvenio`, `nombreEmpresa`, `responsableFirma`, `cantAnexos`, `anexoUnoConvenio`) VALUES
(7, 2, 11111, 'Empresa 2', 'Pacobdfbasjidfbv', 0, NULL);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`idEmpresa`, `nombreEmpresa`, `cifEmpresa`, `direccion`, `telefono`, `owner`, `tutorPracticas`, `responsableContratacion`) VALUES
(1, 'Empresa 1', '12345678A', 'Dirección 1', '123456789', 'Owner 1', 'Tutor 1', 'Responsable 1'),
(2, 'Empresa 2', '87654321B', 'Dirección 2', '987654321', 'Owner 2', 'Tutor 2', 'Responsable 2'),
(3, 'Empresa 3', '45678901C', 'Dirección 3', '987654321', 'Owner 3', 'Tutor 3', 'Responsable 3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `idUsuario` int(4) NOT NULL,
  `nombreUsuario` varchar(20) DEFAULT NULL,
  `correoUsuario` varchar(50) DEFAULT NULL,
  `rol` enum('Admin','Trabajador') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`idUsuario`, `nombreUsuario`, `correoUsuario`, `rol`) VALUES
(1, 'paco', 'paco', 'Admin'),
(2, 'antonio', 'antonio@gmail.com', 'Trabajador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `necesidad`
--

CREATE TABLE `necesidad` (
  `idNecesidad` int(4) NOT NULL,
  `idEmpresa` int(11) DEFAULT NULL,
  `cicloNecesidad` varchar(10) DEFAULT NULL,
  `dam` int(2) DEFAULT NULL,
  `daw` int(2) DEFAULT NULL,
  `asir` int(2) DEFAULT NULL,
  `mark` int(2) DEFAULT NULL,
  `fin` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `necesidad`
--

INSERT INTO `necesidad` (`idNecesidad`, `idEmpresa`, `cicloNecesidad`, `dam`, `daw`, `asir`, `mark`, `fin`) VALUES
(1, 1, 'marzo', 2, 2, 22, 2, 2),
(2, 3, 'marzo', 4, 0, 1, 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `practicas`
--

CREATE TABLE `practicas` (
  `idPractica` int(5) NOT NULL,
  `idAlumno` int(3) DEFAULT NULL,
  `idEmpresa` int(11) DEFAULT NULL,
  `idAnexo` int(5) DEFAULT NULL,
  `informeSeguimiento` longblob DEFAULT NULL,
  `informeFinal` longblob DEFAULT NULL,
  `horarioEntrada` varchar(255) NOT NULL,
  `horarioSalida` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `practicas`
--

INSERT INTO `practicas` (`idPractica`, `idAlumno`, `idEmpresa`, `idAnexo`, `informeSeguimiento`, `informeFinal`, `horarioEntrada`, `horarioSalida`) VALUES
(2, 2, 3, 7, NULL, NULL, '10:00', '12:00');

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
  ADD KEY `fk_anexos_necesidad` (`idNecesidad`),
  ADD KEY `fk_anexos_empresa` (`idEmpresa`);

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
-- Indices de la tabla `bolsa`
--
ALTER TABLE `bolsa`
  ADD PRIMARY KEY (`idBolsa`),
  ADD KEY `fk_bolsa_alumnos` (`idAlumno`),
  ADD KEY `fk_bolsa_empresas` (`idEmpresa`);

--
-- Indices de la tabla `convenio`
--
ALTER TABLE `convenio`
  ADD PRIMARY KEY (`idConvenio`),
  ADD KEY `idEmpresa` (`idEmpresa`);

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
  ADD UNIQUE KEY `cifEmpresa` (`idEmpresa`);

--
-- Indices de la tabla `practicas`
--
ALTER TABLE `practicas`
  ADD PRIMARY KEY (`idPractica`),
  ADD KEY `fk_idAlumno` (`idAlumno`),
  ADD KEY `fk_idEmpresa` (`idEmpresa`),
  ADD KEY `fk_idAnexo` (`idAnexo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `idAlumno` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `alumnos_asignaturas`
--
ALTER TABLE `alumnos_asignaturas`
  MODIFY `id_alum_asig` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `anexos`
--
ALTER TABLE `anexos`
  MODIFY `idAnexo` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  MODIFY `idAsignatura` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `bolsa`
--
ALTER TABLE `bolsa`
  MODIFY `idBolsa` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `convenio`
--
ALTER TABLE `convenio`
  MODIFY `idConvenio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `empresas`
--
ALTER TABLE `empresas`
  MODIFY `idEmpresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `idUsuario` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `necesidad`
--
ALTER TABLE `necesidad`
  MODIFY `idNecesidad` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `practicas`
--
ALTER TABLE `practicas`
  MODIFY `idPractica` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
-- Filtros para la tabla `anexos`
--
ALTER TABLE `anexos`
  ADD CONSTRAINT `fk_anexos_empresa` FOREIGN KEY (`idEmpresa`) REFERENCES `empresas` (`idEmpresa`),
  ADD CONSTRAINT `fk_anexos_necesidad` FOREIGN KEY (`idNecesidad`) REFERENCES `necesidad` (`idNecesidad`);

--
-- Filtros para la tabla `beep`
--
ALTER TABLE `beep`
  ADD CONSTRAINT `beep_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `login` (`idUsuario`);

--
-- Filtros para la tabla `bolsa`
--
ALTER TABLE `bolsa`
  ADD CONSTRAINT `fk_bolsa_alumnos` FOREIGN KEY (`idAlumno`) REFERENCES `alumnos` (`idAlumno`),
  ADD CONSTRAINT `fk_bolsa_empresas` FOREIGN KEY (`idEmpresa`) REFERENCES `empresas` (`idEmpresa`);

--
-- Filtros para la tabla `convenio`
--
ALTER TABLE `convenio`
  ADD CONSTRAINT `convenio_ibfk_1` FOREIGN KEY (`idEmpresa`) REFERENCES `empresas` (`idEmpresa`);

--
-- Filtros para la tabla `necesidad`
--
ALTER TABLE `necesidad`
  ADD CONSTRAINT `fk_necesidad_empresa` FOREIGN KEY (`idEmpresa`) REFERENCES `empresas` (`idEmpresa`);

--
-- Filtros para la tabla `practicas`
--
ALTER TABLE `practicas`
  ADD CONSTRAINT `fk_idAlumno` FOREIGN KEY (`idAlumno`) REFERENCES `alumnos` (`idAlumno`),
  ADD CONSTRAINT `fk_idAnexo` FOREIGN KEY (`idAnexo`) REFERENCES `anexos` (`idAnexo`),
  ADD CONSTRAINT `fk_idEmpresa` FOREIGN KEY (`idEmpresa`) REFERENCES `empresas` (`idEmpresa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
