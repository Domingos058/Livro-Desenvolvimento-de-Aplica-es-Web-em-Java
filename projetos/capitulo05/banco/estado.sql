CREATE TABLE IF NOT EXISTS estado (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  sigla VARCHAR(2) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX sigla_UNIQUE (sigla ASC)
) ENGINE = InnoDB;