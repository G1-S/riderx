package com.riderx.riderx.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_caronas")
public class Carona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O ID do passageiro é obrigatorio")
	private Long passageiroId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carona", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("carona")
	private List<Corrida> corrida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPassageiroId() {
		return passageiroId;
	}

	public void setPassageiroId(Long passageiroId) {
		this.passageiroId = passageiroId;
	}

	public List<Corrida> getCorrida() {
		return corrida;
	}

	public void setCorridaID(List<Corrida> corrida) {
		this.corrida = corrida;
	}
	
	
}
