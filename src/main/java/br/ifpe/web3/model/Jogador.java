package br.ifpe.web3.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="jogador")
public class Jogador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "O campo nome deve ser preenchido")
	private String nome;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;
	@Column(precision=10, scale=2)
	private double salario;
	
    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="time_id", nullable=false)
	private Time time;

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Jogador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jogador(Integer id, String nome, LocalDate dataNascimento, double salario, Time time) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.time = time;
	}
	
	
}
