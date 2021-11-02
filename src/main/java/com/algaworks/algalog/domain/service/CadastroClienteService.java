package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exceptions.EmailJaCadastradoException;
import com.algaworks.algalog.domain.exceptions.EntidadeNaoEncontradaException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	
	private ClienteRepository clientes;
	
	public CadastroClienteService(ClienteRepository clientes) {
		super();
		this.clientes = clientes;
	}

	@Transactional
	public Cliente save(Cliente cliente) {
		boolean emailEmUso = clientes.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteSearch -> !clienteSearch.equals(cliente));
		
		if(emailEmUso) {
			throw new EmailJaCadastradoException("Já existe um cliente cadastrado com esse e-mail.");
		}
		
		return clientes.save(cliente);
	}
	
	@Transactional
	public void delete(Long id) {
		clientes.deleteById(id);
	}
	
	public Cliente findByIdOrError(Long id) {
		return clientes
				.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format(
								"Cliente de código %d não encontrado.", 
								id
						)));
	}
}
