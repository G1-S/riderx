package com.riderx.riderx.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riderx.riderx.model.Carona;
import com.riderx.riderx.model.Corrida;

public interface CaronaRepository extends JpaRepository<Carona, Long> {
	
	public Optional<Corrida> findByUsuario(String corrida);

}
