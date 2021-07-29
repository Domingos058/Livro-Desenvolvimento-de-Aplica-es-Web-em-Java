DROP SCHEMA IF EXISTS venda_produtos;
CREATE SCHEMA IF NOT EXISTS venda_produtos;
USE venda_produtos;

CREATE TABLE IF NOT EXISTS estado (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  sigla VARCHAR(2) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX sigla_UNIQUE (sigla ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS cidade (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  estado_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_cidade_estado_idx (estado_id ASC),
  CONSTRAINT fk_cidade_estado
    FOREIGN KEY (estado_id)
    REFERENCES estado (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS cliente (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  sobrenome VARCHAR(45) NOT NULL,
  dataNascimento DATE NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  email VARCHAR(60) NOT NULL,
  logradouro VARCHAR(50) NOT NULL,
  numero VARCHAR(6) NOT NULL,
  bairro VARCHAR(30) NOT NULL,
  cep VARCHAR(9) NOT NULL,
  cidade_id INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX cpf_UNIQUE (cpf ASC),
  INDEX fk_cliente_cidade_idx (cidade_id ASC),
  CONSTRAINT fk_cliente_cidade
    FOREIGN KEY (cidade_id)
    REFERENCES cidade (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS fornecedor (
  id INT NOT NULL AUTO_INCREMENT,
  razaoSocial VARCHAR(100) NOT NULL,
  cnpj VARCHAR(18) NOT NULL,
  email VARCHAR(60) NOT NULL,
  logradouro VARCHAR(50) NOT NULL,
  numero VARCHAR(6) NOT NULL,
  bairro VARCHAR(30) NOT NULL,
  cep VARCHAR(9) NOT NULL,
  cidade_id INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX CNPJ_UNIQUE (cnpj ASC),
  INDEX fk_fornecedor_cidade_idx (cidade_id ASC),
  CONSTRAINT fk_fornecedor_cidade
    FOREIGN KEY (cidade_id)
    REFERENCES cidade (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS unidade_medida (
  id INT NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(45) NOT NULL,
  sigla VARCHAR(4) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX sigla_UNIQUE (sigla ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS produto (
  id INT NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(60) NOT NULL,
  codigoBarras VARCHAR(13) NOT NULL,
  valorVenda DECIMAL(15,2) NOT NULL,
  estoque DECIMAL(15,2) NOT NULL,
  fornecedor_id INT NOT NULL,
  unidade_medida_id INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX codigoBarras_UNIQUE (codigoBarras ASC),
  INDEX fk_produto_fornecedor_idx (fornecedor_id ASC),
  INDEX fk_produto_unidade_medida_idx (unidade_medida_id ASC),
  CONSTRAINT fk_produto_fornecedor
    FOREIGN KEY (fornecedor_id)
    REFERENCES fornecedor (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_produto_unidade_medida
    FOREIGN KEY (unidade_medida_id)
    REFERENCES unidade_medida (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS venda (
  id INT NOT NULL AUTO_INCREMENT,
  data DATE NOT NULL,
  cancelada TINYINT(1) NOT NULL,
  cliente_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_venda_cliente_idx (cliente_id ASC),
  CONSTRAINT fk_venda_cliente
    FOREIGN KEY (cliente_id)
    REFERENCES cliente (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS item_venda (
  venda_id INT NOT NULL,
  produto_id INT NOT NULL,
  valor DECIMAL(15,2) NOT NULL,
  quantidade DECIMAL(15,2) NOT NULL,
  PRIMARY KEY (venda_id, produto_id),
  INDEX fk_venda_has_produto_produto_idx (produto_id ASC),
  INDEX fk_venda_has_produto_venda_idx (venda_id ASC),
  CONSTRAINT fk_venda_has_produto_venda
    FOREIGN KEY (venda_id)
    REFERENCES venda (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_venda_has_produto_produto
    FOREIGN KEY (produto_id)
    REFERENCES produto (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

INSERT INTO estado (id, nome, sigla) VALUES (1, 'São Paulo', 'SP');
INSERT INTO estado (id, nome, sigla) VALUES (2, 'Minas Gerais', 'MG');

INSERT INTO cidade (id, nome, estado_id) VALUES (1, 'Vargem Grande do Sul', 1);
INSERT INTO cidade (id, nome, estado_id) VALUES (2, 'São João da Boa Vista', 1);
INSERT INTO cidade (id, nome, estado_id) VALUES (3, 'Poços de Caldas', 2);

INSERT INTO cliente (id, nome, sobrenome, dataNascimento, cpf, email, logradouro, numero, bairro, cep, cidade_id) VALUES (1, 'João', 'da Silva', '1999-10-10', '111.111.111-11', 'joao@joao.com.br', 'Rua Hermenegildo Cossi', '750', 'Jardim Fortaleza', '13880-000', 1);
INSERT INTO cliente (id, nome, sobrenome, dataNascimento, cpf, email, logradouro, numero, bairro, cep, cidade_id) VALUES (2, 'Maria', 'Rodrigues', '1974-05-16', '222.222.222-22', 'mariarod@gmail.com', 'Rua Patrocínio Rodrigues', '120', 'Centro', '13880-000', 1);
INSERT INTO cliente (id, nome, sobrenome, dataNascimento, cpf, email, logradouro, numero, bairro, cep, cidade_id) VALUES (3, 'Marcela', 'dos Santos', '1985-09-25', '333.333.333-33', 'mdossantos@uol.com.br', 'Rua Primeirod de Maio', '219', 'Centro', '13880-000', 1);

INSERT INTO fornecedor (id, razaoSocial, cnpj, email, logradouro, numero, bairro, cep, cidade_id) VALUES (1, 'Fruta Madura', '11.111.111/1111-11', 'atendimento@frutamadura.com.br', 'Rua João da Silva', '79', 'Centro', '13825-789', 2);
INSERT INTO fornecedor (id, razaoSocial, cnpj, email, logradouro, numero, bairro, cep, cidade_id) VALUES (2, 'Eletrônicos Dois Irmãos', '22.222.222/2222-22', 'sac@edi.com.br', 'Rua do Comércio', '188', 'Centro', '13880-000', 1);
INSERT INTO fornecedor (id, razaoSocial, cnpj, email, logradouro, numero, bairro, cep, cidade_id) VALUES (3, 'Distribuidora de Carnes do Sul', '33.333.333/3333-33', 'contato@distcarnesdosul.com.br', 'Rua Manoel Junqueira', '874', 'Jardim Industrial', '16859-789', 3);

INSERT INTO unidade_medida (id, descricao, sigla) VALUES (1, 'quilograma', 'kg');
INSERT INTO unidade_medida (id, descricao, sigla) VALUES (2, 'unidade', 'un');

INSERT INTO produto (id, descricao, codigoBarras, valorVenda, estoque, fornecedor_id, unidade_medida_id) VALUES (1, 'maçã', '1111111111111', 3.78, 20, 1, 1);
INSERT INTO produto (id, descricao, codigoBarras, valorVenda, estoque, fornecedor_id, unidade_medida_id) VALUES (2, 'pera', '2222222222222', 5.45, 30, 1, 1);
INSERT INTO produto (id, descricao, codigoBarras, valorVenda, estoque, fornecedor_id, unidade_medida_id) VALUES (3, 'uva', '3333333333333', 9.50, 20, 1, 1);
INSERT INTO produto (id, descricao, codigoBarras, valorVenda, estoque, fornecedor_id, unidade_medida_id) VALUES (4, 'computador', '4444444444444', 3700.00, 10, 2, 2);
INSERT INTO produto (id, descricao, codigoBarras, valorVenda, estoque, fornecedor_id, unidade_medida_id) VALUES (5, 'rádio', '5555555555555', 150.00, 15, 2, 2);
INSERT INTO produto (id, descricao, codigoBarras, valorVenda, estoque, fornecedor_id, unidade_medida_id) VALUES (6, 'lava louças', '6666666666666', 4499.99, 5, 2, 2);
INSERT INTO produto (id, descricao, codigoBarras, valorVenda, estoque, fornecedor_id, unidade_medida_id) VALUES (7, 'alcatra', '7777777777777', 59.99, 150.00, 3, 1);
INSERT INTO produto (id, descricao, codigoBarras, valorVenda, estoque, fornecedor_id, unidade_medida_id) VALUES (8, 'picanha', '8888888888888', 72.25, 120.00, 3, 1);
INSERT INTO produto (id, descricao, codigoBarras, valorVenda, estoque, fornecedor_id, unidade_medida_id) VALUES (9, 'costela bovina', '9999999999999', 30.45, 200.00, 3, 1);
INSERT INTO produto (id, descricao, codigoBarras, valorVenda, estoque, fornecedor_id, unidade_medida_id) VALUES (10, 'patinho', '1234567891234', 60.99, 150.00, 3, 1);
INSERT INTO produto (id, descricao, codigoBarras, valorVenda, estoque, fornecedor_id, unidade_medida_id) VALUES (11, 'lombo suíno', '9876543219876', 34.99, 100.00, 3, 1);
INSERT INTO produto (id, descricao, codigoBarras, valorVenda, estoque, fornecedor_id, unidade_medida_id) VALUES (12, 'peito de frango sem osso', '7958426317591', 20.99, 250.00, 3, 1);