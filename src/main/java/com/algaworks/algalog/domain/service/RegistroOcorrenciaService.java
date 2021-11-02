package com.algaworks.algalog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.Ocorrencia;

@Service
public class RegistroOcorrenciaService {
	
	private BuscaEntregaService buscaEntregaService;
	
	public RegistroOcorrenciaService(BuscaEntregaService buscaEntregaService) {
		super();
		this.buscaEntregaService = buscaEntregaService;
	}

	@Transactional
	public Ocorrencia registrar(Long entregaid, String descricao) {
		Entrega entrega = buscaEntregaService.findByIdOrError(entregaid);
		
		return entrega.adicionarOcorrencia(descricao);
	}
}
