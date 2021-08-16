package com.algaworks.algalog.api.model;

import java.time.OffsetDateTime;

import com.algaworks.algalog.domain.model.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaResumoModel {

	private Long id;
	private ClienteResumoModel cliente;
	private DestinatarioModel destinatario;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
}
