insert into tbl_cuidador values (1,'Zoo01','PEDRO');
insert into tbl_cuidador values (2,'Zoo02','LUIS');
insert into tbl_cuidador values (3,'Zoo03','ALBERTO');
insert into tbl_cuidador values (4,'Zoo04','ANTONIO');

insert into tbl_jaula values (1,'bloco1','ZooAA',1001);
insert into tbl_jaula values (2,'bloco1','ZooAA',1002);
insert into tbl_jaula values (3,'bloco1','ZooAA',1003);
insert into tbl_jaula values (4,'bloco2','ZooAA',1021);
insert into tbl_jaula values (5,'bloco2','ZooAA',1022);
insert into tbl_jaula values (6,'bloco3','ZooAA',1031);

insert into tbl_cuidador_lista_jaulas values (1,1);
insert into tbl_cuidador_lista_jaulas values (1,2);
insert into tbl_cuidador_lista_jaulas values (1,3);
insert into tbl_cuidador_lista_jaulas values (1,4);
insert into tbl_cuidador_lista_jaulas values (2,1);
insert into tbl_cuidador_lista_jaulas values (2,5);
insert into tbl_cuidador_lista_jaulas values (2,6);
insert into tbl_cuidador_lista_jaulas values (3,1);
insert into tbl_cuidador_lista_jaulas values (4,1);

insert into tbl_animal values (1,DATE '2000-07-15','TIGRE','RON','SIBERIANO',1);
insert into tbl_animal values (2,DATE '2001-06-11','TIGRESA','RIN','SIBERIANO',1);
insert into tbl_animal values (3,DATE '2010-08-28','LEAO','LEO','AFRICANO',1);
insert into tbl_animal values (4,DATE '2020-02-01','MACACO','PIN','MICO',2);
insert into tbl_animal values (5,DATE '2020-04-10','MACACO','PON','MICO',2);
insert into tbl_animal values (6,DATE '2020-03-21','MACACO','PUN','MICO',2);
insert into tbl_animal values (7,DATE '2021-05-18','MACACO','PAN','MICO',2);

ALTER SEQUENCE cuidador_seq RESTART WITH 5;
ALTER SEQUENCE animal_seq RESTART WITH 8;
ALTER SEQUENCE jaula_seq RESTART WITH 7;


insert into tbl_user values (X'f5c31d4c4ed44039833fecc5ed0f4751', '$2a$10$SdyuCfSHiBuLpRqprVNCFOI47PpGy.hS7.Vq6XX0TOVxVowytaRMm','admin');
insert into tbl_user values (X'883bc2e7cebf4f4b96089c22af687b03', '$2a$10$SdyuCfSHiBuLpRqprVNCFOI47PpGy.hS7.Vq6XX0TOVxVowytaRMm','user');

insert into tbl_role values (X'f43608f5694140d5a4490edf04e5f5da', 'ROLE_ADMIN');
insert into tbl_role values (X'97ae9e7e9f0f41f4bbc8afebe0b85650', 'ROLE_USER');

insert into tb_users_roles values (X'f5c31d4c4ed44039833fecc5ed0f4751',X'f43608f5694140d5a4490edf04e5f5da');
insert into tb_users_roles values (X'883bc2e7cebf4f4b96089c22af687b03',X'97ae9e7e9f0f41f4bbc8afebe0b85650');