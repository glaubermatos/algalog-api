package com.algaworks.algalog.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

@Service
public class CancelamentoEntregaService {
	
	@Autowired
	private EntregaRepository entregas;
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public void cancelar(Long id) {
		Entrega entrega = buscaEntregaService.findByIdOrError(id);
		
		entrega.cancelar();
		
		entregas.save(entrega);
	}

}
