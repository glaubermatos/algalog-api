package com.algaworks.algalog.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.input.OcorrenciaInput;
import com.algaworks.algalog.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaDisassembler {

	private ModelMapper modelMapper;
	
	public Ocorrencia toDomainMedel(OcorrenciaInput ocorrenciaInput) {
		return modelMapper.map(ocorrenciaInput, Ocorrencia.class);
	}
}
