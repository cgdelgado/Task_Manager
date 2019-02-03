-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-02-2019 a las 13:46:21
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `task_manager`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tasks`
--

CREATE TABLE IF NOT EXISTS `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  `description` text,
  `start` varchar(10) DEFAULT NULL,
  `end` varchar(10) DEFAULT NULL,
  `done` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ID` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf16 AUTO_INCREMENT=24 ;

--
-- Volcado de datos para la tabla `tasks`
--

INSERT INTO `tasks` (`id`, `name`, `description`, `start`, `end`, `done`) VALUES
(9, 'Anáisis de requisitos', 'Analizar requisitos del proyecto', '2019-02-04', '2019-02-07', 1),
(10, 'Diseño interfaz', 'Diseñar la interfaz de usuario para el proyecto', '2019-02-11', '2019-02-13', 1),
(11, 'Validaciones', 'Validacion de formualrios', '2019-02-01', '2019-02-04', 0),
(12, 'Implementacion', 'Implementar código', '2019-02-07', '2019-02-11', 0),
(16, 'Revisión', '', '2019-02-01', '2019-02-04', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
