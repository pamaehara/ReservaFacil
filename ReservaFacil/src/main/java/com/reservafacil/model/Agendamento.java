package com.reservafacil.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.reservafacil.constante.TipoENUM;

@Entity
public class Agendamento {

	@Id
	@Column(name="id", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="contaOrigem", nullable=false, unique=false)
	@NotEmpty
	@Size(min=7, max=7)
	private String contaOrigem;

	@Column(name="contaDestino", nullable=false, unique=false)
	@NotEmpty
	@Size(min=7, max=7)
	private String contaDestino;

	@Column(name="valor", nullable=false, unique=false)
	@NotNull
	private BigDecimal valor;
	
	@Column(name="taxa", nullable=false, unique=false)
	private BigDecimal taxa;
	
	@Column(name="dataAgendamento", unique=false)
	@NotNull
	private LocalDate dataAgendamento;
	
	@Column(name="tipo", nullable=false, unique=false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoENUM tipo;
	
	@Column(name="timestamp", unique=false, insertable=false)
	private LocalDateTime timestamp;
	
	public Agendamento() {
		super();
	}

	public Agendamento(int id, String contaOrigem, String contaDestino, BigDecimal valor, BigDecimal taxa,
			LocalDateTime timestamp, TipoENUM tipo, LocalDate dataAgendamento) {
		super();
		this.id = id;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.taxa = taxa;
		this.timestamp = timestamp;
		this.tipo = tipo;
		this.dataAgendamento = dataAgendamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public TipoENUM getTipo() {
		return tipo;
	}

	public void setTipo(TipoENUM tipo) {
		this.tipo = tipo;
	}
	
	@PrePersist
	protected void onCreate() {
	    if (timestamp == null) { timestamp = LocalDateTime.now(); }
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}