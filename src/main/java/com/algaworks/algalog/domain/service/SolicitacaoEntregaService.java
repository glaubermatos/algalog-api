package com.algaworks.algalog.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {
	
	private EntregaRepository entregas;
	private CadastroClienteService clienteService;
	
	public SolicitacaoEntregaService(EntregaRepository entregas, CadastroClienteService clienteService) {
		super();
		this.entregas = entregas;
		this.clienteService = clienteService;
	}



	@Transactional
	public Entrega solicitar(Entrega entrega) {
		
		
		entrega.setCliente(clienteService.findByIdOrError(entrega.getCliente().getId()));
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregas.save(entrega);
	}
}
