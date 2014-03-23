drop database if exists livraria;
CREATE DATABASE livraria ;
USE livraria;


CREATE TABLE autores (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(80) NOT NULL,
  cpf char(11) NOT NULL,
  telefone char(10) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE livros(
  id int(11) NOT NULL AUTO_INCREMENT,
  titulo varchar(80) NOT NULL,
  editora varchar(80) NOT NULL,
  autor_id int(11) DEFAULT NULL,
  preco double DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_autorlivro FOREIGN KEY (autor_id) REFERENCES autores (id)
);

DELIMITER $$
CREATE trigger apagarLivros
before delete on autores
for each row
begin
    delete from livros
    where autor_id = old.id;
end $$
DELIMITER ;


