package br.ifpe.web3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "time")
public class Time {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "O campo nome deve ser preenchido")
	private String nome;
	private UF uf;

	@OneToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;
	
	@OneToOne(mappedBy = "time")
	private Usuario usuario;
	
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

	public Time() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Time(Integer id, String nome, UF uf, Tecnico tecnico) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
		this.tecnico = tecnico;
	}
	
	
}
