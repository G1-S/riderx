package com.riderx.riderx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riderx.riderx.model.Corrida;

@Repository
public interface CorridaRepository extends JpaRepository<Corrida, Long> {

	public List <Corrida> findAllByDestinoContainingIgnoreCase(@Param("destino") String destino);
}
