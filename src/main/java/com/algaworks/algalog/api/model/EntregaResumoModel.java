package com.algaworks.algalog.api.model;

import java.time.OffsetDateTime;

import com.algaworks.algalog.domain.model.StatusEntrega;

public class EntregaResumoModel {

	private Long id;
	private ClienteResumoModel cliente;
	private DestinatarioModel destinatario;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ClienteResumoModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteResumoModel cliente) {
		this.cliente = cliente;
	}
	public DestinatarioModel getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(DestinatarioModel destinatario) {
		this.destinatario = destinatario;
	}
	public StatusEntrega getStatus() {
		return status;
	}
	public void setStatus(StatusEntrega status) {
		this.status = status;
	}
	public OffsetDateTime getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(OffsetDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}
	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	
}
