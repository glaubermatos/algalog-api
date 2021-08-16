package com.algaworks.algalog.api.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.service.CadastroClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteRepository clientes;
	private CadastroClienteService service;
	
	@GetMapping
	public List<Cliente> index() { 
		return clientes.findAll(); 
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cliente create(@Valid @RequestBody Cliente cliente) {
		return service.save(cliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> show(@PathVariable Long id) {
		return clientes.findById(id)
//				.map(cliente -> ResponseEntity.ok(cliente))
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
		
//		Optional<Cliente> cliente = clientes.findById(id);
//		
//		if (cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}
//				
//		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> update(@PathVariable Long clienteId, @RequestBody Cliente cliente) {
		if (!clientes.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(clienteId);
		cliente = service.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{clienteId}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long clienteId) {
		if (!clientes.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		service.delete(clienteId);
		return ResponseEntity.noContent().build();
	}

}
