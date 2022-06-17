-- consumo_energia.cliente definition

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `data_nascimento` date NOT NULL,
  `cpf` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `endereco` varchar(30) NOT NULL,
  `cep` varchar(11) NOT NULL,
  `sexo` varchar(30) NOT NULL,
  `unidade_consumidora` int(8) NOT NULL,
  `data_vencimento` date NOT NULL,
  `kwh` int(100) NOT NULL,
  `valor_kw` float NOT NULL,
  `valor_total` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `nivel` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;


INSERT INTO consumo_energia.cliente
(id, nome, data_nascimento, cpf, email, endereco, cep, sexo, unidade_consumidora, data_vencimento, kwh, valor_kw, valor_total)
VALUES(29, 'Cláudia Silvana Isabella Dias', '1967-02-26', '570.759.377-', 'claudia_silvana_dias@riguetti.com.br', 'Travessa Salomão Lima da Silva', '69312-535', 'Feminino', 37812973, '2022-07-12', 3, 2.5, 6.25);


INSERT INTO consumo_energia.usuarios
(id, nome, login, senha, nivel)
VALUES(1, 'Administrador', 'admin', 'admin', 'ADMIN');
INSERT INTO consumo_energia.usuarios
(id, nome, login, senha, nivel)
VALUES(2, 'Usuario Coomum', 'user', 'user', 'USUARIO');

