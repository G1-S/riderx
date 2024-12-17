package com.riderx.riderx.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_corridas")
public class Corrida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O Atributo origem é obrigatório")
	private String origem;

	@NotNull(message = "O Atributo destino é obrigatório")
	private String destino;

	@NotNull(message = "O Atributo vagas é obrigatório")
	private Integer vagas;

	@NotNull(message = "O Atributo status é obrigatório")
	private String status;
	
	@NotNull(message = "O Atributo distância é obrigatório")
	private Double distancia;
	
	@ManyToOne
	@JsonIgnoreProperties("corrida")
	private Veiculo veiculo;
	
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Double getDistancia() {
		return distancia;
	}
		
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
		
	}
	
}
