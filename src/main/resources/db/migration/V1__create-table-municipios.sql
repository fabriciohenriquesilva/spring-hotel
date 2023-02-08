CREATE TABLE IF NOT EXISTS municipio (

  id bigint not null auto_increment,
  nome varchar(100) not null,
  estado varchar(50) not null,
  pais varchar(50) not null,

  primary key (id)
);