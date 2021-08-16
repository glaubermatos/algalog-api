create table `cliente` (
  `id` bigint not null auto_increment,
  `nome` VARCHAR(255) not null,
  `email` varchar(20) not null,
  `telefone` varchar(20) not null,
  
  primary key (`id`)
);