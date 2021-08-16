package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exceptions.EntidadeNaoEncontradaException;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

	private EntregaRepository entregas;
	
	public Entrega findByIdOrError(Long entregaId) {
		return entregas.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(String
						.format("Entraga de código %d não encontrada.", entregaId)));
	}
}
