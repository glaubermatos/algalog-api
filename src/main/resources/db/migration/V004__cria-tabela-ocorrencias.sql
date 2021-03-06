create table ocorrencia (
	id BIGINT generated by default as identity not null,
    entrega_id BIGINT not null,
    descricao TEXT not null,
    data_registro TIMESTAMP not null,
    
    primary key (id)
);

alter table ocorrencia add constraint fk_ocorrencia_entrega
foreign key (entrega_id) references entrega (id);