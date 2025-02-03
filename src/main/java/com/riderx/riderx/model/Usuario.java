package com.riderx.riderx.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 2, max = 30)
	private String nome;

	@Email(message = "Digite um usuario válido")
	@NotBlank (message = "O Atributo usuário é obrigatório!")
	private String usuario;

	@NotBlank(message = " O número de telefone é obrigatorio!!")
	@Pattern(regexp = "^\\d{2}9?\\d{8}$")
	private String telefone;

	@NotBlank
	@Size(min = 8, message = "O Atributo senha deve ter no minimo 8 caracteres")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).*$", message = "A senha deve conter letras e números.")
	private String senha;

	private String foto;

	@NotNull(message = "Digite 1 se for motorista ou 0 para passageiro...")
	private Boolean tipo; // se for 1 significa que é motorista
	
	@Size(min = 16, max = 16)
	public String cartaoNumero; 
	
	@Size(min = 3, max = 3)
	public String cartaoCVV;
	
	@Size(min = 7, max = 50)
	public String cartaoNome; 
	
	@Size(min = 5, max = 5)
	public String cartaoExpiracao; 
	
	private String carroMarca;
	
	private String carroModelo;
	
	private String carroCor;
	
	private String carroAno;
	
	private String carroPlaca;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Corrida> corridas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Boolean getTipo() {
		return tipo;
	}

	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}
	
	
	public String getCartaoNumero() {
		return cartaoNumero;
	}

	public void setCartaoNumero(String cartaoNumero) {
		this.cartaoNumero = cartaoNumero;
	}

	public String getCartaoCVV() {
		return cartaoCVV;
	}

	public void setCartaoCVV(String cartaoCVV) {
		this.cartaoCVV = cartaoCVV;
	}

	public String getCartaoNome() {
		return cartaoNome;
	}

	public void setCartaoNome(String cartaoNome) {
		this.cartaoNome = cartaoNome;
	}

	public String getCartaoExpiracao() {
		return cartaoExpiracao;
	}

	public void setCartaoExpiracao(String cartaoExpiracao) {
		this.cartaoExpiracao = cartaoExpiracao;
	}

	public String getCarroMarca() {
		return carroMarca;
	}

	public void setCarroMarca(String carroMarca) {
		this.carroMarca = carroMarca;
	}

	public String getCarroModelo() {
		return carroModelo;
	}

	public void setCarroModelo(String carroModelo) {
		this.carroModelo = carroModelo;
	}

	public String getCarroCor() {
		return carroCor;
	}

	public void setCarroCor(String carroCor) {
		this.carroCor = carroCor;
	}

	public String getCarroAno() {
		return carroAno;
	}

	public void setCarroAno(String carroAno) {
		this.carroAno = carroAno;
	}

	public String getCarroPlaca() {
		return carroPlaca;
	}

	public void setCarroPlaca(String carroPlaca) {
		this.carroPlaca = carroPlaca;
	}

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}

	
}
