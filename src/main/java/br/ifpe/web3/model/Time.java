package br.ifpe.web3.model;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "time")
public class Time {

	/* DADOS DO TIME */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotBlank(message = "O campo nome deve ser preenchido")
	private String nome;
	
	private UF uf;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tecnico_id", referencedColumnName = "id")
	private Tecnico tecnico;
	
	@OneToMany
	@JoinColumn(name = "time_id")
	private List<Jogador> jogadores;
	
	private Integer pontos;
	private Integer jogos;
	private Integer vitoria;
	private Integer empate;
	private Integer derrota;
	private Integer saldoGol;
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
	public UF getUf() {
		return uf;
	}
	public void setUf(UF uf) {
		this.uf = uf;
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
	public Integer getPontos() {
		return pontos;
	}
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	public Integer getJogos() {
		return jogos;
	}
	public void setJogos(Integer jogos) {
		this.jogos = jogos;
	}
	public Integer getVitoria() {
		return vitoria;
	}
	public void setVitoria(Integer vitoria) {
		this.vitoria = vitoria;
	}
	public Integer getEmpate() {
		return empate;
	}
	public void setEmpate(Integer empate) {
		this.empate = empate;
	}
	public Integer getDerrota() {
		return derrota;
	}
	public void setDerrota(Integer derrota) {
		this.derrota = derrota;
	}
	public Integer getSaldoGol() {
		return saldoGol;
	}
	public void setSaldoGol(Integer saldoGol) {
		this.saldoGol = saldoGol;
	}
	public Time(Integer id, @NotBlank(message = "O campo nome deve ser preenchido") String nome, UF uf, Tecnico tecnico,
			List<Jogador> jogadores, Integer pontos, Integer jogos, Integer vitoria, Integer empate, Integer derrota,
			Integer saldoGol) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
		this.tecnico = tecnico;
		this.jogadores = jogadores;
		this.pontos = pontos;
		this.jogos = jogos;
		this.vitoria = vitoria;
		this.empate = empate;
		this.derrota = derrota;
		this.saldoGol = saldoGol;
	}
	public Time() {
		super();
		// TODO Auto-generated constructor stub
	}

}
