package com.algaworks.algalog.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private EntregaRepository entregas;
	private CadastroClienteService clienteService;

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		
		
		entrega.setCliente(clienteService.findByIdOrError(entrega.getCliente().getId()));
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregas.save(entrega);
	}
}
