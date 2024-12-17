package com.riderx.riderx.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riderx.riderx.model.Corrida;
import com.riderx.riderx.repository.CorridaRepository;

@Service
public class CorridaService {
	
	 @Autowired
	    private CorridaRepository corridaRepository;

	public String calculoViagem(Long id, Double velocidade) {
		Corrida corrida = corridaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Corrida não encontrada"));

		Double tempoCorrida = (corrida.getDistancia() / velocidade);
		return "A corrida durou " + tempoCorrida + " horas";
	}
	
}



