package com.riderx.riderx.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
	
	@NotNull(message = "Digite 1 se for cédito ou 0 para débito.")
	public Boolean tipoPagamento;
	
	@ManyToOne
	@JsonIgnoreProperties("corrida")
	private Carona veiculo;
	
	@ManyToOne
	@JoinColumn(name = "motorista_id", nullable = false)
	private Usuario usuario;
	
	public Carona getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Carona veiculo) {
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

	public Boolean getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(Boolean tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
}
