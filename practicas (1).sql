-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-02-2024 a las 18:04:41
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
  `dniAlumno` varchar(12) NOT NULL,
  `nombreAlumno` varchar(50) DEFAULT NULL,
  `yearCurso` year(4) DEFAULT NULL,
  `nssAlumno` varchar(20) DEFAULT NULL,
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
-- Estructura de tabla para la tabla `beep`
--

CREATE TABLE `beep` (
  `idusuario` int(10) NOT NULL,
  `hash_contrasena` varchar(44) DEFAULT NULL,
  `salt` varchar(24) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `beep`
--

INSERT INTO `beep` (`idusuario`, `hash_contrasena`, `salt`) VALUES
(1, 'AJesq4iZ1oHl6MRgU+jE8wz3NJ/cJDLPez09nHRhooI=', '/s2aDkLpft02rvq9bcEwbA=='),
(2, 'b80a6XBIr0cjNb1YP8oJY9sbX93LK0bBYHSuGJVSL6M=', 'RQqrSyLE/wt6PtVcCY0Xvg=='),
(3, 'xqIwIuybPQ0yqaeLHFHua6IZzcx/raZ2JzXIPRs7KFo=', 'iKrOCVOYbMGPm29CflZsxw=='),
(4, 'rBDkF3sXfvbfFI/cjpbpK8zubSA+dIQKiwqhgXPkqIk=', 'cABznzesvpA6515pAv7Sog==');

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
  `informeSeguimiento` longblob DEFAULT NULL,
  `informeFinal` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idusuario` int(10) NOT NULL,
  `nombre_usuario` varchar(9) DEFAULT NULL,
  `apellidos_usuario` varchar(11) DEFAULT NULL,
  `email_usuario` varchar(21) DEFAULT NULL,
  `dni_usuario` varchar(10) DEFAULT NULL,
  `rol` varchar(10) DEFAULT NULL,
  `fecha_alta` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idusuario`, `nombre_usuario`, `apellidos_usuario`, `email_usuario`, `dni_usuario`, `rol`, `fecha_alta`) VALUES
(1, 'Francisco', 'Leon Marcos', 'leonmarcosf@gmail.com', '09141745G', 'Admin', '20-05-2002'),
(2, 'Lionel', 'Messi', 'leomessi10@gmail.com', '0912345G', 'Admin', '19-06-1985'),
(3, 'paco', 'paco', 'paco@gmail.com', '01234567P', 'Admin', '12-12-1997'),
(4, 'Prueba', '12', 'gfhkfty,dtyk', '456856ju56', 'Trabajador', '14-12-2023');

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
-- Indices de la tabla `beep`
--
ALTER TABLE `beep`
  ADD PRIMARY KEY (`idusuario`);

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
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `anexos`
--
ALTER TABLE `anexos`
  MODIFY `idAnexo` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `beep`
--
ALTER TABLE `beep`
  MODIFY `idusuario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idusuario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
