package br.ifpe.web3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="usuario")
public class Usuario {

	/* DADOS DO USUARIO */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "O campo nome deve ser preenchido")
	private String nome;
	
	@Column(length = 20, unique = true)
	@NotBlank(message = "O campo login deve ser preenchido")
	private String username;
	
	@NotBlank(message = "O campo senha deve ser preenchido")
	private String senha;
	
	/* REGISTROS DO USUARIO */
	
	@OneToMany @JoinColumn(name = "usuario_id")
	private List<Time> times;
	
	@OneToMany @JoinColumn(name = "usuario_id")
	private List<Tecnico> tecnicos;
	
	@OneToMany @JoinColumn(name="usuario_id")
	private List<Jogador> jogadores;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public List<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	
}
