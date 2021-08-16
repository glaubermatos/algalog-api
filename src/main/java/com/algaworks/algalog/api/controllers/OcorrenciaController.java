package com.algaworks.algalog.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.assembler.OcorrenciaAssembler;
import com.algaworks.algalog.api.assembler.OcorrenciaDisassembler;
import com.algaworks.algalog.api.model.OcorrenciaModel;
import com.algaworks.algalog.api.model.input.OcorrenciaInput;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.service.BuscaEntregaService;
import com.algaworks.algalog.domain.service.RegistroOcorrenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	private BuscaEntregaService buscaEntregaService;
	private OcorrenciaAssembler ocorrenciaAssembler;
	private OcorrenciaDisassembler ocorrenciaDisassembler;
	private RegistroOcorrenciaService service;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public OcorrenciaModel create(@PathVariable Long entregaId, 
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		return ocorrenciaAssembler
				.toModel(service
						.registrar(entregaId, 
								ocorrenciaDisassembler
									.toDomainMedel(ocorrenciaInput)
									.getDescricao()));
	}
	
	@GetMapping
	public List<OcorrenciaModel> index(@PathVariable Long entregaId) {
		Entrega entrega = buscaEntregaService.findByIdOrError(entregaId);
		
		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
	}
}
