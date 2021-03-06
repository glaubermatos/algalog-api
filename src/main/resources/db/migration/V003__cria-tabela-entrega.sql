create table entrega(
	id BIGINT generated by default as identity not null,
    cliente_id BIGINT not null,
    taxa DECIMAL(10,2) not null,
    status VARCHAR(20) not null,
    data_pedido TIMESTAMP not null,
    data_finalizacao TIMESTAMP,
    
    destinatario_nome VARCHAR(60) not null,
    destinatario_logradouro VARCHAR(255) not null,
    destinatario_numero VARCHAR(30) not null,
    destinatario_complemento VARCHAR(60) not null,
    destinatario_bairro VARCHAR(30) not null,
    
    primary key (id)
);

alter table entrega add constraint fk_entrega_cliente
foreign key (cliente_id) references cliente (id);