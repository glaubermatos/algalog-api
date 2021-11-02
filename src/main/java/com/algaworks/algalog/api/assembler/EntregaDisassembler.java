package com.algaworks.algalog.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.input.EntregaInput;
import com.algaworks.algalog.domain.model.Entrega;

@Component
public class EntregaDisassembler {

	private ModelMapper modelMapper;
	
	public EntregaDisassembler(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	public Entrega toDomainModel(EntregaInput entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
}
