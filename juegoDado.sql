CREATE TABLE `resultados` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `ganador` int(1) NOT NULL
) ENGINE=InnoDB;


CREATE TABLE `usuarios` (
  `usuario` varchar(50) NOT NULL,
  `fechaAlta` date NOT NULL
) ENGINE=InnoDB;


ALTER TABLE `usuarios` ADD PRIMARY KEY (`usuario`);

ALTER TABLE `resultados`  ADD CONSTRAINT `fkUsuarios1` FOREIGN KEY (`nombre`) REFERENCES `usuarios` (`usuario`);

