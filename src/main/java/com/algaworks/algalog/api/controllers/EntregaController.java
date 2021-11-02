package com.algaworks.algalog.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.assembler.EntregaAssembler;
import com.algaworks.algalog.api.assembler.EntregaDisassembler;
import com.algaworks.algalog.api.model.EntregaModel;
import com.algaworks.algalog.api.model.input.EntregaInput;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.FinalizacaoEntregaService;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private FinalizacaoEntregaService finalizacaoEntregaService;
	private SolicitacaoEntregaService service; 
	private EntregaRepository entregas;
	private EntregaAssembler entregaAssembler;
	private EntregaDisassembler entregaDisassembler;
	
	public EntregaController(FinalizacaoEntregaService finalizacaoEntregaService, SolicitacaoEntregaService service,
			EntregaRepository entregas, EntregaAssembler entregaAssembler, EntregaDisassembler entregaDisassembler) {
		super();
		this.finalizacaoEntregaService = finalizacaoEntregaService;
		this.service = service;
		this.entregas = entregas;
		this.entregaAssembler = entregaAssembler;
		this.entregaDisassembler = entregaDisassembler;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		return entregaAssembler
				.toModel(service
						.solicitar(entregaDisassembler.toDomainModel(entregaInput)));
	}
	
	@GetMapping
	public List<EntregaModel> index() {
		return entregaAssembler.toCollectionModel(entregas.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> show(@PathVariable Long entregaId) {
		return entregas.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		finalizacaoEntregaService.finalizar(entregaId);
	}
}
