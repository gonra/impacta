CREATE TABLE tbl_aluno (
	id INTEGER,
	nome varchar2(30),
	cpf varchar2(20),
	turma varchar2(20),
	media REAL
);

CREATE TABLE tbl_professor (
	id INTEGER,
	nome varchar2(30),
	cpf varchar2(20),
	disciplina varchar2(20),
	salario REAL
);

CREATE TABLE tbl_endereco (
	id INTEGER,
	rua varchar2(30),
	casa varchar2(20),
	cidade varchar2(20), 
	cod_aluno INTEGER, 
	cod_professor INTEGER
);

INSERT INTO tbl_aluno (id,nome,cpf,turma,media) VALUES
	 (1,'PEDRO','10000-09','MATEMATICA',9.0),
	 (2,'JOAO','10010-09','MATEMATICA',7.0),
	 (3,'MONICA','10000-09','MATEMATICA',8.0),
	 (4,'CEBOLINHA','10000-09','MATEMATICA',6.0);
	 
INSERT INTO tbl_professor (id,nome,cpf,disciplina,salario) VALUES
	 (1,'DOMINGO LOPEZ','2000-10','CIENCIAS',2000.0),
	 (2,'MARIA PITANGA','3000-10','MUSICA',5000.0);

INSERT INTO tbl_endereco (id,rua,casa,cidade,cod_aluno,cod_professor) VALUES
	 (1,'RUA DOS BOBOS','ZERO','ILUSAO',1,NULL),
	 (2,'RUA XV','15','REPUBLICA',2,NULL),
	 (3,'RUA IPIRANGA','1800','INDEPENDENCIA',3,NULL),
	 (4,'LIMOEIRO','1234','TANTARNIA',4,NULL),
	 (5,'AV. 1 DE MAIO','66','POLIPINDOIA',NULL,1),
	 (6,'AV. EFIMERA','0987','TINGURU',NULL,2);
	 
	 