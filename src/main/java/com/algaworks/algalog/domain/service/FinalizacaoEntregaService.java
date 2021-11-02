package com.algaworks.algalog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {
	
	private EntregaRepository entregas;
	private BuscaEntregaService buscaEntregaService;
	
	public FinalizacaoEntregaService(EntregaRepository entregas, BuscaEntregaService buscaEntregaService) {
		super();
		this.entregas = entregas;
		this.buscaEntregaService = buscaEntregaService;
	}

	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega = buscaEntregaService.findByIdOrError(entregaId);
		
		entrega.finalizar();
		
		entregas.save(entrega);
	}
}
