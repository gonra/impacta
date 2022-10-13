create table TBL_ALUNO (id integer not null, cpf varchar(255), nome varchar(255), cod_endereco integer, media double, turma varchar(255), primary key (id));
create table TBL_ENDERECO (id integer not null, casa varchar(255), cidade varchar(255), rua varchar(255), primary key (id));
create table TBL_PROFESSOR (id integer not null, cpf varchar(255), nome varchar(255), cod_endereco integer, disciplina varchar(255), salario double, primary key (id));
alter table TBL_ALUNO add constraint FK_auok2yl8057or5y39bawg9it6 foreign key (cod_endereco) references TBL_ENDERECO;
alter table TBL_PROFESSOR add constraint FK_r0n0ch9awyxdh26qgl5q1xmj2 foreign key (cod_endereco) references TBL_ENDERECO;