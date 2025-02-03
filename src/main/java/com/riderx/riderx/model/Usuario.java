package com.riderx.riderx.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	@Pattern(regexp = "^\\+?[1-9]\\d{1,14}$")
	private String telefone;

	@NotBlank
	@Size(min = 8, message = "O Atributo senha deve ter no minimo 8 caracteres")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).*$", message = "A senha deve conter letras e números.")
	private String senha;

	private String foto;

	@NotNull(message = "Digite 1 se for motorista ou 0 para passageiro...")
	private Boolean tipo; // se for 1 significa que é motorista
	
	@NotBlank
	@Size(min = 5, message = "Digite um endereço válido.")
	private String enderecoCasa;
	
	@NotBlank
	@Size(min = 5, message = "Digite um endereço válido.")
	private String enderecoTrabalho;
	
	@NotNull(message = "O método de pagamento é obrigatório.")
	@Size(min = 16, max = 16)
	public String numeroCartao;
	
	@NotNull(message = "Digite o código de segurança")
	@Size(min = 3, max = 3)
	public String cvv;
	
	@NotNull(message = "Digite o nome no Cartão.")
	@Size(min = 7, max = 50)
	public String nomeCartao;
	
	@NotNull(message = "Digite a data de expiração: DD/AA")
	@Size(min = 5, max = 5)
	public String dataExpiracao;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Veiculo> veiculo;
	
	@ManyToOne
	@JsonIgnoreProperties("usuario")
	private Corrida corrida;
	
	public Usuario(Long id, String nome, String usuario, String telefone, String senha, String foto, Boolean tipo,
			String enderecoCasa, String enderecoTrabalho, String numeroCartao, String cvv, String nomeCartao, String dataExpiracao) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.telefone = telefone;
		this.senha = senha;
		this.foto = foto;
		this.tipo = tipo;
		this.enderecoCasa = enderecoCasa;
		this.enderecoTrabalho = enderecoTrabalho;
		this.numeroCartao = numeroCartao;
		this.cvv = cvv;
		this.nomeCartao = nomeCartao;
		this.dataExpiracao = dataExpiracao;
	}

	public Usuario() {	}
	

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

	public String getEnderecoCasa() {
		return enderecoCasa;
	}

	public void setEnderecoCasa(String enderecoCasa) {
		this.enderecoCasa = enderecoCasa;
	}

	public String getEnderecoTrabalho() {
		return enderecoTrabalho;
	}

	public void setEnderecoTrabalho(String enderecoTrabalho) {
		this.enderecoTrabalho = enderecoTrabalho;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	public String getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}

	public Corrida getCorrida() {
		return corrida;
	}

	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}
}
