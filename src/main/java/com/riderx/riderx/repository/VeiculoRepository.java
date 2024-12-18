package com.riderx.riderx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.riderx.riderx.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	 public List<Veiculo> findAllByPlacaContainingIgnoreCase(@Param("placa") String placa);

}
