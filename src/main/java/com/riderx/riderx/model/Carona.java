package com.riderx.riderx.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_caronas")
public class Carona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "passageiro_id", nullable = false)
	@JsonBackReference
	private Usuario passageiroId;
	
	@ManyToOne
	@JoinColumn(name = "corrida_id")
	@JsonBackReference
	private Corrida corrida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getPassageiroId() {
		return passageiroId;
	}

	public void setPassageiroId(Usuario passageiroId) {
		this.passageiroId = passageiroId;
	}

	public Corrida getCorrida() {
		return corrida;
	}

	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}
}
