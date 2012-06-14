drop table if exists tb_estado;

create table tb_estado(
id_estado serial not null primary key,
nm_estado varchar(50)
);

drop table if exists tb_cidade;

create table tb_cidade(
id_cidade serial not null primary key,
nm_cidade varchar(120),
populacao varchar(15),
area varchar(15),
pib varchar(30),
descricao varchar(1000),
imagem varchar(300),
id_estado int,
FOREIGN KEY (id_estado) REFERENCES tb_estado (id_estado)
);

create table tb_endereco(
id_endereco serial not null primary key,
nm_endereco varchar (300),
nr_endereco varchar (10),
nm_bairro varchar (250),
nm_complemento varchar(150),
nr_telefone varchar (30),
id_cidade int,
FOREIGN KEY (id_cidade) REFERENCES tb_cidade (id_cidade)
);

create table tb_estabelecimento(
id_estabelecimento serial not null primary key,
nm_estabelecimento varchar(100),
descricao varchar(1000),
imagem varchar(300),
id_endereco int,
FOREIGN KEY (id_endereco) REFERENCES tb_endereco (id_endereco)
);

 create table tb_hotel(
 id_estabelecimento int not null primary key,
 wifi boolean,
 nr_quartos integer,
 FOREIGN KEY (id_estabelecimento) REFERENCES tb_estabelecimento(id_estabelecimento)
);

create table tb_tipo_comida(
id_tipo_comida serial not null primary key,
nm_tipo_comida varchar(50)
);

 create table tb_restaurante(
 id_estabelecimento int not null primary key,
 id_tipo_comida int,
 lotacao int,
 FOREIGN KEY (id_tipo_comida) REFERENCES tb_tipo_comida(id_tipo_comida),
 FOREIGN KEY (id_estabelecimento) REFERENCES tb_estabelecimento(id_estabelecimento)
 );

 create table tb_ponto_turistico(
 id_estabelecimento int not null primary key,
 FOREIGN KEY (id_estabelecimento) REFERENCES tb_estabelecimento(id_estabelecimento)
 );

 create table tb_estadio(
 id_estabelecimento int not null primary key,
 lotacao int,
 FOREIGN KEY (id_estabelecimento) REFERENCES tb_estabelecimento(id_estabelecimento)
 );


drop table if exists tb_evento

create table tb_evento(
id_evento serial not null primary key,
nm_evento varchar(100),
descricao varchar(1000),
imagem varchar(1000)
);


drop table if exists tb_programacao

create table tb_programacao(
id_programacao serial not null primary key,
id_evento int not null,
id_endereco int not null,
dt_evento date,
horario varchar (10),
FOREIGN KEY (id_endereco) REFERENCES tb_endereco (id_endereco),
FOREIGN KEY (id_evento) REFERENCES tb_evento (id_evento)
);





create table tb_admin(
id_admin serial not null primary key,
nm_admin varchar(250),
nr_cpf varchar(11),
nr_rg varchar(14),
login varchar(30),
senha varchar (30),
telefone varchar(20),
email varchar(50)
);




 