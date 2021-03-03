package br.ifpe.web3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "O campo nome deve ser preenchido")
	private String nome;
	
	@Column(length = 20, unique = true)
	@NotBlank(message = "O campo login deve ser preenchido")
	private String login;
	
	@Column(length = 20)
	@NotBlank(message = "O campo senha deve ser preenchido")
	private String senha;
	
	@OneToOne @JoinColumn(name = "time_id")
	private Time time;
	
	@OneToOne @JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;
	
	@OneToMany(mappedBy="usuario")
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	public Usuario(Integer id, @NotBlank(message = "O campo nome deve ser preenchido") String nome,
			@NotBlank(message = "O campo login deve ser preenchido") String login,
			@NotBlank(message = "O campo senha deve ser preenchido") String senha, Time time, Tecnico tecnico,
			List<Jogador> jogadores) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.time = time;
		this.tecnico = tecnico;
		this.jogadores = jogadores;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
